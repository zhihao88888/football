///** 
//* <p>Title: Test.java</p>  
//* <p>Description: </p>  
//* <p>Copyright: Copyright (c) 2018</p>  
//* @author Mr.
//* @date 2018年5月4日  
//* @version 1.0  
//*/ 
//package t.z.h.test;
//
//import java.io.ByteArrayInputStream;
//import java.io.InputStream;
//import java.nio.charset.Charset;
//import java.util.Collections;
//import java.util.List;
//
//import org.apache.commons.io.IOUtils;
//import org.apache.http.HttpEntity;
//import org.apache.http.client.config.RequestConfig;
//import org.apache.http.client.methods.CloseableHttpResponse;
//import org.apache.http.client.methods.HttpPost;
//import org.apache.http.entity.StringEntity;
//import org.apache.http.impl.client.CloseableHttpClient;
//import org.apache.http.impl.client.HttpClientBuilder;
//import org.apache.http.util.EntityUtils;
//import org.apache.log4j.Logger;
//import org.dom4j.Document;
//import org.dom4j.io.SAXReader;
//import org.dom4j.tree.DefaultText;
//import org.dom4j.xpath.DefaultXPath;
//
///**      
//* projectName:jc_analyze   
//* className：Test   
//* description:
//* creator:Mr.
//* date：2018年5月4日 下午1:16:58   
//* @version        
//*/
//public class Test {
//    static int socketTimeout = 30000;// 请求超时时间  
//    static int connectTimeout = 30000;// 传输超时时间  
//    static Logger logger = Logger.getLogger(Test.class);  
//  
//    /** 
//     * 使用SOAP1.1发送消息 
//     *  
//     * @param postUrl 
//     * @param soapXml 
//     * @param soapAction 
//     * @return 
//     */  
//    @SuppressWarnings("unchecked")
//	public static String doPostSoap1_1(String postUrl, String soapXml,  
//            String soapAction) {  
//        String retStr = "";  
//        // 创建HttpClientBuilder  
//        HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();  
//        // HttpClient  
//        CloseableHttpClient closeableHttpClient = httpClientBuilder.build();  
//        HttpPost httpPost = new HttpPost(postUrl);  
//                //  设置请求和传输超时时间  
//        RequestConfig requestConfig = RequestConfig.custom()  
//                .setSocketTimeout(socketTimeout)  
//                .setConnectTimeout(connectTimeout).build();  
//        httpPost.setConfig(requestConfig);  
//        try {  
//            httpPost.setHeader("Content-Type", "text/xml;charset=UTF-8");  
//            httpPost.setHeader("SOAPAction", soapAction);  
//            StringEntity data = new StringEntity(soapXml,  
//                    Charset.forName("UTF-8"));  
//            httpPost.setEntity(data);  
//            CloseableHttpResponse response = closeableHttpClient  
//                    .execute(httpPost);  
//            HttpEntity httpEntity = response.getEntity();  
//            if (httpEntity != null) {  
//                // 打印响应内容  
//            	InputStream content = httpEntity.getContent();
//            	String string = IOUtils.toString(content, "utf-8");
//            	logger.info(string);
//            	Document doc = new SAXReader().read(new ByteArrayInputStream(string.getBytes("UTF-8")));
//				List<DefaultText> nodes = doc.selectNodes("//*[local-name()='out']/text()");
//            	String result = "";
//            	for (DefaultText text : nodes) {
//            		result += text.getText();
//				}
//            	logger.info(result);
//            }  
//            // 释放资源  
//            closeableHttpClient.close();  
//        } catch (Exception e) {  
//            logger.error("exception in doPostSoap1_1", e);  
//        }  
//        return retStr;  
//    }  
//  
//    /** 
//     * 使用SOAP1.2发送消息 
//     *  
//     * @param postUrl 
//     * @param soapXml 
//     * @param soapAction 
//     * @return 
//     */  
//    public static String doPostSoap1_2(String postUrl, String soapXml,  
//            String soapAction) {  
//        String retStr = "";  
//        // 创建HttpClientBuilder  
//        HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();  
//        // HttpClient  
//        CloseableHttpClient closeableHttpClient = httpClientBuilder.build();  
//        HttpPost httpPost = new HttpPost(postUrl);  
//                // 设置请求和传输超时时间  
//        RequestConfig requestConfig = RequestConfig.custom()  
//                .setSocketTimeout(socketTimeout)  
//                .setConnectTimeout(connectTimeout).build();  
//        httpPost.setConfig(requestConfig);  
//        try {  
//            httpPost.setHeader("Content-Type",  
//                    "application/soap+xml;charset=UTF-8");  
//            httpPost.setHeader("SOAPAction", soapAction);  
//            StringEntity data = new StringEntity(soapXml,  
//                    Charset.forName("UTF-8"));  
//            httpPost.setEntity(data);  
//            CloseableHttpResponse response = closeableHttpClient  
//                    .execute(httpPost);  
//            HttpEntity httpEntity = response.getEntity();  
//            if (httpEntity != null) {  
//                // 打印响应内容  
//                retStr = EntityUtils.toString(httpEntity, "UTF-8");  
//                logger.info("response:" + retStr);  
//            }  
//            // 释放资源  
//            closeableHttpClient.close();  
//        } catch (Exception e) {  
//            logger.error("exception in doPostSoap1_2", e);  
//        }  
//        return retStr;  
//    }  
//  
//    public static void main(String[] args) {  
//        String orderSoapXml = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:def=\"http://DefaultNamespace\">\r\n" + 
//        		"   <soapenv:Header/>\r\n" + 
//        		"   <soapenv:Body>\r\n" + 
//        		"      <def:sendmsg>\r\n" + 
//        		"         <def:in0>jh069516</def:in0>\r\n" + 
//        		"         <def:in1><![CDATA[<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n" + 
//        		"<infos>\r\n" + 
//        		"	<info>\r\n" + 
//        		"		<msg_id>-1</msg_id>\r\n" + 
//        		"		<password>29803</password>\r\n" + 
//        		"		<src_tele_num>106573069516</src_tele_num>\r\n" + 
//        		"		<dest_tele_num>18626259701</dest_tele_num>\r\n" + 
//        		"		<msg>你好</msg>\r\n" + 
//        		"	</info>\r\n" + 
//        		"</infos>]]></def:in1>\r\n" + 
//        		"      </def:sendmsg>\r\n" + 
//        		"   </soapenv:Body>\r\n" + 
//        		"</soapenv:Envelope>";  
//
//        String postUrl = "http://jh55.jhmcc.com/webservice/services/sendmsg";  
//        //采用SOAP1.1调用服务端，这种方式能调用服务端为soap1.1和soap1.2的服务  
//        doPostSoap1_1(postUrl, orderSoapXml, "");  
//  
//        //采用SOAP1.2调用服务端，这种方式只能调用服务端为soap1.2的服务  
////        doPostSoap1_2(postUrl, orderSoapXml, "order");  
//    }  
//    
//    String xml = "<request version=\"V1.0\">\r\n" + 
//    		"	<id>f06d8b01-db2e-4ee3-8e8a-6034cf60b5d6</id>\r\n" + 
//    		"	<creation_time value=\"20180724202945\"/>\r\n" + 
//    		"	<interaction_id code=\"HRP004\"/>\r\n" + 
//    		"	<subject>\r\n" + 
//    		"		<bill id=\"201807240035\" >\r\n" + 
//    		"			<type code=\"\" name=\"\"/>\r\n" + 
//    		"			<business_type></business_type>\r\n" + 
//    		"			<dept code=\"1002001\" name=\"\"/>\r\n" + 
//    		"			<stock>\r\n" + 
//    		"				<org code=\"100\" name=\"\"/>\r\n" + 
//    		"				<direct>GENERAL</direct>\r\n" + 
//    		"			</stock>\r\n" + 
//    		"			<picker code=\"\" name=\"\"/>\r\n" + 
//    		"			<owner code=\"\" name=\"\">\r\n" + 
//    		"				<type code=\"\" name=\"\"/>\r\n" + 
//    		"			</owner>\r\n" + 
//    		"			<pick_org code=\"磐安人医\" name=\"100\"/>\r\n" + 
//    		"			<date>20180724202945</date>\r\n" + 
//    		"			<comment></comment>\r\n" + 
//    		"			<materials>\r\n" + 
//    		"				<material code=\"01XYFCS001\">\r\n" + 
//    		"					<base_unit code=\"16\" name=\"盒\"/>\r\n" + 
//    		"					<apply_count>1</apply_count>\r\n" + 
//    		"					<count>1</count>\r\n" + 
//    		"					<flot>180724001</flot>\r\n" + 
//    		"					<stock code=\"CK003\" name=\"\">\r\n" + 
//    		"						<location code=\"9041\" name=\"\"/>\r\n" + 
//    		"					</stock>\r\n" + 
//    		"					<price>20</price>\r\n" + 
//    		"					<comment></comment>\r\n" + 
//    		"				</material>\r\n" + 
//    		"			</materials>\r\n" + 
//    		"		</bill>\r\n" + 
//    		"	</subject>\r\n" + 
//    		"</request>";
//
//}
