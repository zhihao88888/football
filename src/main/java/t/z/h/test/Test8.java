/** 
* <p>Title: Test8.java</p>  
* <p>Description: </p>  
* <p>Copyright: Copyright (c) 2018</p>  
* @author tianzhihao
* @date 2019年2月22日  
* @version 1.0  
*/ 
package t.z.h.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**      
* projectName:jc_analyze   
* className：Test8   
* description:
* creator:tianzhihao
* date：2019年2月22日 下午3:08:53   
* @version        
*/
public class Test8 {
    static String path = "src\\main\\resources\\templates\\dlt.txt";
    public static void main(String[] args) {
        BufferedReader br;
		try {
			br = new BufferedReader(new FileReader(new File(path)));
			String line = br.readLine();
			System.out.println(line);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
