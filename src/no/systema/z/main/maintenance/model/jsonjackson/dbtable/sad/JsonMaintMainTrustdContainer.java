/**
 * 
 */
package no.systema.z.main.maintenance.model.jsonjackson.dbtable.sad;

import java.util.Collection;

/**
 * @author oscardelatorre
 * @date Sep 30, 2016
 *
 */
public class JsonMaintMainTrustdContainer {
	private String user = null;
	public void setUser(String value) {  this.user = value; }
	public String getUser() { return this.user;}
	
	private String errMsg = null;
	public void setErrMsg(String value) {  this.errMsg = value; }
	public String getErrMsg() { return this.errMsg;}
	
	private Collection<JsonMaintMainTrustdRecord> list;
	public void setList(Collection<JsonMaintMainTrustdRecord> value){ this.list = value; }
	public Collection<JsonMaintMainTrustdRecord> getList(){ return list; }
	
	
}
