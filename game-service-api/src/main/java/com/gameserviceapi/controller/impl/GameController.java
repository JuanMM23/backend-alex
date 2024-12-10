package com.gameserviceapi.controller.impl;

import com.gameserviceapi.controller.GameApi;
import com.gameserviceapi.commons.entity.Game;
import com.gameserviceapi.service.IGameService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class GameController implements GameApi {

    private final IGameService gameService;

    @Override
    public ResponseEntity<Game> save(@RequestBody Game game, @RequestHeader(name = "userIdRequest") String userId) {
        System.out.println(userId);
        return new ResponseEntity<>(gameService.saveById(game, userId), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Game> getById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(gameService.getById(id), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Game> update(Long id, Game game) {
        return new ResponseEntity<>(gameService.update(id, game), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> deleteById(Long id) {
        gameService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
