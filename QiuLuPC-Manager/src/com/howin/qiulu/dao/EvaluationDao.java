package com.howin.qiulu.dao;

import java.util.List;

import com.howin.qiulu.pojo.Evaluation;
/**
 * 
* @Title: EvaluationDao
* @Description: 
* @author 吴磊
* @date 2017年3月23日上午11:05:32
 */
public interface EvaluationDao {

	List<Evaluation> getAllEvaluation(int begin, int every);
	
	int getCount();
	
}
