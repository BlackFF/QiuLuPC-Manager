package com.howin.qiulu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.howin.qiulu.dao.EvaluationDao;
import com.howin.qiulu.page.Page;
import com.howin.qiulu.pojo.Evaluation;
import com.howin.qiulu.result.QiuluResult;
import com.howin.qiulu.service.EvaluationService;
/**
 * 
* @Title: EvaluationServiceImpl
* @Description: 
* @author 吴磊
* @date 2017年3月23日上午11:05:18
 */
@Service
public class EvaluationServiceImpl implements EvaluationService {

	@Autowired
	private EvaluationDao evaluationDao;
	/**
	 * 
	 * @author 吴磊
	 * @date 2017年3月23日上午11:05:12
	 * @description 
	 * @param begin
	 * @return
	 */
	@Override
	public QiuluResult getAllEvaluation(int begin) {
		QiuluResult result = new QiuluResult();
		Page page = new Page();
		int count = evaluationDao.getCount();
		page.setTotalCount(count);
		page.setBeginPage(begin);
		page.init();
		List<Evaluation> list = evaluationDao.getAllEvaluation((page.getBeginPage() - 1) * page.getEveryPage(), page.getEveryPage());
		page.setList(list);
		result.setObject(page);
		result.setStatus(true);
		return result;
	}

}
