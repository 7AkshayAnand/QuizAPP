package com.Akshay.quizapp.service;

import com.Akshay.quizapp.Question;
import com.Akshay.quizapp.dao.QuestionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {
    @Autowired
    QuestionDao questionDao;
    public List<Question> getAllQuestions() {
        List<Question> list=questionDao.findAll();
        System.out.println("value from list is  "+list.get(0)+" full list is "+list);
        for(Question q :list){
            System.out.println(q);
        }
        return  list;
    }

    public List<Question> getQuestionsByCategory(String category) {

       return questionDao.findByCategory(category);
    }
}
