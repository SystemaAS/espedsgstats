package no.systema.z.main.maintenance.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.*;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.validation.BindingResult;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.web.bind.ServletRequestDataBinder;

//application imports
import no.systema.main.context.TdsAppContext;
import no.systema.main.service.UrlCgiProxyService;
import no.systema.main.service.UrlCgiProxyServiceImpl;
import no.systema.main.validator.LoginValidator;
import no.systema.main.util.AppConstants;
import no.systema.main.util.DateTimeManager;
import no.systema.main.util.EncodingTransformer;
import no.systema.main.util.JsonDebugger;
import no.systema.main.util.StringManager;

import no.systema.main.model.SystemaWebUser;

import no.systema.z.main.maintenance.service.MaintMainCundfService;
import no.systema.z.main.maintenance.service.MaintMainEdiiService;
import no.systema.z.main.maintenance.service.MaintMainKodtot2Service;
import no.systema.z.main.maintenance.service.MaintMainKodtsfSyparfService;
import no.systema.z.main.maintenance.service.MaintMainQaokp08aService;
import no.systema.z.main.maintenance.model.jsonjackson.dbtable.JsonMaintMainCundfRecord;
import no.systema.z.main.maintenance.model.jsonjackson.dbtable.JsonMaintMainCundfContainer;
import no.systema.z.main.maintenance.model.jsonjackson.dbtable.JsonMaintMainEdiiContainer;
import no.systema.z.main.maintenance.model.jsonjackson.dbtable.JsonMaintMainEdiiRecord;
import no.systema.z.main.maintenance.model.jsonjackson.dbtable.JsonMaintMainKodtot2Container;
import no.systema.z.main.maintenance.model.jsonjackson.dbtable.JsonMaintMainKodtot2Record;
import no.systema.z.main.maintenance.model.jsonjackson.dbtable.JsonMaintMainKodtsfSyparfContainer;
import no.systema.z.main.maintenance.model.jsonjackson.dbtable.JsonMaintMainKodtsfSyparfRecord;
import no.systema.z.main.maintenance.model.jsonjackson.dbtable.JsonMaintMainQaokp08aContainer;
import no.systema.z.main.maintenance.model.jsonjackson.dbtable.JsonMaintMainQaokp08aRecord;
import no.systema.z.main.maintenance.url.store.MaintenanceMainUrlDataStore;
import no.systema.z.main.maintenance.util.MainMaintenanceConstants;



/**
 * MAIN Maintenance  Controller - Child Window popup
 * 
 * @author oscardelatorre
 * @date Aug 15, 2016
 * 
 */

@Controller
@SessionAttributes(AppConstants.SYSTEMA_WEB_USER_KEY)
@Scope("session")
public class MainMaintenanceControllerChildWindow {
	
	private static final Logger logger = Logger.getLogger(MainMaintenanceControllerChildWindow.class.getName());
	private static final JsonDebugger jsonDebugger = new JsonDebugger(800);
	//customer
	
	private ModelAndView loginView = new ModelAndView("login");
	private ApplicationContext context;
	private LoginValidator loginValidator = new LoginValidator();
	//private CodeDropDownMgr codeDropDownMgr = new CodeDropDownMgr();
	private DateTimeManager dateTimeMgr = new DateTimeManager();
	private StringManager strMgr = new StringManager();
	
	@PostConstruct
	public void initIt() throws Exception {
		if("DEBUG".equals(AppConstants.LOG4J_LOGGER_LEVEL)){
			logger.setLevel(Level.DEBUG);
		}
	}
	
