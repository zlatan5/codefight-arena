package com.codefight.arena.repository;

import com.codefight.arena.model.Problem;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadLocalRandom;

@Repository
public class InMemoryProblemRepository implements ProblemRepository{

    private final ConcurrentHashMap<String, Problem> problemStore = new ConcurrentHashMap<>();


    @Override
    public Optional<Problem> findById(String id) {

        if(id == null || id.isBlank()) {
            return Optional.empty();
        }
        //ConcurrentHashmap.get is thread safe.
        return Optional.ofNullable(problemStore.get(id));
    }

    @Override
    public Optional<Problem> getRandomProblem() {

        if(problemStore.isEmpty()) {
            return Optional.empty();
        }
        List<String> keys = new ArrayList<>(problemStore.keySet());
        int randomIndex = ThreadLocalRandom.current().nextInt(keys.size());
        String randomKey = keys.get(randomIndex);

        return Optional.ofNullable(problemStore.get(randomKey));
    }

    @Override
    public List<Problem> findAll() {
        return new ArrayList<>(problemStore.values());
    }

    @Override
    public Problem save(Problem problem) {
        return null;
    }

    @Override
    public boolean existsById(String id) {
        return false;
    }
}
