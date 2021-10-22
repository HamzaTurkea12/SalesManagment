package com.testhamza.hamza;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SaleService {
    @Autowired
    private SaleRepository repo2;

    public List<Sale> listAll() {
        return repo2.findAll();
    }

    public void save(Sale sale) {
        repo2.save(sale);
    }

    public Sale get(int id) {
        return repo2.findById(id).get();
    }

    void checkout(String saleHeaderNumber) {

    }
}
