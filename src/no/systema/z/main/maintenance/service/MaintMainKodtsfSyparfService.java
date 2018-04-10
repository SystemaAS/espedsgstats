/**
 * 
 */
package no.systema.z.main.maintenance.service;

import no.systema.z.main.maintenance.model.jsonjackson.dbtable.JsonMaintMainKodtsfSyparfContainer;

/**
 * 
 * @author oscardelatorre
 * @date Okt 17, 2016
 * 
 *
 */
public interface MaintMainKodtsfSyparfService {
	public JsonMaintMainKodtsfSyparfContainer getList(String utfPayload);
	public JsonMaintMainKodtsfSyparfContainer doUpdate(String utfPayload);
	
}
