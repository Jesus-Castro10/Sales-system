package com.educastro.sales.service;

import com.educastro.sales.model.Sale;
import com.educastro.sales.model.SaleDetails;
import com.educastro.sales.repository.SaleRepository;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import static com.educastro.sales.util.SaleFunctions.*;

@Service
public class SaleService implements ISaleService{

    @Autowired
    private SaleRepository saleRepository;

    @Override
    public List<Sale> toListSale() {
        return saleRepository.findAll();
    }

    @Override
    public Sale findSaleById(Integer idSale) {
        return saleRepository.findById(idSale).orElse(null);
    }

    @Override
    public void saveSale(Sale sale) {
        saleRepository.save(sale);
    }

    @Override
    public void deleteSale(Sale sale) {
        saleRepository.delete(sale);
    }

    public byte[] generateInvoice(Sale sale) throws JRException {
        List<SaleDetails> list = new ArrayList<>();
        if (sale != null){
            list = recoveryProducts(sale);
        }
        // Load the report template
        InputStream reportTemplate = getClass().getResourceAsStream("/reports/Invoice.jrxml");
        // Compile the report template
        JasperReport jasperReport = JasperCompileManager.compileReport(reportTemplate);
        // Convert the list of employees to a JRBeanCollectionDataSource
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(list);
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, dataSource);
        // Export the report to a byte array (PDF format)
        return JasperExportManager.exportReportToPdf(jasperPrint);
    }
}
