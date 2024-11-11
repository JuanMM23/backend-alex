package com.gameserviceapi.service;

import com.gameserviceapi.commons.entity.Game;

public interface IGameService {
    Game saveById(Game game);
    Game getById(Long id);
    void deleteById(Long id);

    Game update(Long id, Game game);
}
