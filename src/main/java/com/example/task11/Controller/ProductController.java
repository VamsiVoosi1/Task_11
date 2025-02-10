package com.example.task11.Controller;

import com.example.task11.Entity.Product;
import com.example.task11.Service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/products")
public class ProductController {
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    @GetMapping("/new")
    public String getForm(){
        return "index";
        }
    @GetMapping("/productForm")
    public String showForm(Model model){
        model.addAttribute("adds",new Product());
        return "product";
    }
    @PostMapping("/saveProduct")
    public String insertData(@ModelAttribute("adds") Product product){
        productService.saveProduct(product);
        return "redirect:/products/view-productList";
    }
    @GetMapping("/view-productList")
    public String showProductList(Model model){
        model.addAttribute("products",productService.getAllProducts());
        return "product-list";
    }


}
