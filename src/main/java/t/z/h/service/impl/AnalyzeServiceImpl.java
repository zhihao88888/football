/** 
* <p>Title: AnalyzeServiceImpl.java</p>  
* <p>Description: </p>  
* <p>Copyright: Copyright (c) 2018</p>  
* @author Mr.
* @date 2018年4月17日  
* @version 1.0  
*/
package t.z.h.service.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import t.z.h.domain.JCData;
import t.z.h.entity.JCDataEntity;
import t.z.h.repository.JCDataRepository;
import t.z.h.service.AnalyzeService;

/**
 * projectName:jc_analyze className：AnalyzeServiceImpl description: creator:Mr.
 * date：2018年4月17日 下午8:19:05
 * 
 * @version
 */
@Component
@Transactional
public class AnalyzeServiceImpl implements AnalyzeService {

	@Autowired
	private JCDataRepository jCDataRepository;

	/**
	 * <p>
	 * Title: goAnalyze
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param victoryOdds
	 * @param drawOdds
	 * @param defeatOdds
	 * @return
	 * @see t.z.h.service.AnalyzeService#goAnalyze(java.lang.String,
	 *      java.lang.String, java.lang.String)
	 */
	@Override
	public String goAnalyze(String victoryOdds, String drawOdds, String defeatOdds) {
		List<JCDataEntity> str = jCDataRepository.find(victoryOdds, drawOdds, defeatOdds);

		return str.toString();
	}

	/**
	 * <p>
	 * Title: toSee
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param str
	 * @return
	 * @see t.z.h.service.AnalyzeService#toSee(java.lang.String)
	 */
	@Override
	public List<String> toSee(String str) {
		List<String> amonut = jCDataRepository.find(str);
		return amonut;
	}

	/**
	 * <p>
	 * Title: handleData
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @return
	 * @throws IOException
	 * @see t.z.h.service.AnalyzeService#handleData()
	 */
	@Override
	public ArrayList<String> handleData(BufferedReader reader) throws IOException {
		BigDecimal common = new BigDecimal("0.1");
		JCData jc = new JCData();
		String str = "";
		String addVictoryOdds = "";
		String subtractVictoryOdds = "";
		String addDrawOdds = "";
		String subtractDrawOdds = "";
		String addDefeatOdds = "";
		String subtractDefeatOdds = "";
		while (!(str = reader.readLine()).equals("")) {
			boolean matches = str.matches("^[\\u4e00-\\u9fa5]*,\\d*.\\d*,\\d*.\\d*,\\d*.\\d*$");
			if (!matches)
				return null;
			// string分析器
			String[] tokenizer = str.split(",");
			for (int i = 0; i < tokenizer.length; i++) {
				if (i == (tokenizer.length - 1) && tokenizer.length > 2) {
					jc.setType(tokenizer[0]);
					jc.setVictoryOdds(tokenizer[1]);
					jc.setDrawOdds(tokenizer[2]);
					jc.setDefeatOdds(tokenizer[3]);
				}
			}
			BigDecimal victoryOdds = new BigDecimal(jc.getVictoryOdds());
			addVictoryOdds = victoryOdds.add(common).toString();
			subtractVictoryOdds = victoryOdds.subtract(common).toString();

			BigDecimal drawOdds = new BigDecimal(jc.getDrawOdds());
			addDrawOdds = drawOdds.add(common).toString().toString();
			subtractDrawOdds = drawOdds.subtract(common).toString();

			BigDecimal defeatOdds = new BigDecimal(jc.getDefeatOdds());
			addDefeatOdds = defeatOdds.add(common).toString();
			subtractDefeatOdds = defeatOdds.subtract(common).toString();
			List<JCDataEntity> list = jCDataRepository.find(jc.getType(), addVictoryOdds, subtractVictoryOdds,
					addDrawOdds, subtractDrawOdds, addDefeatOdds, subtractDefeatOdds);
			List<JCDataEntity> list2 = jCDataRepository.find(jc.getVictoryOdds(), jc.getDrawOdds(), jc.getDefeatOdds());
			getVDD(list, false);
			getVDD(list2, true);
		}
		return null;
	}

	/**
	 * @param isResultOfAll @Title: getVDD @Description: TODO @param: @param
	 * list @return: void @throws
	 */
	private void getVDD(List<JCDataEntity> list, boolean isResultOfAll) {
		int victory = 0;
		int draw = 0;
		int defeat = 0;
		for (JCDataEntity jcd : list) {
			String score = jcd.getScore();
			if (score == null)
				continue;
			System.out.println(jcd.getType() + "-----" + jcd.getHomeField() + score + jcd.getVisitingField() + "\n"
					+ format(jcd.getType().length()) + " | 0胜平负赔" + jcd.getVictoryOdds() + "," + jcd.getDrawOdds() + ","
					+ jcd.getDefeatOdds() + "\n" + format(jcd.getType().length()) + " |" + jcd.getLetBallNum() + "胜平负赔"
					+ jcd.getLVictoryOdds() + "," + jcd.getLDrawOdds() + "," + jcd.getLDefeatOdds() + "\n"
					+ format(jcd.getType().length()) + " | 0比赛时间" + jcd.getGameTime());
			String home = score.substring(0, 1).toString();
			String visit = score.substring(2, score.length()).toString();
			if (Integer.valueOf(home).intValue() > Integer.valueOf(visit).intValue()) {
				victory = victory + 1;
			} else if (Integer.valueOf(home).intValue() < Integer.valueOf(visit).intValue()) {
				defeat = defeat + 1;
			} else {
				draw = draw + 1;
			}
		}
		if (isResultOfAll) {
			System.out.println("相同赔率下:胜" + victory + "场,平" + draw + "场,负" + defeat + "场");
			return;
		}
		System.out.println("相似赔率相同赛别下:胜" + victory + "场,平" + draw + "场,负" + defeat + "场");
	}

	private String format(int length) {
		StringBuilder placeholder = new StringBuilder("");
		for (int i = 0; i < length; i++) {
			placeholder.append(" ");
		}
		return placeholder.toString();
	}

}
