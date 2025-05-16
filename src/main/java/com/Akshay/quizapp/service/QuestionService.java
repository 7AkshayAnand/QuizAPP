package com.Akshay.quizapp.service;

import com.Akshay.quizapp.Question;
import com.Akshay.quizapp.dao.QuestionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {
    @Autowired
    QuestionDao questionDao;
    public ResponseEntity<List<Question>> getAllQuestions() {
       try{
           return  new ResponseEntity<>(questionDao.findAll(), HttpStatus.OK);
       }catch(Exception e){
           e.printStackTrace();
       }

        return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);

    }

    public  ResponseEntity<List<Question>> getQuestionsByCategory(String category) {
      try{
          return new ResponseEntity<>(questionDao.findByCategory(category),HttpStatus.OK);
      }catch(Exception e){
          e.printStackTrace();
      }
        return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<String> addQuestion(Question question) {
       try{
           questionDao.save(question);
           return new ResponseEntity<>("Successfully created",HttpStatus.CREATED);
       }catch(Exception e){
           e.printStackTrace();
       }
        return new ResponseEntity<>("NOT Created",HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public ResponseEntity<String> removeById(Integer id) {
        System.out.println("deletion starts ");
        try{
            questionDao.deleteById(id);
            return new ResponseEntity<>("successfully deleted",HttpStatus.OK);
        }catch(Exception e)
        {
            e.printStackTrace();
        }
       return new ResponseEntity<>("Cannot Delete",HttpStatus.BAD_REQUEST);
    }


    public ResponseEntity<String> updateQuestion(Question updatedQuestion) {
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
             return new ResponseEntity<>("updaed successfully",HttpStatus.CREATED);
        } else {
            throw new RuntimeException("Question not found with id: " + updatedQuestion.getId());
        }
    }

    public ResponseEntity<Optional<Question>> getQuestionById(Integer id) {
        try{
            return new ResponseEntity<>(questionDao.findById(id),HttpStatus.FOUND);
        }catch(Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(Optional.empty(),HttpStatus.NOT_FOUND);
    }
}
