package org.example.springlesson4homework.services;

import org.example.springlesson4homework.domain.Product;
import org.example.springlesson4homework.mapper.ProductMapper;
import org.example.springlesson4homework.template.SqlTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Service
public class SqlH2Service {

    private final JdbcTemplate jdbcTemplate;
    private final SqlTemplate sqlTemplates;

    @Autowired
    public SqlH2Service(JdbcTemplate jdbcTemplate, SqlTemplate sqlTemplates) {
        this.jdbcTemplate = jdbcTemplate;
        this.sqlTemplates = sqlTemplates;
    }
    // Получение всех продуктов
    public List<Product> getAllProducts() {
        return jdbcTemplate.query(sqlTemplates.getSelectAllUsers(), (rs, rowNum) ->
                new Product(rs.getInt("id"), rs.getString("name"), rs.getDouble("price")));
    }

    // Получение продукта по имени
    public Product getProductByName(String name) {
        return jdbcTemplate.queryForObject(sqlTemplates.getSelectProductByName(), new Object[]{name}, new ProductMapper()
        );
    }

    //Создание продукта
    public void createProduct(Product product) {
        jdbcTemplate.update(sqlTemplates.getInsertProduct(), product.getName(), product.getPrice());
    }
// обновление продукта
    public void updateProduct(Product product) {
        jdbcTemplate.update(sqlTemplates.getUpdateProduct(), product.getName(), product.getPrice());
    }
    // Удаление продукта
    public void deleteProduct(String name) {
        jdbcTemplate.update(sqlTemplates.getDeleteProduct(), name);
    }
}

