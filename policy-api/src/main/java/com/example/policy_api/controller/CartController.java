package com.example.policy_api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.policy_api.model.Cart;
import com.example.policy_api.model.Item;


@Controller
@SessionAttributes("cart")
public class CartController {

    @ModelAttribute("cart")
    public Cart cart() {
        return new Cart();
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("item", new Item());
        return "index";
    }

    @PostMapping("/add")
    public String addToCart(@ModelAttribute Item item, @ModelAttribute("cart") Cart cart) {
        cart.addItem(item);
        return "redirect:/cart";
    }

    @GetMapping("/cart")
    public String viewCart(@ModelAttribute("cart") Cart cart, Model model) {
        model.addAttribute("total", cart.getTotal());
        return "cart";
    }

    @PostMapping("/checkout")
    public String checkout(@ModelAttribute("cart") Cart cart) {
        cart.clear();
        return "redirect:/";
    }
}
