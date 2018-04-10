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

public class JsonMaintMainDkeaRecord extends JsonAbstractGrandFatherRecord  {
	private NumberFormatterLocaleAware numberFormatter = new NumberFormatterLocaleAware();
	
	private String dkea_syav = null;                             
	public void setDkea_syav (String value){ this.dkea_syav = value;   }   	
	public String getDkea_syav (){ return this.dkea_syav;   }  
	
	private String dkea_syop = null;                                
	public void setDkea_syop (String value){ this.dkea_syop = value;   }   
	public String getDkea_syop (){ return this.dkea_syop;   }  
	
	private String dkea_14a = null;                                
	public void setDkea_14a (String value){ this.dkea_14a = value;   }   
	public String getDkea_14a (){ return this.dkea_14a;   }  
	
	private String dkea_14b = null;                                
	public void setDkea_14b (String value){ this.dkea_14b = value;   }   
	public String getDkea_14b (){ return this.dkea_14b;   }  
	
	private String dkea_14c = null;                                
	public void setDkea_14c (String value){ this.dkea_14c = value;   }   
	public String getDkea_14c (){ return this.dkea_14c;   }  
	
	private String dkea_14d = null;                                
	public void setDkea_14d (String value){ this.dkea_14d = value;   }   
	public String getDkea_14d (){ return this.dkea_14d;   }  
	
	private String dkea_14e = null;                                
	public void setDkea_14e (String value){ this.dkea_14e = value;   }   
	public String getDkea_14e (){ return this.dkea_14e;   }  
	
	private String dkea_14f = null;                                
	public void setDkea_14f (String value){ this.dkea_14f = value;   }   
	public String getDkea_14f (){ return this.dkea_14f;   }  
	
	private String dkea_0035 = null;                                
	public void setDkea_0035 (String value){ this.dkea_0035 = value;   }   
	public String getDkea_0035 (){ return this.dkea_0035;   }  
	
	private String dkea_ftip = null;                                
	public void setDkea_ftip (String value){ this.dkea_ftip = value;   }   
	public String getDkea_ftip (){ return this.dkea_ftip;   }  
	
	private String dkea_us = null;                                
	public void setDkea_us (String value){ this.dkea_us = value;   }   
	public String getDkea_us (){ return this.dkea_us;   }  
	
	private String dkea_pw = null;                                
	public void setDkea_pw (String value){ this.dkea_pw = value;   }   
	public String getDkea_pw (){ return this.dkea_pw;   }  
	
	private String dkea_prtf = null;                                
	public void setDkea_prtf (String value){ this.dkea_prtf = value;   }   
	public String getDkea_prtf (){ return this.dkea_prtf;   }  
	
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
