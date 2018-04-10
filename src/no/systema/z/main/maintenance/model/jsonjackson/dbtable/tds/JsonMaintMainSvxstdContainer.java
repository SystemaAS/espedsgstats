/**
 * 
 */
package no.systema.z.main.maintenance.model.jsonjackson.dbtable.tds;

import java.util.Collection;

/**
 * @author oscardelatorre
 * @date Jun 16, 2017
 *
 */
public class JsonMaintMainSvxstdContainer {
	private String user = null;
	public void setUser(String value) {  this.user = value; }
	public String getUser() { return this.user;}
	
	private String errMsg = null;
	public void setErrMsg(String value) {  this.errMsg = value; }
	public String getErrMsg() { return this.errMsg;}
	
	private Collection<JsonMaintMainSvxstdRecord> list;
	public void setList(Collection<JsonMaintMainSvxstdRecord> value){ this.list = value; }
	public Collection<JsonMaintMainSvxstdRecord> getList(){ return list; }
	
}
