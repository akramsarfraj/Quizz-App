package com.conceptile.quizzapp.util;

import com.conceptile.quizzapp.model.Question;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


public class QuestionUtil {
    public static List<Question> questionList(){
        Question q1 = new Question();
        q1.setQuestion("Which component of Java is responsible for running the compiled Java bytecode?");
        q1.setOption1("JDK");
        q1.setOption2("JRE");
        q1.setOption3("JVM");
        q1.setOption4("JIT");
        q1.setAnswer("JVM");

        Question q2 = new Question();
        q2.setQuestion("The capital of France, known for the Eiffel Tower and Louvre Museum, is ?");
        q2.setOption1("Paris");
        q2.setOption2("Rome");
        q2.setOption3("Berlin");
        q2.setOption4("Madrid");
        q2.setAnswer("Paris");

        Question q3 = new Question();
        q3.setQuestion("What does SQL stand for?");
        q3.setOption1("Structured Query Language");
        q3.setOption2("Simple Query Language");
        q3.setOption3("Standard Query Language");
        q3.setOption4("Sequential Query Language");
        q3.setAnswer("Structured Query Language");

        Question q4 = new Question();
        q4.setQuestion("Which of the following is NOT a valid keyword in SQL?");
        q4.setOption1("SELECT");
        q4.setOption2("DELETE");
        q4.setOption3("WHERE");
        q4.setOption4("INCLUDE");
        q4.setAnswer("INCLUDE");


        List<Question> questions = new ArrayList<>();
        questions.add(q1);
        questions.add(q2);
        questions.add(q3);
        questions.add(q4);


        return questions;

    }
}
