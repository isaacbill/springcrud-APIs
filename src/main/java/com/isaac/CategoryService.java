package com.isaac;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
	public Category getCategoryById(Integer id) {
	    SqlSession session = MyBatisConfig.getSqlSessionFactory().openSession();
	    try {
	    	Category category = (Category) session.selectOne("com.isaac.CategoryMapper.getCategoryById", id);
	        return category;
	    } finally {
	        session.close();
	    }
	}


	public List<Category> getAllCategories() {
		  SqlSession session = MyBatisConfig.getSqlSessionFactory().openSession();
		  try {
		    @SuppressWarnings("unchecked")
			List<Category> category = session.selectList("com.isaac.CategoryMapper.getAllCategories");
		    return category;
		  } finally {
		    session.close();
		  }
		}

	
	public void addCategory(Category category) {
	    SqlSession session = MyBatisConfig.getSqlSessionFactory().openSession();
	    try {
	        session.insert("com.isaac.CategoryMapper.addCategory", category);
	        session.commit();
	    } finally {
	        session.close();
	    }
	}
	public void editCategory(Category category) {
	    SqlSession session = MyBatisConfig.getSqlSessionFactory().openSession();
	    try {
	        session.update("com.isaac.CategoryMapper.updateCategory", category);
	        session.commit();
	    } finally {
	        session.close();
	    }
	}
	public void deleteCategory(Integer id) {
	    SqlSession session = MyBatisConfig.getSqlSessionFactory().openSession();
	    try {
	        session.update("com.isaac.CategoryMapper.deleteCategory", id);
	        session.commit();
	    } finally {
	        session.close();
	    }
	}

	
}
