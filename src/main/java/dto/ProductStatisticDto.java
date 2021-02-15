package dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductStatisticDto {
    private ProductDto productDto;
    private int count;

    @Override
    public String toString() {
        return productDto.getBrandName() + " : " + count;
    }
}