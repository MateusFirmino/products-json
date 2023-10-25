package teste.productsjson.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import teste.productsjson.client.dto.ProductListResponse;
import teste.productsjson.client.dto.ProductUpdate;
import teste.productsjson.client.dto.ProductsResponse;
import teste.productsjson.client.dto.ProductsDelete;

import java.util.List;

@FeignClient(name = "products", url = "https://dummyjson.com")
public interface DummyClient {

  @GetMapping(value = "products/{id}")
  ProductsResponse getProduct(@PathVariable Long id);

  @GetMapping(value = "products/search")
  ProductListResponse searchProducts(@RequestParam(name = "q") String q);

  @GetMapping(value = "/products")
  ProductListResponse searchCustomProducts(@RequestParam(value = "limit") String limit,
                                           @RequestParam(value = "skip") String skip);

  @GetMapping(value = "/products/categories")
  List<String> getAllCategories();

  @GetMapping(value = "/products/category/{name}")
  ProductListResponse getProductsOfCategory(@PathVariable String name);

  @PostMapping(value = "/products/add")
  ProductsResponse newProduct(@RequestBody ProductsResponse product);

  @PutMapping(value = "/products/{id}")
  ProductsResponse updateProduct(@RequestBody ProductUpdate productUpdate, @PathVariable Long id);

  @DeleteMapping(value = "products/{id}")
  ProductsDelete deleteProduct(@PathVariable Long id);

}
