package com.revature.quizgame;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Question {
    private String content;
    private String answer;

    public Question() {
    }

    public Question(String content, String answer) {
        this.content = content;
        this.answer = answer;
    }

    public void GenerateQuestions(){

    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Question question = (Question) o;
        return Objects.equals(content, question.content) &&
                Objects.equals(answer, question.answer);
    }

    @Override
    public int hashCode() {

        return Objects.hash(content, answer);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Question{");
        sb.append("content='").append(content).append('\'');
        sb.append(", answer='").append(answer).append('\'');
        sb.append('}');
        return sb.toString();
    }
    public String sList(){
        List<String> qList = new ArrayList<>();
        return " ";
    }
}
