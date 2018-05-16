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
    private CharSequence errorMessage = "";
    private CharSequence correctAnswers = "";

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
        if(!(((CheckBox)findViewById(R.id.one_a)).isChecked() == false
                && ((CheckBox)findViewById(R.id.one_d)).isChecked() == false
                && ((CheckBox)findViewById(R.id.one_b)).isChecked() == true
                && ((CheckBox)findViewById(R.id.one_c)).isChecked() == true)) {
            errorMessage = errorMessage + getString(R.string.invalid_answer)+" 1\n";
        }
        correctAnswers = correctAnswers + getString(R.string.question_string)+" 1: "+getString(R.string.answer_string)+" b, c\n";

        if(!(((EditText)findViewById(R.id.two_ans)).getText().toString().equals(ans2))) {
            errorMessage = errorMessage + getString(R.string.invalid_answer)+" 2\n";
        }
        correctAnswers = correctAnswers + getString(R.string.question_string)+" 2: "+getString(R.string.answer_string)+" "+ans2+"\n";

        if((((RadioGroup) findViewById(R.id.three_radio_grp)).getCheckedRadioButtonId())
                != ((RadioButton)findViewById(R.id.three_d)).getId()) {
            errorMessage = errorMessage + getString(R.string.invalid_answer)+" 3\n";
        }
        correctAnswers = correctAnswers + getString(R.string.question_string)+" 3: "+getString(R.string.answer_string)+" d\n";

        if((((RadioGroup) findViewById(R.id.four_radio_grp)).getCheckedRadioButtonId())
                != ((RadioButton)findViewById(R.id.four_c)).getId()) {
            errorMessage = errorMessage + getString(R.string.invalid_answer)+" 4\n";
        }
        correctAnswers = correctAnswers + getString(R.string.question_string)+" 4: "+getString(R.string.answer_string)+" c\n";

        if((((RadioGroup) findViewById(R.id.five_radio_grp)).getCheckedRadioButtonId())
                != ((RadioButton)findViewById(R.id.five_b)).getId()) {
            errorMessage = errorMessage + getString(R.string.invalid_answer)+" 5\n";
        }
        correctAnswers = correctAnswers + getString(R.string.question_string)+" 5: "+getString(R.string.answer_string)+" b\n";

        if(!(((EditText)findViewById(R.id.six_ans)).getText().toString().equals(ans6))) {
            errorMessage = errorMessage + getString(R.string.invalid_answer)+" 6\n";
        }
        correctAnswers = correctAnswers + getString(R.string.question_string)+" 6: "+getString(R.string.answer_string)+" "+ans6+"\n";
    }

    private void populateMessage(CharSequence message, int duration)    {
        Context context = getApplicationContext();
        Toast toast = Toast.makeText(context, message, duration);
        toast.show();
    }

    private void displayMessage(String m) {
        int duration = Toast.LENGTH_SHORT;
        CharSequence message;
        if(m == "") {
            if (errorMessage == "") {
                message = (CharSequence) getString(R.string.success_message);
                populateMessage(message, 1);
                refreshApplication();
            } else {
                populateMessage(errorMessage, 2);
                populateMessage(correctAnswers, 1);
            }
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
        errorMessage = "";
        correctAnswers = getString(R.string.correct_ans_string)+"\n";
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
