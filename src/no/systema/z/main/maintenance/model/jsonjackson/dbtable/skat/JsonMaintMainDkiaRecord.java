package no.systema.z.main.maintenance.model.jsonjackson.dbtable.skat;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

import no.systema.main.model.jsonjackson.general.JsonAbstractGrandFatherRecord;
import no.systema.main.util.*;

/**
 * All variables must be initialized to empty strings and NOT to NULL values
 * This is because the db-inserts that will be done in all fields of the db-table
 * 
 * @author oscardelatorre
 * @date Apr 26, 2017
 * 
 */

public class JsonMaintMainDkiaRecord extends JsonAbstractGrandFatherRecord  {
	private NumberFormatterLocaleAware numberFormatter = new NumberFormatterLocaleAware();
	
	private String dkia_syav = null;                             
	public void setDkia_syav (String value){ this.dkia_syav = value;   }   	
	public String getDkia_syav (){ return this.dkia_syav;   }  
	
	private String dkia_syop = null;                                
	public void setDkia_syop (String value){ this.dkia_syop = value;   }   
	public String getDkia_syop (){ return this.dkia_syop;   }  
	
	private String dkia_14a = null;                                
	public void setDkia_14a (String value){ this.dkia_14a = value;   }   
	public String getDkia_14a (){ return this.dkia_14a;   }  
	
	private String dkia_14b = null;                                
	public String getDkia_14bPropertyName (){ return "dkia_14b"; }
	public void setDkia_14b (String value){ this.dkia_14b = value;   }   
	public String getDkia_14b (){ return this.dkia_14b;   }  
	
	private String dkia_14c = null;                                
	public void setDkia_14c (String value){ this.dkia_14c = value;   }   
	public String getDkia_14c (){ return this.dkia_14c;   }  
	
	private String dkia_14d = null;                                
	public void setDkia_14d (String value){ this.dkia_14d = value;   }   
	public String getDkia_14d (){ return this.dkia_14d;   }  
	
	private String dkia_14e = null;                                
	public void setDkia_14e (String value){ this.dkia_14e = value;   }   
	public String getDkia_14e (){ return this.dkia_14e;   }  
	
	private String dkia_14f = null;                                
	public void setDkia_14f (String value){ this.dkia_14f = value;   }   
	public String getDkia_14f (){ return this.dkia_14f;   }  
	
	private String dkia_0035 = null;                                
	public void setDkia_0035 (String value){ this.dkia_0035 = value;   }   
	public String getDkia_0035 (){ return this.dkia_0035;   }  
	
	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public List<Field> getFields() throws Exception{
		Class cl = Class.forName(this.getClass().getCanonicalName());
		Field[] fields = cl.getDeclaredFields();
		List<Field> list = Arrays.asList(fields);
		
		return list;
	}
}
