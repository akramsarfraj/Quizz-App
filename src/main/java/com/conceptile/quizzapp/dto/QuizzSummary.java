package com.conceptile.quizzapp.dto;

import java.util.List;
import java.util.Map;

public class QuizzSummary {
    private String user_name;
    private long totalQuestion;
    private long total_attempt;

    private long total_correct;

    private long total_incorrect;

    private List<Detail> detail;

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public long getTotalQuestion() {
        return totalQuestion;
    }

    public void setTotalQuestion(long totalQuestion) {
        this.totalQuestion = totalQuestion;
    }

    public long getTotal_attempt() {
        return total_attempt;
    }

    public void setTotal_attempt(long total_attempt) {
        this.total_attempt = total_attempt;
    }

    public long getTotal_correct() {
        return total_correct;
    }

    public void setTotal_correct(long total_correct) {
        this.total_correct = total_correct;
    }

    public long getTotal_incorrect() {
        return total_incorrect;
    }

    public void setTotal_incorrect(long total_incorrect) {
        this.total_incorrect = total_incorrect;
    }

    public List<Detail> getDetail() {
        return detail;
    }

    public void setDetail(List<Detail> detail) {
        this.detail = detail;
    }
}
