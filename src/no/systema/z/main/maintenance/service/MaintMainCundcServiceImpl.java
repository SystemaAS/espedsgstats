/**
 * 
 */
package no.systema.z.main.maintenance.service;

import no.systema.z.main.maintenance.mapper.jsonjackson.dbtable.MaintMainCundcMapper;
import no.systema.z.main.maintenance.model.jsonjackson.dbtable.JsonMaintMainCundcContainer;

/**
 * 
 * @author Fredrik Möller
 * @date Nov 3, 2016
 * 
 * 
 */
public class MaintMainCundcServiceImpl implements MaintMainCundcService {
	/**
	 * 
	 */
	public JsonMaintMainCundcContainer getList(String utfPayload) {
		JsonMaintMainCundcContainer container = null;
		try{
			MaintMainCundcMapper mapper = new MaintMainCundcMapper();
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
	public JsonMaintMainCundcContainer doUpdate(String utfPayload) {
		JsonMaintMainCundcContainer container = null;
		try{
			MaintMainCundcMapper mapper = new MaintMainCundcMapper();
			container = mapper.getContainer(utfPayload);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return container;
		
	}

}
