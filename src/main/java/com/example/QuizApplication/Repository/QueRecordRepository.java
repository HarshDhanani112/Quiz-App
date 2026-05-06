package com.example.QuizApplication.Repository;

import com.example.QuizApplication.Model.UserQuestionsRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QueRecordRepository extends JpaRepository<UserQuestionsRecord,Integer> {
}
