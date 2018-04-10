package no.systema.z.main.maintenance.model.jsonjackson.dbtable;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import no.systema.main.model.jsonjackson.general.JsonAbstractGrandFatherRecord;

/**
 * All variables must be initialized to empty strings and NOT to NULL values
 * This is because the db-inserts that will be done in all fields of the db-table
 * 
 * @author oscardelatorre
 * @date Aug 5, 2016
 * 
 */
public class JsonMaintMainKodtvKodtwRecord extends JsonAbstractGrandFatherRecord {
	//KODTV
	private String kovuni = "V"; //always as default                               
	public void setKovuni (String value){ this.kovuni = value;   }   
	public String getKovuni (){ return this.kovuni;   }  
	
	private String kovavd = null;                                
	public void setKovavd (String value){ this.kovavd = value;   }   
	public String getKovavd (){ return this.kovavd;   }  
	
	private String kovlkg = null;                                
	public void setKovlkg (String value){ this.kovlkg = value;   }   
	public String getKovlkg (){ return this.kovlkg;   }  
	
	private String kovkkg = null;                                
	public void setKovkkg (String value){ this.kovkkg = value;   }   
	public String getKovkkg (){ return this.kovkkg;   }  
	
	private String kovk1 = null;                                
	public void setKovk1 (String value){ this.kovk1 = value;   }   
	public String getKovk1 (){ return this.kovk1;   }  
	
	private String kovk2 = null;                                
	public void setKovk2 (String value){ this.kovk2 = value;   }   
	public String getKovk2 (){ return this.kovk2;   }  
	
	private String kovk3 = null;                                
	public void setKovk3 (String value){ this.kovk3 = value;   }   
	public String getKovk3 (){ return this.kovk3;   }  
	
	private String kovk4 = null;                                
	public void setKovk4 (String value){ this.kovk4 = value;   }   
	public String getKovk4 (){ return this.kovk4;   }  
	
	private String kovk5 = null;                                
	public void setKovk5 (String value){ this.kovk5 = value;   }   
	public String getKovk5 (){ return this.kovk5;   }  
	
	private String kovk6 = null;                                
	public void setKovk6 (String value){ this.kovk6 = value;   }   
	public String getKovk6 (){ return this.kovk6;   }  
	
	private String kovk7 = null;                                
	public void setKovk7 (String value){ this.kovk7 = value;   }   
	public String getKovk7 (){ return this.kovk7;   }  
	
	private String kovk8 = null;                                
	public void setKovk8 (String value){ this.kovk8 = value;   }   
	public String getKovk8 (){ return this.kovk8;   }  
	
	private String kovk9 = null;                                
	public void setKovk9 (String value){ this.kovk9 = value;   }   
	public String getKovk9 (){ return this.kovk9;   }  
	
	private String kovk10 = null;                                
	public void setKovk10 (String value){ this.kovk10 = value;   }   
	public String getKovk10 (){ return this.kovk10;   }  
	
	private String kovk11 = null;                                
	public void setKovk11 (String value){ this.kovk11 = value;   }   
	public String getKovk11 (){ return this.kovk11;   }  
	
	private String kovomr = null;                                
	public void setKovomr (String value){ this.kovomr = value;   }   
	public String getKovomr (){ return this.kovomr;   }  
	
	private String kovpro = null;                                
	public void setKovpro (String value){ this.kovpro = value;   }   
	public String getKovpro (){ return this.kovpro;   }  
	
	private String kovfir = null;                                
	public void setKovfir (String value){ this.kovfir = value;   }   
	public String getKovfir (){ return this.kovfir;   }  
	
	private String kovavr = null;                                
	public void setKovavr (String value){ this.kovavr = value;   }   
	public String getKovavr (){ return this.kovavr;   }  
	
	private String kovxxx = null;                                
	public void setKovxxx (String value){ this.kovxxx = value;   }   
	public String getKovxxx (){ return this.kovxxx;   }  
	
	private String avutpr = null;                                
	public void setAvutpr (String value){ this.avutpr = value;   }   
	public String getAvutpr (){ return this.avutpr;   }  
	
	private String avutmi = null;                                
	public void setAvutmi (String value){ this.avutmi = value;   }   
	public String getAvutmi (){ return this.avutmi;   }  
	
	
	//KODTW
	private String kowuni = "W"; //always as default                               
	public void setKowuni (String value){ this.kowuni = value;   }   
	public String getKowuni (){ return this.kowuni;   }  
	
	private String kowavd = null;                                
	public void setKowavd (String value){ this.kowavd = value;   }   
	public String getKowavd (){ return this.kowavd;   }  
	
	private String kowf1 = null; 
	public void setKowf1 (String value){ this.kowf1 = value;   }   
	public String getKowf1 (){ return this.kowf1;   }              

