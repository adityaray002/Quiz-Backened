package com.telusko.quizapp.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;

import com.telusko.quizapp.Model.Question;
import com.telusko.quizapp.dao.QuestionDao;
import java.util.ArrayList;

@Service
public class QuestionService {
    @Autowired
    QuestionDao questionDao;

    public ResponseEntity<List<Question>> getAllQuestions(){
        try{
             return new ResponseEntity<>(questionDao.findAll(), HttpStatus.OK);
        }catch(Exception e){
            e.printStackTrace();
        }
         return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST); 
           
    }

    public ResponseEntity<List<Question>> getQuestionByCategory(String category){
        try{
            return new ResponseEntity<>(questionDao.findByCategory(category),HttpStatus.OK);
        }catch(Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(questionDao.findByCategory(category),HttpStatus.BAD_REQUEST);
        
    }

    public ResponseEntity<String> addQuestion(Question question){
        questionDao.save(question);
        return new ResponseEntity<String>("success", HttpStatus.CREATED);
    }
}
