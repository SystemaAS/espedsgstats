/**
 * 
 */
package no.systema.z.main.maintenance.service;

import no.systema.z.main.maintenance.model.jsonjackson.dbtable.JsonMaintMainKodtpUtskrsContainer;

/**
 * 
 * @author oscardelatorre
 * @date Aug 9, 2016
 * 
 *
 */
public interface MaintMainKodtpUtskrsService {
	public JsonMaintMainKodtpUtskrsContainer getList(String utfPayload);
	public JsonMaintMainKodtpUtskrsContainer doUpdate(String utfPayload);
	
	
}
