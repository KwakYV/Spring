package ru.gb.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.gb.entity.Product;
import ru.gb.service.ProductService;

@Controller
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    /**
     * Метод создания формы
     */
    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String showSimpleForm(Model model){
        Product product = new Product();
        model.addAttribute("product", product);
        return "create";
    }

    /**
     *  Метод вывода одного сообщения на экран
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String getMessageById(Model model,
                                 @PathVariable Integer id,
                                 @RequestParam(name = "random", defaultValue = "false", required = false) Boolean isRandom) {
        Product product = null;
        if (isRandom){
            product = productService.getRandomProduct();
        } else {
            product = productService.findById(id);
        }
        model.addAttribute("product", product);
        return "product";
    }

    /**
     * Сохранение продукта в базе
     */
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String processForm(Product product){
        if (product.getId() == null){
            productService.save(product);
        } else {
            productService.edit(product);
        }

        return "redirect:/product/all";
    }

    /**
     * Список сообщений
     */
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public String getAll(Model model){
        model.addAttribute("products", productService.findAll());
        return "product-list";
    }

    /**
     * Удаление по Id
     */
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String deleteById(@RequestParam Integer id){
        productService.deleteById(id);
        return "redirect:/product/all";
    }

    /**
     * Редактирование по Id
     */
    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String editById(Model model, @RequestParam Integer id){
        Product product = productService.findById(id);
        model.addAttribute("product", product);
        return "create";
    }
    /**
     *
     */

//    @RequestMapping
//    public String printMessage(Model model){
//        model.addAttribute("product", "Hello from ProductController");
//        return "product";
//    }
}
