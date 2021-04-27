package cn.com.jinkang.module.standard.service.excelexportservice;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

public interface ExcelExportService {
    /**
     * 导出excel
     * @param dataList  数据
     * @param titleData 标题
     * @param Field 标题与数据库字段对应
     * @param response
     * @param <T>
     */
    <T> void exportExcel(List<T> dataList, List titleData, List Field, HttpServletResponse response);
}
