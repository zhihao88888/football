package t.z.h.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * projectName:jc_analyze className：DltResultEntity description: creator:Mr.
 * date：2018年4月17日 下午4:05:14
 * 
 * @version
 */
@Entity
@Table(name = "DLT_RESULT")
public class DltResultEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	// ----------------------------------------------------------------------
	// ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
	// ----------------------------------------------------------------------
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", nullable = false)
	private Integer id;

	// 期号
	@Column(name = "ISSUE", length = 32)
	private String issue;

	// 前1
	@Column(name = "Q1", length = 2)
	private String q1;

	@Column(name = "Q2", length = 2)
	private String q2;

	@Column(name = "Q3", length = 2)
	private String q3;

	@Column(name = "Q4", length = 2)
	private String q4;

	@Column(name = "Q5", length = 2)
	private String q5;

	// 后1
	@Column(name = "H1", length = 2)
	private String h1;

	@Column(name = "H2", length = 2)
	private String h2;

	@Column(name = "JACKPOT", length = 255)
	private String jackpot;

	@Column(name = "ONE_NUM", length = 255)
	private String oneNum;

	@Column(name = "ONE_BONUS", length = 255)
	private String oneBonus;

	@Column(name = "TWO_NUM", length = 255)
	private String twoNum;

	@Column(name = "TWO_BONUS", length = 255)
	private String twoBonus;

	@Column(name = "BET", length = 255)
	private String Bet;

	@Column(name = "LOTTERY_DATE", length = 255)
	private String lotteryDate;

	/**  
	 * @Title:  getId
	 * @Description: please write your description
	 * @return: Integer 
	 */
	public Integer getId() {
		return id;
	}

	/**  
	 * @Title:  setId
	 * @Description: please write your description
	 * @return: Integer 
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**  
	 * @Title:  getIssue
	 * @Description: please write your description
	 * @return: String 
	 */
	public String getIssue() {
		return issue;
	}

	/**  
	 * @Title:  setIssue
	 * @Description: please write your description
	 * @return: String 
	 */
	public void setIssue(String issue) {
		this.issue = issue;
	}

	/**  
	 * @Title:  getQ1
	 * @Description: please write your description
	 * @return: String 
	 */
	public String getQ1() {
		return q1;
	}

	/**  
	 * @Title:  setQ1
	 * @Description: please write your description
	 * @return: String 
	 */
	public void setQ1(String q1) {
		this.q1 = q1;
	}

	/**  
	 * @Title:  getQ2
	 * @Description: please write your description
	 * @return: String 
	 */
	public String getQ2() {
		return q2;
	}

	/**  
	 * @Title:  setQ2
	 * @Description: please write your description
	 * @return: String 
	 */
	public void setQ2(String q2) {
		this.q2 = q2;
	}

	/**  
	 * @Title:  getQ3
	 * @Description: please write your description
	 * @return: String 
	 */
	public String getQ3() {
		return q3;
	}

	/**  
	 * @Title:  setQ3
	 * @Description: please write your description
	 * @return: String 
	 */
	public void setQ3(String q3) {
		this.q3 = q3;
	}

	/**  
	 * @Title:  getQ4
	 * @Description: please write your description
	 * @return: String 
	 */
	public String getQ4() {
		return q4;
	}

	/**  
	 * @Title:  setQ4
	 * @Description: please write your description
	 * @return: String 
	 */
	public void setQ4(String q4) {
		this.q4 = q4;
	}

	/**  
	 * @Title:  getQ5
	 * @Description: please write your description
	 * @return: String 
	 */
	public String getQ5() {
		return q5;
	}

	/**  
	 * @Title:  setQ5
	 * @Description: please write your description
	 * @return: String 
	 */
	public void setQ5(String q5) {
		this.q5 = q5;
	}

	/**  
	 * @Title:  getH1
	 * @Description: please write your description
	 * @return: String 
	 */
	public String getH1() {
		return h1;
	}

	/**  
	 * @Title:  setH1
	 * @Description: please write your description
	 * @return: String 
	 */
	public void setH1(String h1) {
		this.h1 = h1;
	}

	/**  
	 * @Title:  getH2
	 * @Description: please write your description
	 * @return: String 
	 */
	public String getH2() {
		return h2;
	}

	/**  
	 * @Title:  setH2
	 * @Description: please write your description
	 * @return: String 
	 */
	public void setH2(String h2) {
		this.h2 = h2;
	}

	/**  
	 * @Title:  getJackpot
	 * @Description: please write your description
	 * @return: String 
	 */
	public String getJackpot() {
		return jackpot;
	}

	/**  
	 * @Title:  setJackpot
	 * @Description: please write your description
	 * @return: String 
	 */
	public void setJackpot(String jackpot) {
		this.jackpot = jackpot;
	}

	/**  
	 * @Title:  getOneNum
	 * @Description: please write your description
	 * @return: String 
	 */
	public String getOneNum() {
		return oneNum;
	}

	/**  
	 * @Title:  setOneNum
	 * @Description: please write your description
	 * @return: String 
	 */
	public void setOneNum(String oneNum) {
		this.oneNum = oneNum;
	}

	/**  
	 * @Title:  getOneBonus
	 * @Description: please write your description
	 * @return: String 
	 */
	public String getOneBonus() {
		return oneBonus;
	}

	/**  
	 * @Title:  setOneBonus
	 * @Description: please write your description
	 * @return: String 
	 */
	public void setOneBonus(String oneBonus) {
		this.oneBonus = oneBonus;
	}

	/**  
	 * @Title:  getTwoNum
	 * @Description: please write your description
	 * @return: String 
	 */
	public String getTwoNum() {
		return twoNum;
	}

	/**  
	 * @Title:  setTwoNum
	 * @Description: please write your description
	 * @return: String 
	 */
	public void setTwoNum(String twoNum) {
		this.twoNum = twoNum;
	}

	/**  
	 * @Title:  getTwoBonus
	 * @Description: please write your description
	 * @return: String 
	 */
	public String getTwoBonus() {
		return twoBonus;
	}

	/**  
	 * @Title:  setTwoBonus
	 * @Description: please write your description
	 * @return: String 
	 */
	public void setTwoBonus(String twoBonus) {
		this.twoBonus = twoBonus;
	}

	/**  
	 * @Title:  getBet
	 * @Description: please write your description
	 * @return: String 
	 */
	public String getBet() {
		return Bet;
	}

	/**  
	 * @Title:  setBet
	 * @Description: please write your description
	 * @return: String 
	 */
	public void setBet(String bet) {
		Bet = bet;
	}

	/**  
	 * @Title:  getLotteryDate
	 * @Description: please write your description
	 * @return: String 
	 */
	public String getLotteryDate() {
		return lotteryDate;
	}

	/**  
	 * @Title:  setLotteryDate
	 * @Description: please write your description
	 * @return: String 
	 */
	public void setLotteryDate(String lotteryDate) {
		this.lotteryDate = lotteryDate;
	}

	/**   
	 * <p>Title: toString</p>   
	 * <p>Description: </p>   
	 * @return   
	 * @see java.lang.Object#toString()   
	 */
	@Override
	public String toString() {
		return "DltResultEntity [id=" + id + ", issue=" + issue + ", q1=" + q1 + ", q2=" + q2 + ", q3=" + q3 + ", q4="
				+ q4 + ", q5=" + q5 + ", h1=" + h1 + ", h2=" + h2 + ", jackpot=" + jackpot + ", oneNum=" + oneNum
				+ ", oneBonus=" + oneBonus + ", twoNum=" + twoNum + ", twoBonus=" + twoBonus + ", Bet=" + Bet
				+ ", lotteryDate=" + lotteryDate + "]";
	}



}
