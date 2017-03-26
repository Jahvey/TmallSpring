package xyz.ivyxjc.controller;

import static org.springframework.web.bind.annotation.RequestMethod.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import xyz.ivyxjc.bean.Category;
import xyz.ivyxjc.service.CategoryService;
import xyz.ivyxjc.utils.Page;

import java.util.List;

/**
 * Created by jc on 3/19/2017.
 */

@Controller
@RequestMapping("/")
public class AdminController {

    @Autowired
    private CategoryService mCategoryService;

    /**
     * 这里每次都会从数据库中取出所有的数据, 不高效.
     * 可以在查询参数中添加一些其它信息,只从数据库取出当前页面需要的数据
     *
     * @param start
     * @param model
     * @return
     */
    @RequestMapping(value = "/admin_category_list")
    public String adminListCategory(
            @RequestParam(value = "page.start", defaultValue = "0") int start,
            @RequestParam(value = "page.count", defaultValue = "5") int count,
            Model model) {

        if (!model.containsAttribute("thecs")) {
            List<Category> cs = mCategoryService.list();
            Page page = new Page(start, count);
            page.setTotal(cs.size());
            cs = cs.subList(start, Math.min(start + page.getCount(), cs.size()));

            model.addAttribute("thecs", cs);
            model.addAttribute("page", page);
            model.addAttribute(new Category());
        }
        return "admin/listCategory";
    }

    @RequestMapping(value = "/admin_category_edit")
    public String adminEditCategory(
            @RequestParam("id") int id,
            Model model) {
        Category category=mCategoryService.get(id);
        model.addAttribute("c",category);
        model.addAttribute(category);
        return "admin/editCategory";
    }

    @RequestMapping(value = "/admin_category_update",method = POST)
    public String adminUpdateCategory(
            Category bean,
            Model model){
        mCategoryService.update(bean);
        return "redirect:/admin_category_list";
    }

    @RequestMapping(value ="/admin_category_delete")
    public String adminDeleteCategory(
            @RequestParam("id") int id){
        mCategoryService.delete(id);
        return "redirect:/admin_category_list";
    }

    @RequestMapping(value = "/admin_category_add",method = POST)
    public String adminAddCategory(
            Category bean){
        mCategoryService.add(bean);
        return "redirect:/admin_category_list";

    }

}
