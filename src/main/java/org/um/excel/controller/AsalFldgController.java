package org.um.excel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.um.excel.manager.ConsultaPolizaManager;
import org.um.excel.model.ASalFldg;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
//@RequestMapping("/consultas/api/")
public class AsalFldgController {

    @Autowired
    ConsultaPolizaManager consultaPolizaManager;

    @GetMapping(value= "/poliza/{jrnalNo}/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> consultaPoliza(@PathVariable("jrnalNo") Integer jrnalNo){

        List<ASalFldg> lsDatos = new ArrayList<>();
        lsDatos = consultaPolizaManager.poliza(jrnalNo);
        return new ResponseEntity<List<ASalFldg>>(lsDatos, HttpStatus.OK);

    }

    @GetMapping(value= "/polizaB/{jrnalNo}/")
    public ResponseEntity <InputStreamResource> polizaExcell (@PathVariable("jrnalNo") Integer jrnalNo) throws IOException {

        ByteArrayInputStream stream = consultaPolizaManager.polizaExcel(jrnalNo) ;
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment; filename=poliza_"+jrnalNo+"-.xls");
        return ResponseEntity.ok().headers(headers).body(new InputStreamResource(stream));

    }

}
