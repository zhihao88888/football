/** 
* <p>Title: Test7.java</p>  
* <p>Description: </p>  
* <p>Copyright: Copyright (c) 2018</p>  
* @author tianzhihao
* @date 2019年2月20日  
* @version 1.0  
*/ 
package t.z.h.test;

import java.util.HashMap;
import java.util.Map;

import javafx.util.Pair;

/**      
* projectName:jc_analyze   
* className：Test7   
* description:
* creator:tianzhihao
* date：2019年2月20日 上午11:13:35   
* @version        
*/
public class Test7 {

	public static void main(String[] args) {
		System.out.println(" ".toCharArray().length);
		System.out.println("z".toCharArray().length);
		System.out.println("中".toCharArray().length);
		Map<String,Object> map = new HashMap<String,Object>();
		Map<String,Object>[] map2 = new Map[5];
		map2[0] = new HashMap<String,Object>();
		Pair<String, Double> pair = new Pair<String,Double>(null, null);
		Pair<String, Double>[] pairResult = new Pair[255];
		System.out.println(Math.log(257.2857142857));
	}
}
