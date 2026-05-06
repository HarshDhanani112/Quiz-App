package com.example.QuizApplication.Repository;

import com.example.QuizApplication.Model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QueRepository extends JpaRepository<Question,Integer> {
}
