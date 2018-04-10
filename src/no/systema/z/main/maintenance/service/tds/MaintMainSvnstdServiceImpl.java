/**
 * 
 */
package no.systema.z.main.maintenance.service.tds;

import no.systema.z.main.maintenance.model.jsonjackson.dbtable.tds.JsonMaintMainSvnstdContainer;
import no.systema.z.main.maintenance.mapper.jsonjackson.dbtable.tds.MaintMainSvnstdMapper;

/**
 * 
 * @author oscardelatorre
 * @date Jun 26, 2017
 * 
 * 
 */
public class MaintMainSvnstdServiceImpl implements MaintMainSvnstdService {
	/**
	 * 
	 */
	public JsonMaintMainSvnstdContainer getList(String utfPayload) {
		JsonMaintMainSvnstdContainer container = null;
		try{
			MaintMainSvnstdMapper mapper = new MaintMainSvnstdMapper();
			container = mapper.getContainer(utfPayload);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return container;
		
	}
	/**
	 * 
	 * @param utfPayload
	 * @return
	 */
	public JsonMaintMainSvnstdContainer doUpdate(String utfPayload) {
		JsonMaintMainSvnstdContainer container = null;
		try{
			MaintMainSvnstdMapper mapper = new MaintMainSvnstdMapper();
			container = mapper.getContainer(utfPayload);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return container;
		
	}

}
