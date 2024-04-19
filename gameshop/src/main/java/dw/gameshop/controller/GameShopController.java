package dw.gameshop.controller;

import dw.gameshop.model.Game;
import dw.gameshop.model.User;
import dw.gameshop.service.GameshopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GameShopController {
    GameshopService gameshopService;
    @Autowired
    public GameShopController(GameshopService gameshopService) {
        this.gameshopService = gameshopService;
    }
    @PostMapping("products")
    public ResponseEntity<Game> saveGame(@RequestBody Game game){
        return new ResponseEntity<>(gameshopService.saveGame(game), HttpStatus.OK) ;
    }
    @GetMapping("products")
    public ResponseEntity<List<Game>> getAllGames() {
        return new ResponseEntity<>(gameshopService.getAllGames(),HttpStatus.OK);
    }
    @GetMapping("products/{id}")
    public ResponseEntity<Game> getGameById(@PathVariable long id) {
        return new ResponseEntity<>(gameshopService.getGameById(id),HttpStatus.OK);
    }
    @PutMapping("productsp/{id}")
    public ResponseEntity<Game> updateGamesById(@PathVariable long id, @RequestBody Game game){
        return new ResponseEntity<>(gameshopService.updateGamesById(id,game), HttpStatus.OK);
    }

    //유저 파트
    @PostMapping("product/user")
    public ResponseEntity<User> saveUSer(@RequestBody User user){
        return new ResponseEntity<>(gameshopService.saveUser(user), HttpStatus.OK);
    }


}
