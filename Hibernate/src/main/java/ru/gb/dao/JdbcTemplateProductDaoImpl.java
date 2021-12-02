package ru.gb.dao;

import lombok.AllArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import ru.gb.entity.Product;

import java.sql.ResultSet;
import java.sql.SQLException;

//@Component
@AllArgsConstructor
public class JdbcTemplateProductDaoImpl implements ProductDao {
    private final JdbcTemplate jdbcTemplate;

    @Override
    public Iterable<Product> findAll() {
        return jdbcTemplate.query("SELECT id, title, cost, manufacture_date from product",
                new RowMapper<Product>() {
                    @Override
                    public Product mapRow(ResultSet resultSet, int i) throws SQLException {
                        return Product.builder()
                                .id(resultSet.getLong("id"))
                                .title(resultSet.getString("title"))
                                .cost(resultSet.getBigDecimal("cost"))
                                .manufactureDate(resultSet.getDate("manufacture_date").toLocalDate())
                                .build();
                    }
                });
    }

    @Override
    public Product findById(Long id) {
        return jdbcTemplate.query("SELECT id, title, cost, manufacture_date from product where id = ?",
                new ResultSetExtractor<Product>() {
                    @Override
                    public Product extractData(ResultSet rs) throws SQLException, DataAccessException {
                        if (rs.next()) {
                            return Product.builder()
                                    .id(rs.getLong("id"))
                                    .title(rs.getString("title"))
                                    .cost(rs.getBigDecimal("cost"))
                                    .manufactureDate(rs.getDate("manufacture_date").toLocalDate())
                                    .build();

                        } else {
                            return null;
                        }
                    }
                },
                id);
    }

    @Override
    public String findTitleById(Long id) {
        return jdbcTemplate.queryForObject("SELECT title from product where id = ?",
                String.class, id);
    }
}
