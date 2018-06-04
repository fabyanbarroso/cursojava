package com.fbf.quizback.service;

import java.util.List;

import com.fbf.quizback.model.Answer;
import com.fbf.quizback.model.Question;

public interface AnswerService extends AbstractCRUDService<Answer, Integer>{

	Answer create(Question question, String textAnswer, boolean correctAnswer);


	List<Answer> findAllByQuestion(Question question);

}
