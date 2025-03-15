package org.example.springlesson4homework.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.springlesson4homework.domain.Product;
import org.example.springlesson4homework.services.ServiceProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j // Логируем добавление продукта
@Controller
@RequestMapping("/products")
public class ControllerProducts {

    ServiceProduct serviceProduct;
@Autowired
    public ControllerProducts(ServiceProduct serviceProduct) {
        this.serviceProduct = serviceProduct;
    }

    /**
     *
     * Добавили продукт
     * @return продукт
     */
    @PostMapping
    public String addProduct(Product product) {
        log.info("Добавление продукта: {}", product);
        serviceProduct.addProduct(product);
        log.info("Продукт успешно добавлен");
        return "redirect:/products";
    }

    /**
     *
     * Получить все продукты
     * @return Наименования продуктов
     */
    @GetMapping
    public String getProducts(Model model) {
        log.info("Получение всех продуктов");
        model.addAttribute("products", serviceProduct.getAllProducts());
        log.info("Продукты успешно получены");
        return "products";
    }
}
