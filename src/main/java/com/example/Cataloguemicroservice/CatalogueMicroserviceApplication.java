package com.example.Cataloguemicroservice;

import com.example.Cataloguemicroservice.Entities.Category;
import com.example.Cataloguemicroservice.Entities.Product;
import com.example.Cataloguemicroservice.Entities.Supplier;
import com.example.Cataloguemicroservice.Entities.Variety;
import com.example.Cataloguemicroservice.Services.Category.CategoryService;
import com.example.Cataloguemicroservice.Services.ProductService;
import com.example.Cataloguemicroservice.Services.Variety.VarietyService;
import com.example.Cataloguemicroservice.Services.supplier.SupplierService;
import com.example.Cataloguemicroservice.transformers.SupplierTransformer;
import jakarta.persistence.Column;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;



@SpringBootApplication
@EnableAsync
@Slf4j
public class CatalogueMicroserviceApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(CatalogueMicroserviceApplication.class, args);
		System.out.println(" Catalogue Microservice is running...");
		//System.out.println(Runtime.getRuntime().availableProcessors());
	}

	@Autowired
	private  SupplierService supplierService;
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private VarietyService varietyService;
	/*@Autowired
	private ProductService productService;*/
	@Override
	public void run(String... args) throws Exception {

		if (supplierService.getSuppliers().isEmpty()){
			Supplier supplier=new Supplier();
			supplier.setNomSupplier("default supplier");
			supplier.setMail("default supplier");
			supplier.setRib("default supplier");
			supplier.setPhoneNumber("default supplier");
			supplierService.createSupplier(SupplierTransformer.transformToDTO(supplier));
		}
		if (categoryService.getCategorys().isEmpty()){
			Category category=new Category();
			category.setNomCategory("default category");
			categoryService.createCategory(category);
		}

		if (varietyService.getVarietys().isEmpty()){
			Variety variety1=new Variety();
			variety1.setVarietyName("size");
			variety1.setVarietyValue("S");
			varietyService.createVariety(variety1);

			Variety variety2=new Variety();
			variety2.setVarietyName("size");
			variety2.setVarietyValue("M");
			varietyService.createVariety(variety2);

			Variety variety3=new Variety();
			variety3.setVarietyName("size");
			variety3.setVarietyValue("L");
			varietyService.createVariety(variety3);
		}


	}
}
