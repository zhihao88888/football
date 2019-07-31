package t.z.h.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * projectName:jc_analyze className：DltEntity description: creator:Mr.
 * date：2018年4月17日 下午4:05:14
 * 
 * @version
 */
@Entity
@Table(name = "DLT")
public class DltEntity implements Serializable {
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

	@Column(name = "Q6", length = 2)
	private String q6;

	@Column(name = "Q7", length = 2)
	private String q7;

	@Column(name = "Q8", length = 2)
	private String q8;

	@Column(name = "Q9", length = 2)
	private String q9;

	@Column(name = "Q10", length = 2)
	private String q10;

	@Column(name = "Q11", length = 2)
	private String q11;

	@Column(name = "Q12", length = 2)
	private String q12;

	@Column(name = "Q13", length = 2)
	private String q13;

	@Column(name = "Q14", length = 2)
	private String q14;

	@Column(name = "Q15", length = 2)
	private String q15;

	@Column(name = "Q16", length = 2)
	private String q16;

	@Column(name = "Q17", length = 2)
	private String q17;

	@Column(name = "Q18", length = 2)
	private String q18;

	@Column(name = "Q19", length = 2)
	private String q19;

	@Column(name = "Q20", length = 2)
	private String q20;

	@Column(name = "Q21", length = 2)
	private String q21;

	@Column(name = "Q22", length = 2)
	private String q22;

	@Column(name = "Q23", length = 2)
	private String q23;

	@Column(name = "Q24", length = 2)
	private String q24;

	@Column(name = "Q25", length = 2)
	private String q25;

	@Column(name = "Q26", length = 2)
	private String q26;

	@Column(name = "Q27", length = 2)
	private String q27;

	@Column(name = "Q28", length = 2)
	private String q28;

	@Column(name = "Q29", length = 2)
	private String q29;

	@Column(name = "Q30", length = 2)
	private String q30;

	@Column(name = "Q31", length = 2)
	private String q31;

	@Column(name = "Q32", length = 2)
	private String q32;

	@Column(name = "Q33", length = 2)
	private String q33;

	@Column(name = "Q34", length = 2)
	private String q34;

	@Column(name = "Q35", length = 2)
	private String q35;

	// 后1
	@Column(name = "H1", length = 2)
	private String h1;

	@Column(name = "H2", length = 2)
	private String h2;

	@Column(name = "H3", length = 2)
	private String h3;

	@Column(name = "H4", length = 2)
	private String h4;

	@Column(name = "H5", length = 2)
	private String h5;

	@Column(name = "H6", length = 2)
	private String h6;

	@Column(name = "H7", length = 2)
	private String h7;

	@Column(name = "H8", length = 2)
	private String h8;

	@Column(name = "H9", length = 2)
	private String h9;

	@Column(name = "H10", length = 2)
	private String h10;

	@Column(name = "H11", length = 2)
	private String h11;

	@Column(name = "H12", length = 2)
	private String h12;

	/**
	 * @Title: getId
	 * @Description: please write your description
	 * @return: Integer
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @Title: setId
	 * @Description: please write your description
	 * @return: Integer
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @Title: getIssue
	 * @Description: please write your description
	 * @return: String
	 */
	public String getIssue() {
		return issue;
	}

	/**
	 * @Title: setIssue
	 * @Description: please write your description
	 * @return: String
	 */
	public void setIssue(String issue) {
		this.issue = issue;
	}

	/**
	 * @Title: getQ1
	 * @Description: please write your description
	 * @return: String
	 */
	public String getQ1() {
		return q1;
	}

	/**
	 * @Title: setQ1
	 * @Description: please write your description
	 * @return: String
	 */
	public void setQ1(String q1) {
		this.q1 = q1;
	}

	/**
	 * @Title: getQ2
	 * @Description: please write your description
	 * @return: String
	 */
	public String getQ2() {
		return q2;
	}

