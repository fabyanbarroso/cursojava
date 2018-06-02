package com.fbf.quizback.service;

import java.util.Set;

import com.fbf.quizback.exception.QuestionNotFoundException;
import com.fbf.quizback.model.Question;

public interface QuestionService extends AbstractCRUDService<Question, Integer> {

	Question create(Question question, int dificultLevel, int tagQuestion);
	Set<Question> questionQuiz(int idQuiz) throws QuestionNotFoundException;

}
