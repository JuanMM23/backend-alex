package com.gameserviceapi.controller.impl;

import com.gameserviceapi.controller.GameApi;
import com.gameserviceapi.commons.entity.Game;
import com.gameserviceapi.service.IGameService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class GameController implements GameApi {

    private final IGameService gameService;

    @Override
    public ResponseEntity<Game> save(@RequestBody Game game) {
        return ResponseEntity.ok(gameService.saveById(game));
    }

    @Override
    public ResponseEntity<Game> getById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(gameService.getById(id));
    }
}
