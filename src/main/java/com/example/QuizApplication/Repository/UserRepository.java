package com.example.QuizApplication.Repository;

import com.example.QuizApplication.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface UserRepository extends JpaRepository<User,String> {
    @Query(value = "SELECT name FROM user_details WHERE name=?1",nativeQuery = true)
    String checkUser(String name);

    @Query(value = "SELECT name FROM user_questions_record WHERE name=?1 AND q_id=?2",nativeQuery = true)
    String checkQuestion(String name,int que);

    @Query(value = "SELECT COUNT(name) FROM user_questions_record WHERE name=?1",nativeQuery = true)
    int attemptedQuestions(String name);

    @Modifying
    @Transactional
    @Query(value = "UPDATE user_details SET attempted=?2 WHERE name=?1",nativeQuery = true)
    void updateUserAttemptedQuestions(String name,int attempted);

    @Modifying
    @Transactional
    @Query(value = "UPDATE user_details SET score=score+1 WHERE name=?1",nativeQuery = true)
    void updateUserScore(String name);

    @Query(value = "SELECT score FROM user_details WHERE name=?1",nativeQuery = true)
    int getUserScore(String name);


}
