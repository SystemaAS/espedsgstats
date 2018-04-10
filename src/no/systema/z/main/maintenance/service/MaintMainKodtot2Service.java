/**
 * 
 */
package no.systema.z.main.maintenance.service;

import no.systema.z.main.maintenance.model.jsonjackson.dbtable.JsonMaintMainKodtot2Container;

/**
 * 
 * @author oscardelatorre
 * @date Sep 8, 2016
 * 
 *
 */
public interface MaintMainKodtot2Service {
	public JsonMaintMainKodtot2Container getList(String utfPayload);
	public JsonMaintMainKodtot2Container doUpdate(String utfPayload);
	
}
