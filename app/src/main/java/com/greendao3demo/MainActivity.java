package com.greendao3demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.hellod).setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        testDB();
                    }
                }
        );
        appDbhelper = new AppDbhelper(new DbOpenHelper(getApplicationContext(), "grean_liyao"));
        List<Question> questions = appDbhelper.getAllQuestion();
        for (Question question:questions){
            Log.d("Main_test",question.toString());

            List<Option> options =  question.getOptionList();
            for (Option option :options){
                Log.d("Main_test",option.toString());
            }
        }
    }

    static SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyyMMdd HH:mm:ss");

    AppDbhelper appDbhelper;

    public void testDB() {
        appDbhelper = new AppDbhelper(new DbOpenHelper(getApplicationContext(), "grean_liyao"));
        for (int i = 0; i < 10; i++) {
            Option option = new Option();
            option.setQuestionId((long) i);
            option.setCreatedAt(sDateFormat.format(new Date()));
            option.setOptionText("option " + i + " text " + i);
            appDbhelper.insertOption(option);

            Option option1 = new Option();
            option1.setQuestionId((long) i + 1);
            option1.setCreatedAt(sDateFormat.format(new Date()));
            option1.setOptionText("option 1l text " + i + 1);
            appDbhelper.insertOption(option1);

            Option option2 = new Option();
            option2.setQuestionId((long) i + 2);
            option2.setCreatedAt(sDateFormat.format(new Date()));
            option2.setOptionText("option 1l text " + i + 2);
            appDbhelper.insertOption(option2);

            Option option3 = new Option();
            option3.setQuestionId((long) i + 3);
            option3.setCreatedAt(sDateFormat.format(new Date()));
            option3.setOptionText("option 1l text " + i + 3);
            appDbhelper.insertOption(option3);
        }

        for (int i = 0; i < 10; i++) {
            Question question = new Question();
            question.setId((long) i);
            question.setQuestionText(" -------------question " + i);
            appDbhelper.insertQuest(question);
        }

        //
        List<Question> questions = appDbhelper.getAllQuestion();
        for (Question question:questions){
            Log.d("Main_test",question.toString());
        }

    }
}
