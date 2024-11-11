package com.gameserviceapi.controller;

import com.gameserviceapi.commons.constants.ApiPathsVariables;
import com.gameserviceapi.commons.entity.Game;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping(ApiPathsVariables.V1_ROUTE + ApiPathsVariables.GAMES_ROUTE)
public interface GameApi {

    @PostMapping
    ResponseEntity<Game> save(@RequestBody Game game);

    @GetMapping("/{id}")
    ResponseEntity<Game> getById(@PathVariable("id") Long id);
}
