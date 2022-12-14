package org.binar.microservce.orderservice.controller;


import lombok.extern.slf4j.Slf4j;
import net.sf.jasperreports.engine.JRException;
import org.binar.microservce.orderservice.request.FileDataDB;
import org.binar.microservce.orderservice.controller.servce.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@Slf4j
@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/invoice")
public class InvoiceController {

    @Autowired
    InvoiceService invoiceService;

    @GetMapping("/downloadFile")
    public ResponseEntity<?> fileDownloadJasper(@RequestParam(value = "filename") String filename) throws IOException,  JRException {
          try{
              FileDataDB fileDataDB = invoiceService.generateFileInvoice(filename);
              log.info(fileDataDB+"file ada");
              return ResponseEntity.ok().contentType(MediaType.parseMediaType(fileDataDB.getFileType()))
              .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename\"" + filename + "\"")
              .body(new ByteArrayResource(fileDataDB.getData()));
          }catch(JRException e){
              log.error("file not found" + e.getMessage());
              return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
          }

    }
}


