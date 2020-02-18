package eu.bucior.trivia.data;

import java.util.ArrayList;

import eu.bucior.trivia.model.Question;

public interface AnswerListAsyncResponse {
    void processFinished(ArrayList<Question> questionArrayList);
}
