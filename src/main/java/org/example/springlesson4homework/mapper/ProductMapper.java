package org.example.springlesson4homework.mapper;

import org.example.springlesson4homework.domain.Product;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
@Component
public class ProductMapper implements RowMapper<Product> {
    @Override
    public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Product(rs.getInt("id"), rs.getString("name"), rs.getDouble("price"));
    }
}