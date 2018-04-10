package no.systema.z.main.maintenance.model.jsonjackson.dbtable.sad;
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
 * @date Sep 21, 2016
 * 
 */
public class JsonMaintMainTrkodfRecord extends JsonAbstractGrandFatherRecord {
	private NumberFormatterLocaleAware numberFormatter = new NumberFormatterLocaleAware();
	
	private String tkunik = "";                             
	public String getTkunikPropertyName (){ return "tkunik"; }
	public void setTkunik (String value){ this.tkunik = value;   }   
	public String getTkunik (){ return this.tkunik;   }  
	
	private String tkkode = "";                                
	public String getTkkodePropertyName (){ return "tkkode"; }
	public void setTkkode (String value){ this.tkkode = value;   }   
	public String getTkkode (){ return this.tkkode;   }  
	
	private String tktxtn = "";                                
	public String getTktxtnPropertyName (){ return "tktxtn"; }
	public void setTktxtn (String value){ this.tktxtn = value;   }   
	public String getTktxtn (){ return this.tktxtn;   }  
	
	private String tktxte = "";                                
	public String getTktxtePropertyName (){ return "tktxte"; }
	public void setTktxte (String value){ this.tktxte = value;   }   
	public String getTktxte (){ return this.tktxte;   }  
	
	private String tkavg = "";                                
	public String getTkavgPropertyName (){ return "tkavg"; }
	public void setTkavg (String value){ this.tkavg = value;   }   
	public String getTkavg (){ return this.tkavg;   }  
	
	
	private String tkank = "";                                
	public String getTkankPropertyName (){ return "tkank"; }
	public void setTkank (String value){ this.tkank = value;   }   
	public String getTkank (){ return this.tkank;   }  
	
	private String tktrs = "";                                
	public String getTktrsPropertyName (){ return "tktrs"; }
	public void setTktrs (String value){ this.tktrs = value;   }   
	public String getTktrs (){ return this.tktrs;   }  
	
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
