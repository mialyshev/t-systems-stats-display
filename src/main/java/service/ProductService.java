package service;

import dto.ProductStatisticDto;

import java.util.List;

public interface ProductService {

    List<ProductStatisticDto> getStats();
}