	/**
	 * 
	 * @param session
	 * @param request
	 * @return
	 */
	@RequestMapping(value="mainmaintenance_childwindow_customer.do", params="action=doFind",  method={RequestMethod.GET, RequestMethod.POST} )
	public ModelAndView searchCustomer(HttpSession session, HttpServletRequest request){
		logger.info("Inside searchCustomer");
		
		ModelAndView successView = new ModelAndView("mainmaintenance_childwindow_customer");
		Map model = new HashMap();
		String callerType = request.getParameter("ctype");
		String firma = request.getParameter("firma");
		String customerName = request.getParameter("sonavn");
		String customerNr = request.getParameter("knr");
		logger.info("callerType:" + callerType);
		logger.info("customerName:" + customerName);
		SystemaWebUser appUser = this.loginValidator.getValidUser(session);
		//fallback to FIRMA
		if(strMgr.isNull(firma)){
			firma = appUser.getCompanyCode();
		}
		
		if(appUser==null){
			return this.loginView;
				
		}else{
			Collection<JsonMaintMainCundfRecord> list = new ArrayList<JsonMaintMainCundfRecord>();
			//prepare the access CGI with RPG back-end
			if( (customerNr!=null && !"".equals(customerNr)) || (customerName!=null && !"".equals(customerName)) ){
				
				String BASE_URL = MaintenanceMainUrlDataStore.MAINTENANCE_MAIN_BASE_SYCUNDFR_GET_LIST_URL;
				String urlRequestParamsKeys = this.getRequestUrlKeyParametersForSearchCustomer(appUser.getUser(), customerName, customerNr, firma);
				logger.info("URL: " + BASE_URL);
				logger.info("PARAMS: " + urlRequestParamsKeys);
				logger.info(Calendar.getInstance().getTime() +  " CGI-start timestamp");
				String jsonPayload = this.urlCgiProxyService.getJsonContent(BASE_URL, urlRequestParamsKeys);
				//debugger
				logger.debug(jsonDebugger.debugJsonPayloadWithLog4J(jsonPayload));
				logger.info(Calendar.getInstance().getTime() +  " CGI-end timestamp");
		    	if(jsonPayload!=null){
		    		jsonPayload = jsonPayload.replaceFirst("Customerlist", "customerlist");
		    		JsonMaintMainCundfContainer container = this.maintMainCundfService.getList(jsonPayload);
		    		if(container!=null){
		    			list = container.getList();
		    			for(JsonMaintMainCundfRecord  record : list){
		    				//logger.info("CUSTOMER via AJAX: " + record.getKnavn() + " NUMBER:" + record.getKundnr());
		    				//logger.info("KPERS: " + record.getKpers() + " TLF:" + record.getTlf());
		    			}
		    		}
		    	}
			}
			
			model.put("customerList", list);
			model.put("sonavn", customerName);
			model.put("knr", customerNr);
			model.put("ctype", callerType);
			model.put("firma", firma);
			
			successView.addObject(MainMaintenanceConstants.DOMAIN_MODEL , model);
			
	    	return successView;	
		  	
		}
		
	}
	
