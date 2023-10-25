package teste.productsjson.client;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductList {
  private List<Products> products;
  private int total;
  private int skip;
  private int limit;

}
