/** 
* <p>Title: Test4.java</p>  
* <p>Description: </p>  
* <p>Copyright: Copyright (c) 2018</p>  
* @author tianzhihao
* @date 2018年9月7日  
* @version 1.0  
*/
package t.z.h.test;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * projectName:jc_analyze className：Test4 description: creator:tianzhihao
 * date：2018年9月7日 下午2:18:24
 * 
 * @version
 */
public class Test4 {
	public static void main(String[] args) {
		// "18104 01 13 14 26 28 07 11 6,430,739,174 1 10,000,000 40 253,224 203,640,357 2018-09-05";
//		String q1 = "01";
//		if(q1.contentEquals("01")) {
//			q1 = q1.substring(1);
//			System.out.println(q1);
//		}
//		System.out.println("01".hashCode());
//		System.out.println("11".hashCode());
		SimpleDateFormat format = new SimpleDateFormat("yymmdd");
		SimpleDateFormat format2 = new SimpleDateFormat("yyMMdd");
		System.out.println(format.format(new Date()));
		System.out.println(format2.format(new Date()));
		
	}
}