	/**
	 * 
	 * @param session
	 * @param request
	 * @return
	 */
	@RequestMapping(value="mainmaintenance_childwindow_edi.do", params="action=doFind",  method={RequestMethod.GET, RequestMethod.POST} )
	public ModelAndView searchEdi(HttpSession session, HttpServletRequest request){
		logger.info("Inside searchEdi");
		
		ModelAndView successView = new ModelAndView("mainmaintenance_childwindow_edi");
		Map model = new HashMap();
		String callerType = request.getParameter("ctype");
		logger.info(callerType);
		String name = request.getParameter("navn");
		String id = request.getParameter("id");
		
		SystemaWebUser appUser = this.loginValidator.getValidUser(session);
		
		if(appUser==null){
			return this.loginView;
				
		}else{
			Collection<JsonMaintMainEdiiRecord> list = new ArrayList<JsonMaintMainEdiiRecord>();
			//prepare the access CGI with RPG back-end
			
			String BASE_URL = MaintenanceMainUrlDataStore.MAINTENANCE_MAIN_BASE_SYEDIIR_GET_LIST_URL;
			String urlRequestParamsKeys = this.getRequestUrlKeyParametersForSearchEdi(appUser.getUser(), id, name);
			logger.info("URL: " + BASE_URL);
			logger.info("PARAMS: " + urlRequestParamsKeys);
			logger.info(Calendar.getInstance().getTime() +  " CGI-start timestamp");
			String jsonPayload = this.urlCgiProxyService.getJsonContent(BASE_URL, urlRequestParamsKeys);
			//debugger
			logger.debug(jsonDebugger.debugJsonPayloadWithLog4J(jsonPayload));
			logger.info(Calendar.getInstance().getTime() +  " CGI-end timestamp");
	    	if(jsonPayload!=null){
	    		JsonMaintMainEdiiContainer container = this.maintMainEdiiService.getList(jsonPayload);
	    		if(container!=null){
	    			list = container.getList();
	    			for(JsonMaintMainEdiiRecord  record : list){
	    				
	    			}
	    		}
	    	}
			model.put("list", list);
			
			model.put("id", id);
			model.put("navn", name);
			model.put("ctype", callerType);
			
			successView.addObject(MainMaintenanceConstants.DOMAIN_MODEL , model);
			
	    	return successView;	
		  	
		}
		
	}
	/**
	 * 
	 * @param session
	 * @param request
	 * @return
	 */
	@RequestMapping(value="mainmaintenance_childwindow_opptype.do", params="action=doFind",  method={RequestMethod.GET, RequestMethod.POST} )
	public ModelAndView searchOppType(HttpSession session, HttpServletRequest request){
		logger.info("Inside searchOppType");
		
		ModelAndView successView = new ModelAndView("mainmaintenance_childwindow_opptype");
		Map model = new HashMap();
		String callerType = request.getParameter("ctype");
		logger.info(callerType);
		String id = request.getParameter("id");
		
		SystemaWebUser appUser = this.loginValidator.getValidUser(session);
		
		if(appUser==null){
			return this.loginView;
				
		}else{
			Collection<JsonMaintMainKodtot2Record> list = new ArrayList<JsonMaintMainKodtot2Record>();
			//prepare the access CGI with RPG back-end
			
			String BASE_URL = MaintenanceMainUrlDataStore.MAINTENANCE_MAIN_BASE_DROPDOWN_SYFA61R_GET_OPPTYPE_LIST_URL;
			String urlRequestParamsKeys = this.getRequestUrlKeyParametersForSearchOpptype(appUser.getUser(), id);
			logger.info("URL: " + BASE_URL);
			logger.info("PARAMS: " + urlRequestParamsKeys);
			logger.info(Calendar.getInstance().getTime() +  " CGI-start timestamp");
			String jsonPayload = this.urlCgiProxyService.getJsonContent(BASE_URL, urlRequestParamsKeys);
			//debugger
			logger.debug(jsonDebugger.debugJsonPayloadWithLog4J(jsonPayload));
			logger.info(Calendar.getInstance().getTime() +  " CGI-end timestamp");
	    	if(jsonPayload!=null){
	    		JsonMaintMainKodtot2Container container = this.maintMainKodtot2Service.getList(jsonPayload);
	    		if(container!=null){
	    			list = container.getList();
	    			for(JsonMaintMainKodtot2Record  record : list){
	    			 //debug	
	    			}
	    		}
	    	}
			model.put("list", list);
			model.put("id", id);
			model.put("ctype", callerType);
			
			successView.addObject(MainMaintenanceConstants.DOMAIN_MODEL , model);
			
	    	return successView;	
		  	
		}
		
	}
	/**
	 * 
	 * @param session
	 * @param request
	 * @return
	 */
	@RequestMapping(value="mainmaintenance_childwindow_signatures.do", method={RequestMethod.GET, RequestMethod.POST })
	public ModelAndView searchSignatures(HttpSession session, HttpServletRequest request){
		ModelAndView successView = new ModelAndView("mainmaintenance_childwindow_signatures");
		SystemaWebUser appUser = (SystemaWebUser)session.getAttribute(AppConstants.SYSTEMA_WEB_USER_KEY);
		Map model = new HashMap();
		String callerType = request.getParameter("ctype");
		logger.info(callerType);
		String id = request.getParameter("id");
		
		if(appUser==null){
			return this.loginView;
		}else{
			logger.info("Inside method: mainmaintenance_childwindow_signatures");
			
			String BASE_URL = MaintenanceMainUrlDataStore.MAINTENANCE_MAIN_BASE_SYFA60R_GET_LIST_URL;
			String urlRequestParams = "user=" + appUser.getUser();
			logger.info(Calendar.getInstance().getTime() + " CGI-start timestamp");
	    	logger.info("URL: " + jsonDebugger.getBASE_URL_NoHostName(BASE_URL));
	    	logger.info("URL PARAMS: " + urlRequestParams);
	    	String jsonPayload = this.urlCgiProxyService.getJsonContent(BASE_URL, urlRequestParams);
	    	//DEBUG
	    	this.jsonDebugger.debugJsonPayload(jsonPayload, 1000);
	    	//extract
	    	List<JsonMaintMainKodtsfSyparfRecord> list = new ArrayList();
	    	if(jsonPayload!=null){
				//lists
	    		JsonMaintMainKodtsfSyparfContainer container = this.maintMainKodtsfSyparfService.getList(jsonPayload);
		        if(container!=null){
		        	list = (List)container.getList();
		        }
	    	}
	    	model.put("list", list);
			model.put("id", id);
			model.put("ctype", callerType);
			
			successView.addObject(MainMaintenanceConstants.DOMAIN_MODEL , model);
			
	    	return successView;	
		  	
		}
	}
 	
