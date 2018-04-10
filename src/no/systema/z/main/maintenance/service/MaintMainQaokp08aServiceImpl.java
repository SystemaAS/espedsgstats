/**
 * 
 */
package no.systema.z.main.maintenance.service;

import no.systema.z.main.maintenance.model.jsonjackson.dbtable.JsonMaintMainQaokp08aContainer;
import no.systema.z.main.maintenance.mapper.jsonjackson.dbtable.MaintMainQaokp08aMapper;

/**
 * 
 * @author oscardelatorre
 * @date May 5, 2017
 * 
 * 
 */
public class MaintMainQaokp08aServiceImpl implements MaintMainQaokp08aService {
	/**
	 * 
	 */
	public JsonMaintMainQaokp08aContainer getList(String utfPayload) {
		JsonMaintMainQaokp08aContainer container = null;
		try{
			MaintMainQaokp08aMapper mapper = new MaintMainQaokp08aMapper();
			container = mapper.getContainer(utfPayload);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return container;
		
	}

}
