package com.example.QuizApplication.Service;

import com.example.QuizApplication.Model.Question;
import com.example.QuizApplication.Repository.QueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QueService {

    @Autowired
    QueRepository repo;

    public void insertQue(List<Question> q){
        repo.saveAll(q);
    }
}
