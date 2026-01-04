package com.codefight.arena.repository;

import com.codefight.arena.model.Battle;

import java.util.Optional;

public interface BattleRepository {

    Battle save(Battle battle);
    Optional<Battle> findById(String id);
    Battle update(Battle battle);

}
