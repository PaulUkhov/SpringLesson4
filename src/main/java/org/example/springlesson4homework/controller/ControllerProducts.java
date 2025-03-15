package org.example.springlesson4homework.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.springlesson4homework.domain.Product;
import org.example.springlesson4homework.services.ServiceProduct;
import org.example.springlesson4homework.services.SqlH2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j // Логи добавление продукта
@Controller
@RequestMapping("/products")
@AllArgsConstructor
public class ControllerProducts {
    SqlH2Service sqlH2Service;

    /**
     * Получить все продукты
     *
     * @return Наименования продуктов
     */

    @GetMapping
    public String getProducts(Model model) {
        log.info("Получение всех продуктов");
        List<Product> products = sqlH2Service.getAllProducts();
        model.addAttribute("products", products);
        log.info("Продукты успешно получены");
        return "products";  // Возвращаем имя представления, например, "products.html"
    }

    /**
     * Получить продукт по имени
     *
     * @return Имя продукта
     */

    @GetMapping("/{name}")
    public String getProductByName(@PathVariable("name") String name, Model model) {
        log.info("Получение продуктов по имени");
        Product product = sqlH2Service.getProductByName(name);
        model.addAttribute("product", product);
        log.info("Продукты по имени успешно получены");
        return "productDetail";  // Возвращаем имя представления, например, "productDetail.html"
    }

    /**
     * Создать новый продукт
     *
     * @return Имя продукта
     */
    @PostMapping
    public String createProduct(@ModelAttribute Product product) {
        log.info("Создание нового продукта");
        sqlH2Service.createProduct(product);
        log.info("Создание нового продукта успешно выполнено");
        return "redirect:/products";  // Перенаправляем на список продуктов
    }

    /**
     * Обновить продукт
     *
     * @return Список продуктов
     */
    @PutMapping("/{name}")
    public String updateProduct(@PathVariable("name") String name, @ModelAttribute Product product) {
        log.info("Обновление существующего продукта ");
        product.setName(name);
        sqlH2Service.updateProduct(product);
        log.info("Обновление существующего продукта успешно выполнено ");
        return "redirect:/products";  // Перенаправляем на список продуктов
    }

    /**
     * Удалить продукт
     *
     * @return Список продуктов
     */
    @DeleteMapping("/{name}")
    public String deleteProduct(@PathVariable("name") String name) {
        log.info("Удаление продукта ");
        sqlH2Service.deleteProduct(name);
        log.info("Удаление продукта успешно выполнено");
        return "redirect:/products";  // Перенаправляем на список продуктов
    }
}


