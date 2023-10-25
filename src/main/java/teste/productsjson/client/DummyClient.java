package teste.productsjson.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "products", url = "https://dummyjson.com")
public interface DummyClient {

  @GetMapping(value = "/products")
  ProductList getAllProducts();

  @GetMapping(value = "products/{id}")
  Products getProduct(@PathVariable Long id);

  @GetMapping(value = "products/search")
  ProductList searchProducts(@RequestParam(name = "q") String q);

  @GetMapping(value = "/products/categories")
  List<String> getAllCategories();

  @GetMapping(value = "/products/category/{name}")
  ProductList getProductsOfCategory(@PathVariable String name);

  @PostMapping(value = "/products/add")
  Products newProduct(@RequestBody Products product);

  @PutMapping(value = "/products/{id}")
  Products updateProduct(@RequestBody ProductUpdate productUpdate,@PathVariable Long id);

  @DeleteMapping(value = "products/{id}")
  ProductsDelete deleteProduct(@PathVariable Long id);

}
