package com.codefight.arena.repository;

import com.codefight.arena.model.Problem;

import java.util.List;
import java.util.Optional;

public interface ProblemRepository {

    Optional<Problem> findById(String id);
    Optional<Problem> getRandomProblem();

    List<Problem> findAll();

    Problem save(Problem problem);

    boolean existsById(String id);
}
