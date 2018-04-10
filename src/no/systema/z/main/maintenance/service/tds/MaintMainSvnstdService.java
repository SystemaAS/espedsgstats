/**
 * 
 */
package no.systema.z.main.maintenance.service.tds;

import no.systema.z.main.maintenance.model.jsonjackson.dbtable.tds.JsonMaintMainSvnstdContainer;

/**
 * 
 * @author oscardelatorre
 * @date Jun 26, 2017
 * 
 *
 */
public interface MaintMainSvnstdService {
	public JsonMaintMainSvnstdContainer getList(String utfPayload);
	public JsonMaintMainSvnstdContainer doUpdate(String utfPayload);
	
}
