package com.Akshay.quizapp.service;

import com.Akshay.quizapp.Question;
import com.Akshay.quizapp.dao.QuestionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

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

    public String addQuestion(Question question) {
        questionDao.save(question);
        return "Successfully created";
    }

    public String removeById(Integer id) {
        System.out.println("deletion starts ");
        questionDao.deleteById(id);
        return "successfully deleted";
    }


    public String updateQuestion(Question updatedQuestion) {
        Optional<Question> existingQuestionOpt = questionDao.findById(updatedQuestion.getId());

        if (existingQuestionOpt.isPresent()) {
//            System.out.println("yes i am present");
            Question existingQuestion = existingQuestionOpt.get();

            existingQuestion.setQuestionTitle(updatedQuestion.getQuestionTitle());
            existingQuestion.setOption1(updatedQuestion.getOption1());
            existingQuestion.setOption2(updatedQuestion.getOption2());
            existingQuestion.setOption3(updatedQuestion.getOption3());
            existingQuestion.setOption4(updatedQuestion.getOption4());
            existingQuestion.setRightAnswer(updatedQuestion.getRightAnswer());
            existingQuestion.setDiffcultylevel(updatedQuestion.getDiffcultylevel());
            existingQuestion.setCategory(updatedQuestion.getCategory());

             questionDao.save(existingQuestion);
             return "updaed successfully";
        } else {
            throw new RuntimeException("Question not found with id: " + updatedQuestion.getId());
        }
    }
}
