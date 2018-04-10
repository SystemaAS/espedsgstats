package no.systema.z.main.maintenance.model.jsonjackson.dbtable;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

import no.systema.main.model.jsonjackson.general.JsonAbstractGrandFatherRecord;

public class JsonMaintMainEdiiRecord extends JsonAbstractGrandFatherRecord {

	private String inid = "";                                
	public void setInid (String value){ this.inid = value;   }   
	public String getInid (){ return this.inid;   }              

	private String inna = "";                                
	public void setInna (String value){ this.inna = value;   }   
	public String getInna (){ return this.inna;   }              

	private String innetw = "";                                
	public void setInnetw (String value){ this.innetw = value;   }   
	public String getInnetw (){ return this.innetw;   }              

	private String inex = "";                                
	public void setInex (String value){ this.inex = value;   }   
	public String getInex (){ return this.inex;   }              

	//TODO many more since the table has many columns

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
