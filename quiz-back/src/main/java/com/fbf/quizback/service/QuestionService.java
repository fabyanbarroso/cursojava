package com.fbf.quizback.service;

import com.fbf.quizback.model.Question;

public interface QuestionService extends AbstractCRUDService<Question, Integer> {

	Question create(Question question, int dificultLevel, int tagQuestion);

}
