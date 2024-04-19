package dw.gameshop.service;

import dw.gameshop.expection.ResourceNotFoundException;
import dw.gameshop.model.Purchase;
import dw.gameshop.model.User;
import dw.gameshop.resposition.PurchaesRepository;
import dw.gameshop.resposition.UserRespository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PurchaseService {

    @Autowired
    PurchaesRepository purchaesRepository;
    @Autowired
    UserRespository userRespository;
    public Purchase savePurchase(Purchase purchase){
        purchaesRepository.save(purchase);
        return purchase;
    }
    public List<Purchase> getAllPurchase() {
        return purchaesRepository.findAll();
    }
    public List<Purchase> getPurchaseListByUser(String userId) {
        // 유저아이디로 유저객체 찾기
        Optional<User> userOptional = userRespository.findByUserId(userId);  //구글링 : Jpa 메서드규칙
        if (userOptional.isEmpty()) {
            throw new ResourceNotFoundException("User", "ID", userId);
        }
        return purchaesRepository.findByUser(userOptional.get());
    }
}
