package gb.ru.order.dto.mapper;

import gb.ru.order.dto.ProductDto;
import gb.ru.order.entity.Product;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


import java.util.NoSuchElementException;

@Mapper
public interface ProductMapper {
    Product toProduct(ProductDto productDto);
    ProductDto toProductDto(Product product);
}
