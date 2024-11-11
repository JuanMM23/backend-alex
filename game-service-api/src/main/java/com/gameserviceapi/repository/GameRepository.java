package com.gameserviceapi.repository;

import com.gameserviceapi.commons.entity.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {
}
