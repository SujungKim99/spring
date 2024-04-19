package dw.gameshop.service;

import dw.gameshop.expection.ResourceNotFoundException;
import dw.gameshop.model.Game;
import dw.gameshop.model.User;
import dw.gameshop.resposition.GameshopRespository;
import dw.gameshop.resposition.UserRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class GameshopService {

    GameshopRespository gameshopRespositoty;
    //유저파트
    UserRespository userRespository;

    public GameshopService(GameshopRespository gameshopRespositoty, UserRespository userRespository) {
        this.gameshopRespositoty = gameshopRespositoty;
        this.userRespository = userRespository;
    }

    public Game saveGame(Game game) {
        gameshopRespositoty.save(game);
        return game;
    }

    public List<Game> getAllGames() {
        return gameshopRespositoty.findAll();
    }

    public Game getGameById(@PathVariable long id) {
        Optional<Game> game = gameshopRespositoty.findById(id);
        if (game.isEmpty()) {
            throw new ResourceNotFoundException("Gameshop","ID",id);
        } else {
            return game.get();
        }
    }

    public Game updateGamesById(@PathVariable long id, Game game){
        Optional<Game> game1 = gameshopRespositoty.findById(id);
        if(game1.isPresent()){
            game1.get().setTitle(game.getTitle());
            game1.get().setGenre(game.getGenre());
            game1.get().setPrice(game.getPrice());
            game1.get().setText(game.getText());

            gameshopRespositoty.save(game1.get());
            return game1.get();
        }else {
            throw new ResourceNotFoundException("Gameshop","ID",id);
        }
    }
    public User saveUser(User user){
        return  userRespository.save(user);
    }
}