	/**
	 * @Title: setQ2
	 * @Description: please write your description
	 * @return: String
	 */
	public void setQ2(String q2) {
		this.q2 = q2;
	}

	/**
	 * @Title: getQ3
	 * @Description: please write your description
	 * @return: String
	 */
	public String getQ3() {
		return q3;
	}

	/**
	 * @Title: setQ3
	 * @Description: please write your description
	 * @return: String
	 */
	public void setQ3(String q3) {
		this.q3 = q3;
	}

	/**
	 * @Title: getQ4
	 * @Description: please write your description
	 * @return: String
	 */
	public String getQ4() {
		return q4;
	}

	/**
	 * @Title: setQ4
	 * @Description: please write your description
	 * @return: String
	 */
	public void setQ4(String q4) {
		this.q4 = q4;
	}

	/**
	 * @Title: getQ5
	 * @Description: please write your description
	 * @return: String
	 */
	public String getQ5() {
		return q5;
	}

	/**
	 * @Title: setQ5
	 * @Description: please write your description
	 * @return: String
	 */
	public void setQ5(String q5) {
		this.q5 = q5;
	}

	/**
	 * @Title: getQ6
	 * @Description: please write your description
	 * @return: String
	 */
	public String getQ6() {
		return q6;
	}

	/**
	 * @Title: setQ6
	 * @Description: please write your description
	 * @return: String
	 */
	public void setQ6(String q6) {
		this.q6 = q6;
	}

	/**
	 * @Title: getQ7
	 * @Description: please write your description
	 * @return: String
	 */
	public String getQ7() {
		return q7;
	}

	/**
	 * @Title: setQ7
	 * @Description: please write your description
	 * @return: String
	 */
	public void setQ7(String q7) {
		this.q7 = q7;
	}

	/**
	 * @Title: getQ8
	 * @Description: please write your description
	 * @return: String
	 */
	public String getQ8() {
		return q8;
	}

	/**
	 * @Title: setQ8
	 * @Description: please write your description
	 * @return: String
	 */
	public void setQ8(String q8) {
		this.q8 = q8;
	}

	/**
	 * @Title: getQ9
	 * @Description: please write your description
	 * @return: String
	 */
	public String getQ9() {
		return q9;
	}

	/**
	 * @Title: setQ9
	 * @Description: please write your description
	 * @return: String
	 */
	public void setQ9(String q9) {
		this.q9 = q9;
	}

	/**
	 * @Title: getQ10
	 * @Description: please write your description
	 * @return: String
	 */
	public String getQ10() {
		return q10;
	}

	/**
	 * @Title: setQ10
	 * @Description: please write your description
	 * @return: String
	 */
	public void setQ10(String q10) {
		this.q10 = q10;
	}

	/**
	 * @Title: getQ11
	 * @Description: please write your description
	 * @return: String
	 */
	public String getQ11() {
		return q11;
	}

	/**
	 * @Title: setQ11
	 * @Description: please write your description
	 * @return: String
	 */
	public void setQ11(String q11) {
		this.q11 = q11;
	}

	/**
	 * @Title: getQ12
	 * @Description: please write your description
	 * @return: String
	 */
	public String getQ12() {
		return q12;
	}

	/**
	 * @Title: setQ12
	 * @Description: please write your description
	 * @return: String
	 */
	public void setQ12(String q12) {
		this.q12 = q12;
	}

	/**
	 * @Title: getQ13
	 * @Description: please write your description
	 * @return: String
	 */
	public String getQ13() {
		return q13;
	}

	/**
	 * @Title: setQ13
	 * @Description: please write your description
	 * @return: String
	 */
	public void setQ13(String q13) {
		this.q13 = q13;
	}

	/**
	 * @Title: getQ14
	 * @Description: please write your description
	 * @return: String
	 */
	public String getQ14() {
		return q14;
	}

	/**
	 * @Title: setQ14
	 * @Description: please write your description
	 * @return: String
	 */
	public void setQ14(String q14) {
		this.q14 = q14;
	}

