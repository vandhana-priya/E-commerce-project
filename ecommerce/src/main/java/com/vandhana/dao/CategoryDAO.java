package com.vandhana.dao;

import java.util.List;

import com.vandhana.model.Category;

public interface CategoryDAO {
	public void addCategory(Category category);
    public Category getCategoryById(int id); 
    public List<Category> getAllCategory();
    public void delete(int id);
}
