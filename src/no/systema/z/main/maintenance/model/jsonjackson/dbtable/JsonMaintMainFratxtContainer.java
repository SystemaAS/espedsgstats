/**
 * 
 */
package no.systema.z.main.maintenance.model.jsonjackson.dbtable;

import java.util.Collection;

/**
 * @author Fredrik Möller
 * @date Mar 13, 2016
 *
 */
public class JsonMaintMainFratxtContainer implements IJsonMaintMainContainer {
	private String user = null;
	public void setUser(String value) {  this.user = value; }
	public String getUser() { return this.user;}
	
	private String errMsg = null;
	public void setErrMsg(String value) {  this.errMsg = value; }
	public String getErrMsg() { return this.errMsg;}
	
	
	private Collection<JsonMaintMainFratxtRecord> dtoList;
	public void setList(Collection<JsonMaintMainFratxtRecord> value){ this.dtoList = value; }
	public Collection<JsonMaintMainFratxtRecord> getDtoList(){ return dtoList; }
	
}
