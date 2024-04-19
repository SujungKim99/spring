package dw.gameshop.resposition;

import dw.gameshop.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.beans.JavaBean;
import java.util.Optional;

public interface UserRespository extends JpaRepository<User, String> {
    Optional<User> findByUserId(String userId);
}
