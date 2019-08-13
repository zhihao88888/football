/** 
* <p>Title: Test6.java</p>  
* <p>Description: </p>  
* <p>Copyright: Copyright (c) 2018</p>  
* @author tianzhihao
* @date 2019年2月18日  
* @version 1.0  
*/ 
package t.z.h.test;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.util.StringUtils;
/**      
* projectName:jc_analyze   
* className：Test6   
* description:
* creator:tianzhihao
* date：2019年2月18日 上午9:55:43   
* @version        
*/
public class Test6 {

    public static void main(String[] args){
    	
    	trimSchemas("E:\\jcdata\\processed");
    }
 
    public static void trimSchemas(String path){
    	System.out.println("--------START--------");
        if (null != path) {
            File file = new File(path);
            if (file.exists()) {
                File[] listFile = file.listFiles();
                if(null != listFile){
                    for (File child : listFile) {
                        if (child.isFile()) {
							String tempPath = child.getAbsolutePath();
							String year = child.getName().substring(0, 4);
							try {
								if(StringUtils.isEmpty(tempPath))continue;
								XSSFWorkbook wk = new XSSFWorkbook(tempPath);
								Sheet sheet = wk.getSheetAt(0);
								for (Row row : sheet) {
									Cell cell = row.getCell(1);
									CellType cellType = cell.getCellType();
									int compareTo = cellType.compareTo(CellType.NUMERIC);
									if(compareTo==0)continue;
									String value = cell.getStringCellValue();
									if(value.equals("比赛时间")||StringUtils.isEmpty(value))continue;
									if(value.length()>12) value = value.substring(0, 11);
									String replace = value.replace("-", "/");
									replace=year+"/"+replace;
									cell.setCellValue(replace);
								}
								FileOutputStream fos = new FileOutputStream(child.getName());
								wk.write(fos);
								wk.close();
							} catch (IOException e) {
								e.printStackTrace();
							}
							System.out.println("--------Processing--------");
                        } else if (child.isDirectory()) {
                        	trimSchemas(child.getAbsolutePath());
                        }
                    }
                }
            }
        }
        System.out.println("--------END--------");
    }

}
