/**
 * 
 */
package no.systema.z.main.maintenance.service;

import no.systema.z.main.maintenance.model.jsonjackson.dbtable.JsonMaintMainFirmContainer;
import no.systema.z.main.maintenance.mapper.jsonjackson.dbtable.MaintMainFirmMapper;

/**
 * 
 * @author oscardelatorre
 * @date Aug 4, 2016
 * 
 * 
 */
public class MaintMainFirmServiceImpl implements MaintMainFirmService {
	/**
	 * 
	 */
	public JsonMaintMainFirmContainer getList(String utfPayload) {
		JsonMaintMainFirmContainer container = null;
		try{
			MaintMainFirmMapper mapper = new MaintMainFirmMapper();
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
	public JsonMaintMainFirmContainer doUpdate(String utfPayload) {
		JsonMaintMainFirmContainer container = null;
		try{
			MaintMainFirmMapper mapper = new MaintMainFirmMapper();
			container = mapper.getContainer(utfPayload);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return container;
		
	}

}
