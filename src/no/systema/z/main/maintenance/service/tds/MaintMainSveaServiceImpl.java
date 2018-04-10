/**
 * 
 */
package no.systema.z.main.maintenance.service.tds;

import no.systema.z.main.maintenance.model.jsonjackson.dbtable.tds.JsonMaintMainSveaContainer;
import no.systema.z.main.maintenance.mapper.jsonjackson.dbtable.tds.MaintMainSveaMapper;

/**
 * 
 * @author oscardelatorre
 * @date Jun 08, 2017
 * 
 * 
 */
public class MaintMainSveaServiceImpl implements MaintMainSveaService {
	/**
	 * 
	 */
	public JsonMaintMainSveaContainer getList(String utfPayload) {
		JsonMaintMainSveaContainer container = null;
		try{
			MaintMainSveaMapper mapper = new MaintMainSveaMapper();
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
	public JsonMaintMainSveaContainer doUpdate(String utfPayload) {
		JsonMaintMainSveaContainer container = null;
		try{
			MaintMainSveaMapper mapper = new MaintMainSveaMapper();
			container = mapper.getContainer(utfPayload);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return container;
		
	}

}
