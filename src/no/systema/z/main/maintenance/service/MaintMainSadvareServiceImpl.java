/**
 * 
 */
package no.systema.z.main.maintenance.service;

import no.systema.z.main.maintenance.mapper.jsonjackson.dbtable.MaintMainGenericMapper;
import no.systema.z.main.maintenance.model.jsonjackson.dbtable.JsonMaintMainSadvareContainer;

/**
 * 
 * @author Fredrik Möller
 * @date Nov 22, 2016
 * 
 * 
 */
public class MaintMainSadvareServiceImpl implements MaintMainSadvareService {
	
	@Override
	public JsonMaintMainSadvareContainer getContainer(String utfPayload) {
		JsonMaintMainSadvareContainer container = null;
		try {
			MaintMainGenericMapper mapper = new MaintMainGenericMapper(new JsonMaintMainSadvareContainer());
			container = (JsonMaintMainSadvareContainer)mapper.getContainer(utfPayload);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return container;

	}

}
