package com.sales.api.salesAPI;

import com.sales.api.salesAPI.model.Sale;
import com.sales.api.salesAPI.controller.SaleController;
import com.sales.api.salesAPI.repository.SaleRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class SalesApiApplicationTests {
    @Autowired
    private SaleRepository saleRepository;

    @Test
    public void testCreateSale() {
        Sale sale = new Sale();
        sale.setSellerName("John Doe");
        sale.setTotal(100.0);
        sale.setDate(LocalDate.now());

        Sale savedSale = saleRepository.save(sale);

        assertNotNull(savedSale);
        assertEquals("John Doe", savedSale.getSellerName());
    }

    @Test
    public void testGetAllSales() {
        Sale sale1 = new Sale();
        sale1.setSellerName("John Doe");
        sale1.setTotal(100.0);
        sale1.setDate(LocalDate.now());

        Sale sale2 = new Sale();
        sale2.setSellerName("Jane Doe");
        sale2.setTotal(200.0);
        sale2.setDate(LocalDate.now());

        saleRepository.save(sale1);
        saleRepository.save(sale2);

        List<Sale> sales = saleRepository.findAll();

        assertNotNull(sales);
        assertEquals(2, sales.size());
    }
}