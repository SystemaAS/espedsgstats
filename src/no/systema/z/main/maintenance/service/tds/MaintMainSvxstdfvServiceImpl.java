/**
 * 
 */
package no.systema.z.main.maintenance.service.tds;

import no.systema.z.main.maintenance.model.jsonjackson.dbtable.tds.JsonMaintMainSvxstdfvContainer;
import no.systema.z.main.maintenance.mapper.jsonjackson.dbtable.tds.MaintMainSvxstdfvMapper;

/**
 * 
 * @author oscardelatorre
 * @date Jun 21, 2017
 * 
 * 
 */
public class MaintMainSvxstdfvServiceImpl implements MaintMainSvxstdfvService {
	/**
	 * 
	 */
	public JsonMaintMainSvxstdfvContainer getList(String utfPayload) {
		JsonMaintMainSvxstdfvContainer container = null;
		try{
			MaintMainSvxstdfvMapper mapper = new MaintMainSvxstdfvMapper();
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
	public JsonMaintMainSvxstdfvContainer doUpdate(String utfPayload) {
		JsonMaintMainSvxstdfvContainer container = null;
		try{
			MaintMainSvxstdfvMapper mapper = new MaintMainSvxstdfvMapper();
			container = mapper.getContainer(utfPayload);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return container;
		
	}

}
