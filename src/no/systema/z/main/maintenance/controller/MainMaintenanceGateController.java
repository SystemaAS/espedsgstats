package no.systema.z.main.maintenance.controller;

import java.util.*;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import no.systema.main.service.UrlCgiProxyService;

//application imports
import no.systema.main.model.SystemaWebUser;
import no.systema.main.util.AppConstants;
//models
import no.systema.z.main.maintenance.model.MainMaintenanceMainListObject;
import no.systema.z.main.maintenance.util.MainMaintenanceConstants;
import no.systema.z.main.maintenance.util.MessageSourceHelper;


/**
 * Gateway to the Main Maintenance Application
 * 
 * 
 * @author oscardelatorre
 * @date Jun 28, 2016
 * 
 * 	
 */

@Controller
public class MainMaintenanceGateController {
	private static final Logger logger = Logger.getLogger(MainMaintenanceGateController.class.getName());
	private ModelAndView loginView = new ModelAndView("login");
	private final String LANGUAGE_CODE_NORWAY = "NO";
	private final String LANGUAGE_CODE_SWEDEN = "SV";
	private final String LANGUAGE_CODE_DENMARK = "DA";
	private MessageSourceHelper messageSourceHelper = null;
	
	/**
	 * 
	 * @param user
	 * @param result
	 * @param request
	 * @return
	 * 
	 */
	@RequestMapping(value="mainmaintenancegate.do", method={RequestMethod.GET, RequestMethod.POST })
	public ModelAndView tvinnsadmaintenancegate(HttpSession session, HttpServletRequest request){
		ModelAndView successView = new ModelAndView("mainmaintenancegate");
		SystemaWebUser appUser = (SystemaWebUser)session.getAttribute(AppConstants.SYSTEMA_WEB_USER_KEY);
		Map model = new HashMap();
		messageSourceHelper = new MessageSourceHelper(request);
		if(appUser==null){
			return this.loginView;
		}else{
			appUser.setActiveMenu("INIT");
			logger.info("Inside method: mainmaintenancegate");
			logger.info("appUser user:" + appUser.getUser());
			logger.info("appUser lang:" + appUser.getUsrLang());
			logger.info("appUser userAS400:" + appUser.getUserAS400());
			
			appUser.setActiveMenu(SystemaWebUser.ACTIVE_MENU_MAIN_MAINTENANCE);
			session.setAttribute(MainMaintenanceConstants.ACTIVE_URL_RPG_MAIN_MAINTENANCE, MainMaintenanceConstants.ACTIVE_URL_RPG_INITVALUE); 
			
			List list = this.populateMaintenanceMainList(appUser);
			//this.populateAvdelningHtmlDropDownsFromJsonString(model, appUser);
			//this.populateSignatureHtmlDropDownsFromJsonString(model, appUser);
			//this.setCodeDropDownMgr(appUser, model);
			//init filter with users signature (for starters)
			//searchFilter.setSg(appUser.getTvinnSadSign());
			//successView.addObject("searchFilter" , searchFilter);
			//init the rest
			model.put("list", list);
			successView.addObject(MainMaintenanceConstants.DOMAIN_MODEL , model);
			
			logger.info("Host via HttpServletRequest.getHeader('Host'): " + request.getHeader("Host"));
		    
			return successView;
			
		}
	}

	/**
	 * 
	 * @return
	 */
	private List<MainMaintenanceMainListObject> populateMaintenanceMainList(SystemaWebUser appUser ){
		List<MainMaintenanceMainListObject> listObject = new ArrayList<MainMaintenanceMainListObject>();
		MainMaintenanceMainListObject object = new  MainMaintenanceMainListObject();
		        
		
		object.setId("1");
		object.setSubject("Avdelinger");//default
		if(LANGUAGE_CODE_SWEDEN.equals(appUser.getUsrLang())){
			object.setSubject("Avdelningar");
		}else if(LANGUAGE_CODE_DENMARK.equals(appUser.getUsrLang())){
			object.setSubject("Afdelinger");
		}
		object.setCode("mainmaintenanceavdgate");
		object.setText("SYFA14 / KODTA, NAVAVD, KODTSF, KODTD, KODTASID, FIRM, CUNDF");
		object.setDbTable("KODTA");
		object.setStatus("G");
		//object.setPgm("syfa14r");
		listObject.add(object);
		//
		object = new  MainMaintenanceMainListObject();
		object.setId("2");
		object.setSubject("Saksbehandlere");//default
		if(LANGUAGE_CODE_SWEDEN.equals(appUser.getUsrLang())){
			object.setSubject("Handläggare");
		}else if(LANGUAGE_CODE_DENMARK.equals(appUser.getUsrLang())){
			object.setSubject("Toldrepræsentanter");
		}
		object.setCode("mainmaintenancesign");
		object.setText("SYFA60 / KODTSF, SYPARF");
		object.setDbTable("KODTSF");
		object.setStatus("G");
		object.setPgm("syfa60r");
		listObject.add(object);
		//
		object = new  MainMaintenanceMainListObject();
		object.setId("3");
		object.setSubject(messageSourceHelper.getMessage("systema.main.maintenance.customerreg", null));
		object.setCode("mainmaintenancecundf");
		object.setText("VKUND / CUNDF, CUNDC, FRATXT, SYPARF, CUNDMAF,....");
		object.setDbTable("CUNDF");
		object.setStatus("Y");
		object.setPgm("vkund");
		listObject.add(object);
		//
		object = new  MainMaintenanceMainListObject();
		object.setId("4");
		object.setSubject("Firmaopplysninger");
		if(LANGUAGE_CODE_SWEDEN.equals(appUser.getUsrLang())){
			object.setSubject("Firmaupplysningar");
		}else if(LANGUAGE_CODE_DENMARK.equals(appUser.getUsrLang())){
			object.setSubject("Firmaoplysninger");
		}
		object.setCode("mainmaintenancefirm");
		object.setText("SYFA30 / FIRM,FIRFB,FIRKOS,FIRKU,FIRSTA,FIRTR");
		object.setDbTable("FIRM");
		object.setStatus("Y");
		object.setPgm("syfa30r");
		listObject.add(object);
		
		object = new  MainMaintenanceMainListObject();
		object.setId("5");
		object.setSubject(messageSourceHelper.getMessage("systema.main.maintenance.arkiv", null));
		object.setCode("mainmaintenancearkivgate");
		object.setText("ARKIV / ARKTXT,...");
		object.setStatus("G");
		listObject.add(object);		
		
		
		return listObject;
	}
	
	//Wired - SERVICES
	@Qualifier ("urlCgiProxyService")
	private UrlCgiProxyService urlCgiProxyService;
	@Autowired
	@Required
	public void setUrlCgiProxyService (UrlCgiProxyService value){ this.urlCgiProxyService = value; }
	public UrlCgiProxyService getUrlCgiProxyService(){ return this.urlCgiProxyService; }
	
	
		
}

