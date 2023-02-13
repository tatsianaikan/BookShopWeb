package com.example.bookshop.controller;



import com.example.bookshop.entity.Product;
import com.example.bookshop.entity.Status;
import com.example.bookshop.pojos.ProductObj;
import com.example.bookshop.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private IProductService productService;

    /**
     * Add new product in DB
     * @param productObj - Obj
     * @return a JSON with added Product
     */
    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public Product addProduct(@RequestBody ProductObj productObj){
        return productService.addProduct(productObj);
    }

    /**
     * Edit product in DB
     * @param productObj - Obj
     * @return a JSON with edited Product
     */
    @PutMapping("/edit")
    @ResponseBody
    public Product editProduct(@RequestBody ProductObj productObj){
        return productService.editProduct(productObj);
    }

    /**
     * Get Product by Id
     * @param productId - int
     * @return a JSON of found Product
     */
    @GetMapping("/get")
    @ResponseBody
    public Product getProduct(@RequestParam int productId){
        return productService.getProduct(productId);
    }

    /**
     * Search Product by Id
     * @param productId - int
     * @return a JSON of found Product
     */
    @GetMapping("/search")
    @ResponseBody
    public Product searchProduct (@RequestParam int productId){
        return productService.searchProduct(productId);
    }

    /**
     * Delete Product by Id
     * @param productId - int
     * @return String message about successful removal of Product
     */
    @DeleteMapping("/delete")
    @ResponseBody
    public String deleteProduct(@RequestParam int productId){
        Product product = new Product();
        product =  productService.getProduct(productId);
        productService.deleteProduct(productId);
        return product.getDescription() + " was deleted!";
    }

    /**
     * Receiving all Product in DB
     * @return a JSON with list of the Product
     */
    @GetMapping("/all")
    @ResponseBody
    public List<Product> getAllProduct(){
        return productService.getAllProducts();
    }

}




/**
 * customer can:
 *      - view products
 *      - search product
 *      - book product
 *
 * managers can:
 *      - view products
 *      - add product
 *      - edit product
 *      - delete product
 *
 */
