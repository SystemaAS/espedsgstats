/**
 * 
 */
package no.systema.z.main.maintenance.service.skat;

import no.systema.z.main.maintenance.model.jsonjackson.dbtable.skat.JsonMaintMainDkiaContainer;
import no.systema.z.main.maintenance.mapper.jsonjackson.dbtable.skat.MaintMainDkiaMapper;

/**
 * 
 * @author oscardelatorre
 * @date Apr 26, 2017
 * 
 * 
 */
public class MaintMainDkiaServiceImpl implements MaintMainDkiaService {
	/**
	 * 
	 */
	public JsonMaintMainDkiaContainer getList(String utfPayload) {
		JsonMaintMainDkiaContainer container = null;
		try{
			MaintMainDkiaMapper mapper = new MaintMainDkiaMapper();
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
	public JsonMaintMainDkiaContainer doUpdate(String utfPayload) {
		JsonMaintMainDkiaContainer container = null;
		try{
			MaintMainDkiaMapper mapper = new MaintMainDkiaMapper();
			container = mapper.getContainer(utfPayload);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return container;
		
	}

}
