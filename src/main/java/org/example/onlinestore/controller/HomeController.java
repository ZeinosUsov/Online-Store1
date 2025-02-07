package org.example.onlinestore.controller;

import org.example.onlinestore.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

    private List<Product> productList = new ArrayList<>();

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("message", "Добро пожаловать в интернет-магазин!");
        return "index";
    }
    @GetMapping("/products")
    public String products(Model model) {
        List<Product> productList = new ArrayList<>();
        productList.add(new Product("Телефон", 50000, "Смартфон с отличной камерой"));
        productList.add(new Product("Ноутбук", 90000, "Мощный ноутбук для работы и игр"));
        productList.add(new Product("Наушники", 7000, "Беспроводные наушники с шумоподавлением"));

        model.addAttribute("products", productList);
        return "products";
    }
    @GetMapping("/add-product")
    public String addProductForm(Model model) {
        model.addAttribute("product", new Product("", 0.0, ""));
        return "add-product";
    }

    @PostMapping("/add-product")
    public String addProduct(@ModelAttribute Product product, Model model) {
        // На данном этапе мы просто добавляем товар во временный список
        productList.add(product);
        model.addAttribute("products", productList);
        return "products";
    }
}