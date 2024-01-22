
package com.example.Cataloguemicroservice.Services.Variety;

import com.example.Cataloguemicroservice.Entities.Product;
import com.example.Cataloguemicroservice.Entities.Variety;
import com.example.Cataloguemicroservice.Exceptions.MyEntityNotFoundException;
import com.example.Cataloguemicroservice.Repository.ProductRepository;
import com.example.Cataloguemicroservice.Repository.VarietyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class VarietyServiceImpl implements VarietyService{

    private VarietyRepository varietyRepository;
    private  ProductRepository productRepository;
    @Autowired
    public VarietyServiceImpl(VarietyRepository varietyRepository,ProductRepository productRepository) {
        this.varietyRepository = varietyRepository;
        this.productRepository = productRepository;
    }

    @Override
    public void delVarietys(List<Long> ids) {

        for (Long i:ids){
            varietyRepository.deleteById(i);
        }
    }
    @Override
    public List<Variety> getVarietys() {
        return varietyRepository.findAll();
    }

    @Override
    public void deleteVariety(Long id) {
        varietyRepository.deleteById(id);
    }

    @Override
    public void deleteVarietyByCheck(Long id) throws MyEntityNotFoundException {
        Variety varietyByID = getVarietyByID(id);
         List<Product> allByVarietiesIsEmpty = productRepository.findAllByVarietiesIsEmpty();

    }

    @Override
    public Variety getVarietyByID(long id) throws MyEntityNotFoundException {
        return varietyRepository.findById(id).orElseThrow(()-> new MyEntityNotFoundException("Variaty not found for id:"+id));
    }

    public Variety updateVariety(long id, Variety newVariety) throws MyEntityNotFoundException {
        Variety variety = varietyRepository.findById(id).orElseThrow(()->
                new MyEntityNotFoundException("Variety not found to update for ID: " + id));
        variety.setVarietyName(newVariety.getVarietyName());
        variety.setVarietyValue(newVariety.getVarietyValue());
        variety.setQuantity(newVariety.getQuantity());
        variety.setProducts(newVariety.getProducts());

        return varietyRepository.save(variety);
    }

    @Override
    public Variety createVariety(Variety variety) {
        return varietyRepository.save(variety);
    }
}
