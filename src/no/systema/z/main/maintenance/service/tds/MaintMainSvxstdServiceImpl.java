/**
 * 
 */
package no.systema.z.main.maintenance.service.tds;

import no.systema.z.main.maintenance.model.jsonjackson.dbtable.tds.JsonMaintMainSvxstdContainer;
import no.systema.z.main.maintenance.mapper.jsonjackson.dbtable.tds.MaintMainSvxstdMapper;

/**
 * 
 * @author oscardelatorre
 * @date Jun 13, 2017
 * 
 * 
 */
public class MaintMainSvxstdServiceImpl implements MaintMainSvxstdService {
	/**
	 * 
	 */
	public JsonMaintMainSvxstdContainer getList(String utfPayload) {
		JsonMaintMainSvxstdContainer container = null;
		try{
			MaintMainSvxstdMapper mapper = new MaintMainSvxstdMapper();
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
	public JsonMaintMainSvxstdContainer doUpdate(String utfPayload) {
		JsonMaintMainSvxstdContainer container = null;
		try{
			MaintMainSvxstdMapper mapper = new MaintMainSvxstdMapper();
			container = mapper.getContainer(utfPayload);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return container;
		
	}

}
