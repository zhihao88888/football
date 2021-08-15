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

import com.alibaba.fastjson.JSONObject;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import t.z.h.entity.DltEntity;

/**      
* projectName:jc_analyze   
* className：DltRepository   
* description:
* creator:Mr.
* date：2018年4月17日 下午8:41:49   
* @version        
*/
public interface DltRepository extends CrudRepository<DltEntity, Integer> {

	/**   
	 * @Title: findLast   
	 * @Description: TODO  
	 * @param: @return      
	 * @return: DltEntity      
	 * @throws   
	 */
	@Query(value="SELECT * FROM dlt d ORDER BY d.issue DESC LIMIT 1",nativeQuery = true)
	DltEntity findLast();

	/**   
	 * @Title: findByIssue   
	 * @Description: TODO  
	 * @param: @param string
	 * @param: @return      
	 * @return: DltEntity      
	 * @throws   
	 */
	@Query(value="SELECT * from dlt d WHERE d.issue =?1+1",nativeQuery = true)
	DltEntity findByNextIssue(String string);

	/**   
	 * @Title: findByIssue   
	 * @Description: TODO  
	 * @param: @param issue
	 * @param: @return      
	 * @return: DltEntity      
	 * @throws   
	 */
	DltEntity findByIssue(String issue);

	/**
	 * @param issue    
	 * @Title: findByQ1OfUpIssue   
	 * @Description: TODO  
	 * @param: @param q1
	 * @param: @return      
	 * @return: DltEntity      
	 * @throws   
	 */
	@Query(value="select * from dlt d where d.issue =?1-1",nativeQuery = true)
	DltEntity findByQ1OfUpIssue(String issue);

	@Query(value="select t.issue,(d.q1+d.q2+d.q3+d.q4+d.q5)/5 expectation from dlt t left join dlt_result d on t.issue=d.issue order by t.issue asc",nativeQuery = true)
	List<JSONObject> findIssueData();


}
