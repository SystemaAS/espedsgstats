/**
 * 
 */
package no.systema.z.main.maintenance.service;

import no.systema.z.main.maintenance.model.jsonjackson.dbtable.JsonMaintMainFirmContainer;

/**
 * 
 * @author oscardelatorre
 * @date Aug 3, 2016
 * 
 *
 */
public interface MaintMainFirmService {
	public JsonMaintMainFirmContainer getList(String utfPayload);
	public JsonMaintMainFirmContainer doUpdate(String utfPayload);
	
}
