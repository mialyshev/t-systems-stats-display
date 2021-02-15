package dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {

    private long id;

    private int quantity;

    private int price;

    private String model;

    private String url;

    private String categoryName;

    private String brandName;

    private String seasonName;

    private String colorName;

    private String materialName;

    private float size;

    @Override
    public String toString() {
        return brandName + " " + model;
    }
}
