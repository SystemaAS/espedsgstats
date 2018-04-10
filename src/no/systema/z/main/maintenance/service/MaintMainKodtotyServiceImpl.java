/**
 * 
 */
package no.systema.z.main.maintenance.service;

import no.systema.z.main.maintenance.mapper.jsonjackson.dbtable.MaintMainGenericMapper;
import no.systema.z.main.maintenance.model.jsonjackson.dbtable.JsonMaintMainKodtotyContainer;

/**
 * 
 * @author Fredrik Möller
 * @date Mar 13, 2017
 * 
 * 
 */
public class MaintMainKodtotyServiceImpl implements MaintMainKodtotyService {
	
	@Override
	public JsonMaintMainKodtotyContainer getContainer(String utfPayload) {
		JsonMaintMainKodtotyContainer container = null;
		try {
			MaintMainGenericMapper mapper = new MaintMainGenericMapper(new JsonMaintMainKodtotyContainer());
			container = (JsonMaintMainKodtotyContainer)mapper.getContainer(utfPayload);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return container;

	}

}
