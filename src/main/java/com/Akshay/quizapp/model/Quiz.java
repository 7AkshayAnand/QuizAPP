package com.Akshay.quizapp.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@ToString

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private  String title;
    @ManyToMany
    private List<Question> questions;
}
