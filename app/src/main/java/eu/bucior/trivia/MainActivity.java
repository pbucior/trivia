package eu.bucior.trivia;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import eu.bucior.trivia.data.AnswerListAsyncResponse;
import eu.bucior.trivia.data.QuestionBank;
import eu.bucior.trivia.model.Question;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView questionTextView, questionCounterTextView;
    private Button trueButton, falseButton;
    private ImageButton prevButton, nextButton;
    private int currentQuestionIndex = 0;
    private List<Question> questionList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        questionTextView = findViewById(R.id.question_text);
        questionCounterTextView = findViewById(R.id.counter_text);

        trueButton = findViewById(R.id.true_button);
        falseButton = findViewById(R.id.false_button);
        prevButton = findViewById(R.id.prev_button);
        nextButton = findViewById(R.id.next_button);

        trueButton.setOnClickListener(this);
        falseButton.setOnClickListener(this);
        prevButton.setOnClickListener(this);
        nextButton.setOnClickListener(this);

        questionList = new QuestionBank().getQuestions(new AnswerListAsyncResponse() {
            @Override
            public void processFinished(ArrayList<Question> questionArrayList) {
                questionTextView.setText(questionArrayList.get(currentQuestionIndex).getAnswer());
                questionCounterTextView.setText(currentQuestionIndex + "/" + questionList.size());
            }
        });

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.true_button:
                break;
            case R.id.false_button:
                break;
            case R.id.prev_button:
                if (currentQuestionIndex > 0) {
                    currentQuestionIndex = (currentQuestionIndex - 1) % questionList.size();
                    updateQuestion();
                }
                break;
            case R.id.next_button:
                currentQuestionIndex = (currentQuestionIndex + 1) % questionList.size();
                updateQuestion();
                break;
        }
    }

    private void updateQuestion() {
        String question = questionList.get(currentQuestionIndex).getAnswer();
        questionTextView.setText(question);
        questionCounterTextView.setText(currentQuestionIndex + "/" + questionList.size());
    }
}
