/**
 * 
 */
package no.systema.z.main.maintenance.service.tds;

import no.systema.z.main.maintenance.model.jsonjackson.dbtable.tds.JsonMaintMainSveaContainer;

/**
 * 
 * @author oscardelatorre
 * @date Jun 08, 2017
 * 
 *
 */
public interface MaintMainSveaService {
	public JsonMaintMainSveaContainer getList(String utfPayload);
	public JsonMaintMainSveaContainer doUpdate(String utfPayload);
	
}
