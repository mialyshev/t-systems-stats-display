package util;

import com.google.gson.Gson;
import dto.ProductStatisticDto;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Type;

import com.google.gson.reflect.TypeToken;


import javax.inject.Singleton;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Singleton
@Slf4j
public class StatsJsonParser {

    private final Gson gson = new Gson();
    ;

    public List<ProductStatisticDto> parse(String json) {
        Type productListType = new TypeToken<ArrayList<ProductStatisticDto>>() {}.getType();
        List<ProductStatisticDto> productStatisticDtos = null;

        productStatisticDtos = gson.fromJson(json, productListType);
        return productStatisticDtos;
    }
}
