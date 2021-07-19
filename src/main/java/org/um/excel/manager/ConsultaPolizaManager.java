package org.um.excel.manager;

import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.um.excel.model.ASalFldg;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

public interface ConsultaPolizaManager {

        List<ASalFldg> poliza(Integer jrnalNo);

        ByteArrayInputStream polizaExcel(Integer jrnalNo) throws IOException;

}
