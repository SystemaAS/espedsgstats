package no.systema.z.main.maintenance.model.jsonjackson.dbtable;
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
 * @date Sep 22, 2016
 * 
 */
public class JsonMaintMainKodtot2Record extends JsonAbstractGrandFatherRecord  {
	
	private String ko2sta = "";                             
	public String getKo2staPropertyName (){ return "ko2sta"; }
	public void setKo2sta (String value){ this.ko2sta = value;   }   
	public String getKo2sta (){ return this.ko2sta;   }  
	
	private String ko2uni = "";                                
	public String getKo2uniPropertyName (){ return "ko2uni"; }
	public void setKo2uni (String value){ this.ko2uni = value;   }   
	public String getKo2uni (){ return this.ko2uni;   }  
	
	private String ko2kod = "";                                
	public String getKo2kodPropertyName (){ return "ko2kod"; }
	public void setKo2kod (String value){ this.ko2kod = value;   }   
	public String getKo2kod (){ return this.ko2kod;   }  
	
	private String ko2ntx = "";                                
	public String getKo2ntxPropertyName (){ return "ko2ntx"; }
	public void setKo2ntx (String value){ this.ko2ntx = value;   }   
	public String getKo2ntx (){ return this.ko2ntx;   }  
	
	private String ko2etx = "";                                
	public String getKo2etxPropertyName (){ return "ko2etx"; }
	public void setKo2etx (String value){ this.ko2etx = value;   }   
	public String getKo2etx (){ return this.ko2etx;   }  
	
	private String ko2fb = "";                                
	public String getKo2fbPropertyName (){ return "ko2fb"; }
	public void setKo2fb (String value){ this.ko2fb = value;   }   
	public String getKo2fb (){ return this.ko2fb;   }  
	
	private String ko2fps = "";                                
	public String getKo2fpsPropertyName (){ return "ko2fps"; }
	public void setKo2fps (String value){ this.ko2fps = value;   }   
	public String getKo2fps (){ return this.ko2fps;   } 
	
	private String ko2kk = "";                                
	public String getKo2kkPropertyName (){ return "ko2kk"; }
	public void setKo2kk (String value){ this.ko2kk = value;   }   
	public String getKo2kk (){ return this.ko2kk;   } 
	
	private String ko2ti = "";                                
	public String getKo2tiPropertyName (){ return "ko2ti"; }
	public void setKo2ti (String value){ this.ko2ti = value;   }   
	public String getKo2ti (){ return this.ko2ti;   }
	
	private String ko2fi = "";                                
	public String getKo2fiPropertyName (){ return "ko2fi"; }
	public void setKo2fi (String value){ this.ko2fi = value;   }   
	public String getKo2fi (){ return this.ko2fi;   }
	
	private String ko2te = "";                                
	public String getKo2tePropertyName (){ return "ko2te"; }
	public void setKo2te (String value){ this.ko2te = value;   }   
	public String getKo2te (){ return this.ko2te;   }
	
	private String ko2bi = "";                                
	public String getKo2biPropertyName (){ return "ko2bi"; }
	public void setKo2bi (String value){ this.ko2bi = value;   }   
	public String getKo2bi (){ return this.ko2bi;   }
	
	private String ko2cm = "";                                
	public String getKo2cmPropertyName (){ return "ko2cm"; }
	public void setKo2cm (String value){ this.ko2cm = value;   }   
	public String getKo2cm (){ return this.ko2cm;   }
	
	private String ko2ff = "";                                
	public String getKo2ffPropertyName (){ return "ko2ff"; }
	public void setKo2ff (String value){ this.ko2ff = value;   }   
	public String getKo2ff (){ return this.ko2ff;   }
	
	private String ko2mvk = "";                                
	public String getKo2mvkPropertyName (){ return "ko2mvk"; }
	public void setKo2mvk (String value){ this.ko2mvk = value;   }   
	public String getKo2mvk (){ return this.ko2mvk;   }
	
	private String ko2mvs = "";                                
	public String getKo2mvsPropertyName (){ return "ko2mvs"; }
	public void setKo2mvs (String value){ this.ko2mvs = value;   }   
	public String getKo2mvs (){ return this.ko2mvs;   }
	
	private String ko2st = "";                                
	public String getKo2stPropertyName (){ return "ko2st"; }
	public void setKo2st (String value){ this.ko2st = value;   }   
	public String getKo2st (){ return this.ko2st;   }
	
	private String ko2kon = "";                                
	public String getKo2konPropertyName (){ return "ko2kon"; }
	public void setKo2kon (String value){ this.ko2kon = value;   }   
	public String getKo2kon (){ return this.ko2kon;   }
	
	private String ko2utl = "";                                
	public String getKo2utlPropertyName (){ return "ko2utl"; }
	public void setKo2utl (String value){ this.ko2utl = value;   }   
	public String getKo2utl (){ return this.ko2utl;   }
	
	private String ko2xx1 = "";                                
	public String getKo2xx1PropertyName (){ return "ko2xx1"; }
	public void setKo2xx1 (String value){ this.ko2xx1 = value;   }   
	public String getKo2xx1 (){ return this.ko2xx1;   }
	
	private String ko2pst = "";                                
	public String getKo2pstPropertyName (){ return "ko2pst"; }
	public void setKo2pst (String value){ this.ko2pst = value;   }   
	public String getKo2pst (){ return this.ko2pst;   }
	
	private String ko2xx2 = "";   //Ledige platser                             
	public String getKo2xx2PropertyName (){ return "ko2xx2"; }
	public void setKo2xx2 (String value){ this.ko2xx2 = value;   }   
	public String getKo2xx2 (){ return this.ko2xx2;   }
	
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
