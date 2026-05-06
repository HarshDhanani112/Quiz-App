package com.example.QuizApplication.Controller;

import com.example.QuizApplication.Model.Question;
import com.example.QuizApplication.Service.QueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("quiz")
public class QueController {
    @Autowired
    QueService queService;

    @PostMapping("insertQue")
    public String insertQue(@RequestBody List<Question> q){
        queService.insertQue(q);
        return "Questions added successfully...";
    }
}
