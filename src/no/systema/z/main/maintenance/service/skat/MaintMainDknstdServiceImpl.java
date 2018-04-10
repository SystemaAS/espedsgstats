/**
 * 
 */
package no.systema.z.main.maintenance.service.skat;

import no.systema.z.main.maintenance.model.jsonjackson.dbtable.skat.JsonMaintMainDknstdContainer;
import no.systema.z.main.maintenance.mapper.jsonjackson.dbtable.skat.MaintMainDknstdMapper;

/**
 * 
 * @author oscardelatorre
 * @date Sep 20, 2016
 * 
 * 
 */
public class MaintMainDknstdServiceImpl implements MaintMainDknstdService {
	/**
	 * 
	 */
	public JsonMaintMainDknstdContainer getList(String utfPayload) {
		JsonMaintMainDknstdContainer container = null;
		try{
			MaintMainDknstdMapper mapper = new MaintMainDknstdMapper();
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
	public JsonMaintMainDknstdContainer doUpdate(String utfPayload) {
		JsonMaintMainDknstdContainer container = null;
		try{
			MaintMainDknstdMapper mapper = new MaintMainDknstdMapper();
			container = mapper.getContainer(utfPayload);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return container;
		
	}

}
