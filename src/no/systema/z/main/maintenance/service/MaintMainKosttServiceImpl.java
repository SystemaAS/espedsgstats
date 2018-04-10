/**
 * 
 */
package no.systema.z.main.maintenance.service;

import no.systema.z.main.maintenance.model.jsonjackson.dbtable.JsonMaintMainKosttContainer;
import no.systema.z.main.maintenance.mapper.jsonjackson.dbtable.MaintMainKosttMapper;

/**
 * 
 * @author oscardelatorre
 * @date Apr 21, 2017
 * 
 * 
 */
public class MaintMainKosttServiceImpl implements MaintMainKosttService {
	/**
	 * 
	 */
	public JsonMaintMainKosttContainer getList(String utfPayload) {
		JsonMaintMainKosttContainer container = null;
		try{
			MaintMainKosttMapper mapper = new MaintMainKosttMapper();
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
	public JsonMaintMainKosttContainer doUpdate(String utfPayload) {
		JsonMaintMainKosttContainer container = null;
		try{
			MaintMainKosttMapper mapper = new MaintMainKosttMapper();
			container = mapper.getContainer(utfPayload);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return container;
		
	}

}