	/**
	 * 
	 * @param session
	 * @param request
	 * @return
	 */
	@RequestMapping(value="mainmaintenance_childwindow_osusers.do", params="action=doFind",  method={RequestMethod.GET, RequestMethod.POST} )
	public ModelAndView searchOsUsers(HttpSession session, HttpServletRequest request){
		logger.info("Inside searchOsUsers");
		
		ModelAndView successView = new ModelAndView("mainmaintenance_childwindow_osusers");
		Map model = new HashMap();
		String callerType = request.getParameter("ctype");
		logger.info(callerType);
		String id = request.getParameter("id");
		
		SystemaWebUser appUser = this.loginValidator.getValidUser(session);
		
		if(appUser==null){
			return this.loginView;
				
		}else{
			Collection<JsonMaintMainQaokp08aRecord> list = new ArrayList<JsonMaintMainQaokp08aRecord>();
			//prepare the access CGI with RPG back-end
			String BASE_URL = MaintenanceMainUrlDataStore.MAINTENANCE_MAIN_BASE_SYQAOKP08A_GET_LIST_URL;
			String urlRequestParamsKeys = this.getRequestUrlKeyParametersForSearchOsUsers(appUser.getUser(), id);
			logger.info("URL: " + BASE_URL);
			logger.info("PARAMS: " + urlRequestParamsKeys);
			logger.info(Calendar.getInstance().getTime() +  " CGI-start timestamp");
			String jsonPayload = this.urlCgiProxyService.getJsonContent(BASE_URL, urlRequestParamsKeys);
			//debugger
			logger.debug(jsonDebugger.debugJsonPayloadWithLog4J(jsonPayload));
			logger.info(Calendar.getInstance().getTime() +  " CGI-end timestamp");
	    	if(jsonPayload!=null){
	    		JsonMaintMainQaokp08aContainer container = this.maintMainQaokp08aService.getList(jsonPayload);
	    		if(container!=null){
	    			list = container.getList();
	    			for(JsonMaintMainQaokp08aRecord  record : list){
	    				
	    			}
	    		}
	    	}
			model.put("list", list);
			
			model.put("id", id);
			//model.put("adress", id);
			model.put("ctype", callerType);
			
			successView.addObject(MainMaintenanceConstants.DOMAIN_MODEL , model);
			
	    	return successView;	
		  	
		}
		
	}
	/**
	 * 
	 * @param applicationUser
	 * @param customerName
	 * @param customerNumber
	 * @param firma
	 * @return
	 */
	private String getRequestUrlKeyParametersForSearchCustomer(String applicationUser, String customerName, String customerNumber, String firma){
		  StringBuffer sb = new StringBuffer();
		  sb.append("user=" + applicationUser);
		  if(customerName!=null && !"".equals(customerName) && customerNumber!=null && !"".equals(customerNumber)){
			  sb.append( MainMaintenanceConstants.URL_CHAR_DELIMETER_FOR_PARAMS_WITH_HTML_REQUEST + "knavn=" + customerName );
			  sb.append( MainMaintenanceConstants.URL_CHAR_DELIMETER_FOR_PARAMS_WITH_HTML_REQUEST + "kundnr=" + customerNumber );
			  if(firma!=null && !"".equals(firma)){
				  sb.append( MainMaintenanceConstants.URL_CHAR_DELIMETER_FOR_PARAMS_WITH_HTML_REQUEST + "firma=" + firma );
			  }
			  
		  }else if (customerName!=null && !"".equals(customerName)){
			  sb.append( MainMaintenanceConstants.URL_CHAR_DELIMETER_FOR_PARAMS_WITH_HTML_REQUEST + "knavn=" + customerName );
			  if(firma!=null && !"".equals(firma)){
				  sb.append( MainMaintenanceConstants.URL_CHAR_DELIMETER_FOR_PARAMS_WITH_HTML_REQUEST + "firma=" + firma );
			  }
		  }else if (customerNumber!=null && !"".equals(customerNumber)){
			  sb.append( MainMaintenanceConstants.URL_CHAR_DELIMETER_FOR_PARAMS_WITH_HTML_REQUEST + "kundnr=" + customerNumber );
			  if(firma!=null && !"".equals(firma)){
				  sb.append( MainMaintenanceConstants.URL_CHAR_DELIMETER_FOR_PARAMS_WITH_HTML_REQUEST + "firma=" + firma );
			  }
		  }
		  
		  return sb.toString();
	  }
	