	private String kowf2 = null; 
	public void setKowf2 (String value){ this.kowf2 = value;   }   
	public String getKowf2 (){ return this.kowf2;   }              

	private String kowf3 = null; 
	public void setKowf3 (String value){ this.kowf3 = value;   }   
	public String getKowf3 (){ return this.kowf3;   }              

	private String kowf4 = null; 
	public void setKowf4 (String value){ this.kowf4 = value;   }   
	public String getKowf4 (){ return this.kowf4;   }              

	private String kowf5 = null; 
	public void setKowf5 (String value){ this.kowf5 = value;   }   
	public String getKowf5 (){ return this.kowf5;   }              

	private String kowf6 = null; 
	public void setKowf6 (String value){ this.kowf6 = value;   }   
	public String getKowf6 (){ return this.kowf6;   }              

	private String kowf7 = null; 
	public void setKowf7 (String value){ this.kowf7 = value;   }   
	public String getKowf7 (){ return this.kowf7;   }              

	private String kowf8 = null; 
	public void setKowf8 (String value){ this.kowf8 = value;   }   
	public String getKowf8 (){ return this.kowf8;   }              

	private String kowf9 = null; 
	public void setKowf9 (String value){ this.kowf9 = value;   }   
	public String getKowf9 (){ return this.kowf9;   }              

	private String kowf10 = null; 
	public void setKowf10 (String value){ this.kowf10 = value;   }   
	public String getKowf10 (){ return this.kowf10;   }              

	private String kowf11 = null; 
	public void setKowf11 (String value){ this.kowf11 = value;   }   
	public String getKowf11 (){ return this.kowf11;   }              

	private String kowf12 = null; 
	public void setKowf12 (String value){ this.kowf12 = value;   }   
	public String getKowf12 (){ return this.kowf12;   }              

	private String kowmm = null; 
	public void setKowmm (String value){ this.kowmm = value;   }   
	public String getKowmm (){ return this.kowmm;   }              

	private String kowlas = null; 
	public void setKowlas (String value){ this.kowlas = value;   }   
	public String getKowlas (){ return this.kowlas;   }              

	private String kowawb = null; 
	public void setKowawb (String value){ this.kowawb = value;   }   
	public String getKowawb (){ return this.kowawb;   }              

	private String kowhod = null; 
	public void setKowhod (String value){ this.kowhod = value;   }   
	public String getKowhod (){ return this.kowhod;   }              

	private String kowbbs = null; 
	public void setKowbbs (String value){ this.kowbbs = value;   }   
	public String getKowbbs (){ return this.kowbbs;   }              

	private String kowxxx = null; 
	public void setKowxxx (String value){ this.kowxxx = value;   }   
	public String getKowxxx (){ return this.kowxxx;   }              

	private String kowkom = null; 
	public void setKowkom (String value){ this.kowkom = value;   }   
	public String getKowkom (){ return this.kowkom;   }              

	//Child list
	private Collection<JsonMaintMainKodtpUtskrsRecord> childList;
	public void setChildList(Collection<JsonMaintMainKodtpUtskrsRecord> value){ this.childList = value; }
	public Collection<JsonMaintMainKodtpUtskrsRecord> getChildList(){ return childList; }
	
	
	//Own fields
	//KOVXXX0
	private String kovxxx0 = null; 
	public void setKovxxx0 (String value){ this.kovxxx0 = value;   }   
	public String getKovxxx0 (){ return this.kovxxx0;   }              

	private String kovxxx1 = null; 
	public void setKovxxx1 (String value){ this.kovxxx1 = value;   }   
	public String getKovxxx1 (){ return this.kovxxx1;   }              

	private String kovxxx3 = null; 
	public void setKovxxx3 (String value){ this.kovxxx3 = value;   }   
	public String getKovxxx3 (){ return this.kovxxx3;   }              

	private String kovxxx4 = null; 
	public void setKovxxx4 (String value){ this.kovxxx4 = value;   }   
	public String getKovxxx4 (){ return this.kovxxx4;   }              

	private String kovxxx5 = null; 
	public void setKovxxx5 (String value){ this.kovxxx5 = value;   }   
	public String getKovxxx5 (){ return this.kovxxx5;   }              

	//KOWXXX0
	private String kowxxx0 = null; 
	public void setKowxxx0 (String value){ this.kowxxx0 = value;   }   
	public String getKowxxx0 (){ return this.kowxxx0;   }              

	private String kowxxx1 = null; 
	public void setKowxxx1 (String value){ this.kowxxx1 = value;   }   
	public String getKowxxx1 (){ return this.kowxxx1;   }              

	private String kowxxx2 = null; 
	public void setKowxxx2 (String value){ this.kowxxx2 = value;   }   
	public String getKowxxx2 (){ return this.kowxxx2;   }              

	
	
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
