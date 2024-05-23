package com.sales.api.salesAPI;

import com.sales.api.salesAPI.model.Sale;
import com.sales.api.salesAPI.service.SaleService;
import com.sales.api.salesAPI.repository.SaleRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class SalesApiApplicationTests {
    @InjectMocks
    private SaleService saleService;

    @Mock
    private SaleRepository saleRepository;

    public void SaleServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreateSale() {
        Sale sale = new Sale();
        sale.setId(1L);
        sale.setSaleDate(LocalDate.now());
        sale.setValue(100.0);
        sale.setSellerId(1L);
        sale.setSellerName("John Doe");

        when(saleRepository.save(sale)).thenReturn(sale);

        Sale createdSale = saleService.createSale(sale);

        assertEquals(sale, createdSale);
    }

    @Test
    public void testGetAllSales() {
        Sale sale1 = new Sale();
        sale1.setId(1L);
        sale1.setSaleDate(LocalDate.now());
        sale1.setValue(100.0);
        sale1.setSellerId(1L);
        sale1.setSellerName("John Doe");

        Sale sale2 = new Sale();
        sale2.setId(2L);
        sale2.setSaleDate(LocalDate.now());
        sale2.setValue(200.0);
        sale2.setSellerId(2L);
        sale2.setSellerName("Jane Doe");

        when(saleRepository.findAll()).thenReturn(Arrays.asList(sale1, sale2));

        List<Sale> sales = saleService.getAllSales();

        assertEquals(2, sales.size());
        assertEquals(sale1, sales.get(0));
        assertEquals(sale2, sales.get(1));
    }
}