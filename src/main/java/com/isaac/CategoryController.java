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
//@RequestMapping("/categories")
public class CategoryController {
	@Autowired
	 CategoryService categoryService;

	    

	    @GetMapping("/categories")
	    public String getAllCategories(Model model) {
	        List<Category> categories = categoryService.getAllCategories();
	        model.addAttribute("categories", categories);
	        return "categories";
	    }

	    @GetMapping("/categories/add")
	    public String showAddCategoryForm(Model model) {
	        model.addAttribute("category", new Category());
	        return "add-category";
	    }

	    @PostMapping("/categories/add")
	    public String addCategory(@ModelAttribute("category") Category category) {
	        categoryService.addCategory(category);
	        return "redirect:/categories";
	    }

	    @GetMapping("/categories/edit/{id}")
	    public String showEditCategoryForm(@PathVariable("id") Integer id, Model model) {
	        Category category = categoryService.getCategoryById(id);
	        model.addAttribute("category", category);
	        return "edit-category";
	    }

	    @PostMapping("/categories/edit/{id}")
	    public String editCategory(@PathVariable("id") Integer id, @ModelAttribute("category") Category category) {
	        category.setId(id);
	        categoryService.editCategory(category);
	        return "redirect:/categories";
	    }

	    @GetMapping("/categories/delete/{id}")
	    public String deleteCategory(@PathVariable("id") Integer id) {
	        categoryService.deleteCategory(id);
	        return "redirect:/categories";
	    }

}
