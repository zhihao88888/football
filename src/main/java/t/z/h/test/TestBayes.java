package t.z.h.test;

import java.io.BufferedReader;  
import java.io.IOException;  
import java.io.InputStreamReader;  
import java.util.ArrayList;  
/*训练数据：
youth high no fair no  
youth high no excellent no  
middle_aged high no fair yes  
senior medium no fair yes  
senior low yes fair yes  
senior low yes excellent no  
middle_aged low yes excellent yes  
youth medium no fair no  
youth low yes fair yes  
senior medium yes fair yes  
youth medium yes excellent yes  
middle_aged medium no excellent yes  
middle_aged high yes fair yes  
senior medium no excellent no  

对原训练数据进行测试，测试如果如下：
请输入测试元组  
youth high no fair  
The class is: no  
请输入测试元组  
youth high no excellent  
The class is: no  
请输入测试元组  
middle_aged high no fair  
The class is: yes  
请输入测试元组  
senior medium no fair  
The class is: yes  
请输入测试元组  
senior low yes fair  
The class is: yes  
请输入测试元组  
senior low yes excellent  
The class is: yes  
请输入测试元组  
middle_aged low yes excellent  
The class is: yes  
请输入测试元组  
youth medium no fair  
The class is: no  
请输入测试元组  
youth low yes fair  
The class is: yes  
请输入测试元组  
senior medium yes fair  
The class is: yes  
请输入测试元组  
youth medium yes excellent  
The class is: yes  
请输入测试元组  
middle_aged medium no excellent  
The class is: yes  
请输入测试元组  
middle_aged high yes fair  
The class is: yes  
请输入测试元组  
senior medium no excellent  
The class is: no */
public class TestBayes {  

    //读取测试元组
    public ArrayList<String> readTestData() throws IOException{  
        ArrayList<String> candAttr = new ArrayList<String>();  
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));  
        String str = "";  
        while (!(str = reader.readLine()).equals("")) {
            //string分析器
            String[] tokenizer = str.split(" ");
            for(int i=0;i<tokenizer.length;i++){
                candAttr.add(tokenizer[i]);
            } 
        }  
        return candAttr;  
    }  

    //读取训练集
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

    public static void main(String[] args) {  
        TestBayes tb = new TestBayes();  
        ArrayList<ArrayList<String>> datas = null;  
        ArrayList<String> testT = null;  
        Bayes bayes = new Bayes();  
        try {  
            System.out.println("请输入训练数据");  
            datas = tb.readData();  
            while (true) {  
                System.out.println("请输入测试元组");  
                testT = tb.readTestData();  
                String c = bayes.predictClass(datas, testT);  
                System.out.println("The class is: " + c);  
            }  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
    }  
}  
