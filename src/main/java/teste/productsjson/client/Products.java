package teste.productsjson.client;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Products {

  private Long id;
  private String title;
  private String description;
  private Long price;
  private Double discountPercentage;
  private Double rating;
  private Long stock;
  private String brand;
  private String category;
  private String thumbnail;
  private List<String> images;

}