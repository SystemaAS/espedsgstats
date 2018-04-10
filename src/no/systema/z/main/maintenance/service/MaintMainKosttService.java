/**
 * 
 */
package no.systema.z.main.maintenance.service;

import no.systema.z.main.maintenance.model.jsonjackson.dbtable.JsonMaintMainKosttContainer;

/**
 * 
 * @author oscardelatorre
 * @date Apr 21, 2017
 * 
 */
public interface MaintMainKosttService {
	public JsonMaintMainKosttContainer getList(String utfPayload);
	public JsonMaintMainKosttContainer doUpdate(String utfPayload);
	
}
