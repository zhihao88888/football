/** 
* <p>Title: JCDataRepository.java</p>  
* <p>Description: </p>  
* <p>Copyright: Copyright (c) 2018</p>  
* @author Mr.
* @date 2018年4月17日  
* @version 1.0  
*/ 
package t.z.h.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import t.z.h.entity.JCDataEntity;

/**      
* projectName:jc_analyze   
* className：JCDataRepository   
* description:
* creator:Mr.
* date：2018年4月17日 下午8:41:49   
* @version        
*/
public interface JCDataRepository extends CrudRepository<JCDataEntity, Integer> {

	/**   
	 * @Title: find   
	 * @param: @param victoryOdds
	 * @param: @param drawOdds
	 * @param: @param defeatOdds
	 * @param: @return      
	 * @return: String      
	 * @throws   
	 */
	@Query("select jc from JCDataEntity jc where jc.victoryOdds = ?1 and jc.drawOdds = ?2 and jc.defeatOdds = ?3")
	List<JCDataEntity> find(String victoryOdds, String drawOdds, String defeatOdds);

	/**   
	 * @Title: find   
	 * @Description: TODO  
	 * @param: @param str
	 * @param: @return      
	 * @return: String      
	 * @throws   
	 */
	@Query("select jc from JCDataEntity jc where jc.victoryOdds+jc.drawOdds+jc.defeatOdds = ?1")
	List<String> find(String str);

	/**   
	 * @Title: find   
	 * @Description: TODO  
	 * @param: @param type
	 * @param: @param addVictoryOdds
	 * @param: @param subtractVictoryOdds
	 * @param: @param addDrawOdds
	 * @param: @param subtractDrawOdds
	 * @param: @param addDefeatOdds
	 * @param: @param subtractDefeatOdds
	 * @param: @return      
	 * @return: List<JCDataEntity>      
	 * @throws   
	 */
	@Query("SELECT j FROM JCDataEntity j WHERE j.type=?1 AND (j.victoryOdds BETWEEN ?3 AND ?2) AND (j.drawOdds BETWEEN ?5 AND ?4) AND (j.defeatOdds BETWEEN ?7 AND ?6)")
	List<JCDataEntity> find(String type, String addVictoryOdds, String subtractVictoryOdds,
			String addDrawOdds, String subtractDrawOdds, String addDefeatOdds,
			String subtractDefeatOdds);

	/**   
	 * @Title: find   
	 * @Description: TODO  
	 * @param: @param addVictoryOdds
	 * @param: @param subtractVictoryOdds
	 * @param: @param addDrawOdds
	 * @param: @param subtractDrawOdds
	 * @param: @param addDefeatOdds
	 * @param: @param subtractDefeatOdds
	 * @param: @return      
	 * @return: List<JCDataEntity>      
	 * @throws   
	 */
	@Query("SELECT j FROM JCDataEntity j WHERE  (j.victoryOdds BETWEEN ?2 AND ?1) AND (j.drawOdds BETWEEN ?4 AND ?3) AND (j.defeatOdds BETWEEN ?6 AND ?5)")
	List<JCDataEntity> find(String addVictoryOdds, String subtractVictoryOdds, String addDrawOdds,
			String subtractDrawOdds, String addDefeatOdds, String subtractDefeatOdds);


}
