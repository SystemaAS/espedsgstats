/**
 * 
 */
package no.systema.z.main.maintenance.service.tds;

import no.systema.z.main.maintenance.model.jsonjackson.dbtable.tds.JsonMaintMainSviaContainer;
import no.systema.z.main.maintenance.mapper.jsonjackson.dbtable.tds.MaintMainSviaMapper;

/**
 * 
 * @author oscardelatorre
 * @date Jun 13, 2017
 * 
 * 
 */
public class MaintMainSviaServiceImpl implements MaintMainSviaService {
	/**
	 * 
	 */
	public JsonMaintMainSviaContainer getList(String utfPayload) {
		JsonMaintMainSviaContainer container = null;
		try{
			MaintMainSviaMapper mapper = new MaintMainSviaMapper();
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
	public JsonMaintMainSviaContainer doUpdate(String utfPayload) {
		JsonMaintMainSviaContainer container = null;
		try{
			MaintMainSviaMapper mapper = new MaintMainSviaMapper();
			container = mapper.getContainer(utfPayload);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return container;
		
	}

}
