package xyz.ivyxjc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import xyz.ivyxjc.bean.Category;
import xyz.ivyxjc.bean.Product;
import xyz.ivyxjc.service.CategoryService;
import xyz.ivyxjc.service.ProductService;

import java.util.List;

/**
 * Created by jc on 3/19/2017.
 */

@Controller
@RequestMapping("/")
public class HomeController {


    @Autowired
    CategoryService mCategoryService;

    @Autowired
    ProductService mProductService;

    @RequestMapping(method = RequestMethod.GET)
    public String index(
            Model model
    ){
        List<Category> cs=mCategoryService.list();

        model.addAttribute("cs",cs);
        return "front/home";
    }


    @RequestMapping(value = "forecategory",method = RequestMethod.GET)
    public String categoryIndex(
            @RequestParam("cid") int cid,
            Model model
    ){
        Category c=mCategoryService.get(cid);
        for (Product p:c.getProducts()){
           mProductService.get(p.getId());
        }
        model.addAttribute("c",c);
        return "front/category";
    }
}