	/**
	 * @Title: getQ15
	 * @Description: please write your description
	 * @return: String
	 */
	public String getQ15() {
		return q15;
	}

	/**
	 * @Title: setQ15
	 * @Description: please write your description
	 * @return: String
	 */
	public void setQ15(String q15) {
		this.q15 = q15;
	}

	/**
	 * @Title: getQ16
	 * @Description: please write your description
	 * @return: String
	 */
	public String getQ16() {
		return q16;
	}

	/**
	 * @Title: setQ16
	 * @Description: please write your description
	 * @return: String
	 */
	public void setQ16(String q16) {
		this.q16 = q16;
	}

	/**
	 * @Title: getQ17
	 * @Description: please write your description
	 * @return: String
	 */
	public String getQ17() {
		return q17;
	}

	/**
	 * @Title: setQ17
	 * @Description: please write your description
	 * @return: String
	 */
	public void setQ17(String q17) {
		this.q17 = q17;
	}

	/**
	 * @Title: getQ18
	 * @Description: please write your description
	 * @return: String
	 */
	public String getQ18() {
		return q18;
	}

	/**
	 * @Title: setQ18
	 * @Description: please write your description
	 * @return: String
	 */
	public void setQ18(String q18) {
		this.q18 = q18;
	}

	/**
	 * @Title: getQ19
	 * @Description: please write your description
	 * @return: String
	 */
	public String getQ19() {
		return q19;
	}

	/**
	 * @Title: setQ19
	 * @Description: please write your description
	 * @return: String
	 */
	public void setQ19(String q19) {
		this.q19 = q19;
	}

	/**
	 * @Title: getQ20
	 * @Description: please write your description
	 * @return: String
	 */
	public String getQ20() {
		return q20;
	}

	/**
	 * @Title: setQ20
	 * @Description: please write your description
	 * @return: String
	 */
	public void setQ20(String q20) {
		this.q20 = q20;
	}

	/**
	 * @Title: getQ21
	 * @Description: please write your description
	 * @return: String
	 */
	public String getQ21() {
		return q21;
	}

	/**
	 * @Title: setQ21
	 * @Description: please write your description
	 * @return: String
	 */
	public void setQ21(String q21) {
		this.q21 = q21;
	}

	/**
	 * @Title: getQ22
	 * @Description: please write your description
	 * @return: String
	 */
	public String getQ22() {
		return q22;
	}

	/**
	 * @Title: setQ22
	 * @Description: please write your description
	 * @return: String
	 */
	public void setQ22(String q22) {
		this.q22 = q22;
	}

	/**
	 * @Title: getQ23
	 * @Description: please write your description
	 * @return: String
	 */
	public String getQ23() {
		return q23;
	}

	/**
	 * @Title: setQ23
	 * @Description: please write your description
	 * @return: String
	 */
	public void setQ23(String q23) {
		this.q23 = q23;
	}

	/**
	 * @Title: getQ24
	 * @Description: please write your description
	 * @return: String
	 */
	public String getQ24() {
		return q24;
	}

	/**
	 * @Title: setQ24
	 * @Description: please write your description
	 * @return: String
	 */
	public void setQ24(String q24) {
		this.q24 = q24;
	}

	/**
	 * @Title: getQ25
	 * @Description: please write your description
	 * @return: String
	 */
	public String getQ25() {
		return q25;
	}

	/**
	 * @Title: setQ25
	 * @Description: please write your description
	 * @return: String
	 */
	public void setQ25(String q25) {
		this.q25 = q25;
	}

	/**
	 * @Title: getQ26
	 * @Description: please write your description
	 * @return: String
	 */
	public String getQ26() {
		return q26;
	}

	/**
	 * @Title: setQ26
	 * @Description: please write your description
	 * @return: String
	 */
	public void setQ26(String q26) {
		this.q26 = q26;
	}

	/**
	 * @Title: getQ27
	 * @Description: please write your description
	 * @return: String
	 */
	public String getQ27() {
		return q27;
	}

