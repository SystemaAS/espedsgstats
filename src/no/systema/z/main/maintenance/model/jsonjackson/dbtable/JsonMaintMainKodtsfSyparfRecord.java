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
 * @date Okt 17, 2016
 * 
 */
public class JsonMaintMainKodtsfSyparfRecord extends JsonAbstractGrandFatherRecord  {
	
	private boolean duplicateSignature = false;
	public void setDuplicateSignature (boolean value){ this.duplicateSignature = value;   }   
	public boolean getDuplicateSignature (){ return this.duplicateSignature;   }  
	
	
	//KODTSF table
	private String kosfst = null;                                
	public void setKosfst (String value){ this.kosfst = value;   }   
	public String getKosfst (){ return this.kosfst;   }  

	private String kosfun = null;                                
	public void setKosfun (String value){ this.kosfun = value;   }   
	public String getKosfun (){ return this.kosfun;   }  

	private String kosfsi = null;                                
	public void setKosfsi (String value){ this.kosfsi = value;   }   
	public String getKosfsi (){ return this.kosfsi;   }  

	private String kosfnv = null;                                
	public void setKosfnv (String value){ this.kosfnv = value;   }   
	public String getKosfnv (){ return this.kosfnv;   }  

	private String kosfxx = null;                                
	public void setKosfxx (String value){ this.kosfxx = value;   }   
	public String getKosfxx (){ return this.kosfxx;   }  

	
	//SYPARF table
	private String syrecn = null;                             
	public void setSyrecn (String value){ this.syrecn = value;   }   
	public String getSyrecn (){ return this.syrecn;   }  
	
	private String syuser = null;                                
	public void setSyuser (String value){ this.syuser = value;   }   
	public String getSyuser (){ return this.syuser;   }  
	    
	private String sykunr = null;                                
	public void setSykunr (String value){ this.sykunr = value;   }   
	public String getSykunr (){ return this.sykunr;   }  
	
	private String syavd = null;                                
	public void setSyavd (String value){ this.syavd = value;   }   
	public String getSyavd (){ return this.syavd;   }  
	
	private String sypaid = null;                                
	public void setSypaid (String value){ this.sypaid = value;   }   
	public String getSypaid (){ return this.sypaid;   }  
	
	private String sysort = null;                                
	public void setSysort (String value){ this.sysort = value;   }   
	public String getSysort (){ return this.sysort;   }  
	
	private String syvrdn = null;                                
	public void setSyvrdn (String value){ this.syvrdn = value;   }   
	public String getSyvrdn (){ return this.syvrdn;   }  
	
	private String syvrda = null;                                
	public void setSyvrda (String value){ this.syvrda = value;   }   
	public String getSyvrda (){ return this.syvrda;   }  

	
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
