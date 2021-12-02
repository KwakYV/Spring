package ru.gb.dao;

import lombok.AllArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import ru.gb.entity.Product;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

//@Component
@AllArgsConstructor
public class NamedJdbcTemplateProductDaoImpl implements ProductDao {

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public Iterable<Product> findAll() {
        return namedParameterJdbcTemplate.query("select * from product",
                new RowMapper<Product>() {
                    @Override
                    public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
                        return Product.builder()
                                .id(rs.getLong("id"))
                                .title(rs.getString("title"))
                                .cost(rs.getBigDecimal("cost"))
                                .manufactureDate(rs.getDate("manufacture_date").toLocalDate())
                                .build();
                    }
                });
    }

    @Override
    public Product findById(Long id) {
        String sql = "select * from product where id = :product_id";
        HashMap<String, Object> namedParameters = new HashMap<>();
        namedParameters.put("product_id", id);
        return namedParameterJdbcTemplate.query(sql, namedParameters,
                new ResultSetExtractor<Product>() {
                    @Override
                    public Product extractData(ResultSet rs) throws SQLException, DataAccessException {
                        Product product = null;
                        while (rs.next()){
                            product = Product.builder()
                                    .id(rs.getLong("id"))
                                    .title(rs.getString("title"))
                                    .cost(rs.getBigDecimal("cost"))
                                    .manufactureDate(rs.getDate("manufacture_date").toLocalDate())
                                    .build();
                        }
                        return product;
                    }
                });
    }

    @Override
    public String findTitleById(Long id) {
        String sql = "select title from product where id = :product_id";
        HashMap<String, Object> namedParameters = new HashMap<>();
        namedParameters.put("product_id", id);
        return namedParameterJdbcTemplate.queryForObject(sql, namedParameters, String.class);
    }
}
