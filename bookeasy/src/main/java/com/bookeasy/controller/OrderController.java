package com.bookeasy.controller;

import com.bookeasy.Global.GlobalData;
import com.bookeasy.entity.Item;
import com.bookeasy.entity.Order;
import com.bookeasy.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
@Controller
@RequestMapping("/orders")
public class OrderController {

    private OrderService orderService;

    @Autowired
    public OrderController(OrderService theOrderService) { this.orderService = theOrderService; }

    @GetMapping("/list")
    public String listAllOrders(Model theModel) {
        List<Order> theOrder = orderService.findAll();
        theModel.addAttribute("orders", theOrder);
        return "allOrders";
    }

    @GetMapping("/save/{username}")
    public String saveOrders(Model theModel,@PathVariable String username) {
        Random random = new Random();
        int orderId= random.nextInt(10000 - 1000 + 1) + 1000;

        System.out.println(GlobalData.getCart().size());
        for (int i = 0; i < GlobalData.getCart().size(); i++) {
            Order order = new Order();
            order.setOrderId(orderId);
            order.setUsername(username);
            order.setOrderNumber(GlobalData.getCart().get(i).getNum());
            order.setTotalAmount(GlobalData.getCart().get(i).getNum()*GlobalData.getCart().get(i).getBookItem().getBookPrice());
            order.setStatus("Placed");
            order.setBookId(GlobalData.getCart().get(i).getBookItem().getBookId());

            System.out.println(order.toString());
            orderService.save(order);
            GlobalData.setCard(new ArrayList<Item>());
        }
         return "home";
    }

}
