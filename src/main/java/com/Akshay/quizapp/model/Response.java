package com.Akshay.quizapp.model;

import jakarta.persistence.Entity;
import lombok.*;

//@Entity
@Data
@ToString

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Response {
    private Integer id;
    private String response;
}