	/**
	 * @Title: setQ27
	 * @Description: please write your description
	 * @return: String
	 */
	public void setQ27(String q27) {
		this.q27 = q27;
	}

	/**
	 * @Title: getQ28
	 * @Description: please write your description
	 * @return: String
	 */
	public String getQ28() {
		return q28;
	}

	/**
	 * @Title: setQ28
	 * @Description: please write your description
	 * @return: String
	 */
	public void setQ28(String q28) {
		this.q28 = q28;
	}

	/**
	 * @Title: getQ29
	 * @Description: please write your description
	 * @return: String
	 */
	public String getQ29() {
		return q29;
	}

	/**
	 * @Title: setQ29
	 * @Description: please write your description
	 * @return: String
	 */
	public void setQ29(String q29) {
		this.q29 = q29;
	}

	/**
	 * @Title: getQ30
	 * @Description: please write your description
	 * @return: String
	 */
	public String getQ30() {
		return q30;
	}

	/**
	 * @Title: setQ30
	 * @Description: please write your description
	 * @return: String
	 */
	public void setQ30(String q30) {
		this.q30 = q30;
	}

	/**
	 * @Title: getQ31
	 * @Description: please write your description
	 * @return: String
	 */
	public String getQ31() {
		return q31;
	}

	/**
	 * @Title: setQ31
	 * @Description: please write your description
	 * @return: String
	 */
	public void setQ31(String q31) {
		this.q31 = q31;
	}

	/**
	 * @Title: getQ32
	 * @Description: please write your description
	 * @return: String
	 */
	public String getQ32() {
		return q32;
	}

	/**
	 * @Title: setQ32
	 * @Description: please write your description
	 * @return: String
	 */
	public void setQ32(String q32) {
		this.q32 = q32;
	}

	/**
	 * @Title: getQ33
	 * @Description: please write your description
	 * @return: String
	 */
	public String getQ33() {
		return q33;
	}

	/**
	 * @Title: setQ33
	 * @Description: please write your description
	 * @return: String
	 */
	public void setQ33(String q33) {
		this.q33 = q33;
	}

	/**
	 * @Title: getQ34
	 * @Description: please write your description
	 * @return: String
	 */
	public String getQ34() {
		return q34;
	}

	/**
	 * @Title: setQ34
	 * @Description: please write your description
	 * @return: String
	 */
	public void setQ34(String q34) {
		this.q34 = q34;
	}

	/**
	 * @Title: getQ35
	 * @Description: please write your description
	 * @return: String
	 */
	public String getQ35() {
		return q35;
	}

	/**
	 * @Title: setQ35
	 * @Description: please write your description
	 * @return: String
	 */
	public void setQ35(String q35) {
		this.q35 = q35;
	}

	/**
	 * @Title: getH1
	 * @Description: please write your description
	 * @return: String
	 */
	public String getH1() {
		return h1;
	}

	/**
	 * @Title: setH1
	 * @Description: please write your description
	 * @return: String
	 */
	public void setH1(String h1) {
		this.h1 = h1;
	}

	/**
	 * @Title: getH2
	 * @Description: please write your description
	 * @return: String
	 */
	public String getH2() {
		return h2;
	}

	/**
	 * @Title: setH2
	 * @Description: please write your description
	 * @return: String
	 */
	public void setH2(String h2) {
		this.h2 = h2;
	}

	/**
	 * @Title: getH3
	 * @Description: please write your description
	 * @return: String
	 */
	public String getH3() {
		return h3;
	}

	/**
	 * @Title: setH3
	 * @Description: please write your description
	 * @return: String
	 */
	public void setH3(String h3) {
		this.h3 = h3;
	}

	/**
	 * @Title: getH4
	 * @Description: please write your description
	 * @return: String
	 */
	public String getH4() {
		return h4;
	}

	/**
	 * @Title: setH4
	 * @Description: please write your description
	 * @return: String
	 */
	public void setH4(String h4) {
		this.h4 = h4;
	}

