package cn.com.jinkang.module.standard.service.excelexportservice.impl;

import cn.com.jinkang.module.standard.service.excelexportservice.ExcelExportService;
import com.baomidou.mybatisplus.core.toolkit.BeanUtils;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import javax.servlet.http.HttpServletResponse;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class ExcelExportServiceImpl  implements ExcelExportService {
    @Override
    public <T> void exportExcel(List<T> dataList, List titleData, List Field, HttpServletResponse response) {
        //创建excel数据表格
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("数据");
        //设置表头
        createTitle(workbook,sheet,titleData);
        //循环数据写到excel中
        for (int i= 0; i<dataList.size();i++){
            HSSFRow row = sheet.createRow(i+1);

            Map<String, Object> map;
            Object obj=dataList.get(i);
            boolean ok;
            if(obj instanceof Map){
                map=(Map<String, Object>)obj;
                ok=true;
            }else{
                map= BeanUtils.beanToMap(obj);
                ok=false;
            }
            for (int j = 0; j < Field.size(); j++){
                String field = ExcelExportServiceImpl.toStr(Field.get(j));
                String value;
                if(ok){
                    value =ExcelExportServiceImpl.toStr(map.get(field.toUpperCase()));
                }else{
                    value=ExcelExportServiceImpl.toStr(map.get(field));
                }

                if (value!=null && !"".equals(value)){
                    row.createCell(j).setCellValue(value);
                }
            }
        }
        //时间戳命名文件名
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
        String format = df.format(new Date());
        String fileName = format + ".xls";

        try {
            //生成excel文件
            buildExcelFile(fileName, workbook);

            //浏览器下载excel
            buildExcelDocument(fileName,workbook,response);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    //生成表头
    public void createTitle(HSSFWorkbook workbook, HSSFSheet sheet,List titleData){
        HSSFRow row = sheet.createRow(0);
        //设置行高
        row.setHeightInPoints(18);
        //设置列宽度
        sheet.setColumnWidth(0,30*256);
        sheet.setColumnWidth(1,30*256);
        sheet.setColumnWidth(2,30*256);
        sheet.setColumnWidth(3,30*256);
        //设置为居中加粗
        HSSFCellStyle style = workbook.createCellStyle();
        HSSFFont font = workbook.createFont();
        font.setBold(true);
        style.setFont(font);
        style.setAlignment(HorizontalAlignment.CENTER);
        style.setVerticalAlignment(VerticalAlignment.CENTER);
        HSSFCell cell;
        //设置表头样式
        row.setRowStyle(style);
        //循环出表头信息
        for (int i = 0; i < titleData.size();i++){
            cell = row.createCell(i);
            cell.setCellValue(titleData.get(i)+"");
        }
    }
    //生成excel文件
    public void buildExcelFile(String filename,HSSFWorkbook workbook) throws Exception{
        FileOutputStream fos = new FileOutputStream(filename);
        workbook.write(fos);
        fos.flush();
        fos.close();
    }
    //浏览器下载excel
    public void buildExcelDocument(String filename, HSSFWorkbook workbook, HttpServletResponse response) throws Exception{
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-Disposition", "attachment;filename="+ URLEncoder.encode(filename, "utf-8"));
        OutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
        outputStream.flush();
        outputStream.close();
    }
    public static String toStr(Object str) {
        return toStr(str, "");
    }

    public static String toStr(Object str, String defaultValue) {
        return null == str ? defaultValue : String.valueOf(str);
    }
}

