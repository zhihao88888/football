///** 
//* <p>Title: Test5.java</p>  
//* <p>Description: </p>  
//* <p>Copyright: Copyright (c) 2018</p>  
//* @author tianzhihao
//* @date 2018年11月20日  
//* @version 1.0  
//*/ 
//package t.z.h.test;
//
//import java.util.List;
//
//import org.dom4j.Document;
//import org.dom4j.DocumentException;
//import org.dom4j.DocumentHelper;
//import org.dom4j.Element;
//import org.dom4j.tree.DefaultElement;
//
///**      
//* projectName:jc_analyze   
//* className：Test5   
//* description:
//* creator:tianzhihao
//* date：2018年11月20日 下午4:00:48   
//* @version        
//*/
//public class Test5 {
//	@SuppressWarnings("unchecked")
//	public static void main(String[] args) throws DocumentException {
//		String xml = "<response version=\"V1.0\">\r\n" + 
//				"	<id>93641996-ef47-42ba-9072-415cf387bdd3</id>\r\n" + 
//				"	<creation_time value=\"20181120145241\"/>\r\n" + 
//				"	<interaction_id code=\"2.16.840.1.113883.1.6\"/>\r\n" + 
//				"	<sender code=\"SYS001\"/>\r\n" + 
//				"	<receiver code=\"SYS002\"/>\r\n" + 
//				"	<acknowledgement type=\"AE\">\r\n" + 
//				"		<request_id value=\"请求消息流水号\"/>\r\n" + 
//				"		<acknowledgement_detail>\r\n" + 
//				"			<text>未查询到数据</text>\r\n" + 
//				"		</acknowledgement_detail>\r\n" + 
//				"		<pay_amout/>\r\n" + 
//				"		<rec_pay_amout/>\r\n" + 
//				"		<total_pay_amout/>\r\n" + 
//				"		<prescription_ids/>\r\n" + 
//				"		<remark/>\r\n" + 
//				"		<medicare_Settle_log_id/>\r\n" + 
//				"		<fee_info>\r\n" + 
//				"			<type_code>1</type_code>\r\n" + 
//				"			<type_name>1</type_name>\r\n" + 
//				"			<type_amout>1</type_amout>\r\n" + 
//				"		</fee_info>\r\n" + 
//				"		<fee_info>\r\n" + 
//				"			<type_code>555</type_code>\r\n" + 
//				"			<type_name>2</type_name>\r\n" + 
//				"			<type_amout>2</type_amout>\r\n" + 
//				"		</fee_info>	\r\n" + 
//				"	</acknowledgement>\r\n" + 
//				"</response>";
//		
//		Document doc = DocumentHelper.parseText(xml);
//		List<DefaultElement> nodes = doc.selectNodes("//fee_info"); 
//		for (DefaultElement defaultElement : nodes) {
//			String name = defaultElement.element("type_code").getText();
//			System.out.println(name);
//		}
//	}
//}
