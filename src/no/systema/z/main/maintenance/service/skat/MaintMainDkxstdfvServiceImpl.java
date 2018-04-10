/**
 * 
 */
package no.systema.z.main.maintenance.service.skat;

import no.systema.z.main.maintenance.model.jsonjackson.dbtable.skat.JsonMaintMainDkxstdfvContainer;
import no.systema.z.main.maintenance.mapper.jsonjackson.dbtable.skat.MaintMainDkxstdfvMapper;

/**
 * 
 * @author oscardelatorre
 * @date Sep 20, 2016
 * 
 * 
 */
public class MaintMainDkxstdfvServiceImpl implements MaintMainDkxstdfvService {
	/**
	 * 
	 */
	public JsonMaintMainDkxstdfvContainer getList(String utfPayload) {
		JsonMaintMainDkxstdfvContainer container = null;
		try{
			MaintMainDkxstdfvMapper mapper = new MaintMainDkxstdfvMapper();
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
	public JsonMaintMainDkxstdfvContainer doUpdate(String utfPayload) {
		JsonMaintMainDkxstdfvContainer container = null;
		try{
			MaintMainDkxstdfvMapper mapper = new MaintMainDkxstdfvMapper();
			container = mapper.getContainer(utfPayload);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return container;
		
	}

}
