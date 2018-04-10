/**
 * 
 */
package no.systema.z.main.maintenance.service;

import no.systema.z.main.maintenance.model.jsonjackson.dbtable.JsonMaintMainSyparfContainer;

/**
 * 
 * @author Fredrik Möller
 * @date Nov 22, 2016
 * 
 *
 */
public interface MaintMainSyparfService {
	/**
	 * Get JsonMaintMainSyparfContainer
	 * 
	 * @param utfPayload
	 * @return JsonMaintMainSyparfContainer
	 */
	public JsonMaintMainSyparfContainer getContainer(String utfPayload);
	
}
