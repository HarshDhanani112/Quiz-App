package com.example.QuizApplication.DTO;

import org.springframework.http.HttpStatus;

public class QuestionResponseDTO {
    private QuestionDTO que;
    private HttpStatus status;
    private String msg;

    public QuestionResponseDTO(QuestionDTO que, HttpStatus status, String msg) {
        this.que = que;
        this.status = status;
        this.msg = msg;
    }

    public QuestionDTO getQue() {
        return que;
    }

    public void setQue(QuestionDTO que) {
        this.que = que;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
