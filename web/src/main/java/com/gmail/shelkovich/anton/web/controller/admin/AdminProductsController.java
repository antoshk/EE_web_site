package com.gmail.shelkovich.anton.web.controller.admin;

import com.gmail.shelkovich.anton.service.FileService;
import com.gmail.shelkovich.anton.service.ProductService;
import com.gmail.shelkovich.anton.service.model.dto.ProductDTO;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;

@Controller
@RequestMapping("/admin/products")
public class AdminProductsController {

    private static final Logger logger = Logger.getLogger(AdminProductsController.class);

    @Value("${controller.productPerAdminPage:20}")
    private Integer productPerPage;

    @Autowired
    private ProductService productService;

    @Autowired
    private FileService fileService;

    @GetMapping
    public String productFirstPage(ModelMap model) throws IOException {
        model.addAttribute("catalog", productService.getByPage(productPerPage, null));
        model.addAttribute("pagination", productService.getPagination(productPerPage, null));
        return "editProducts";
    }

    @GetMapping(value = "/page/{page}")
    public String productsPage(@PathVariable Integer page, ModelMap model) throws IOException {
        model.addAttribute("catalog", productService.getByPage(productPerPage, page));
        model.addAttribute("pagination", productService.getPagination(productPerPage, page));
        return "editProducts";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String editProduct(@PathVariable Long id, ModelMap model) {
        model.addAttribute("product", productService.getById(id));
        model.addAttribute("action", "Изменить");
        return "addOrEditProduct";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public String updateProduct(@PathVariable Long id, @Valid @ModelAttribute("product") ProductDTO product, BindingResult result) {
        if (result.hasErrors()) {
            return "addOrEditProduct";
        }

        if (!product.getImage().isEmpty()) {
            String path = fileService.save(product.getImage(), "products/");
            if (path != null) {
                product.setImageURI(path);
                fileService.deleteFileByNewsId(product.getId());
            } else {
                product.setImageURI(null);
                logger.info("While updating product the returned image path is null");
            }
        } else {
            logger.info("While updating products the image file is empty");
        }

        product.setId(id);
        productService.updateProduct(product);
        return "redirect:/admin/products";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addProduct(ModelMap model) {
        model.addAttribute("product", new ProductDTO());
        model.addAttribute("action", "Добавить");
        return "addOrEditProduct";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String saveProduct(@Valid @ModelAttribute("product") ProductDTO product, BindingResult result) {
        if (result.hasErrors()) {
            return "addOrEditProduct";
        }

        if (!product.getImage().isEmpty()) {
            String path = fileService.save(product.getImage(), "products/");
            if (path != null) {
                product.setImageURI(path);
            } else {
                logger.info("While updating news the returned file path is null");
                result.addError(new FieldError("product", "image","Can not save file"));
                return "addOrEditProduct";
            }
        } else {
            logger.info("While updating news the image file is empty");
            result.addError(new FieldError("product", "photo","Can not load file"));
            return "addOrEditProduct";
        }

        productService.addNew(product);
        return "redirect:/admin/products";
    }

    @RequestMapping(value = "/{id}/delete", method = RequestMethod.POST)
    public String deleteProduct(@PathVariable Long id) {
        productService.delete(id);
        return "redirect:/admin/products";
    }



}
