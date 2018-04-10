/**
 * 
 */
package no.systema.z.main.maintenance.model.jsonjackson.dbtable;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * @author oscardelatorre
 * @date Sep 22, 2016
 *
 */
public class JsonMaintMainKodtot2Container {
	private String user = null;
	public void setUser(String value) {  this.user = value; }
	public String getUser() { return this.user;}
	
	private String errMsg = null;
	public void setErrMsg(String value) {  this.errMsg = value; }
	public String getErrMsg() { return this.errMsg;}
	
	
	private Collection<JsonMaintMainKodtot2Record> list;
	public void setList(Collection<JsonMaintMainKodtot2Record> value){ this.list = value; }
	public Collection<JsonMaintMainKodtot2Record> getList(){ return list; }
	
	
}
