package dw.wholesale_company.service;

import dw.wholesale_company.model.Order;
import dw.wholesale_company.model.OrderDetail;
import dw.wholesale_company.repository.OrderDetailRepository;
import dw.wholesale_company.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderService {
    @Autowired
    OrderRepository orderRepository;

    public List<Order> getAllOrder(){
        return orderRepository.findAll();
    }

    public List<Order> getOverDate() {
        List <Order> orders = orderRepository.findAll();
        for (int i = 0; i < orders.size(); i++) {
            if (Oe)


        }
    }
}
