package ru.gb.dao;

import lombok.extern.slf4j.Slf4j;
import ru.gb.entity.Manufacturer;
import ru.gb.entity.Product;

import java.sql.*;
import java.util.HashSet;
import java.util.Set;


public class JdbcProductDaoImpl implements ProductDao {

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:postgresql://localhost:5432/geek", "geek_user", "geek");
    }

    @Override
    public Iterable<Product> findAll() {
        Set<Product> result = new HashSet<>();
        try(Connection connection = getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement("select * from product");
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                final Product product = Product.builder()
                        .id(resultSet.getLong("id"))
                        .title(resultSet.getString("title"))
                        .cost(resultSet.getBigDecimal("cost"))
                        .manufactureDate(resultSet.getDate("manufacture_date").toLocalDate())
                        .build();
                result.add(product);
            }
            preparedStatement.close();
        } catch(Exception e){
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Product findById(Long id) {
        Product product = null;
        try(Connection connection = getConnection()){
            PreparedStatement statement = connection.prepareStatement(String.format("select * from product where id = %d", id));
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                product = Product.builder()
                        .title(resultSet.getString("title"))
                        .cost(resultSet.getBigDecimal("cost"))
                        .manufactureDate(resultSet.getDate("manufacture_date").toLocalDate())
                        .build();
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return product;
    }

    @Override
    public String findTitleById(Long id) {
        String title = null;
        try(Connection connection = getConnection()){
            PreparedStatement statement = connection.prepareStatement(String.format("select * from product where id = %d", id));
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                title = resultSet.getString("title");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return title;
    }
}
