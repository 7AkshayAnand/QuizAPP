package com.Akshay.quizapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Data
@ToString

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class QuestionWrapper {
    @Id
    private Integer id;
    private String questionTitle;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
}

//we have created this class for returning questions for quiz and for that we have to eliminate the rightanswer and difficulty level before sending to the client