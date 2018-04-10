/**
 * 
 */
package no.systema.z.main.maintenance.service;

import no.systema.z.main.maintenance.model.jsonjackson.dbtable.JsonMaintMainEdiiContainer;
import no.systema.z.main.maintenance.mapper.jsonjackson.dbtable.MaintMainEdiiMapper;

/**
 * 
 * @author oscardelatorre
 * @date Sep 8, 2016
 * 
 * 
 */
public class MaintMainEdiiServiceImpl implements MaintMainEdiiService {
	/**
	 * 
	 */
	public JsonMaintMainEdiiContainer getList(String utfPayload) {
		JsonMaintMainEdiiContainer container = null;
		try{
			MaintMainEdiiMapper mapper = new MaintMainEdiiMapper();
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
	public JsonMaintMainEdiiContainer doUpdate(String utfPayload) {
		JsonMaintMainEdiiContainer container = null;
		try{
			MaintMainEdiiMapper mapper = new MaintMainEdiiMapper();
			container = mapper.getContainer(utfPayload);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return container;
		
	}

}
