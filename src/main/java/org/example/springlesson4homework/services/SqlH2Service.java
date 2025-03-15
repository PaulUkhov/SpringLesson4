package org.example.springlesson4homework.services;

import org.example.springlesson4homework.domain.Product;
import org.example.springlesson4homework.template.SqlTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

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

    public List<Product> getAllProducts() {
        return jdbcTemplate.query(sqlTemplates.getSelectAllUsers(), (rs, rowNum) ->
                new Product(rs.getString("name"), rs.getDouble("price"))); // <-- Исправлено
    }

    public Product getProductByName(String name) {
        return jdbcTemplate.queryForObject(sqlTemplates.getSelectProductByName(), new Object[]{name}, (rs, rowNum) ->
                new Product(rs.getString("name"), rs.getDouble("price"))); // <-- Исправлено
    }

    public void createProduct(Product product) {
        jdbcTemplate.update(sqlTemplates.getInsertProduct(), product.getName(), product.getPrice()); // <-- Исправлено
    }

    public void updateProduct(Product product) {
        jdbcTemplate.update(sqlTemplates.getUpdateProduct(), product.getName(), product.getPrice()); // <-- Исправлено
    }

    public void deleteProduct(String name) {
        jdbcTemplate.update(sqlTemplates.getDeleteProduct(), name); // <-- Исправлено
    }
}

