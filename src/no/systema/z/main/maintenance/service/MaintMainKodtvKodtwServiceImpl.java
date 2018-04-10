/**
 * 
 */
package no.systema.z.main.maintenance.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Service;

import no.systema.main.service.UrlCgiProxyService;
import no.systema.main.util.JsonDebugger;
import no.systema.z.main.maintenance.model.jsonjackson.dbtable.JsonMaintMainKodtvKodtwContainer;
import no.systema.z.main.maintenance.model.jsonjackson.dbtable.JsonMaintMainKodtvKodtwRecord;
import no.systema.z.main.maintenance.mapper.jsonjackson.dbtable.MaintMainKodtvKodtwMapper;
import no.systema.z.main.maintenance.url.store.MaintenanceMainUrlDataStore;

/**
 * 
 * @author oscardelatorre
 * @date Aug 5, 2016
 * 
 * 
 */
public class MaintMainKodtvKodtwServiceImpl implements MaintMainKodtvKodtwService {
	private static final Logger logger = Logger.getLogger(MaintMainKodtvKodtwServiceImpl.class.getName());
	private static final JsonDebugger jsonDebugger = new JsonDebugger();
	
	/**
	 * 
	 */
	public JsonMaintMainKodtvKodtwContainer getList(String utfPayload) {
		JsonMaintMainKodtvKodtwContainer container = null;
		try{
			MaintMainKodtvKodtwMapper mapper = new MaintMainKodtvKodtwMapper();
			container = mapper.getContainer(utfPayload);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return container;
		
	}
	/**
	 * 
	 * @param utfPayload
	 * @return
	 */
	public JsonMaintMainKodtvKodtwContainer doUpdate(String utfPayload) {
		JsonMaintMainKodtvKodtwContainer container = null;
		try{
			MaintMainKodtvKodtwMapper mapper = new MaintMainKodtvKodtwMapper();
			container = mapper.getContainer(utfPayload);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return container;
		
	}
	/**
	 * 
	 */
	public JsonMaintMainKodtvKodtwRecord fetchRecord(String applicationUser, String id){
		JsonMaintMainKodtvKodtwRecord record = new JsonMaintMainKodtvKodtwRecord();
    	
		String BASE_URL = MaintenanceMainUrlDataStore.MAINTENANCE_MAIN_BASE_SYFA28R_GET_LIST_URL;
		String urlRequestParams = "user=" + applicationUser + "&kovavd=" + id;
		
		logger.info(Calendar.getInstance().getTime() + " CGI-start timestamp");
    	logger.info("URL: " + jsonDebugger.getBASE_URL_NoHostName(BASE_URL));
    	logger.info("URL PARAMS: " + urlRequestParams);
    	String jsonPayload = this.urlCgiProxyService.getJsonContent(BASE_URL, urlRequestParams);
    	//DEBUG
    	this.jsonDebugger.debugJsonPayload(jsonPayload, 1000);
    	//extract
    	List<JsonMaintMainKodtvKodtwRecord> list = new ArrayList();
    	
    	if(jsonPayload!=null){
			//lists
    		JsonMaintMainKodtvKodtwContainer container = this.getList(jsonPayload);
	        if(container!=null){
	        	list = (List)container.getList();
	        	for(JsonMaintMainKodtvKodtwRecord tmp : list){
	        		record = tmp;
	        		
	        	}
	        }
    	}
    	return record;
    	
	}
	
	//Wired - SERVICES
	@Qualifier ("urlCgiProxyService")
	private UrlCgiProxyService urlCgiProxyService;
	@Autowired
	@Required
	public void setUrlCgiProxyService (UrlCgiProxyService value){ this.urlCgiProxyService = value; }
	public UrlCgiProxyService getUrlCgiProxyService(){ return this.urlCgiProxyService; }
	
}