	/**
	 * 
	 * @param applicationUser
	 * @param id
	 * @param name
	 * @return
	 */
	private String getRequestUrlKeyParametersForSearchEdi(String applicationUser, String id, String name){
		  StringBuffer sb = new StringBuffer();
		  sb.append("user=" + applicationUser);
		  if(id!=null && !"".equals(id) && name!=null && !"".equals(name)){
			  sb.append( MainMaintenanceConstants.URL_CHAR_DELIMETER_FOR_PARAMS_WITH_HTML_REQUEST + "inid=" + id );
			  sb.append( MainMaintenanceConstants.URL_CHAR_DELIMETER_FOR_PARAMS_WITH_HTML_REQUEST + "inna=" + name );
			  
		  }else if (id!=null && !"".equals(id)){
			  sb.append( MainMaintenanceConstants.URL_CHAR_DELIMETER_FOR_PARAMS_WITH_HTML_REQUEST + "inid=" + id );
		  }else if (name!=null && !"".equals(name)){
			  sb.append( MainMaintenanceConstants.URL_CHAR_DELIMETER_FOR_PARAMS_WITH_HTML_REQUEST + "inna=" + name );
		  }
		  
		  return sb.toString();
	 }
	
	/**
	 * 
	 * @param applicationUser
	 * @param id
	 * @return
	 */
	private String getRequestUrlKeyParametersForSearchOpptype(String applicationUser, String id){
		  StringBuffer sb = new StringBuffer();
		  sb.append("user=" + applicationUser);
		  if(id!=null && !"".equals(id) ){
			  sb.append( MainMaintenanceConstants.URL_CHAR_DELIMETER_FOR_PARAMS_WITH_HTML_REQUEST + "ko2kod=" + id.toUpperCase() );
		  }

		  return sb.toString();
	  }
	
	/**
	 * 
	 * @param applicationUser
	 * @param id
	 * @return
	 */
	private String getRequestUrlKeyParametersForSearchOsUsers(String applicationUser, String id){
		  StringBuffer sb = new StringBuffer();
		  sb.append("user=" + applicationUser);
		  if(id!=null && !"".equals(id) ){
			  sb.append( MainMaintenanceConstants.URL_CHAR_DELIMETER_FOR_PARAMS_WITH_HTML_REQUEST + "wos8dden=" + id.toUpperCase() );
		  }

		  return sb.toString();
	  }
	
	
	//SERVICES
	@Qualifier ("urlCgiProxyService")
	private UrlCgiProxyService urlCgiProxyService;
	@Autowired
	@Required
	public void setUrlCgiProxyService (UrlCgiProxyService value){ this.urlCgiProxyService = value; }
	public UrlCgiProxyService getUrlCgiProxyService(){ return this.urlCgiProxyService; }
	
	
	@Qualifier 
	private MaintMainCundfService maintMainCundfService;
	@Autowired
	@Required	
	public void setMaintMainCundfService(MaintMainCundfService value){this.maintMainCundfService = value;}
	public MaintMainCundfService getMaintMainCundfService(){ return this.maintMainCundfService; }
	
	
	@Qualifier 
	private MaintMainEdiiService maintMainEdiiService;
	@Autowired
	@Required	
	public void setMaintMainEdiiService(MaintMainEdiiService value){this.maintMainEdiiService = value;}
	public MaintMainEdiiService getMaintMainEdiiService(){ return this.maintMainEdiiService; }
	
	
	@Qualifier 
	private MaintMainKodtot2Service maintMainKodtot2Service;
	@Autowired
	@Required	
	public void setMaintMainKodtot2Service(MaintMainKodtot2Service value){this.maintMainKodtot2Service = value;}
	public MaintMainKodtot2Service getMaintMainKodtot2Service(){ return this.maintMainKodtot2Service; }
	
	
	@Qualifier ("maintMainKodtsfSyparfService")
	private MaintMainKodtsfSyparfService maintMainKodtsfSyparfService;
	@Autowired
	@Required
	public void setMaintMainKodtsfSyparfService (MaintMainKodtsfSyparfService value){ this.maintMainKodtsfSyparfService = value; }
	public MaintMainKodtsfSyparfService getMaintMainKodtsfSyparfService(){ return this.maintMainKodtsfSyparfService; }
	
	@Qualifier ("maintMainQaokp08aService")
	private MaintMainQaokp08aService maintMainQaokp08aService;
	@Autowired
	@Required
	public void setMaintMainQaokp08aService (MaintMainQaokp08aService value){ this.maintMainQaokp08aService = value; }
	public MaintMainQaokp08aService getMaintMainQaokp08aService(){ return this.maintMainQaokp08aService; }
	
	
}

