package com.bookeasy.controller;

import com.bookeasy.Global.GlobalData;
import com.bookeasy.entity.Item;
import com.bookeasy.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class CartController {
    @Autowired
    private BookService bookService;
    private static final Logger log =
            LoggerFactory.getLogger(BookController.class);

    @GetMapping("/addToCart/{bookId}")
    public String addToCart(@PathVariable int bookId) {
        System.out.println(GlobalData.getCart().size());
        boolean flag = false;
        for (int i = 0; i < GlobalData.getCart().size(); i++) {
            if (GlobalData.getCart().get(i).getBookItem().getBookId() == bookId) {
                int temp = GlobalData.getCart().get(i).getNum();
                GlobalData.getCart().get(i).setNum(temp + 1);
                flag = true;
            }
        }

        if (flag == false) {
            Item item = new Item();
            item.setBookItem(bookService.findById(bookId));
            item.setNum(1);
            GlobalData.getCart().add(item);
        }
//        for (Book book : GlobalData.getCart()) {
//            System.out.println("Book ID: " + book.getBookId());
//            System.out.println("Title: " + book.getBookTitle());
//            System.out.println("Author: " + book.getBookAuthor());
//            System.out.println("-------");
//        }
        return "redirect:/books/list";
    }

    @GetMapping("/cart")
    public String showCart(Model theModel) {
        System.out.println(GlobalData.getCart().toString());
        theModel.addAttribute("cartCount", GlobalData.getCart().size());
        double amount = GlobalData.getCart().stream().mapToDouble(
                Item -> Item.getBookItem().getBookPrice() * Item.getNum()).sum();
        theModel.addAttribute("total", amount);
        double amountWithTax = amount*1.15;
        theModel.addAttribute("totalWithTax", amountWithTax);
//        theModel.addAttribute("total",GlobalData.getCart().stream().mapToDouble(Item-> Item.getBookItem().getBookPrice()).sum());
        theModel.addAttribute("cart", GlobalData.getCart());

        return "myCart";
    }

    @GetMapping("/cart/removeItem/{index}")
    public String cartItemRemove(@PathVariable int index) {

        for (int i = 0; i < GlobalData.getCart().size(); i++) {
            if (GlobalData.getCart().get(i).getBookItem().getBookId() == index) {
                GlobalData.getCart().remove(i);
            }
        }
        return "redirect:/cart";
    }
}
