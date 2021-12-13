package no.systema.main.testsuite;


import java.util.*;
import org.apache.logging.log4j.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import no.systema.main.url.store.MainUrlDataStore;
import no.systema.z.main.maintenance.url.store.MaintenanceMainUrlDataStore;
import no.systema.tvinn.sad.z.maintenance.felles.url.store.TvinnSadMaintenanceFellesUrlDataStore;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Json Response Controller
 * 
 * This class is the controller driver for the testsuite - SKAT
 * All service-test communication from the outside world to espedsgskat.war is done through this gateway
 * 
 * @author oscardelatorre
 * @date Apr 09, 2018
 * 
 */

@Controller
public class JsonResponseOutputterController {
	private static Logger logger = LogManager.getLogger(JsonResponseOutputterController.class.getName());
	private static JsonSpecialCharactersManager jsonFixMgr = new JsonSpecialCharactersManager();
	private static String JSON_START = "{";
	private static String JSON_END = "}";
	private static String JSON_QUOTES = "\"";
	private static String JSON_RECORD_SEPARATOR = ",";
	private static String JSON_FIELD_SEPARATOR = ",";
	
	private static String JSON_OPEN_LIST = "[";
	private static String JSON_CLOSE_LIST = "]";
	private static String JSON_OPEN_LIST_RECORD = "{";
	private static String JSON_CLOSE_LIST_RECORD = "}";
	//init the reflection manager here
	private JavaReflectionManager reflectionMgr = new JavaReflectionManager();
	
	
	/**
	 * Test call 
	 * http://localhost:8080/espedsgstats/sytsuite.do?user=OSCAR
	 * @return
	 */
	@RequestMapping(value="sytsuite.do", method={RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public String sytsuite( HttpSession session, HttpServletRequest request) {
		StringBuffer sb = new StringBuffer();
		try{
			logger.info("Inside sytsuite");
			//TEST-->logger.info("Servlet root:" + AppConstants.VERSION_SYJSERVICES);
			
			//get list
			logger.info("Init lists");
			List<Object> urlStoreObjectList = this.getUrlObjectList();
			List<TestersuiteObject> testersuiteObjectlist = new ArrayList<TestersuiteObject>(); 
			for(Object urlStoreObjRecord : urlStoreObjectList){
				logger.info("testing urlStore:" + urlStoreObjRecord.getClass().getName());
				reflectionMgr.buildList(testersuiteObjectlist, urlStoreObjRecord);
			}
			logger.info("After testersuiteObjectlist size;" + testersuiteObjectlist.size());
			
			//build the return JSON
			sb.append(JSON_START);
			sb.append(this.setFieldQuotes("user") + ":" + this.setFieldQuotes("OSCAR") + ",");
			sb.append(this.setFieldQuotes("list") + ":");
			sb.append(JSON_OPEN_LIST);
			int counter = 1;
			logger.info("Strax innan testersuiteObjectList loop...");
			for(TestersuiteObject record : testersuiteObjectlist){
				//logger.info("in the loop");
				if(counter>1){ sb.append(JSON_RECORD_SEPARATOR); }
				sb.append(JSON_OPEN_LIST_RECORD); 
				sb.append(JSON_QUOTES + "status" + JSON_QUOTES + ":" + JSON_QUOTES + jsonFixMgr.cleanRecord(record.getStatus()) + JSON_QUOTES);
				sb.append(JSON_FIELD_SEPARATOR );
				sb.append(JSON_QUOTES + "serviceUrl" + JSON_QUOTES + ":" + JSON_QUOTES + jsonFixMgr.cleanRecord(record.getServiceUrl()) + JSON_QUOTES);
				sb.append(JSON_FIELD_SEPARATOR );
				sb.append(JSON_QUOTES + "serviceName" + JSON_QUOTES + ":" + JSON_QUOTES + jsonFixMgr.cleanRecord(record.getServiceName()) + JSON_QUOTES);
				sb.append(JSON_FIELD_SEPARATOR );
				sb.append(JSON_QUOTES + "description" + JSON_QUOTES + ":" + JSON_QUOTES + jsonFixMgr.cleanRecord(record.getDescription()) + JSON_QUOTES);
				sb.append(JSON_FIELD_SEPARATOR );
				sb.append(JSON_QUOTES + "errMsg" + JSON_QUOTES + ":" + JSON_QUOTES + jsonFixMgr.cleanRecord(record.getErrMsg()) + JSON_QUOTES);
				sb.append(JSON_CLOSE_LIST_RECORD);
				counter++;
			}
			
			sb.append(JSON_CLOSE_LIST);
			sb.append(JSON_END);
			
			
		}catch(Exception e){
			session.invalidate();
			String error = "ERROR [JsonResponseOutputterController]" + e.toString();
			return error;
		}
	    session.invalidate();
		return sb.toString();
	}
	
	/**
	 * This list must be updated manually ...
	 * @param testModule
	 * @return
	 */
	private List<Object> getUrlObjectList(){
		List<Object> listObj= new ArrayList<Object>();
		Object urlStoreObj = null;
		
		urlStoreObj = new TvinnSadMaintenanceFellesUrlDataStore();
		listObj.add(urlStoreObj);
		
		urlStoreObj = new MaintenanceMainUrlDataStore();
		listObj.add(urlStoreObj);
		
		urlStoreObj = new MainUrlDataStore();
		listObj.add(urlStoreObj);
		
		
			
		return listObj;
	}
	
	
	/**
	 * 
	 * @param value
	 * @return
	 */
	private String setFieldQuotes(String value){
		String retval = value;
		retval = this.JSON_QUOTES + value + this.JSON_QUOTES;
		
		return retval;
	}
	
	
}

