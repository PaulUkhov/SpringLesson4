package org.example.springlesson4homework.controller;

import org.example.springlesson4homework.domain.Product;
import org.example.springlesson4homework.services.ServiceProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/products")
public class ControllerProducts {

    ServiceProduct serviceProduct;
@Autowired
    public ControllerProducts(ServiceProduct serviceProduct) {
        this.serviceProduct = serviceProduct;
    }

    @PostMapping
    public String addProduct(Product product) {
         serviceProduct.addProduct(product);
        return "redirect:/products";
    }

    @GetMapping
    public String getProducts(Model model) {
        model.addAttribute("products",serviceProduct.getAllProducts());
        return "products";
    }
}
