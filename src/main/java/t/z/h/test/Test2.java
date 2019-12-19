/** 
* <p>Title: TEST2.java</p>  
* <p>Description: </p>  
* <p>Copyright: Copyright (c) 2018</p>  
* @author tianzhihao
* @date 2018年9月5日  
* @version 1.0  
*/ 
package t.z.h.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import t.z.h.service.RedisService;

/**      
* projectName:jc_analyze   
* className：TEST2   
* description:
* creator:tianzhihao
* date：2018年9月5日 上午10:07:15   
* @version        
*/
@RestController
public class Test2 {
    @Autowired
    private RedisService redisService ;


    @RequestMapping(value = "/test",method = RequestMethod.POST)
    public String demoTest(){
//        redisService.set("1","value22222");
    	return "<response version=\"V1.0\">\r\n" + 
    			"	<id>消息流水号</id>\r\n" + 
    			"	<creation_time value=\"消息创建时间\"/>\r\n" + 
    			"	<interaction_id code=\"消息的服务编码\"/>\r\n" + 
    			"	<sender code=\"发送系统编码\"/>\r\n" + 
    			"	<receiver code=\"接收系统编码\"/>\r\n" + 
    			"	<!--成功为AA，失败为AE -->\r\n" + 
    			"	<acknowledgement type=\"AA\">\r\n" + 
    			"		<request_id value=\"请求消息流水号\"/>\r\n" + 
    			"		<acknowledgement_detail>\r\n" + 
    			"			<text>消息成功失败说明</text>\r\n" + 
    			"		</acknowledgement_detail>\r\n" + 
    			"		<vital_signs>\r\n" + 
    			"			<patient_id>123456</patient_id>\r\n" + 
    			"			<length_of_stay_quantity>2</length_of_stay_quantity>\r\n" + 
    			"			<recording_date>2014-07-01</recording_date>\r\n" + 
    			"			<temperature unit=\"℃\">\r\n" + 
    			"				<type>腋温</type>\r\n" + 
    			"				<value>38</value>\r\n" + 
    			"			</temperature>\r\n" + 
    			"			<weight unit=\"kg\">3.0</weight>\r\n" + 
    			"			<sphygmus unit=\"次/分\">脉搏</sphygmus>\r\n" + 
    			"			<blood_pressure unit=\"kPa\">收缩压,舒张压</blood_pressure>\r\n" + 
    			"			<breathe unit=\"次/分\">呼吸</breathe>\r\n" + 
    			"			<blood_oxygen unit=\"%\">血氧</blood_oxygen>\r\n" + 
    			"		</vital_signs>\r\n" + 
    			"		<vital_signs>\r\n" + 
    			"			<patient_id>123456</patient_id>\r\n" + 
    			"			<length_of_stay_quantity>2</length_of_stay_quantity>\r\n" + 
    			"			<recording_date>2014-07-01</recording_date>\r\n" + 
    			"			<temperature unit=\"℃\">\r\n" + 
    			"				<type>腋温</type>\r\n" + 
    			"				<value>38</value>\r\n" + 
    			"			</temperature>\r\n" + 
    			"			<weight unit=\"kg\">3.0</weight>\r\n" + 
    			"			<sphygmus unit=\"次/分\">脉搏</sphygmus>\r\n" + 
    			"			<blood_pressure unit=\"kPa\">收缩压,舒张压</blood_pressure>\r\n" + 
    			"			<breathe unit=\"次/分\">呼吸</breathe>\r\n" + 
    			"			<blood_oxygen unit=\"%\">血氧</blood_oxygen>\r\n" + 
    			"		</vital_signs>\r\n" + 
    			"	</acknowledgement>\r\n" + 
    			"</response>\r\n" + 
    			"";
    }
}
