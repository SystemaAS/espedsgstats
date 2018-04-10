/**
 * 
 */
package no.systema.z.main.maintenance.service;

import no.systema.z.main.maintenance.mapper.jsonjackson.dbtable.MaintMainGenericMapper;
import no.systema.z.main.maintenance.model.jsonjackson.dbtable.JsonMaintMainFratxtContainer;

/**
 * 
 * @author Fredrik Möller
 * @date Mar 13, 2017
 * 
 * 
 */
public class MaintMainFratxtServiceImpl implements MaintMainFratxtService {
	
	@Override
	public JsonMaintMainFratxtContainer getContainer(String utfPayload) {
		JsonMaintMainFratxtContainer container = null;
		try {
			MaintMainGenericMapper mapper = new MaintMainGenericMapper(new JsonMaintMainFratxtContainer());
			container = (JsonMaintMainFratxtContainer)mapper.getContainer(utfPayload);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return container;

	}

}
