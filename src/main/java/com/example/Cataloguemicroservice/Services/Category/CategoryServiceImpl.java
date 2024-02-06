package com.example.Cataloguemicroservice.Services.Category;
import com.example.Cataloguemicroservice.Entities.Category;
import com.example.Cataloguemicroservice.Entities.Product;
import com.example.Cataloguemicroservice.Exceptions.MyEntityNotFoundException;
import com.example.Cataloguemicroservice.Repository.CategoryRepository;
import com.example.Cataloguemicroservice.Repository.ProductRepository;
import com.example.Cataloguemicroservice.Services.ProductService;
import com.example.Cataloguemicroservice.Services.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    private CategoryRepository categoryRepository;
    private ProductRepository productRepository;
    @Autowired
    public  CategoryServiceImpl(CategoryRepository categoryRepository,ProductRepository productRepository) {
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
    }
    @Override
    public List<Category> getCategorys() {
        return categoryRepository.findAll();
    }
    /*@Override
    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }*/
    //
    //this function will delete the category and give all
    //product that had it a default category
    //
    @Override
    public void deleteCategory(Long id)  {
        //make sure to set id of default category
        Category defaultCategory = null;
        try {
            defaultCategory = categoryRepository.findById(1L)
                    .orElseThrow(()->new MyEntityNotFoundException(" default category not found for id:"+ 1
                            +"for this code to work you have to have a deafult category with id = 1"));
        } catch (MyEntityNotFoundException e) {
            throw new RuntimeException(e);
        }

        //fetch category for delete
        //Optional<Category> optionalCategory = categoryRepository.findById(id);
        Category categoryToDel = null;
        try {
            categoryToDel = categoryRepository.findById(id)
                    .orElseThrow(()->new MyEntityNotFoundException("category to delete not found for id:"+id));
        } catch (MyEntityNotFoundException e) {
            throw new RuntimeException(e);
        }
        // Get the products associated with the category to be deleted
        List<Product> products = categoryToDel.getProducts();
        // Set the default category
        for (Product product : products) {
            product.setCategory(defaultCategory);
        }
        // Save the products with deafult categorys
        //productRepository.createProducts(ProductTransformer.transformListToDTOList(products));
        productRepository.saveAll(products);
        //delete the category
        categoryRepository.deleteById(id);

    }
    public Category getCategoryByID(long id) throws MyEntityNotFoundException {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new MyEntityNotFoundException("Category not found for ID: " + id));
    }
    @Override
    public Category updateCategory(long id,Category newCategory) throws MyEntityNotFoundException {
        Category category = categoryRepository.findById(id).orElseThrow(()->
                new MyEntityNotFoundException("Category not found to update for ID: " + id));
        category.setNomCategory(newCategory.getNomCategory());
        return categoryRepository.save(category);
    }

    @Override
    public Category createCategory(Category catalogue) {
        return categoryRepository.save(catalogue);
    }

}
