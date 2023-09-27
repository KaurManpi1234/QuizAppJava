package com.example.quizappjava;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity3 extends AppCompatActivity {
    TextView tvQuestion,tvScore,tvQuestionNo;
    RadioGroup radioGroup;
    RadioButton rb1,rb2,rb3,rb4;
    Button btnNext;
    int totalQuestions;
    int qCounter=0;
    ColorStateList dfRbColor;
    boolean answered;
    int score;
    private QuestionModel currentQuestion;

private List<QuestionModel> questionslist;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        questionslist = new ArrayList<>();
        tvQuestion = findViewById(R.id.tv_question);

        tvScore = findViewById(R.id.txt_play_score);
         btnNext=findViewById(R.id.nextQuestionBtn);
        tvQuestionNo = findViewById(R.id.tv_noOfQues);
         radioGroup = findViewById(R.id.radiogrp);
        rb1 = findViewById(R.id.radioButton1);
        rb2 = findViewById(R.id.radioButton2);
        rb3 = findViewById(R.id.radioButton3);
        rb4 = findViewById(R.id.radioButton4);

        dfRbColor = rb1.getTextColors();

addQuestions();
totalQuestions=questionslist.size();
showNextQuestion();
btnNext.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        if (answered == false) {
            if (rb1.isChecked() || rb2.isChecked() || rb3.isChecked() || rb4.isChecked()) {
                checkAnser();
            } else {
                Toast.makeText(MainActivity3.this, "Please select an option", Toast.LENGTH_SHORT).show();
            }
        } else {
            showNextQuestion();
        }

    }
});
    }

    private void checkAnser() {
        answered=true;
        RadioButton rbSelected=findViewById(radioGroup.getCheckedRadioButtonId());
        int answerNo=radioGroup.indexOfChild(rbSelected)+1;
        if(answerNo==currentQuestion.getCorrectAnsNo()){
            score++;
            tvScore.setText("Score:"+score);
        }
        rb1.setTextColor(Color.RED);
        rb2.setTextColor(Color.RED);
        rb3.setTextColor(Color.RED);
        rb4.setTextColor(Color.RED);
        switch (currentQuestion.getCorrectAnsNo()){
            case 1:
                rb1.setTextColor(Color.GREEN);
                break;
            case 2:
                rb2.setTextColor(Color.GREEN);
                break;
            case 3:
                rb3.setTextColor(Color.GREEN);
                break;

            case 4:
                rb4.setTextColor(Color.GREEN);
                break;


        }
        if(qCounter<totalQuestions){
            btnNext.setText("Next");
        }else{
            btnNext.setText("Finish");
        }

    }

    private void showNextQuestion() {
        radioGroup.clearCheck();
        rb1.setTextColor(dfRbColor);
        rb2.setTextColor(dfRbColor);
        rb3.setTextColor(dfRbColor);
        rb4.setTextColor(dfRbColor);


        if (qCounter<totalQuestions){
            currentQuestion=questionslist.get(qCounter);
            tvQuestion.setText(currentQuestion.getQuestion());
            rb1.setText(currentQuestion.getOption1());
            rb2.setText(currentQuestion.getOption2());

            rb3.setText(currentQuestion.getOption3());
            rb4.setText(currentQuestion.getOption4());
qCounter++;
btnNext.setText("Next");
tvQuestionNo.setText("Question:"+qCounter+"/"+totalQuestions);
answered=false;
        }else{
            finish();

        }
    }

    private void addQuestions() {
        questionslist.add(new QuestionModel(" Where is the “Gurudwara Ber Sahib” situated?" ,
                "Tarantaran " ,
                        "                 Nankana sahib" ,
                        "                 Sultanpur" ,
                        "                 Amritsar",3

        ));
        questionslist.add(new QuestionModel(" Que2:Who was the composer of the “Asa Di Vaar”?" ,
                " Guru Nanak" ,
                " Guru Angad" ,
                " Guru Ramdass" ,
                " Guru Arjan",1));

        questionslist.add(new QuestionModel("Que3:Which of the following Gurus composed the “Japuji Sahib”?" ,
            " Guru Ramdass" ,
            " Guru Angad" ,
            " Guru Nanak" ,
            " Guru Amardass",3));
        questionslist.add(new QuestionModel("Que4:Which had been the distinguished industry in Punjab during the 16th century?" ,
                " Agriculture",
                " Textile Industry" ,
                " Animal Husbandry" ,
                " None of these",2));
        questionslist.add(new QuestionModel("Que5:Which are the main two difficulties in writing of the Punjab history?" ,
                " Lack of reliable sources" ,
                " Religious fanaticism of the Muslim writers" ,
                " Indolence of the Punjabies" ,
                " Lack of reliable sources and religious fanaticism of the Muslim Writers",4));

        questionslist.add(new QuestionModel(" Que6:When was the first battle of Panipat fought?" , " In April 21, 1524 AD" , " In April 21, 1526 AD" , " In April 26, 1526 AD" , " In September 26, 1526 AD",2));
        questionslist.add(new QuestionModel("Que7:How many paise did Guru Angad Dev offer and paid obeisance to the successor?" , " Two paise" , " Three paise" , " Five paise" , " Ten paise",3));
        questionslist.add(new QuestionModel("Que8: Which place is that, where Guru Nanak Dev ji acquired the celestial knowledge?" , " Sultanpur lodhi" , " Muktsar" , " Amritsar" , " Nanaksar",1));

        questionslist.add(new QuestionModel(" Que9:Which languages is the ‘Jafarnama’ available in?" , " Persian and Hindi" , " Punjabi and Persian" , " Punjabi and English" , "All of these",2));
        questionslist.add(new QuestionModel(" Que10:What is called as the Punjabi script?" , " Persian" , " Punjabi" , " Gurmukhi" , " English",3));


        questionslist.add(new QuestionModel("Que11: How old was Guru Amardass during his accession to the Gurgaddi?" , "60 years" , " 80 years", " 45 years" , " 73 years",4));

        questionslist.add(new QuestionModel("Que12:Who composed the Ratnawali ?" , " Bhai Veer Singh" , " Meharban Ji" , " Bhai Mani Singh" , "Bhai Bala",3));
        questionslist.add(new QuestionModel("Que13:Who did introduce the coins of the Sikhs?" , " Maharaja Ranjit Singh" , " Banda Singh Bahadur" , " Ahmed Shah Abdali" , " None of these",2));
        questionslist.add(new QuestionModel("Que14: How many compositions have been included in the Dasam Granth?" , " 18" , "16" ,
                " 10" ,
                " 12",3));

        questionslist.add(new QuestionModel("Que15: When was Punjab merged into the British territory?" ,
            " In 1849 AD" ,
            " In 1876 AD" ,
            " In 1842 AD" ,
            "In 1843 AD",1));
        questionslist.add(new QuestionModel("Que16:Which of the ‘Sakhies’ is considered as to be the most reliable?" ,
                " Bhai Mani Singh’s Janam Sakhi" ,
                "Ancient Janam Sakhi" ,
                " Sakhi, by Meharban" ,
                " The Janam Sakhi by Bhai Bala",2));
        questionslist.add(new QuestionModel("Que17: When did Babur attack Punjab for the first time? " ,
                " In 1539" ,
                " In 1516" ,
                " In 1519" ,
                " In 1529"

                ,3));

        questionslist.add(new QuestionModel("Que18:How many times did Babur attack Punjab in all?" ,
                " Four times" ,
                " Six times" ,
                " Three times" ,
                " Five times",4));
        questionslist.add(new QuestionModel("Que19: Who had been the founder of the Bhakti movement?" ,
                " Guru Nanak Dev Ji" ,
                " Guru Arjan Dev Ji" ,
                " Guru Gobind Singh Ji" ,
                " Guru RamDas Ji",1));

        questionslist.add(new QuestionModel("Que20: Where did the Sajjan Thug use to live?" ,
                " Multan" ,
                " Rai Bhoyen" ,
                " Talumba village" ,
                " Lahore",3));

    }
}