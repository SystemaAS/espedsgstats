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
 * @date Aug 17, 2016
 * 
 */
public class JsonMaintMainKodtaHodeRecord extends JsonAbstractGrandFatherRecord  {
	
	//KODTA table
	private String koaavd = null;                                
	public void setKoaavd (String value){ this.koaavd = value;   }   
	public String getKoaavd (){ return this.koaavd;   }  
	
	private String koanvn = null;                                
	public void setKoanvn (String value){ this.koanvn = value;   }   
	public String getKoanvn (){ return this.koanvn;   }  
	
	//HODE table
	private String hoavd = null;                                
	public void setHoavd (String value){ this.hoavd = value;   }   
	public String getHoavd (){ return this.hoavd;   }  
	
	private String honet = null;                                
	public void setHonet (String value){ this.honet = value;   }   
	public String getHonet (){ return this.honet;   }  
	
	private String hostfr = null;                                
	public void setHostfr (String value){ this.hostfr = value;   }   
	public String getHostfr (){ return this.hostfr;   }  
	
	private String kopty = null;                                
	public void setKopty (String value){ this.kopty = value;   }   
	public String getKopty (){ return this.kopty;   }  
	
	private String hobt1 = null;                                
	public void setHobt1 (String value){ this.hobt1 = value;   }   
	public String getHobt1 (){ return this.hobt1;   }  
	
	private String hobt2 = null;                                
	public void setHobt2 (String value){ this.hobt2 = value;   }   
	public String getHobt2 (){ return this.hobt2;   }  
	
	private String hobt3 = null;                                
	public void setHobt3 (String value){ this.hobt3 = value;   }   
	public String getHobt3 (){ return this.hobt3;   }  
	
	private String hoht1 = null;                                
	public void setHoht1 (String value){ this.hoht1 = value;   }   
	public String getHoht1 (){ return this.hoht1;   }  
	
	private String hoht2 = null;                                
	public void setHoht2 (String value){ this.hoht2 = value;   }   
	public String getHoht2 (){ return this.hoht2;   }  
	
	private String hoht3 = null;                                
	public void setHoht3 (String value){ this.hoht3 = value;   }   
	public String getHoht3 (){ return this.hoht3;   }  
	
	private String hoht4 = null;                                
	public void setHoht4 (String value){ this.hoht4 = value;   }   
	public String getHoht4 (){ return this.hoht4;   }  
	
	private String hoht5 = null;                                
	public void setHoht5 (String value){ this.hoht5 = value;   }   
	public String getHoht5 (){ return this.hoht5;   }  
	
	private String hoht6 = null;                                
	public void setHoht6 (String value){ this.hoht6 = value;   }   
	public String getHoht6 (){ return this.hoht6;   }  
	
	private String hoht7 = null;                                
	public void setHoht7 (String value){ this.hoht7 = value;   }   
	public String getHoht7 (){ return this.hoht7;   }  
	
	
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
