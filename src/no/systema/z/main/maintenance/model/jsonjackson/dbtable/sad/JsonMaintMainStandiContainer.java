/**
 * 
 */
package no.systema.z.main.maintenance.model.jsonjackson.dbtable.sad;

import java.util.Collection;

/**
 * @author oscardelatorre
 * @date Aug 25, 2016
 *
 */
public class JsonMaintMainStandiContainer {
	private String user = null;
	public void setUser(String value) {  this.user = value; }
	public String getUser() { return this.user;}
	
	private String errMsg = null;
	public void setErrMsg(String value) {  this.errMsg = value; }
	public String getErrMsg() { return this.errMsg;}
	
	
	private Collection<JsonMaintMainStandiRecord> list;
	public void setList(Collection<JsonMaintMainStandiRecord> value){ this.list = value; }
	public Collection<JsonMaintMainStandiRecord> getList(){ return list; }
	
}
