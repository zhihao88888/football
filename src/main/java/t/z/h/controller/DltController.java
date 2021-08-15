/** 
* <p>Title: DltController.java</p>  
* <p>Description: </p>  
* <p>Copyright: Copyright (c) 2018</p>  
* @author tianzhihao
* @date 2018年9月7日  
* @version 1.0  
*/ 
package t.z.h.controller;

import java.util.List;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import t.z.h.service.DltService;

/**      
* projectName:jc_analyze   
* className：DltController   
* description:
* creator:tianzhihao
* date：2018年9月7日 上午9:51:01   
* @version        
*/
@Controller
@RequestMapping(value="/dlt")
public class DltController {

	@Autowired
	private DltService dltService;
	
//	String dlt = "18104,1,6,3,25,12,2,2,16,16,7,10,5,13,14,3,5,20,6,12,4,4,2,3,1,6,26,6,28,3,4,13,15,11,8,1,5,1,1,3,3,4,7,10,4,2,11,2";
	@RequestMapping(value="/put",method = RequestMethod.POST)
	@ResponseBody
	public String put(String dlt) {
		
		return dltService.setDlt(dlt);
	}
	
//	String dlt = "18104 01 13 14 26 28 07 11 6,430,739,174 1 10,000,000 40 253,224 203,640,357 2018-09-05";
	@RequestMapping(value="/setResult",method = RequestMethod.POST)
	@ResponseBody
	public String setResult(String dlt) {
		
		return dltService.setResult(dlt);
	}
	
	@RequestMapping("/echarts")
	public String echarts() {
		return "/echarts.html";
	}

	@RequestMapping("/pie")
	public String pie() {
		return "/pie-legend.html";
	}

	@RequestMapping("/issueData")
	@ResponseBody
	public List<JSONObject> issueData() {
		return dltService.getIssueData();
	}
	
	@RequestMapping("/expectationValue")
	@ResponseBody
	public List<Double> expectationValue() {
		return dltService.getExpectationValue();
	}

	@RequestMapping("/pieData")
	@ResponseBody
	public List<JSONObject> pieData() {
		return dltService.getPieData();
	}
	
}
