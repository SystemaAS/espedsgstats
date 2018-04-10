/**
 * 
 */
package no.systema.z.main.maintenance.service;

import no.systema.z.main.maintenance.model.jsonjackson.dbtable.JsonMaintMainKodtaTellContainer;
import no.systema.z.main.maintenance.mapper.jsonjackson.dbtable.MaintMainKodtaTellMapper;

/**
 * 
 * @author oscardelatorre
 * @date Aug 19, 2016
 * 
 * 
 */
public class MaintMainKodtaTellServiceImpl implements MaintMainKodtaTellService {
	/**
	 * 
	 */
	public JsonMaintMainKodtaTellContainer getList(String utfPayload) {
		JsonMaintMainKodtaTellContainer container = null;
		try{
			MaintMainKodtaTellMapper mapper = new MaintMainKodtaTellMapper();
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
	public JsonMaintMainKodtaTellContainer doUpdate(String utfPayload) {
		JsonMaintMainKodtaTellContainer container = null;
		try{
			MaintMainKodtaTellMapper mapper = new MaintMainKodtaTellMapper();
			container = mapper.getContainer(utfPayload);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return container;
		
	}
	
}
