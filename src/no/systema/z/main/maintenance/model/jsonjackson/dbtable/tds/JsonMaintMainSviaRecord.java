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
 * @date Jun 13, 2017
 * 
 */

public class JsonMaintMainSviaRecord extends JsonAbstractGrandFatherRecord  {
	private NumberFormatterLocaleAware numberFormatter = new NumberFormatterLocaleAware();
	
	private String svia_syav = null;                             
	public void setSvia_syav (String value){ this.svia_syav = value;   }   	
	public String getSvia_syav (){ return this.svia_syav;   }  
	
	private String svia_syop = null;                                
	public void setSvia_syop (String value){ this.svia_syop = value;   }   
	public String getSvia_syop (){ return this.svia_syop;   }  
	
	private String svia_omeo = null;                                
	public void setSvia_omeo (String value){ this.svia_omeo = value;   }   
	public String getSvia_omeo (){ return this.svia_omeo;   }  
	
	private String svia_omha = null;                                
	public void setSvia_omha (String value){ this.svia_omha = value;   }   
	public String getSvia_omha (){ return this.svia_omha;   }  
	
	private String svia_omtl = null;                                
	public void setSvia_omtl (String value){ this.svia_omtl = value;   }   
	public String getSvia_omtl (){ return this.svia_omtl;   }  
	
	private String svia_omty = null;                                
	public void setSvia_omty (String value){ this.svia_omty = value;   }   
	public String getSvia_omty (){ return this.svia_omty;   }  
	
	private String svia_0035 = null;                                
	public void setSvia_0035 (String value){ this.svia_0035 = value;   }   
	public String getSvia_0035 (){ return this.svia_0035;   }  
	
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
