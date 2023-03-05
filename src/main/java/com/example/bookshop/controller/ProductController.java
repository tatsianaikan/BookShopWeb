package com.example.bookshop.controller;



import com.example.bookshop.entity.Product;
import com.example.bookshop.pojosdto.ProductDto;
import com.example.bookshop.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
//@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private IProductService productService;

    /**
     * Add new product in DB
     * @param productDto - Obj
     * @return a JSON with added Product
     */
    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public ProductDto addProduct(@RequestBody ProductDto productDto){
        return productService.addProduct(productDto);
    }

    /**
     * Edit product in DB
     * @param productDto - Obj
     * @return a JSON with edited Product
     */
    @PutMapping("/edit")
    @ResponseBody
    public ProductDto editProduct(@RequestBody ProductDto productDto){
        return productService.editProduct(productDto);
    }

    /**
     * Get Product by Id
     * @param productId - int
     * @return a JSON of found Product
     */
    @GetMapping("/get")
    @ResponseBody
    public ProductDto getProduct(@RequestParam long productId){
        return productService.getProduct(productId);
    }

    /**
     * Search Product by Id
     * @param productId - int
     * @return a JSON of found Product
     */
    @GetMapping("/search")
    @ResponseBody
    public ProductDto searchProduct (@RequestParam long productId){
        return productService.searchProduct(productId);
    }

    /**
     * Delete Product by Id
     * @param productId - int
     * @return String message about successful removal of Product
     */
    @DeleteMapping("/delete")
    @ResponseBody
    public void deleteProduct(@RequestParam long productId){
        productService.deleteProduct(productId);
    }

    /**
     * Receiving all Product in DB
     * @return a JSON with list of the Product
     */
    @GetMapping("/all")
    @ResponseBody
    public List<ProductDto> getAllProduct(){
        return productService.getAllProducts();
    }

    @GetMapping("")
    public String productsPage(Model model) {
        model.addAttribute("title", "Products Page");
        return "view/pages/productsPage";
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
