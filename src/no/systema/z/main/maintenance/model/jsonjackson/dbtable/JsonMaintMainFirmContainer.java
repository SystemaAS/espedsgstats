/**
 * 
 */
package no.systema.z.main.maintenance.model.jsonjackson.dbtable;

import java.util.Collection;

/**
 * @author oscardelatorre
 * @date Aug 4, 2016
 *
 */
public class JsonMaintMainFirmContainer {
	private String user = null;
	public void setUser(String value) {  this.user = value; }
	public String getUser() { return this.user;}
	
	private String errMsg = null;
	public void setErrMsg(String value) {  this.errMsg = value; }
	public String getErrMsg() { return this.errMsg;}
	
	
	private Collection<JsonMaintMainFirmRecord> list;
	public void setList(Collection<JsonMaintMainFirmRecord> value){ this.list = value; }
	public Collection<JsonMaintMainFirmRecord> getList(){ return list; }
	
}
