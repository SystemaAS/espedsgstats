/**
 * 
 */
package no.systema.z.main.maintenance.model.jsonjackson.dbtable.sad;

import java.util.Collection;

/**
 * @author oscardelatorre
 * @date Sep 16, 2016
 *
 */
public class JsonMaintMainStandeContainer {
	private String user = null;
	public void setUser(String value) {  this.user = value; }
	public String getUser() { return this.user;}
	
	private String errMsg = null;
	public void setErrMsg(String value) {  this.errMsg = value; }
	public String getErrMsg() { return this.errMsg;}
	
	
	private Collection<JsonMaintMainStandeRecord> list;
	public void setList(Collection<JsonMaintMainStandeRecord> value){ this.list = value; }
	public Collection<JsonMaintMainStandeRecord> getList(){ return list; }
	
}
