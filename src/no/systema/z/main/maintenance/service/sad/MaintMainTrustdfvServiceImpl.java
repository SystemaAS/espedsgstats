/**
 * 
 */
package no.systema.z.main.maintenance.service.sad;

import no.systema.z.main.maintenance.model.jsonjackson.dbtable.sad.JsonMaintMainTrustdfvContainer;
import no.systema.z.main.maintenance.mapper.jsonjackson.dbtable.sad.MaintMainTrustdfvMapper;

/**
 * 
 * @author oscardelatorre
 * @date Sep 20, 2016
 * 
 * 
 */
public class MaintMainTrustdfvServiceImpl implements MaintMainTrustdfvService {
	/**
	 * 
	 */
	public JsonMaintMainTrustdfvContainer getList(String utfPayload) {
		JsonMaintMainTrustdfvContainer container = null;
		try{
			MaintMainTrustdfvMapper mapper = new MaintMainTrustdfvMapper();
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
	public JsonMaintMainTrustdfvContainer doUpdate(String utfPayload) {
		JsonMaintMainTrustdfvContainer container = null;
		try{
			MaintMainTrustdfvMapper mapper = new MaintMainTrustdfvMapper();
			container = mapper.getContainer(utfPayload);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return container;
		
	}

}
