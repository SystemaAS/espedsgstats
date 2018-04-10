/**
 * 
 */
package no.systema.z.main.maintenance.service.sad;

import no.systema.z.main.maintenance.model.jsonjackson.dbtable.sad.JsonMaintMainTristdContainer;
import no.systema.z.main.maintenance.mapper.jsonjackson.dbtable.sad.MaintMainTristdMapper;

/**
 * 
 * @author oscardelatorre
 * @date Sep 20, 2016
 * 
 * 
 */
public class MaintMainTristdServiceImpl implements MaintMainTristdService {
	/**
	 * 
	 */
	public JsonMaintMainTristdContainer getList(String utfPayload) {
		JsonMaintMainTristdContainer container = null;
		try{
			MaintMainTristdMapper mapper = new MaintMainTristdMapper();
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
	public JsonMaintMainTristdContainer doUpdate(String utfPayload) {
		JsonMaintMainTristdContainer container = null;
		try{
			MaintMainTristdMapper mapper = new MaintMainTristdMapper();
			container = mapper.getContainer(utfPayload);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return container;
		
	}

}
