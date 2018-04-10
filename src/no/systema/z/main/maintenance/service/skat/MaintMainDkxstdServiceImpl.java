/**
 * 
 */
package no.systema.z.main.maintenance.service.skat;

import no.systema.z.main.maintenance.model.jsonjackson.dbtable.skat.JsonMaintMainDkxstdContainer;
import no.systema.z.main.maintenance.mapper.jsonjackson.dbtable.skat.MaintMainDkxstdMapper;

/**
 * 
 * @author oscardelatorre
 * @date Sep 20, 2016
 * 
 * 
 */
public class MaintMainDkxstdServiceImpl implements MaintMainDkxstdService {
	/**
	 * 
	 */
	public JsonMaintMainDkxstdContainer getList(String utfPayload) {
		JsonMaintMainDkxstdContainer container = null;
		try{
			MaintMainDkxstdMapper mapper = new MaintMainDkxstdMapper();
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
	public JsonMaintMainDkxstdContainer doUpdate(String utfPayload) {
		JsonMaintMainDkxstdContainer container = null;
		try{
			MaintMainDkxstdMapper mapper = new MaintMainDkxstdMapper();
			container = mapper.getContainer(utfPayload);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return container;
		
	}

}
