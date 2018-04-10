/**
 * 
 */
package no.systema.z.main.maintenance.service;

import no.systema.z.main.maintenance.model.jsonjackson.dbtable.JsonMaintMainKodtaHodeContainer;

/**
 * 
 * @author oscardelatorre
 * @date Aug 17, 2016
 * 
 *
 */
public interface MaintMainKodtaHodeService {
	public JsonMaintMainKodtaHodeContainer getList(String utfPayload);
	public JsonMaintMainKodtaHodeContainer doUpdate(String utfPayload);
	
	
}
