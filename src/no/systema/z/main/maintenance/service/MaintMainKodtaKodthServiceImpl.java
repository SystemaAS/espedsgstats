/**
 * 
 */
package no.systema.z.main.maintenance.service;

import no.systema.z.main.maintenance.model.jsonjackson.dbtable.JsonMaintMainKodtaKodthContainer;
import no.systema.z.main.maintenance.mapper.jsonjackson.dbtable.MaintMainKodtaKodthMapper;

/**
 * 
 * @author oscardelatorre
 * @date Aug 19, 2016
 * 
 * 
 */
public class MaintMainKodtaKodthServiceImpl implements MaintMainKodtaKodthService {
	/**
	 * 
	 */
	public JsonMaintMainKodtaKodthContainer getList(String utfPayload) {
		JsonMaintMainKodtaKodthContainer container = null;
		try{
			MaintMainKodtaKodthMapper mapper = new MaintMainKodtaKodthMapper();
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
	public JsonMaintMainKodtaKodthContainer doUpdate(String utfPayload) {
		JsonMaintMainKodtaKodthContainer container = null;
		try{
			MaintMainKodtaKodthMapper mapper = new MaintMainKodtaKodthMapper();
			container = mapper.getContainer(utfPayload);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return container;
		
	}
	
}
