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

import t.z.h.entity.DltResultEntity;

/**      
* projectName:jc_analyze   
* className：DltResultRepository   
* description:
* creator:Mr.
* date：2018年4月17日 下午8:41:49   
* @version        
*/
public interface DltResultRepository extends CrudRepository<DltResultEntity, Integer> {

	/**   
	 * @Title: findByIssue   
	 * @Description: TODO  
	 * @param: @param issue
	 * @param: @return      
	 * @return: DltResultEntity      
	 * @throws   
	 */
	DltResultEntity findByIssue(String issue);

	/**   
	 * @Title: findByH1AndH2   
	 * @Description: TODO  
	 * @param: @param h1
	 * @param: @param h2
	 * @param: @return      
	 * @return: List<DltResultEntity>      
	 * @throws   
	 */
	List<DltResultEntity> findByH1AndH2(String h1, String h2);

	/**   
	 * @Title: findByNextIssue   
	 * @Description: TODO  
	 * @param: @param nextIssueOfString
	 * @param: @return      
	 * @return: DltResultEntity      
	 * @throws   
	 */
	@Query(value="SELECT * from dlt_result d WHERE d.issue =?1+1",nativeQuery = true)
	DltResultEntity findByNextIssue(String nextIssueOfString);

	/**   
	 * @Title: findByRange   
	 * @Description: TODO  
	 * @param: @param i
	 * @param: @return      
	 * @return: List<DltResultEntity>      
	 * @throws   
	 */
	@Query(value=" SELECT * FROM dlt_result d ORDER BY d.issue DESC LIMIT ?1",nativeQuery = true)
	List<DltResultEntity> findByRange(int i);

	/**
	 * @param issue    
	 * @Title: findByNum   
	 * @Description: TODO  
	 * @param: @param q1
	 * @param: @return      
	 * @return: long      
	 * @throws   
	 */
	@Query(value="SELECT count(*) FROM dlt_result d WHERE ?1 in (d.q1,d.q2,d.q3,d.q4,d.q5) AND d.issue <= ?2",nativeQuery = true)
	long countByNumAndIssue(String q1, String issue);

	/**
	 * @param issue    
	 * @Title: countByIssue   
	 * @Description: TODO  
	 * @param: @return      
	 * @return: long      
	 * @throws   
	 */
	@Query(value="SELECT count(*) FROM dlt_result d WHERE d.issue <= ?1",nativeQuery = true)
	long countByIssue(String issue);



}
