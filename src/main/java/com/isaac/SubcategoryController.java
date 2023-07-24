package com.isaac;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
//@RequestMapping("/subcategories")
public class SubcategoryController {
	@Autowired
	SubcategoryService subcategoryService;
     CategoryService categoryService;

    public SubcategoryController(SubcategoryService subcategoryService, CategoryService categoryService) {
        this.subcategoryService = subcategoryService;
        this.categoryService = categoryService;
    }
	    

	    @GetMapping("/subcategories")
	    public String getAllSubcategories(Model model) {
	        List<Subcategory> subcategories = subcategoryService.getAllSubcategories();
	        model.addAttribute("subcategories", subcategories);
	        return "subcategories";
	    }

	    @GetMapping("/subcategories/add")
	    public String showAddSubcategoryForm(Model model) {
	        List<Category> categories = categoryService.getAllCategories();
	        model.addAttribute("categories", categories);
	        model.addAttribute("subcategory", new Subcategory());
	        return "add-subcategory";
	    }

	    @PostMapping("/subcategories/add")
	    public String addSubcategory(@ModelAttribute("subcategory") Subcategory subcategory) {
	        subcategoryService.addSubcategory(subcategory);
	        return "redirect:/subcategories";
	    }

	    @GetMapping("/subcategories/edit/{id}")
	    public String showEditSubcategoryForm(@PathVariable("id") Integer id, Model model) {
	        Subcategory subcategory = subcategoryService.getSubcategoryById(id);
	        List<Category> categories = categoryService.getAllCategories();
	        model.addAttribute("categories", categories);
	        model.addAttribute("subcategory", subcategory);
	        return "edit-subcategory";
	    }

	    @PostMapping("/subcategories/edit/{id}")
	    public String editSubcategory(@PathVariable("id") Integer id, @ModelAttribute("subcategory") Subcategory subcategory) {
	        subcategory.setId(id);
	        subcategoryService.editSubcategory(subcategory);
	        return "redirect:/subcategories";
	    }

	    @GetMapping("/subcategories/delete/{id}")
	    public String deleteSubcategory(@PathVariable("id") Integer id) {
	        subcategoryService.deleteSubcategory(id);
	        return "redirect:/subcategories";
	    }
}
