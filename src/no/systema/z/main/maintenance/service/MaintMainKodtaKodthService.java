/**
 * 
 */
package no.systema.z.main.maintenance.service;

import no.systema.z.main.maintenance.model.jsonjackson.dbtable.JsonMaintMainKodtaKodthContainer;

/**
 * 
 * @author oscardelatorre
 * @date Aug 19, 2016
 * 
 *
 */
public interface MaintMainKodtaKodthService {
	public JsonMaintMainKodtaKodthContainer getList(String utfPayload);
	public JsonMaintMainKodtaKodthContainer doUpdate(String utfPayload);
	
	
}
