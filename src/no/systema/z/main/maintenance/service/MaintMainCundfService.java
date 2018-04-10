/**
 * 
 */
package no.systema.z.main.maintenance.service;

import no.systema.z.main.maintenance.model.jsonjackson.dbtable.JsonMaintMainCundfContainer;

/**
 * 
 * @author oscardelatorre
 * @date Aug 15, 2016
 * 
 *
 */
public interface MaintMainCundfService {
	public JsonMaintMainCundfContainer getList(String utfPayload);
	public JsonMaintMainCundfContainer doUpdate(String utfPayload);
	
}
