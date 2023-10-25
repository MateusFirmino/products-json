package teste.productsjson.client.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductListResponse {
  private List<ProductsResponse> products;
  private int total;
  private int skip;
  private int limit;

}
