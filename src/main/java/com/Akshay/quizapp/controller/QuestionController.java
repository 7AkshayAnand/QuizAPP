package com.Akshay.quizapp.controller;

import com.Akshay.quizapp.Question;
import com.Akshay.quizapp.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("question")
public class QuestionController {
    @Autowired
    QuestionService questionService;
    @GetMapping("allQuestion")
    public List<Question> getAllQuestion(){
        return questionService.getAllQuestions();
    }
    @GetMapping("category/{category}")
    public List<Question> getQuestionByCategory(@PathVariable String category){
        return questionService.getQuestionsByCategory(category);
    }
    @PostMapping("add")
    public String addQuestion(@RequestBody Question question){
      return questionService.addQuestion(question);

    }

    @GetMapping("search/{id}")
    public Optional<Question> searchById(@PathVariable Integer id){
        return questionService.getQuestionById(id);
    }

    @PostMapping("update")
    public String updateQuestion(@RequestBody Question question){
        return questionService.updateQuestion(question);
    }


    @DeleteMapping("/remove/{id}")
    public String removeQuestion(@PathVariable Integer id){
        System.out.println("i am here");
        return questionService.removeById(id);
    }

}
