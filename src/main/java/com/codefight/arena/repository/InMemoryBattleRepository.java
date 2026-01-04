package com.codefight.arena.repository;

import com.codefight.arena.model.Battle;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class InMemoryBattleRepository implements BattleRepository{

    private final ConcurrentHashMap<String, Battle> battleStorage = new ConcurrentHashMap<>();

    @Override
    public Battle save(Battle battle) {
        return null;
    }

    @Override
    public Optional<Battle> findById(String id) {
        return Optional.empty();
    }

    @Override
    public Battle update(Battle battle) {
        return null;
    }
}
