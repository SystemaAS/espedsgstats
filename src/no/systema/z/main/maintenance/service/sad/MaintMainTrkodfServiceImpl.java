/**
 * 
 */
package no.systema.z.main.maintenance.service.sad;

import no.systema.z.main.maintenance.model.jsonjackson.dbtable.sad.JsonMaintMainTrkodfContainer;
import no.systema.z.main.maintenance.mapper.jsonjackson.dbtable.sad.MaintMainTrkodfMapper;

/**
 * 
 * @author oscardelatorre
 * @date Sep 21, 2016
 * 
 * 
 */
public class MaintMainTrkodfServiceImpl implements MaintMainTrkodfService {
	/**
	 * 
	 */
	public JsonMaintMainTrkodfContainer getList(String utfPayload) {
		JsonMaintMainTrkodfContainer container = null;
		try{
			MaintMainTrkodfMapper mapper = new MaintMainTrkodfMapper();
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
	public JsonMaintMainTrkodfContainer doUpdate(String utfPayload) {
		JsonMaintMainTrkodfContainer container = null;
		try{
			MaintMainTrkodfMapper mapper = new MaintMainTrkodfMapper();
			container = mapper.getContainer(utfPayload);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return container;
		
	}

}
