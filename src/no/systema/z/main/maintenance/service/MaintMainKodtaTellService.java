/**
 * 
 */
package no.systema.z.main.maintenance.service;

import no.systema.z.main.maintenance.model.jsonjackson.dbtable.JsonMaintMainKodtaTellContainer;

/**
 * 
 * @author oscardelatorre
 * @date Aug 19, 2016
 * 
 *
 */
public interface MaintMainKodtaTellService {
	public JsonMaintMainKodtaTellContainer getList(String utfPayload);
	public JsonMaintMainKodtaTellContainer doUpdate(String utfPayload);
	
	
}
