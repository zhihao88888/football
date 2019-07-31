/** 
* <p>Title: SoccerReport.java</p>  
* <p>Description: </p>  
* <p>Copyright: Copyright (c) 2018</p>  
* @author Mr.
* @date 2018年4月17日  
* @version 1.0  
*/ 
package t.z.h.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import t.z.h.domain.JCData;
import t.z.h.service.AnalyzeService;

/**      
* projectName:jc_analyze   
* className：SoccerReport   
* description:
* creator:Mr.
* date：2018年4月17日 下午5:03:40   
* @version        
*/
@Controller
public class SoccerReportController {
	
	@Autowired
	private AnalyzeService analyzeService;
	
	/**   
	 * @Title: readData   
	 * @Description: 获取输入数据  
	 * @return: ArrayList<ArrayList<String>>      
	 * @throws   
	 */
	public ArrayList<ArrayList<String>> readData() throws IOException {  
        ArrayList<ArrayList<String>> datas = new ArrayList<ArrayList<String>>();  
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));  
        String str = "";  
        while (!(str = reader.readLine()).equals("")) {  
            String[] tokenizer = str.split(" ");  
            ArrayList<String> s = new ArrayList<String>();  
            for(int i=0;i<tokenizer.length;i++){
                s.add(tokenizer[i]);
            } 
            datas.add(s);  
        }  
        return datas;  
    }  
	
	
	@RequestMapping("/")
	@ResponseBody
    public ArrayList<String> handleData() throws IOException{  
        ArrayList<String> candAttr = new ArrayList<String>();  
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));  
        String str = "";
        JCData jc = new JCData();
        while (!(str = reader.readLine()).equals("")) {
            //string分析器
            String[] tokenizer = str.split(" ");
            for(int i=0;i<tokenizer.length;i++){
            	if(i==(tokenizer.length-1)) {
            		jc.setVictoryOdds(tokenizer[0]);
            		jc.setDrawOdds(tokenizer[1]);
            		jc.setDefeatOdds(tokenizer[2]);
            	}
            }
           str = analyzeService.goAnalyze(jc.getVictoryOdds(),jc.getDrawOdds(),jc.getDefeatOdds());
           candAttr.add(str);
        }  
        return candAttr;  
    }
}