	/**
	 * @Title: getH5
	 * @Description: please write your description
	 * @return: String
	 */
	public String getH5() {
		return h5;
	}

	/**
	 * @Title: setH5
	 * @Description: please write your description
	 * @return: String
	 */
	public void setH5(String h5) {
		this.h5 = h5;
	}

	/**
	 * @Title: getH6
	 * @Description: please write your description
	 * @return: String
	 */
	public String getH6() {
		return h6;
	}

	/**
	 * @Title: setH6
	 * @Description: please write your description
	 * @return: String
	 */
	public void setH6(String h6) {
		this.h6 = h6;
	}

	/**
	 * @Title: getH7
	 * @Description: please write your description
	 * @return: String
	 */
	public String getH7() {
		return h7;
	}

	/**
	 * @Title: setH7
	 * @Description: please write your description
	 * @return: String
	 */
	public void setH7(String h7) {
		this.h7 = h7;
	}

	/**
	 * @Title: getH8
	 * @Description: please write your description
	 * @return: String
	 */
	public String getH8() {
		return h8;
	}

	/**
	 * @Title: setH8
	 * @Description: please write your description
	 * @return: String
	 */
	public void setH8(String h8) {
		this.h8 = h8;
	}

	/**
	 * @Title: getH9
	 * @Description: please write your description
	 * @return: String
	 */
	public String getH9() {
		return h9;
	}

	/**
	 * @Title: setH9
	 * @Description: please write your description
	 * @return: String
	 */
	public void setH9(String h9) {
		this.h9 = h9;
	}

	/**
	 * @Title: getH10
	 * @Description: please write your description
	 * @return: String
	 */
	public String getH10() {
		return h10;
	}

	/**
	 * @Title: setH10
	 * @Description: please write your description
	 * @return: String
	 */
	public void setH10(String h10) {
		this.h10 = h10;
	}

	/**
	 * @Title: getH11
	 * @Description: please write your description
	 * @return: String
	 */
	public String getH11() {
		return h11;
	}

	/**
	 * @Title: setH11
	 * @Description: please write your description
	 * @return: String
	 */
	public void setH11(String h11) {
		this.h11 = h11;
	}

	/**
	 * @Title: getH12
	 * @Description: please write your description
	 * @return: String
	 */
	public String getH12() {
		return h12;
	}

	/**
	 * @Title: setH12
	 * @Description: please write your description
	 * @return: String
	 */
	public void setH12(String h12) {
		this.h12 = h12;
	}

	/**
	 * <p>
	 * Title: toString
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @return
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "DltEntity [id=" + id + ", issue=" + issue + ", q1=" + q1 + ", q2=" + q2 + ", q3=" + q3 + ", q4=" + q4
				+ ", q5=" + q5 + ", q6=" + q6 + ", q7=" + q7 + ", q8=" + q8 + ", q9=" + q9 + ", q10=" + q10 + ", q11="
				+ q11 + ", q12=" + q12 + ", q13=" + q13 + ", q14=" + q14 + ", q15=" + q15 + ", q16=" + q16 + ", q17="
				+ q17 + ", q18=" + q18 + ", q19=" + q19 + ", q20=" + q20 + ", q21=" + q21 + ", q22=" + q22 + ", q23="
				+ q23 + ", q24=" + q24 + ", q25=" + q25 + ", q26=" + q26 + ", q27=" + q27 + ", q28=" + q28 + ", q29="
				+ q29 + ", q30=" + q30 + ", q31=" + q31 + ", q32=" + q32 + ", q33=" + q33 + ", q34=" + q34 + ", q35="
				+ q35 + ", h1=" + h1 + ", h2=" + h2 + ", h3=" + h3 + ", h4=" + h4 + ", h5=" + h5 + ", h6=" + h6
				+ ", h7=" + h7 + ", h8=" + h8 + ", h9=" + h9 + ", h10=" + h10 + ", h11=" + h11 + ", h12=" + h12 + "]";
	}

}
