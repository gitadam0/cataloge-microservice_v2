package com.example.Cataloguemicroservice.Controller;

import com.example.Cataloguemicroservice.DTO.SupplierDTO;
import com.example.Cataloguemicroservice.Entities.Supplier;
import com.example.Cataloguemicroservice.Exceptions.MyEntityNotFoundException;
import com.example.Cataloguemicroservice.Services.supplier.SupplierService;
import com.example.Cataloguemicroservice.jms.MessageSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/suppliers")
public class SupplierController {

    private final SupplierService supplierService;

    public SupplierController(SupplierService supplierService) {
        this.supplierService = supplierService;
    }

    @GetMapping
    public List<SupplierDTO> getSuppliers() {
        return supplierService.getSuppliers();
    }

    @GetMapping("/{id}")
    public SupplierDTO getSupplierByID(@PathVariable Long id) throws MyEntityNotFoundException {
        return supplierService.getSupplierById(id);
    }
    @GetMapping("getSupplierByIdWithProducts./{id}")
    public Supplier getSupplierByIDWithProducts(@PathVariable Long id) throws MyEntityNotFoundException {
        return supplierService.getSupplierProducts(id);
    }
    @Autowired
    MessageSender messageSender;
    @PostMapping
    public SupplierDTO createSupplier(@RequestBody SupplierDTO supplier) throws MyEntityNotFoundException {
        SupplierDTO supplierDTO= supplierService.createSupplier(supplier);
        messageSender.sendSupplier(supplierDTO);
        return supplierDTO;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteSupplier(@PathVariable Long id) {
        supplierService.deleteSupplier(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public SupplierDTO updateSupplier(@PathVariable Long id, @RequestBody SupplierDTO supplier) throws MyEntityNotFoundException {
        return supplierService.updateSupplier(id, supplier);
    }
}
