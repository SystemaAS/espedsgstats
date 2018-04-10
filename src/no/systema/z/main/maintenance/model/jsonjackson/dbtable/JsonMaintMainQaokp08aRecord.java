package no.systema.z.main.maintenance.model.jsonjackson.dbtable;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

import no.systema.main.model.jsonjackson.general.JsonAbstractGrandFatherRecord;

/**
 * All variables must be initialized to empty strings and NOT to NULL values
 * This is because the db-inserts that will be done in all fields of the db-table
 * 
 * @author oscardelatorre
 * @date May 05, 2017
 * 
 */
public class JsonMaintMainQaokp08aRecord extends JsonAbstractGrandFatherRecord  {
	
	private String wos8dden = "";                              
	public String getWos8ddenPropertyName (){ return "wos8dden"; }
	public void setWos8dden (String value){ this.wos8dden = value;   }   
	public String getWos8dden (){ return this.wos8dden;   }  
	
	private String wos8ddgn = "";                                
	public String getWos8ddgnPropertyName (){ return "wos8ddgn"; }
	public void setWos8ddgn (String value){ this.wos8ddgn = value;   }   
	public String getWos8ddgn (){ return this.wos8ddgn;   }  
	
	private String wos8desc = ""; 
	public String getWos8descPropertyName (){ return "wos8desc"; }
	public void setWos8desc (String value){ this.wos8desc = value;   }   
	public String getWos8desc (){ return this.wos8desc;   }              

	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public List<Field> getFields() throws Exception {
		Class cl = Class.forName(this.getClass().getCanonicalName());
		Field[] fields = cl.getDeclaredFields();
		List<Field> list = Arrays.asList(fields);

		return list;
	}

}
