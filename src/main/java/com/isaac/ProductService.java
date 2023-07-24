package com.isaac;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;


@Service
public class ProductService {
	
	public Products getProductById(Integer id) {
	    SqlSession session = MyBatisConfig.getSqlSessionFactory().openSession();
	    try {
	        Products product = (Products) session.selectOne("com.isaac.ProductMapper.getProductById", id);
	        return product;
	    } finally {
	        session.close();
	    }
	}


	public List<Products> getAllProducts() {
		  SqlSession session = MyBatisConfig.getSqlSessionFactory().openSession();
		  try {
		    @SuppressWarnings("unchecked")
			List<Products> products = session.selectList("com.isaac.ProductMapper.getAllProducts");
		    return products;
		  } finally {
		    session.close();
		  }
		}

	
	public void addProduct(Products product) {
	    SqlSession session = MyBatisConfig.getSqlSessionFactory().openSession();
	    try {
	        session.insert("com.isaac.ProductMapper.addProduct", product);
	        session.commit();
	    } finally {
	        session.close();
	    }
	}
	public void editProduct(Products product) {
	    SqlSession session = MyBatisConfig.getSqlSessionFactory().openSession();
	    try {
	        session.update("com.isaac.ProductMapper.updateProduct", product);
	        session.commit();
	    } finally {
	        session.close();
	    }
	}
	public void deleteProduct(Integer id) {
	    SqlSession session = MyBatisConfig.getSqlSessionFactory().openSession();
	    try {
	        session.update("com.isaac.ProductMapper.deleteProduct", id);
	        session.commit();
	    } finally {
	        session.close();
	    }
	}
	}

