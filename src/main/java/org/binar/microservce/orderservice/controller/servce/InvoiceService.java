package org.binar.microservce.orderservice.controller.servce;

import net.sf.jasperreports.engine.JRException;
import org.binar.microservce.orderservice.request.FileDataDB;

public interface InvoiceService {
    FileDataDB generateFileInvoice(String filename) throws JRException;
}
