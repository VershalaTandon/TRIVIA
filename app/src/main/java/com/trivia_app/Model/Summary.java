package com.trivia_app.Model;

public class Summary {
    String name, date, question1, q1_option1, q1_option2, q1_option3, q1_option4, answer1,
            question2, q2_option1, q2_option2, q2_option3, q2_option4, answer2;

    public Summary(String name, String date, String question1, String q1_option1, String q1_option2, String q1_option3, String q1_option4,
                   String answer1, String question2, String q2_option1, String q2_option2, String q2_option3, String q2_option4, String answer2) {
        this.name = name;
        this.date = date;
        this.question1 = question1;
        this.q1_option1 = q1_option1;
        this.q1_option2 = q1_option2;
        this.q1_option3 = q1_option3;
        this.q1_option4 = q1_option4;
        this.answer1 = answer1;
        this.question2 = question2;
        this.q2_option1 = q2_option1;
        this.q2_option2 = q2_option2;
        this.q2_option3 = q2_option3;
        this.q2_option4 = q2_option4;
        this.answer2 = answer2;
    }

    public String getName() {
        return name;
    }

    public String getDate() {
        return date;
    }

    public String getQuestion1() {
        return question1;
    }

    public String getQ1_option1() {
        return q1_option1;
    }

    public String getQ1_option2() {
        return q1_option2;
    }

    public String getQ1_option3() {
        return q1_option3;
    }

    public String getQ1_option4() {
        return q1_option4;
    }

    public String getAnswer1() {
        return answer1;
    }

    public String getQuestion2() {
        return question2;
    }

    public String getQ2_option1() {
        return q2_option1;
    }

    public String getQ2_option2() {
        return q2_option2;
    }

    public String getQ2_option3() {
        return q2_option3;
    }

    public String getQ2_option4() {
        return q2_option4;
    }

    public String getAnswer2() {
        return answer2;
    }
}
