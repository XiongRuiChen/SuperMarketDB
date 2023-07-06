package com.cssl.view;

import com.cssl.pojo.Smbms_bill;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.view.document.AbstractXlsView;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

public class ExcelView extends AbstractXlsView {
    @Override
    protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request, HttpServletResponse response) throws Exception {
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;charset=UTF-8");
        //设置下载后的文件名
        String fileName = "AllBills.xlsx";
        //设置下载头
        response.setHeader("Content-Disposition", "inline; filename=" + fileName);
        //从model中取出查询到的数据
        List<Smbms_bill> list = (List<Smbms_bill>) model.get("data");
        //创建sheet表
        Sheet sheet = workbook.createSheet("订单表");
        //创建行
        Row firstRow = sheet.createRow(0);
        //设置首行单元格信息
        Cell firstRowfirstCell = firstRow.createCell(0);
        firstRowfirstCell.setCellValue("序号");

        Cell firstRowfirstCel2 = firstRow.createCell(1);
        firstRowfirstCel2.setCellValue("订单编码");

        Cell firstRowfirstCel3 = firstRow.createCell(2);
        firstRowfirstCel3.setCellValue("商品名称");

        Cell firstRowfirstCel4 = firstRow.createCell(3);
        firstRowfirstCel4.setCellValue("供应商");

        Cell firstRowfirstCel5 = firstRow.createCell(4);
        firstRowfirstCel5.setCellValue("订单金额");

        Cell firstRowfirstCel6 = firstRow.createCell(5);
        firstRowfirstCel6.setCellValue("是否付款");

        Cell firstRowfirstCel7 = firstRow.createCell(6);
        firstRowfirstCel7.setCellValue("创建时间");

        //循环生产数据
        for (int i = 0; i < list.size(); i++) {
            Smbms_bill bill = list.get(i);
            Row row = sheet.createRow(i + 1);
            row.createCell(0).setCellValue(i + 1);
            row.createCell(1).setCellValue(bill.getBillCode());
            row.createCell(2).setCellValue(bill.getProductName());
            row.createCell(3).setCellValue(bill.getSmbmsProvider().getProName());
            row.createCell(4).setCellValue(bill.getTotalPrice().doubleValue());
            row.createCell(5).setCellValue(bill.getIsPayment());
            row.createCell(6).setCellValue(bill.getCreationDate());
        }
        ServletOutputStream out = response.getOutputStream();
        workbook.write(out);
        System.out.println("下载ok");
        out.flush();
        out.close();
    }
}
//git config --global user.name "KarxiX"
// git config --global user.email  "xiangshuo1992@gmail.com"