package com.example.android.quiz;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private int quizScore = 0;
    private static final int TOTAL_SCORE = 6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Set icons on action bar
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.logo);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        //Set layout
        setContentView(R.layout.activity_main);
    }

    private void validateAnswers(View view){
        String ans2 = getString(R.string.q_2_ans);
        String ans6 = getString(R.string.q_6_ans);
        if((!((CheckBox)findViewById(R.id.one_a)).isChecked()
                && !((CheckBox)findViewById(R.id.one_d)).isChecked()
                && ((CheckBox)findViewById(R.id.one_b)).isChecked()
                && ((CheckBox)findViewById(R.id.one_c)).isChecked())) {
            quizScore++;
        }

        if((((EditText)findViewById(R.id.two_ans)).getText().toString().equals(ans2))) {
            quizScore++;
        }

        if((((RadioGroup) findViewById(R.id.three_radio_grp)).getCheckedRadioButtonId())
                == ((RadioButton)findViewById(R.id.three_d)).getId()) {
            quizScore++;
        }

        if((((RadioGroup) findViewById(R.id.four_radio_grp)).getCheckedRadioButtonId())
                == ((RadioButton)findViewById(R.id.four_c)).getId()) {
            quizScore++;
        }

        if((((RadioGroup) findViewById(R.id.five_radio_grp)).getCheckedRadioButtonId())
                == ((RadioButton)findViewById(R.id.five_b)).getId()) {
            quizScore++;
        }

        if((((EditText)findViewById(R.id.six_ans)).getText().toString().equals(ans6))) {
            quizScore++;
        }
    }

    private void populateMessage(CharSequence message, int duration)    {
        Context context = getApplicationContext();
        Toast toast = Toast.makeText(context, message, duration);
        toast.show();
    }

    private void displayMessage(String m) {
        int duration = Toast.LENGTH_SHORT;
        CharSequence message;
        if(m.equals("")) {
            message = getString(R.string.score_string, quizScore, TOTAL_SCORE);
            populateMessage(message, 1);
        } else {
            message = (CharSequence) m;
            populateMessage(message, 1);
        }
    }

    private void refreshApplication(){
        finish();
        startActivity(getIntent());
    }

    private void resetVariables(){
        quizScore = 0;
    }

    public void takeQuiz(View view){
        resetVariables();
        validateAnswers(view);
        displayMessage("");
    }

    public void resetQuiz(View view){
        displayMessage(getString(R.string.quiz_resetting_message));
        refreshApplication();
        displayMessage(getString(R.string.quiz_reset_message));
    }
}
