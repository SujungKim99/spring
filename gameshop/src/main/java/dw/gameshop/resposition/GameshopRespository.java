package dw.gameshop.resposition;

import dw.gameshop.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameshopRespository extends JpaRepository<Game, Long> {
}
