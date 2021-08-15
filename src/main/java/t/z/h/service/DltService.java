/** 
* <p>Title: DltService.java</p>  
* <p>Description: </p>  
* <p>Copyright: Copyright (c) 2018</p>  
* @author tianzhihao
* @date 2018年8月30日  
* @version 1.0  
*/ 
package t.z.h.service;

import com.alibaba.fastjson.JSONObject;

import java.util.List;

/**      
* projectName:jc_analyze   
* className：DltService   
* description:
* creator:tianzhihao
* date：2018年8月30日 下午2:21:27   
* @version        
*/
public interface DltService {

	/**   
	 * @Title: getDlt   
	 * @Description: TODO  
	 * @param: @return      
	 * @return: String      
	 * @throws   
	 */
	String getDlt();

	/**   
	 * @Title: put   
	 * @Description: TODO  
	 * @param: @param dlt
	 * @param: @return      
	 * @return: String      
	 * @throws   
	 */
	String setDlt(String dlt);

	/**   
	 * @Title: setResult   
	 * @Description: TODO  
	 * @param: @param dlt
	 * @param: @return      
	 * @return: String      
	 * @throws   
	 */
	String setResult(String dlt);

	List<JSONObject> getIssueData();

	List<Double> getExpectationValue();

    List<JSONObject> getPieData();
}
