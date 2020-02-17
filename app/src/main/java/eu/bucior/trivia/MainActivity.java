package eu.bucior.trivia;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import eu.bucior.trivia.data.QuestionBank;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new QuestionBank().getQuestions();
    }
}
