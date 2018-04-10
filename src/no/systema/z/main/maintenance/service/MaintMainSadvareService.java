/**
 * 
 */
package no.systema.z.main.maintenance.service;

import no.systema.z.main.maintenance.model.jsonjackson.dbtable.JsonMaintMainSadvareContainer;

/**
 * 
 * @author Fredrik Möller
 * @date Nov 22, 2016
 * 
 *
 */
public interface MaintMainSadvareService {
	/**
	 * Get JsonMaintMainSadvareContainer
	 * 
	 * @param utfPayload
	 * @return JsonMaintMainSadvareContainer
	 */
	public JsonMaintMainSadvareContainer getContainer(String utfPayload);
	
}
