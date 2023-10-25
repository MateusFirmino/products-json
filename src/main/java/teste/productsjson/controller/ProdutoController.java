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
import teste.productsjson.client.ProductList;
import teste.productsjson.client.ProductUpdate;
import teste.productsjson.client.Products;
import teste.productsjson.client.ProductsDelete;

import java.util.List;


@RestController
@RequestMapping("/products")
public class ProdutoController {

  private final DummyClient dummyClient;

  public ProdutoController(DummyClient dummyClient) {this.dummyClient = dummyClient;}

  @GetMapping
  public ProductList getAllProducts() {
    return dummyClient.getAllProducts();
  }

  @GetMapping(value = "/{id}")
  public Products getProduct(@PathVariable Long id) {
    return dummyClient.getProduct(id);
  }

  @GetMapping(value = "/search")
  public ProductList searchProducts(@RequestParam(name = "q") String q) {
    return dummyClient.searchProducts(q);
  }

  @GetMapping(value = "/categories")
  public List<String> getAllCategories() {
    return dummyClient.getAllCategories();
  }

  @GetMapping(value = "/category/{name}")
  public ProductList getAllProductsCategories(@PathVariable String name) {
    return dummyClient.getProductsOfCategory(name);
  }

  @PostMapping(value = "/add")
  public Products newProduct(@RequestBody Products product) {
    return dummyClient.newProduct(product);
  }

  @PutMapping(value = "/{id}")
  public Products updateProduct(
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