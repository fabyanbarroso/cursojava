package com.fbf.quizback.service;

import com.fbf.quizback.exception.QuestionNotFoundException;
import com.fbf.quizback.model.Answer;
import com.fbf.quizback.model.Question;

public interface QuestionService extends AbstractCRUDService<Question, Integer> {

	Question create(Question question, int dificultLevel, int tagQuestion);

	Answer createAnswer(int idQuestion, String textAnswer, boolean correctAnswer) throws QuestionNotFoundException;

	void deleteAnswerQuiz(Question question, int idAnswer) throws QuestionNotFoundException;

}
