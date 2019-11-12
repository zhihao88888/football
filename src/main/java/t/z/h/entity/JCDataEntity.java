package t.z.h.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


/**      
* projectName:jc_analyze   
* className：JCDataEntity   
* description:
* creator:Mr.
* date：2018年4月17日 下午4:05:14   
* @version        
*/
@Entity
@Table(name="JC_DATA")
public class JCDataEntity implements Serializable{
	 private static final long serialVersionUID = 1L;

	    //----------------------------------------------------------------------
	    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
	    //----------------------------------------------------------------------
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name="ID", nullable=false)
	    private Integer    id       ;

	    //赛别
	    @Column(name="GTYPE", length=225)
	    private String       type   ;
	    
	    //主场
	    @Column(name="HOME_FIELD", length=225)
	    private String       homeField   ;
	    
	    //客场
	    @Column(name="VISITING_FIELD", length=225)
	    private String       visitingField   ;
	    
	    //胜赔
	    @Column(name="VICTORY_ODDS", length=225)
	    private String     victoryOdds     ;

	    //平赔
	    @Column(name="DRAW_ODDS", length=225)
	    private String     drawOdds     ;

	    //负赔
	    @Column(name="DEFEAT_ODDS", length=225)
	    private String     defeatOdds      ;

	    //让球数
	    @Column(name="LET_BALL_NUM", length=225)
	    private String     letBallNum   ;

	    //让胜赔
	    @Column(name="L_VICTORY_ODDS", length=225)
	    private String     LVictoryOdds      ;

	    //让平赔
	    @Column(name="L_DRAW_ODDS", length=225)
	    private String       LDrawOdds   ;

	    //让负赔
	    @Column(name="L_DEFEAT_ODDS", length=225)
	    private String     LDefeatOdds     ;

	    //胜平负结果
	    @Column(name="NRESULT", length=225)
	    private String       result   ;

	    //让球胜平负结果
	    @Column(name="L_RESULT", length=225)
	    private String     LResult     ;

	    //比分
	    @Column(name="SCORE", length=225)
	    private String       score   ;
	    
	    //总进球
	    @Column(name="GOAL_NUM", length=225)
	    private String       goalNum   ;
	    
	    //比赛时间
	    @Column(name="GAME_TIME")
	    private String     gameTime  ;

	    //备注
	    @Column(name="NOTES", length=225)
	    private String     notes        ;
	    
	    //主队红牌数
	    @Column(name="H_RED_CARD", length=225)
	    private String     hRedCard        ;

	    
	    //客队红牌数
	    @Column(name="V_RED_CARD", length=225)
	    private String     vRedCard        ;
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
		 * @Title:  getType
		 * @Description: please write your description
		 * @return: String 
		 */
		public String getType() {
			return type;
		}

		/**  
		 * @Title:  setType
		 * @Description: please write your description
		 * @return: String 
		 */
		public void setType(String type) {
			this.type = type;
		}

		/**  
		 * @Title:  getHomeField
		 * @Description: please write your description
		 * @return: String 
		 */
		public String getHomeField() {
			return homeField;
		}

		/**  
		 * @Title:  setHomeField
		 * @Description: please write your description
		 * @return: String 
		 */
		public void setHomeField(String homeField) {
			this.homeField = homeField;
		}

		/**  
		 * @Title:  getVisitingField
		 * @Description: please write your description
		 * @return: String 
		 */
		public String getVisitingField() {
			return visitingField;
		}

		/**  
		 * @Title:  setVisitingField
		 * @Description: please write your description
		 * @return: String 
		 */
		public void setVisitingField(String visitingField) {
			this.visitingField = visitingField;
		}

		/**  
		 * @Title:  getVictoryOdds
		 * @Description: please write your description
		 * @return: String 
		 */
		public String getVictoryOdds() {
			return victoryOdds;
		}

		/**  
		 * @Title:  setVictoryOdds
		 * @Description: please write your description
		 * @return: String 
		 */
		public void setVictoryOdds(String victoryOdds) {
			this.victoryOdds = victoryOdds;
		}

		/**  
		 * @Title:  getDrawOdds
		 * @Description: please write your description
		 * @return: String 
		 */
		public String getDrawOdds() {
			return drawOdds;
		}

		/**  
		 * @Title:  setDrawOdds
		 * @Description: please write your description
		 * @return: String 
		 */
		public void setDrawOdds(String drawOdds) {
			this.drawOdds = drawOdds;
		}

		/**  
		 * @Title:  getDefeatOdds
		 * @Description: please write your description
		 * @return: String 
		 */
		public String getDefeatOdds() {
			return defeatOdds;
		}

		/**  
		 * @Title:  setDefeatOdds
		 * @Description: please write your description
		 * @return: String 
		 */
		public void setDefeatOdds(String defeatOdds) {
			this.defeatOdds = defeatOdds;
		}

		/**  
		 * @Title:  getLetBallNum
		 * @Description: please write your description
		 * @return: String 
		 */
		public String getLetBallNum() {
			return letBallNum;
		}

		/**  
		 * @Title:  setLetBallNum
		 * @Description: please write your description
		 * @return: String 
		 */
		public void setLetBallNum(String letBallNum) {
			this.letBallNum = letBallNum;
		}

		/**  
		 * @Title:  getLVictoryOdds
		 * @Description: please write your description
		 * @return: String 
		 */
		public String getLVictoryOdds() {
			return LVictoryOdds;
		}

		/**  
		 * @Title:  setLVictoryOdds
		 * @Description: please write your description
		 * @return: String 
		 */
		public void setLVictoryOdds(String lVictoryOdds) {
			LVictoryOdds = lVictoryOdds;
		}

		/**  
		 * @Title:  getLDrawOdds
		 * @Description: please write your description
		 * @return: String 
		 */
		public String getLDrawOdds() {
			return LDrawOdds;
		}

		/**  
		 * @Title:  setLDrawOdds
		 * @Description: please write your description
		 * @return: String 
		 */
		public void setLDrawOdds(String lDrawOdds) {
			LDrawOdds = lDrawOdds;
		}

		/**  
		 * @Title:  getLDefeatOdds
		 * @Description: please write your description
		 * @return: String 
		 */
		public String getLDefeatOdds() {
			return LDefeatOdds;
		}

		/**  
		 * @Title:  setLDefeatOdds
		 * @Description: please write your description
		 * @return: String 
		 */
		public void setLDefeatOdds(String lDefeatOdds) {
			LDefeatOdds = lDefeatOdds;
		}

		/**  
		 * @Title:  getResult
		 * @Description: please write your description
		 * @return: String 
		 */
		public String getResult() {
			return result;
		}

		/**  
		 * @Title:  setResult
		 * @Description: please write your description
		 * @return: String 
		 */
		public void setResult(String result) {
			this.result = result;
		}

		/**  
		 * @Title:  getLResult
		 * @Description: please write your description
		 * @return: String 
		 */
		public String getLResult() {
			return LResult;
		}

		/**  
		 * @Title:  setLResult
		 * @Description: please write your description
		 * @return: String 
		 */
		public void setLResult(String lResult) {
			LResult = lResult;
		}

		/**  
		 * @Title:  getScore
		 * @Description: please write your description
		 * @return: String 
		 */
		public String getScore() {
			return score;
		}

		/**  
		 * @Title:  setScore
		 * @Description: please write your description
		 * @return: String 
		 */
		public void setScore(String score) {
			this.score = score;
		}

		/**  
		 * @Title:  getGoalNum
		 * @Description: please write your description
		 * @return: String 
		 */
		public String getGoalNum() {
			return goalNum;
		}

		/**  
		 * @Title:  setGoalNum
		 * @Description: please write your description
		 * @return: String 
		 */
		public void setGoalNum(String goalNum) {
			this.goalNum = goalNum;
		}

		/**  
		 * @Title:  getGameTime
		 * @Description: please write your description
		 * @return: Date 
		 */
		public String getGameTime() {
			return gameTime;
		}

		/**  
		 * @Title:  setGameTime
		 * @Description: please write your description
		 * @return: Date 
		 */
		public void setGameTime(String gameTime) {
			this.gameTime = gameTime;
		}

		/**  
		 * @Title:  getNotes
		 * @Description: please write your description
		 * @return: String 
		 */
		public String getNotes() {
			return notes;
		}

		/**  
		 * @Title:  setNotes
		 * @Description: please write your description
		 * @return: String 
		 */
		public void setNotes(String notes) {
			this.notes = notes;
		}
		
		public String gethRedCard() {
			return hRedCard;
		}

		public void sethRedCard(String hRedCard) {
			this.hRedCard = hRedCard;
		}

		public String getvRedCard() {
			return vRedCard;
		}

		public void setvRedCard(String vRedCard) {
			this.vRedCard = vRedCard;
		}

		@Override
		public String toString() {
			return "JCDataEntity [id=" + id + ", type=" + type + ", homeField=" + homeField + ", visitingField="
					+ visitingField + ", victoryOdds=" + victoryOdds + ", drawOdds=" + drawOdds + ", defeatOdds="
					+ defeatOdds + ", letBallNum=" + letBallNum + ", LVictoryOdds=" + LVictoryOdds + ", LDrawOdds="
					+ LDrawOdds + ", LDefeatOdds=" + LDefeatOdds + ", result=" + result + ", LResult=" + LResult
					+ ", score=" + score + ", goalNum=" + goalNum + ", gameTime=" + gameTime + ", notes=" + notes
					+ ", hRedCard=" + hRedCard + ", vRedCard=" + vRedCard + "]";
		}

		
	    
	    
}
