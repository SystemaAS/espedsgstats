/**
 * 
 */
package no.systema.z.main.maintenance.service.skat;

import no.systema.z.main.maintenance.model.jsonjackson.dbtable.skat.JsonMaintMainDkeaContainer;
import no.systema.z.main.maintenance.mapper.jsonjackson.dbtable.skat.MaintMainDkeaMapper;

/**
 * 
 * @author oscardelatorre
 * @date Apr 26, 2017
 * 
 * 
 */
public class MaintMainDkeaServiceImpl implements MaintMainDkeaService {
	/**
	 * 
	 */
	public JsonMaintMainDkeaContainer getList(String utfPayload) {
		JsonMaintMainDkeaContainer container = null;
		try{
			MaintMainDkeaMapper mapper = new MaintMainDkeaMapper();
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
	public JsonMaintMainDkeaContainer doUpdate(String utfPayload) {
		JsonMaintMainDkeaContainer container = null;
		try{
			MaintMainDkeaMapper mapper = new MaintMainDkeaMapper();
			container = mapper.getContainer(utfPayload);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return container;
		
	}

}
