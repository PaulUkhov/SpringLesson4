package org.example.springlesson4homework;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
//Базовое задание:
//        1. Создание базового веб-приложения Spring MVC
//Начните с создания простого веб-приложения с использованием Spring MVC. Это может быть простой сайт,
// который выводит "Привет, мир!" на главной странице.
// Используйте аннотацию @Controller и @RequestMapping для маршрутизации запросов на эту страницу.
//2. Добавление Thymeleaf в проект
// Добавьте Thymeleaf в свое веб-приложение Spring MVC.
// Создайте простую страницу с некоторыми переменными, которые заполняются с помощью модели
// Spring MVC и отображаются на странице с использованием Thymeleaf.
//3. Создание формы ввода и обработка данных формы
//Создайте страницу с формой ввода, используя Thymeleaf для рендеринга формы. Затем создайте контроллер Spring MVC,
// который обрабатывает отправку формы и выводит полученные данные. Это может быть форма для регистрации или любая другая форма,
// которая собирает информацию от пользователя.
//
//Все необходимые примеры кода для этого задания мы разбирали на семинаре.

@ConfigurationPropertiesScan
@SpringBootApplication
public class SpringLesson4HomeWorkApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringLesson4HomeWorkApplication.class, args);
    }

}
