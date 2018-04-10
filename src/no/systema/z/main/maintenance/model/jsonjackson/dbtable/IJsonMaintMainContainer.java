/**
 * 
 */
package no.systema.z.main.maintenance.model.jsonjackson.dbtable;

import java.util.Collection;

/**
 * This interface should be implemented by Containers that can use the generic {@link MaintMainGenericMapper}
 * 
 * @author Fredrik Möller
 * @date Nov 22, 2016
 *
 */
public interface IJsonMaintMainContainer {

	/**
	 * Get list of Records
	 * @return
	 */
	public Collection<?> getDtoList();

}
