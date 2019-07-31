/** 
* <p>Title: Test3.java</p>  
* <p>Description: </p>  
* <p>Copyright: Copyright (c) 2018</p>  
* @author tianzhihao
* @date 2018年9月6日  
* @version 1.0  
*/ 
package t.z.h.test;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import t.z.h.entity.DltEntity;

/**      
* projectName:jc_analyze   
* className：Test3   
* description:
* creator:tianzhihao
* date：2018年9月6日 下午2:44:56   
* @version        
*/
public class Test3 {
	public static void main(String[] args) {

		DltEntity dltEntity = new DltEntity();

		Field[] fields = dltEntity.getClass().getDeclaredFields();

		
		String dlt = "18104,1,6,3,25,12,2,2,16,16,7,10,5,13,14,3,5,20,6,12,4,4,2,3,1,6,26,6,28,3,4,13,15,11,8,1,5,1,1,3,3,4,7,10,4,2,11,2";
		String[] split = dlt.split(",");
		try {
			for (int i = 0; i < split.length; i++) {
				String string = split[i];
				for (Field field : fields) {
					String name = field.getName();
					if(!name.equals("id")&!name.equals("serialVersionUID")) {
						PropertyDescriptor pd = new PropertyDescriptor(name, dltEntity.getClass());
						Object invoke = pd.getReadMethod().invoke(dltEntity);
						if(invoke!=null) {
							continue;
						}
						pd.getWriteMethod().invoke(dltEntity, string);
						break;
					}
				}
			}			
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(dltEntity.toString());
	}
}
