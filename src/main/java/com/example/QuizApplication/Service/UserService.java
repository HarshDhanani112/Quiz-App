package com.example.QuizApplication.Service;

import com.example.QuizApplication.DTO.*;
import com.example.QuizApplication.Model.Question;
import com.example.QuizApplication.Model.User;
import com.example.QuizApplication.Model.UserQuestionsRecord;
import com.example.QuizApplication.Repository.QueRecordRepository;
import com.example.QuizApplication.Repository.QueRepository;
import com.example.QuizApplication.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class UserService {
    int queLimit = 5;

    @Autowired
    UserRepository userRepo;

    @Autowired
    QueRepository  queRepo;

    @Autowired
    QueRecordRepository queRecRepo;

    public UserResponseDTO register(User u){
        String name = userRepo.checkUser(u.getName());
        if(name == null){
            userRepo.save(u);
            UserResponseDTO res = new UserResponseDTO("Registered successfully...", HttpStatus.OK);
            return res;
        }
        else{
            UserResponseDTO res = new UserResponseDTO("User already exists...", HttpStatus.OK);
            return res;
        }
    }

    public QuestionResponseDTO getQuestion(String name){
        String user = userRepo.checkUser(name);

        if(user == null){
            QuestionResponseDTO res = new QuestionResponseDTO(null,HttpStatus.OK,"Invalid User");
            return res;
        }
        else{
            int attempted = userRepo.attemptedQuestions(name);
            if(attempted >= queLimit){
                int score = userRepo.getUserScore(name);
                //Show resulted total score
                QuestionResponseDTO res = new QuestionResponseDTO(null,HttpStatus.OK,"Your Final score is: "+score+"/"+queLimit);
                return res;
            }

            Random random = new Random();

            int rNo = random.nextInt(25)+1;
            String question = userRepo.checkQuestion(name,rNo);

            while(question != null){
                rNo = random.nextInt(25)+1;
                question = userRepo.checkQuestion(name,rNo);
            }
            queRecRepo.save(new UserQuestionsRecord(name,rNo));
            userRepo.updateUserAttemptedQuestions(name,attempted+1);

            Question q = queRepo.findById(rNo).orElse(null);

            QuestionDTO que = new QuestionDTO(q.getQ_id(),q.getQuestion(),q.getA(),q.getB(),q.getC(),q.getD());

            QuestionResponseDTO res = new QuestionResponseDTO(que,HttpStatus.OK,"Question fetched successfully...");
            return res;
        }

    }

    public SubmitResponseDTO submitUserAns(SubmitRequestDTO s){
        String checkQue = userRepo.checkQuestion(s.getUserName(),s.getQ_id());

        if(checkQue == null){
            return new SubmitResponseDTO("Invalid Question id... ",HttpStatus.OK);
        }

        Question que = queRepo.findById(s.getQ_id()).orElse(null);

        String correctAns = que.getCorrectOption();
        if(correctAns.equals(s.getAns())){
            userRepo.updateUserScore(s.getUserName());
            return new SubmitResponseDTO("Your answer is correct...",HttpStatus.OK);
        }
        return new SubmitResponseDTO("Correct Option:- "+correctAns,HttpStatus.OK);
    }
}
