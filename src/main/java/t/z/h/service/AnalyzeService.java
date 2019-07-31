/** 
* <p>Title: AnalyzeService.java</p>  
* <p>Description: </p>  
* <p>Copyright: Copyright (c) 2018</p>  
* @author Mr.
* @date 2018年4月17日  
* @version 1.0  
*/ 
package t.z.h.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**      
* projectName:jc_analyze   
* className：AnalyzeService   
* description:
* creator:Mr.
* date：2018年4月17日 下午8:18:31   
* @version        
*/
public interface AnalyzeService{

	/**   
	 * @Title: goAnalyze   
	 * @Description: TODO  
	 * @param: @param victoryOdds
	 * @param: @param drawOdds
	 * @param: @param defeatOdds
	 * @param: @return      
	 * @return: String      
	 * @throws   
	 */
	String goAnalyze(String victoryOdds, String drawOdds, String defeatOdds);

	/**   
	 * @Title: toSee   
	 * @Description: TODO  
	 * @param: @param str
	 * @param: @return      
	 * @return: String      
	 * @throws   
	 */
	List<String> toSee(String str);

	/**
	 * @param reader 
	 * @throws IOException    
	 * @Title: handleData   
	 * @Description: TODO  
	 * @param: @return      
	 * @return: ArrayList<String>      
	 * @throws   
	 */
	ArrayList<String> handleData(BufferedReader reader) throws IOException;

}
