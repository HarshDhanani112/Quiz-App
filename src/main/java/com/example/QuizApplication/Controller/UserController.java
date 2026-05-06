package com.example.QuizApplication.Controller;

import com.example.QuizApplication.DTO.QuestionResponseDTO;
import com.example.QuizApplication.DTO.SubmitRequestDTO;
import com.example.QuizApplication.DTO.SubmitResponseDTO;
import com.example.QuizApplication.DTO.UserResponseDTO;
import com.example.QuizApplication.Model.User;
import com.example.QuizApplication.Service.UserService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("quiz")
public class UserController {
    @Autowired
    UserService service;

    @PostMapping("register")
    public UserResponseDTO register(@RequestBody User u){
        return service.register(u);
    }

    @GetMapping("getQuestion")
    public QuestionResponseDTO getQuestion(@PathParam("name")String name){
        return service.getQuestion(name);
    }

    @PostMapping("submitAnswer")
    public SubmitResponseDTO submitAnswer(@RequestBody SubmitRequestDTO dto){
        return service.submitUserAns(dto);
    }
}
