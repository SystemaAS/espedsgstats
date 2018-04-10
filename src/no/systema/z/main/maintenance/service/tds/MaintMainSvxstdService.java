/**
 * 
 */
package no.systema.z.main.maintenance.service.tds;

import no.systema.z.main.maintenance.model.jsonjackson.dbtable.tds.JsonMaintMainSvxstdContainer;

/**
 * 
 * @author oscardelatorre
 * @date Jun 16, 2017
 * 
 *
 */
public interface MaintMainSvxstdService {
	public JsonMaintMainSvxstdContainer getList(String utfPayload);
	public JsonMaintMainSvxstdContainer doUpdate(String utfPayload);
	
}
