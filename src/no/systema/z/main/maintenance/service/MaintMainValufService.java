/**
 * 
 */
package no.systema.z.main.maintenance.service;

import no.systema.z.main.maintenance.model.jsonjackson.dbtable.JsonMaintMainValufContainer;

/**
 * 
 * @author Fredrik Möller
 * @date Mar 13, 2017
 * 
 *
 */
public interface MaintMainValufService {

	public JsonMaintMainValufContainer getContainer(String utfPayload);
	
}
