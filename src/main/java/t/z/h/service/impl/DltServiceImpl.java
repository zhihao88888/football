/** 
* <p>Title: DltServiceImpl.java</p>  
* <p>Description: </p>  
* <p>Copyright: Copyright (c) 2018</p>  
* @author tianzhihao
* @date 2018年8月30日  
* @version 1.0  
*/ 
package t.z.h.service.impl;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.sql.DataSource;

import org.apache.commons.collections.Bag;
import org.apache.commons.collections.bag.HashBag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import t.z.h.entity.DltEntity;
import t.z.h.entity.DltResultEntity;
import t.z.h.repository.DltRepository;
import t.z.h.repository.DltResultRepository;
import t.z.h.service.DltService;

/**      
* projectName:jc_analyze   
* className：DltServiceImpl   
* description:
* creator:tianzhihao
* date：2018年8月30日 下午2:21:46   
* @version        
*/
@Component
@Transactional
public class DltServiceImpl implements DltService {
	
	static List<String> lastResult = new ArrayList<String>();
	
	static List<String> sameTrend = new ArrayList<String>();

	@Autowired
	private DltRepository dltRepository;
	
	@Autowired
	private DltResultRepository dltResultRepository;

	@PersistenceContext
	private EntityManager em;
	
    @Autowired
    private DataSource dataSource; 
	/**   
	 * <p>Title: getDlt</p>   
	 * <p>Description: </p>   
	 * @param dlt
	 * @return   
	 * @see t.z.h.service.DltService#getDlt(java.lang.String)   
	 */
	@Override
	public String getDlt() {
		try {
			dataSource.getConnection().createStatement().execute("truncate table test");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DltEntity last = dltRepository.findLast();
//		DltEntity last = dltRepository.findByIssue("19015");
		String issue = last.getIssue();
		DltResultEntity result = dltResultRepository.findByIssue(issue);
		String expect = getExpectDlt(result,last);
		getSameTrendDlt(sameTrend);
		getBigAndSmall(30);
		return expect;
	}
	

	/**   
	 * @Title: getBigAndSmall   
	 * @Description: TODO  
	 * @param: @param i      
	 * @return: void      
	 * @throws   
	 */
	private void getBigAndSmall(int i) {
		List<DltResultEntity> dltResults = dltResultRepository.findByRange(i);
		System.out.println("大小走势开始-----------------------------");
		for (DltResultEntity dlt : dltResults) {
			StringBuilder sb = new StringBuilder();
			sb.append(dlt.getIssue());
			long countOfIssue = dltResultRepository.countByIssue(dlt.getIssue());
			long average = countOfIssue*5/35;
			long countOfQ1 = dltResultRepository.countByNumAndIssue(dlt.getQ1(),dlt.getIssue());
			if(countOfQ1 <= average) {
				sb.append("小");
			}else {
				sb.append("大");
			}
			long countOfQ2 = dltResultRepository.countByNumAndIssue(dlt.getQ2(),dlt.getIssue());
			if(countOfQ2 <= average) {
				sb.append("小");
			}else {
				sb.append("大");
			}
			long countOfQ3 = dltResultRepository.countByNumAndIssue(dlt.getQ3(),dlt.getIssue());
			if(countOfQ3 <= average) {
				sb.append("小");
			}else {
				sb.append("大");
			}
			long countOfQ4 = dltResultRepository.countByNumAndIssue(dlt.getQ4(),dlt.getIssue());
			if(countOfQ4 <= average) {
				sb.append("小");
			}else {
				sb.append("大");
			}
			long countOfQ5 = dltResultRepository.countByNumAndIssue(dlt.getQ5(),dlt.getIssue());
			if(countOfQ5 <= average) {
				sb.append("小");
			}else {
				sb.append("大");
			}
			System.out.println(sb.toString());
		}
		System.out.println("大小走势结束-----------------------------");
	}


	/**   
	 * @Title: getSameTrendDlt   
	 * @Description: TODO  
	 * @param: @param sameTrend2      
	 * @return: void      
	 * @throws   
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void getSameTrendDlt(List<String> sameTrend2) {
		HashSet h = new HashSet(sameTrend2);
		sameTrend.clear();
		sameTrend.addAll(h);
		System.out.println("下期相同走势开始-----------------------------");
//		Collections.sort(sameTrend2);
		for (String string : sameTrend2) {
			System.out.println(string);
		}
		System.out.println("下期相同走势结束-----------------------------");
	}

	/**   
	 * @Title: getExpectDlt   
	 * @Description: TODO  
	 * @param: @param result
	 * @param: @return      
	 * @return: String      
	 * @throws   
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private String getExpectDlt(DltResultEntity result, DltEntity last) {
		Class<? extends DltEntity> dlt = last.getClass();
		
		String q1 = result.getQ1();
		getCount(last,dlt,q1);
		
		String q2 = result.getQ2();
		getCount(last,dlt,q2);
		
		String q3 = result.getQ3();
		getCount(last,dlt,q3);
		
		String q4 = result.getQ4();
		getCount(last,dlt,q4);
		
		String q5 = result.getQ5();
		getCount(last,dlt,q5);

		Bag bag = new HashBag(lastResult); 
		HashSet h = new HashSet(lastResult);
		lastResult.clear();
		lastResult.addAll(h);
		System.out.println("前区计算开始-----------------------------");
		for (String string : lastResult) {
			System.out.println(string+"出现次数为"+bag.getCount(string));
		}
		System.out.println("前区计算结束-----------------------------");				
		
		String h1 = result.getH1();
		String h2 = result.getH2();
		getCountOfH(h1,h2);

		return null;
	}

	/**   
	 * @Title: getCountOfH   
	 * @Description: TODO  
	 * @param: @param h1
	 * @param: @param h2      
	 * @return: void      
	 * @throws   
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void getCountOfH(String h1, String h2) {
		List<DltResultEntity> listOfResult = dltResultRepository.findByH1AndH2(h1,h2);
		List<String> lastResult = new ArrayList<String>();
		for (DltResultEntity dltResultEntity : listOfResult) {
			String issue = dltResultEntity.getIssue();
			DltResultEntity resultEntity = dltResultRepository.findByNextIssue(issue);
			if(resultEntity!=null) {
				String h1OfResult = resultEntity.getH1();
				String h2OfResult = resultEntity.getH2();
				lastResult.add(h1OfResult);
				lastResult.add(h2OfResult);
			}
		}
		Bag bag = new HashBag(lastResult);
		HashSet h = new HashSet(lastResult);
		lastResult.clear();
		lastResult.addAll(h);
		System.out.println("后区计算开始-----------------------------");
		for (String string : lastResult) {
			System.out.println(string+"出现次数为"+bag.getCount(string));
		}
		System.out.println("后区计算结束-----------------------------");
	}
	/**
	 * @param last    
	 * @Title: getCount   
	 * @Description: TODO  
	 * @param: @param dlt
	 * @param: @param q1
	 * @param: @return      
	 * @return: String      
	 * @throws   
	 */
	private String getCount(DltEntity last, Class<? extends DltEntity> dlt, String q1){
		try {
			int leftOfq1 = 1;
			int rightOfq1 = 35;
			boolean isSameTrend = false;
			boolean isSameTrendResultList = false;
			if(q1.equals("01")) {
				rightOfq1 = 2;
				List<Object> resultList = getResultList(last,dlt,q1,rightOfq1);
				isSameTrend = true;
				rightCount(resultList,q1,isSameTrend,isSameTrendResultList);
				return null;
			}
			if(q1.equals("35")) {
				leftOfq1 = 34;
				List<Object> resultList2 = getResultList(last,dlt,q1,leftOfq1);
				isSameTrend = true;
				leftCount(resultList2,q1,isSameTrend,isSameTrendResultList);
				return null;
			}
			leftOfq1 = Integer.valueOf(q1).intValue()-1;
			rightOfq1 = Integer.valueOf(q1).intValue()+1;
			int upOfq1 = getValueOfUpIssue(last.getIssue(),q1);
			
			List<Object> resultList = getResultList(last,dlt,q1,leftOfq1);
			leftCount(resultList,q1,isSameTrend,isSameTrendResultList);	
			List<Object> resultList2 = getResultList(last,dlt,q1,rightOfq1);
			rightCount(resultList2,q1,isSameTrend,isSameTrendResultList);
			
			List<Object> sameTrendResultList = getSameTrendResultList(last,q1,leftOfq1,rightOfq1);
			isSameTrend = true;
			isSameTrendResultList = true;
			leftCount(sameTrendResultList,q1,isSameTrend,isSameTrendResultList);	
			rightCount(sameTrendResultList,q1,isSameTrend,isSameTrendResultList);
			
			List<Object> upResultList = getUpResultList(last,q1,upOfq1);
			isSameTrend = false;
			isSameTrendResultList = false;
			leftCount(upResultList,q1,isSameTrend,isSameTrendResultList);	
			rightCount(upResultList,q1,isSameTrend,isSameTrendResultList);			
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IntrospectionException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}		

		return null;
	}

	/**
	 * @param isSameTrendResultList 
	 * @param sameTrend2 
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 * @throws IllegalAccessException 
	 * @throws IntrospectionException    
	 * @Title: rightCount   
	 * @Description: TODO  
	 * @param: @param resultList2
	 * @param: @param q1      
	 * @return: void      
	 * @throws   
	 */
	private void rightCount(List<Object> resultList2, String q1, boolean isSameTrend, boolean isSameTrendResultList) throws IntrospectionException,
	IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		for (Object obj : resultList2) {
//			Map map = (Map)obj;
			String issue = obj.toString();
			boolean isTrue = check(issue,q1);
			if(!isTrue)return;
			DltResultEntity findByIssue = dltResultRepository.findByNextIssue(issue);
			if(findByIssue!=null) {
				DltEntity dltEntity = dltRepository.findByNextIssue(issue);
				Class<? extends DltEntity> class1 = dltEntity.getClass();
				String fieldName ="";
				if(q1.startsWith("0")) {
					fieldName = "q"+q1.substring(1);
				}else {
					fieldName = "q"+q1;
				}
				PropertyDescriptor pd = new PropertyDescriptor(fieldName, class1);
				Object invoke = pd.getReadMethod().invoke(dltEntity);
				if(Integer.valueOf(invoke.toString()).intValue()>Integer.valueOf(q1).intValue()) {
					continue;
				}
				if(findByIssue.getQ1().hashCode()>= q1.hashCode()) {
					if(!isSameTrendResultList)lastResult.add(findByIssue.getQ1());
					if(isSameTrend) sameTrend.add(findByIssue.getQ1());
				}else if(findByIssue.getQ2().hashCode()>= q1.hashCode()) {
					if(!isSameTrendResultList)lastResult.add(findByIssue.getQ2());	
					if(isSameTrend) sameTrend.add(findByIssue.getQ2());
				}else if(findByIssue.getQ3().hashCode()>= q1.hashCode()) {
					if(!isSameTrendResultList)lastResult.add(findByIssue.getQ3());
					if(isSameTrend) sameTrend.add(findByIssue.getQ3());
				}else if(findByIssue.getQ4().hashCode()>= q1.hashCode()) {
					if(!isSameTrendResultList)lastResult.add(findByIssue.getQ4());						
					if(isSameTrend) sameTrend.add(findByIssue.getQ4());
				}else if(findByIssue.getQ5().hashCode()>= q1.hashCode()) {
					if(!isSameTrendResultList)lastResult.add(findByIssue.getQ5());						
					if(isSameTrend) sameTrend.add(findByIssue.getQ5());
				}
			}
		}	
	}
	/**
	 * @param isSameTrendResultList 
	 * @param isSameTrend 
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 * @throws IllegalAccessException 
	 * @throws IntrospectionException 
	 * @throws SecurityException 
	 * @throws NoSuchMethodException 
	 * @param q1    
	 * @Title: leftCount   
	 * @Description: TODO  
	 * @param: @param resultList      
	 * @return: void      
	 * @throws   
	 */
	private void leftCount(List<Object> resultList, String q1, boolean isSameTrend, boolean isSameTrendResultList) throws IntrospectionException, 
	IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		for (Object obj : resultList) {
//			Map map = (Map)obj;
			String issue = obj.toString();
			boolean isTrue = check(issue,q1);
			if(!isTrue)return;
			DltResultEntity findByIssue = dltResultRepository.findByNextIssue(issue);
			if(findByIssue!=null) {
				DltEntity dltEntity = dltRepository.findByNextIssue(issue);
				Class<? extends DltEntity> class1 = dltEntity.getClass();
				String fieldName ="";
				if(q1.startsWith("0")) {
					fieldName = "q"+q1.substring(1);
				}else {
					fieldName = "q"+q1;
				}
				PropertyDescriptor pd = new PropertyDescriptor(fieldName, class1);
				Object invoke = pd.getReadMethod().invoke(dltEntity);
				if(Integer.valueOf(invoke.toString()).intValue()>Integer.valueOf(q1).intValue()) {
					continue;
				}
				if(findByIssue.getQ5().hashCode()<= q1.hashCode()) {
					if(!isSameTrendResultList)lastResult.add(findByIssue.getQ5());
					if(isSameTrend) sameTrend.add(findByIssue.getQ5());
				}else if(findByIssue.getQ4().hashCode()<= q1.hashCode()) {
					if(!isSameTrendResultList)lastResult.add(findByIssue.getQ4());						
					if(isSameTrend) sameTrend.add(findByIssue.getQ4());
				}else if(findByIssue.getQ3().hashCode()<= q1.hashCode()) {
					if(!isSameTrendResultList)lastResult.add(findByIssue.getQ3());						
					if(isSameTrend) sameTrend.add(findByIssue.getQ3());
				}else if(findByIssue.getQ2().hashCode()<= q1.hashCode()) {
					if(!isSameTrendResultList)lastResult.add(findByIssue.getQ2());						
					if(isSameTrend) sameTrend.add(findByIssue.getQ2());
				}else if(findByIssue.getQ1().hashCode()<= q1.hashCode()) {
					if(!isSameTrendResultList)lastResult.add(findByIssue.getQ1());						
					if(isSameTrend) sameTrend.add(findByIssue.getQ1());
				}
			}
		}	
	}
	/**   
	 * @Title: check   
	 * @Description: TODO  
	 * @param: @param issue
	 * @param: @param q1
	 * @param: @return      
	 * @return: boolean      
	 * @throws   
	 */
	private boolean check(String issue, String q1) {
		DltResultEntity resultEntity = dltResultRepository.findByIssue(issue);
		if(q1.length()==1) q1 = "0"+q1;
		String q1OfRe = resultEntity.getQ1();
		if(q1OfRe.equals(q1)) return true;
		String q2OfRe = resultEntity.getQ2();
		if(q2OfRe.equals(q1)) return true;
		String q3OfRe = resultEntity.getQ3();
		if(q3OfRe.equals(q1)) return true;
		String q4OfRe = resultEntity.getQ4();
		if(q4OfRe.equals(q1)) return true;
		String q5OfRe = resultEntity.getQ5();
		if(q5OfRe.equals(q1)) return true;
		return false;
	}

	/**
	 * @param leftOfq1 
	 * @param last    
	 * @Title: getResultList   
	 * @Description: TODO  
	 * @param: @param dlt
	 * @param: @param q1
	 * @param: @return      
	 * @return: List<Object>      
	 * @throws   
	 */
	@SuppressWarnings("unchecked")
	private List<Object> getResultList(DltEntity last, Class<? extends DltEntity> dlt, String q1, int leftOfq1) {
		StringBuilder sql = new StringBuilder();

		try {
			if(q1.startsWith("0")) {
				q1 = q1.substring(1);
			}
			Field fieldOfLeft = dlt.getDeclaredField("q"+leftOfq1);
			PropertyDescriptor pd = new PropertyDescriptor(fieldOfLeft.getName(), dlt);
			Object invokeOfLeft = pd.getReadMethod().invoke(last);
			String valueOfLeft = String.valueOf(invokeOfLeft);
			sql.append("select d.issue from Dlt d where d.").append("q"+q1).append("='").append(q1).append("' and d.").append("q"+leftOfq1)
			.append("='").append(valueOfLeft).append("' AND d.issue between '07001' and '").append(last.getIssue()+"'-1");
			Query query = em.createNativeQuery(sql.toString());
//		    query.unwrap(SQLQuery.class).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		   return query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**   
	 * @Title: getSameTrendResultList   
	 * @Description: TODO  
	 * @param: @param last
	 * @param: @param q1
	 * @param: @param leftOfq1
	 * @param: @param rightOfq1
	 * @param: @return      
	 * @return: List<Object>      
	 * @throws   
	 */
	@SuppressWarnings("unchecked")
	private List<Object> getSameTrendResultList(DltEntity last, String q1, int leftOfq1, int rightOfq1) {
		StringBuilder sql = new StringBuilder();
		try {
			if(q1.startsWith("0")) {
				q1 = q1.substring(1);
			}
			Field fieldOfLeft = last.getClass().getDeclaredField("q"+leftOfq1);
			PropertyDescriptor pdOfLeft = new PropertyDescriptor(fieldOfLeft.getName(), last.getClass());
			Object invokeOfLeft = pdOfLeft.getReadMethod().invoke(last);
			String valueOfLeft = String.valueOf(invokeOfLeft);
			Field fieldOfRight = last.getClass().getDeclaredField("q"+rightOfq1);
			PropertyDescriptor pdOfRight = new PropertyDescriptor(fieldOfRight.getName(), last.getClass());
			Object invokeOfRight = pdOfRight.getReadMethod().invoke(last);
			String valueOfRight = String.valueOf(invokeOfRight);
			sql.append("select d.issue from Dlt d where d.").append("q"+q1+"='").append(q1).append("' and d.").append("q"+leftOfq1+"='").append(valueOfLeft+"'")
			.append(" and q"+rightOfq1+"='").append(valueOfRight+"' AND d.issue between '07001' and '").append(last.getIssue()+"'-1");
			Query query = em.createNativeQuery(sql.toString());
//		    query.unwrap(SQLQuery.class).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		   return query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}	


	/**   
	 * @Title: getUpResultList   
	 * @Description: TODO  
	 * @param: @param last
	 * @param: @param q1
	 * @param: @param upOfq1
	 * @param: @return      
	 * @return: List<Object>      
	 * @throws   
	 */
	@SuppressWarnings("unchecked")
	private List<Object> getUpResultList(DltEntity last, String q1, int upOfq1) {
		StringBuilder sql = new StringBuilder();

		try {
			if(q1.startsWith("0")) {
				q1 = q1.substring(1);
			}
			sql.append("select d.issue from  dlt d ,dlt t where d.q").append(q1).append("='").append(q1).append("' and t.q")
			.append(q1).append("='").append(upOfq1).append("' and t.issue=d.issue-1 AND d.issue between '07001' and '").append(last.getIssue()+"'-1");
			Query query = em.createNativeQuery(sql.toString());
		   return query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return null;
	}

	/**   
	 * @Title: getValueOfUpIssue   
	 * @Description: TODO  
	 * @param: @param issue
	 * @param: @param q1
	 * @param: @return      
	 * @return: int      
	 * @throws   
	 */
	@SuppressWarnings("unchecked")
	private int getValueOfUpIssue(String issue, String q1) {
		if(q1.startsWith("0")) {
			q1 = q1.substring(1);
		}
		String sql = "select d.q"+q1+" from dlt d where d.issue='"+issue+"'-1 ";
		Query query = em.createNativeQuery(sql);
		String q1OfUpIssue = "";	
		List<Object> resultList = query.getResultList();
		if(!resultList.isEmpty()) {
			q1OfUpIssue = query.getResultList().get(0).toString();
		}else {
			return 0;
		}
		return Integer.valueOf(q1OfUpIssue).intValue();
	}
	
	/**   
	 * <p>Title: setDlt</p>   
	 * <p>Description: </p>   
	 * @param dlt
	 * @return   
	 * @see t.z.h.service.DltService#setDlt(java.lang.String)   
	 */
	@Override
	public String setDlt(String dlt) {
		DltEntity dltEntity = new DltEntity();
		Field[] fields = dltEntity.getClass().getDeclaredFields();
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
			dltRepository.save(dltEntity);
			return "SUCCESS";
		} catch (Exception e) {
			e.printStackTrace();
			return "FAILURE";
		}
	}
	/**   
	 * <p>Title: setResult</p>   
	 * <p>Description: </p>   
	 * @param dlt
	 * @return   
	 * @see t.z.h.service.DltService#setResult(java.lang.String)   
	 */
	@Override
	public String setResult(String dlt) {
		DltResultEntity dltEntity = new DltResultEntity();
		Field[] fields = dltEntity.getClass().getDeclaredFields();
		String[] split = dlt.split(" ");
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
			dltResultRepository.save(dltEntity);
			return "SUCCESS";
		} catch (Exception e) {
			e.printStackTrace();
			return "FAILURE";
		}
	}

}
