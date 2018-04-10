/**
 * 
 */
package no.systema.z.main.maintenance.service;

import no.systema.z.main.maintenance.model.jsonjackson.dbtable.JsonMaintMainKodtotyContainer;

/**
 * 
 * @author Fredrik Möller
 * @date Mar 13, 2017
 * 
 *
 */
public interface MaintMainKodtotyService {

	public JsonMaintMainKodtotyContainer getContainer(String utfPayload);
	
}
