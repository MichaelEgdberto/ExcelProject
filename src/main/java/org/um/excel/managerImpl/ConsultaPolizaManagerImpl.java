package org.um.excel.managerImpl;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.um.excel.dao.ASalFldgDao;
import org.um.excel.manager.ConsultaPolizaManager;
import org.um.excel.model.ASalFldg;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
@Service("ConsultaPolizaManager")
public class ConsultaPolizaManagerImpl implements ConsultaPolizaManager {


    @Autowired
    ASalFldgDao aSalFldgDao;

    @Override
    public List<ASalFldg> poliza(Integer jrnalNo) {
        return aSalFldgDao.buscaPoliza(jrnalNo);
    }


    @Override
    public ByteArrayInputStream polizaExcel(Integer jrnalNo) throws IOException {

        Workbook workbook = new HSSFWorkbook();

        CreationHelper createHelper = workbook.getCreationHelper();
        ByteArrayOutputStream stream = new ByteArrayOutputStream();

        Font headerFont = workbook.createFont();
        headerFont.setBoldweight(Font.BOLDWEIGHT_BOLD);
        //headerFont.setBold(true);
        headerFont.setFontName("Segoe UI");
        headerFont.setFontHeightInPoints((short) 10);

        Font contenidoFont = workbook.createFont();
        contenidoFont.setBoldweight(Font.BOLDWEIGHT_NORMAL);
        contenidoFont.setFontName("Segoe UI");
        contenidoFont.setFontHeightInPoints((short) 12);

        Font contenidoNum= workbook.createFont();
        contenidoNum.setFontName("Segoe UI");
        contenidoNum.setFontHeightInPoints((short) 12);



        CellStyle headerCellStyle = workbook.createCellStyle();
        headerCellStyle.setFont(headerFont);

        CellStyle contenidoCellStyle = workbook.createCellStyle();
        contenidoCellStyle.setFont(contenidoFont);

        CellStyle numericoStyle = workbook.createCellStyle();
        short format = (short) BuiltinFormats.getBuiltinFormat("#,##0.00");
        numericoStyle.setFont(contenidoNum);
        numericoStyle.setDataFormat(format);

        CellStyle fechaStyle = workbook.createCellStyle();
        fechaStyle.setDataFormat(createHelper.createDataFormat().getFormat("dd/mm/yyyy"));
        //short formatDate = (short) BuiltinFormats.getBuiltinFormat("dd/mm/yyyy");
        fechaStyle.setFont(contenidoFont);

        Sheet sheet = workbook.createSheet();

        int rownum =0;

        Row row = sheet.createRow(rownum);
        Cell cell = row.createCell(0);
        cell.setCellValue("UNIVERSIDAD DE MONTEMORELOS");
        sheet.addMergedRegion(new CellRangeAddress(rownum, rownum,0,5));
        cell.setCellStyle(headerCellStyle);


        rownum++;
        row = sheet.createRow(rownum);
        cell = row.createCell(0);
        cell.setCellValue("Libertad 1300 Pte." );
        sheet.addMergedRegion(new CellRangeAddress(rownum, rownum,0,5));
        //        cell.setCellValue("REPORTE FONDOS ASIGNADOS ");
        cell.setCellStyle(headerCellStyle);


        rownum++;
        row = sheet.createRow(rownum);
        cell = row.createCell(0);
        cell.setCellValue("Barrio Matamoros Montemorelos" );
        sheet.addMergedRegion(new CellRangeAddress(rownum, rownum,0,5));
        cell.setCellStyle(headerCellStyle);

        row = sheet.createRow(rownum);
        cell = row.createCell(8);
        cell.setCellValue("Fondo de operación [10]");
        cell.setCellStyle(headerCellStyle);


        rownum++;
        row = sheet.createRow(rownum);
        cell = row.createCell(0);
        cell.setCellValue("Nuevo Léon, México" );
        sheet.addMergedRegion(new CellRangeAddress(rownum, rownum,0,5));
        cell.setCellStyle(headerCellStyle);

        row = sheet.createRow(rownum);
        cell = row.createCell(8);
        cell.setCellValue("Código de cuenta ERSEBAR01");
        cell.setCellStyle(headerCellStyle);


        rownum++;
        row = sheet.createRow(rownum);
        cell = row.createCell(0);
        cell.setCellValue("Tel: +1(301) 680-6000 Fax: +1(301)680-6050" );
        sheet.addMergedRegion(new CellRangeAddress(rownum, rownum,0,5));
        cell.setCellStyle(headerCellStyle);

        row = sheet.createRow(rownum);
        cell = row.createCell(8);
        cell.setCellValue("Periodo 2020001 al 2020005");
        cell.setCellStyle(headerCellStyle);


        rownum++;
        row = sheet.createRow(rownum);
        cell = row.createCell(0);
        cell.setCellValue("ARTURO SEBASTIOAN ESCUDERO" );
        sheet.addMergedRegion(new CellRangeAddress(rownum, rownum,0,5));
        cell.setCellStyle(headerCellStyle);

        row = sheet.createRow(rownum);
        cell = row.createCell(8);
        cell.setCellValue(new Date());
        cell.setCellStyle(headerCellStyle);


        rownum++;
        row = sheet.createRow(rownum);
        cell = row.createCell(0);
        cell.setCellValue("9800289" );
        sheet.addMergedRegion(new CellRangeAddress(rownum, rownum,0,5));
        cell.setCellStyle(headerCellStyle);

        row = sheet.createRow(rownum);
        cell = row.createCell(8);
        cell.setCellValue("pagina");
        cell.setCellStyle(headerCellStyle);


        rownum++;
        row = sheet.createRow(rownum);
        cell = row.createCell(0);
        cell.setCellValue("FECHA");
        cell.setCellStyle(headerCellStyle);

        cell = row.createCell(1);
        cell.setCellValue("DIARIO");
        cell.setCellStyle(headerCellStyle);

        cell = row.createCell(2);
        cell.setCellValue("REFERENCIA");
        cell.setCellStyle(headerCellStyle);

        cell = row.createCell(3);
        cell.setCellValue("DESCRIPCIÓN");
        cell.setCellStyle(headerCellStyle);

//        cell = row.createCell(4);
//        cell.setCellValue("ANALT1");
//        cell.setCellStyle(headerCellStyle);
//
//        cell = row.createCell(5);
//        cell.setCellValue("ANALT2");
//        cell.setCellStyle(headerCellStyle);
//
//        cell = row.createCell(6);
//        cell.setCellValue("NO CUENTA");
//        cell.setCellStyle(headerCellStyle);
//
//        cell = row.createCell(7);
//        cell.setCellValue("CUENTA");
//        cell.setCellStyle(headerCellStyle);
////
////        cell = row.createCell(7);
////        cell.setCellValue("WHO");
////        cell.setCellStyle(headerCellStyle);
//
//        cell = row.createCell(8);
//        cell.setCellValue("DESCRIPCION");
//        cell.setCellStyle(headerCellStyle);

        cell = row.createCell(4);
        cell.setCellValue("DEBITO");
        cell.setCellStyle(headerCellStyle);

        cell = row.createCell(5);
        cell.setCellValue("CREDITO");
        cell.setCellStyle(headerCellStyle);

        List<ASalFldg> poliza = poliza(jrnalNo);

        BigDecimal bgDDeb = BigDecimal.ZERO;
        BigDecimal bgDCre = BigDecimal.ZERO;
        for(ASalFldg jrnal : poliza){
            rownum++;
            row = sheet.createRow(rownum);
            cell = row.createCell(0);
            cell.setCellValue(jrnal.getTransDatetime());
            cell.setCellStyle(fechaStyle);

            cell = row.createCell(1);
            cell.setCellValue(jrnal.getJrnalLine());
            cell.setCellStyle(contenidoCellStyle);

            cell = row.createCell(2);
            cell.setCellValue(jrnal.getJrnalType());
            cell.setCellStyle(contenidoCellStyle);

            cell = row.createCell(3);
            cell.setCellValue(jrnal.getVchrNum());
            cell.setCellStyle(contenidoCellStyle);

            cell = row.createCell(4);
            cell.setCellValue(jrnal.getAnalT1());
            cell.setCellStyle(contenidoCellStyle);

            cell = row.createCell(5);
            cell.setCellValue(jrnal.getAnalT2());
            cell.setCellStyle(contenidoCellStyle);

            cell = row.createCell(6);
            cell.setCellValue(jrnal.getAccntCode().getAcntCode());
            cell.setCellStyle(contenidoCellStyle);

            cell = row.createCell(7);
            cell.setCellValue(jrnal.getAccntCode().getDescr());
            cell.setCellStyle(contenidoCellStyle);

            cell = row.createCell(8);
            cell.setCellValue(jrnal.getDescriptn());
            cell.setCellStyle(contenidoCellStyle);


            if (jrnal.getAmount().compareTo(BigDecimal.ZERO) <0) {
                cell = row.createCell(9);
                cell.setCellValue(jrnal.getAmount().doubleValue());
                cell.setCellStyle(numericoStyle);
                bgDDeb = bgDDeb.add(jrnal.getAmount());
            } else {
                cell = row.createCell(10);
                cell.setCellValue(jrnal.getAmount().doubleValue());
                cell.setCellStyle(numericoStyle);
                bgDCre = bgDCre.add(jrnal.getAmount());
            }
        }
        rownum++;
        row = sheet.createRow(rownum);
        cell = row.createCell(6);
        cell.setCellValue("TOTAL DE EJECUCIÓN");
        cell.setCellStyle(headerCellStyle);

        cell = row.createCell(7);
        cell.setCellValue(bgDDeb.doubleValue());
        cell.setCellStyle(numericoStyle);

        cell = row.createCell(8);
        cell.setCellValue(bgDCre.doubleValue());
        cell.setCellStyle(numericoStyle);


        sheet.autoSizeColumn(0);
        sheet.autoSizeColumn(1);
        sheet.autoSizeColumn(2);
        sheet.autoSizeColumn(3);
        sheet.autoSizeColumn(4);
        sheet.autoSizeColumn(5);
        sheet.autoSizeColumn(6);
        sheet.autoSizeColumn(7);
        sheet.autoSizeColumn(8);
        sheet.autoSizeColumn(9);
        sheet.autoSizeColumn(10);

        workbook.write(stream);
        return new ByteArrayInputStream(stream.toByteArray());
    }
}