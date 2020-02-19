package eu.bucior.trivia.data;

import android.content.Context;
import android.content.SharedPreferences;

import eu.bucior.trivia.controller.AppController;

public class Preferences {
    private static final String PREF_ID = "trivia_prefs";
    private static final String SCORE_KEY = "score";
    private static final Context context = AppController.getInstance();

    public static int getHighestScore() {
        SharedPreferences getSharedPrefs = context.getSharedPreferences(PREF_ID, context.MODE_PRIVATE);
        int highestScore = getSharedPrefs.getInt(SCORE_KEY, 0);
        return highestScore;
    }

    public static void updateHighestScore(int score) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREF_ID, context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(SCORE_KEY, score);
        editor.apply();
    }
}
