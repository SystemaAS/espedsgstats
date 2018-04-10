/**
 * 
 */
package no.systema.z.main.maintenance.service;

import no.systema.z.main.maintenance.mapper.jsonjackson.dbtable.MaintMainGenericMapper;
import no.systema.z.main.maintenance.model.jsonjackson.dbtable.JsonMaintMainValufContainer;

/**
 * 
 * @author Fredrik Möller
 * @date Mar 13, 2017
 * 
 * 
 */
public class MaintMainValufServiceImpl implements MaintMainValufService {
	
	@Override
	public JsonMaintMainValufContainer getContainer(String utfPayload) {
		JsonMaintMainValufContainer container = null;
		try {
			MaintMainGenericMapper mapper = new MaintMainGenericMapper(new JsonMaintMainValufContainer());
			container = (JsonMaintMainValufContainer)mapper.getContainer(utfPayload);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return container;

	}

}
