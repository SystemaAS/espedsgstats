/**
 * 
 */
package no.systema.z.main.maintenance.service.sad;

import no.systema.z.main.maintenance.model.jsonjackson.dbtable.sad.JsonMaintMainStandiContainer;
import no.systema.z.main.maintenance.mapper.jsonjackson.dbtable.sad.MaintMainStandiMapper;

/**
 * 
 * @author oscardelatorre
 * @date Aug 25, 2016
 * 
 * 
 */
public class MaintMainStandiServiceImpl implements MaintMainStandiService {
	/**
	 * 
	 */
	public JsonMaintMainStandiContainer getList(String utfPayload) {
		JsonMaintMainStandiContainer container = null;
		try{
			MaintMainStandiMapper mapper = new MaintMainStandiMapper();
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
	public JsonMaintMainStandiContainer doUpdate(String utfPayload) {
		JsonMaintMainStandiContainer container = null;
		try{
			MaintMainStandiMapper mapper = new MaintMainStandiMapper();
			container = mapper.getContainer(utfPayload);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return container;
		
	}

}
