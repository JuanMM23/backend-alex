package com.gameserviceapi.service.impl;

import com.gameserviceapi.commons.entity.Game;
import com.gameserviceapi.commons.exceptions.GameException;
import com.gameserviceapi.repository.GameRepository;
import com.gameserviceapi.service.IGameService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class GameService implements IGameService {

    private final GameRepository gameRepository;

    @Override
    public Game saveById(Game game) {
        return gameRepository.save(game);
    }

    @Override
    public Game getById(Long gameId) {
        return gameRepository.findById(gameId).orElseThrow(() -> new GameException(HttpStatus.NOT_FOUND, "Not found"));
    }
}
