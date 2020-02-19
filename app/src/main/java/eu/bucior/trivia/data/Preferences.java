package eu.bucior.trivia.data;

import android.content.Context;
import android.content.SharedPreferences;

import eu.bucior.trivia.controller.AppController;

public class Preferences {
    private static final String PREF_ID = "trivia_prefs";
    private static final String SCORE_KEY = "score";
    private static final String STATE_KEY = "state";
    private static final Context context = AppController.getInstance();
    private static final SharedPreferences sharedPreferences = context.getSharedPreferences(PREF_ID, context.MODE_PRIVATE);
    private static SharedPreferences.Editor editor;

    public static int getHighestScore() {
        int highestScore = sharedPreferences.getInt(SCORE_KEY, 0);
        return highestScore;
    }

    public static void updateHighestScore(int score) {
        editor = sharedPreferences.edit();
        editor.putInt(SCORE_KEY, score);
        editor.apply();
    }

    public static void setState(int index) {
        editor = sharedPreferences.edit();
        editor.putInt(STATE_KEY, index);
        editor.apply();
    }

    public static int getState() {
        int index = sharedPreferences.getInt(STATE_KEY, 0);
        return index;
    }


}
