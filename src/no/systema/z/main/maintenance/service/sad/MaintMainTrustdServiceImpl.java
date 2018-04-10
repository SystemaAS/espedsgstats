/**
 * 
 */
package no.systema.z.main.maintenance.service.sad;

import no.systema.z.main.maintenance.model.jsonjackson.dbtable.sad.JsonMaintMainTrustdContainer;
import no.systema.z.main.maintenance.mapper.jsonjackson.dbtable.sad.MaintMainTrustdMapper;

/**
 * 
 * @author oscardelatorre
 * @date Sep 20, 2016
 * 
 * 
 */
public class MaintMainTrustdServiceImpl implements MaintMainTrustdService {
	/**
	 * 
	 */
	public JsonMaintMainTrustdContainer getList(String utfPayload) {
		JsonMaintMainTrustdContainer container = null;
		try{
			MaintMainTrustdMapper mapper = new MaintMainTrustdMapper();
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
	public JsonMaintMainTrustdContainer doUpdate(String utfPayload) {
		JsonMaintMainTrustdContainer container = null;
		try{
			MaintMainTrustdMapper mapper = new MaintMainTrustdMapper();
			container = mapper.getContainer(utfPayload);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return container;
		
	}

}
