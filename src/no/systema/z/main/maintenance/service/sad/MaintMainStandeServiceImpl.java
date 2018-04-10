/**
 * 
 */
package no.systema.z.main.maintenance.service.sad;

import no.systema.z.main.maintenance.model.jsonjackson.dbtable.sad.JsonMaintMainStandeContainer;
import no.systema.z.main.maintenance.mapper.jsonjackson.dbtable.sad.MaintMainStandeMapper;

/**
 * 
 * @author oscardelatorre
 * @date Sep 16, 2016
 * 
 * 
 */
public class MaintMainStandeServiceImpl implements MaintMainStandeService {
	/**
	 * 
	 */
	public JsonMaintMainStandeContainer getList(String utfPayload) {
		JsonMaintMainStandeContainer container = null;
		try{
			MaintMainStandeMapper mapper = new MaintMainStandeMapper();
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
	public JsonMaintMainStandeContainer doUpdate(String utfPayload) {
		JsonMaintMainStandeContainer container = null;
		try{
			MaintMainStandeMapper mapper = new MaintMainStandeMapper();
			container = mapper.getContainer(utfPayload);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return container;
		
	}

}
