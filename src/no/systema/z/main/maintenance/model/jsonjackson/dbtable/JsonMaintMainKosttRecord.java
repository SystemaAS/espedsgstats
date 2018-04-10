package no.systema.z.main.maintenance.model.jsonjackson.dbtable;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

import no.systema.main.model.jsonjackson.general.JsonAbstractGrandFatherRecord;

public class JsonMaintMainKosttRecord extends JsonAbstractGrandFatherRecord {

	private String kttyp = null;                                
	public void setKttyp (String value){ this.kttyp = value;   }   
	public String getKttyp (){ return this.kttyp;   }              

	private String ktnr = null;                                
	public void setKtnr (String value){ this.ktnr = value;   }   
	public String getKtnr (){ return this.ktnr;   }              

	private String ktna = null;                                
	public void setKtna (String value){ this.ktna = value;   }   
	public String getKtna (){ return this.ktna;   }              

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
