package teste.productsjson.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import teste.productsjson.client.DummyClient;
import teste.productsjson.client.dto.ProductListResponse;
import teste.productsjson.client.dto.ProductUpdate;
import teste.productsjson.client.dto.ProductsDelete;
import teste.productsjson.client.dto.ProductsResponse;

import java.util.List;


@RestController
@RequestMapping("/products")
public class ProdutoController {

  private final DummyClient dummyClient;

  public ProdutoController(DummyClient dummyClient) {this.dummyClient = dummyClient;}

  @GetMapping(value = "/{id}")
  public ProductsResponse getProduct(@PathVariable Long id) {
    return dummyClient.getProduct(id);
  }

  @GetMapping(value = "/search")
  public ProductListResponse searchProducts(@RequestParam(name = "q") String q) {
    return dummyClient.searchProducts(q);
  }

  @GetMapping()
  public ProductListResponse searchCustomProducts(
    @RequestParam(value = "limit", required = false) String limit,
    @RequestParam(value = "skip", required = false) String skip
  ) {
    return dummyClient.searchCustomProducts(limit, skip);
  }

  @GetMapping(value = "/categories")
  public List<String> getAllCategories() {
    return dummyClient.getAllCategories();
  }

  @GetMapping(value = "/category/{name}")
  public ProductListResponse getAllProductsCategories(@PathVariable String name) {
    return dummyClient.getProductsOfCategory(name);
  }

  @PostMapping(value = "/add")
  public ProductsResponse newProduct(@RequestBody ProductsResponse product) {
    return dummyClient.newProduct(product);
  }

  @PutMapping(value = "/{id}")
  public ProductsResponse updateProduct(
    @RequestBody ProductUpdate productUpdate,
    @PathVariable Long id
  ) {
    return dummyClient.updateProduct(productUpdate, id);
  }

  @DeleteMapping(value = "/{id}")
  public ProductsDelete deleteProduct(@PathVariable Long id) {
    return dummyClient.deleteProduct(id);
  }

}