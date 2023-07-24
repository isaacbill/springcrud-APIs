package com.isaac;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

@Service
public class SubcategoryService {
	
	public Subcategory getSubcategoryById(Integer id) {
	    SqlSession session = MyBatisConfig.getSqlSessionFactory().openSession();
	    try {
	    	Subcategory subcategory = (Subcategory) session.selectOne("com.isaac.SubcategoryMapper.getSubcategoryById", id);
	        return subcategory;
	    } finally {
	        session.close();
	    }
	}


	public List<Subcategory> getAllSubcategories() {
		  SqlSession session = MyBatisConfig.getSqlSessionFactory().openSession();
		  try {
		    @SuppressWarnings("unchecked")
			List<Subcategory> subcategory = session.selectList("com.isaac.SubcategoryMapper.getAllSubcategories");
		    return subcategory;
		  } finally {
		    session.close();
		  }
		}

	
	public void addSubcategory(Subcategory subcategory) {
	    SqlSession session = MyBatisConfig.getSqlSessionFactory().openSession();
	    try {
	        session.insert("com.isaac.SubcategoryMapper.addSubcategory", subcategory);
	        session.commit();
	    } finally {
	        session.close();
	    }
	}
	public void editSubcategory(Subcategory subcategory) {
	    SqlSession session = MyBatisConfig.getSqlSessionFactory().openSession();
	    try {
	        session.update("com.isaac.SubcategoryMapper.updateSubcategory", subcategory);
	        session.commit();
	    } finally {
	        session.close();
	    }
	}
	public void deleteSubcategory(Integer id) {
	    SqlSession session = MyBatisConfig.getSqlSessionFactory().openSession();
	    try {
	        session.update("com.isaac.SubcategoryMapper.deleteSubcategory", id);
	        session.commit();
	    } finally {
	        session.close();
	    }
	}
	

}
