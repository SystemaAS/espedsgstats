package no.systema.z.main.maintenance.model.jsonjackson.dbtable.tds;
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
 * @date Jun 08, 2017
 * 
 */

public class JsonMaintMainSveaRecord extends JsonAbstractGrandFatherRecord  {
	private NumberFormatterLocaleAware numberFormatter = new NumberFormatterLocaleAware();
	
	private String svea_syav = null;                             
	public void setSvea_syav (String value){ this.svea_syav = value;   }   	
	public String getSvea_syav (){ return this.svea_syav;   }  
	
	private String svea_syop = null;                                
	public void setSvea_syop (String value){ this.svea_syop = value;   }   
	public String getSvea_syop (){ return this.svea_syop;   }  
	
	private String svea_omeo = null;                                
	public void setSvea_omeo (String value){ this.svea_omeo = value;   }   
	public String getSvea_omeo (){ return this.svea_omeo;   }  
	
	private String svea_omha = null;                                
	public void setSvea_omha (String value){ this.svea_omha = value;   }   
	public String getSvea_omha (){ return this.svea_omha;   }  
	
	private String svea_omtl = null;                                
	public void setSvea_omtl (String value){ this.svea_omtl = value;   }   
	public String getSvea_omtl (){ return this.svea_omtl;   }  
	
	private String svea_omty = null;                                
	public void setSvea_omty (String value){ this.svea_omty = value;   }   
	public String getSvea_omty (){ return this.svea_omty;   }  
	
	private String svea_0035 = null;                                
	public void setSvea_0035 (String value){ this.svea_0035 = value;   }   
	public String getSvea_0035 (){ return this.svea_0035;   }  
	
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
