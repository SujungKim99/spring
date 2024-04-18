package dw.gameshop.controller;

import dw.gameshop.model.Game;
import dw.gameshop.service.GameshopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GameShopController {
    GameshopService gameshopService;
    @Autowired
    public GameShopController(GameshopService gameshopService) {
        this.gameshopService = gameshopService;
    }
    @PostMapping("aip/gameshop")
    public Game saveGam(@RequestBody Game game){
        return gameshopService.saveGame(game);
    }
    @GetMapping("aip/gameshop")
    public List<Game> getAllGames() {
        return gameshopService.getAllGames();
    }
    @GetMapping("aip/gameshop/{id}")
    public Game getGameById(@PathVariable long id) {
        return gameshopService.getGameById(id);
    }
    @PutMapping("aip/gameshop/{id}")
    public Game updateGamesById(@PathVariable long id, @RequestBody Game game){
        return gameshopService.updateGamesById(id,game);
    }

}
