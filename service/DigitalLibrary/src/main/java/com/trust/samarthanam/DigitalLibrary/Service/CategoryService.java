package com.trust.samarthanam.DigitalLibrary.Service;

import com.trust.samarthanam.DigitalLibrary.Model.Books;
import com.trust.samarthanam.DigitalLibrary.Model.Category;
import com.trust.samarthanam.DigitalLibrary.dao.BooksRepo;
import com.trust.samarthanam.DigitalLibrary.dao.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CategoryService {


    @Autowired
    private CategoryRepo categoryRepo;
//--------------------------------------- list all categories-----------------------------------------------------------

    public List<Category> listAll() {
        return categoryRepo.findAll();
    }


//----------------------------------------list all categories ----------------------------------------------------------
    public ArrayList<String> listCategory() {
        ArrayList<String> categories=new ArrayList<String>();
        List<Category> l = categoryRepo.findAll();
        for(Category category: l ){
            categories.add(category.getCategory());
        };
        return categories;
    }


//---------------------------------------list all subcategories of a main category--------------------------------------
    public List<String> listSubCategory(String key) {
        ArrayList<String> subCategories=new ArrayList<String>();
        List<Category> l = categoryRepo.findAll();


        for(Category category: l ){
            if(category.getCategory().equals(key)){
                subCategories.add(category.getSubCategory());
            }
        }
        return subCategories;
    }
}
