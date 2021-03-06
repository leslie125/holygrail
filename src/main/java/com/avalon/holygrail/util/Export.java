package com.avalon.holygrail.util;

import com.avalon.holygrail.excel.bean.SXSSFExcelWorkBookExport;
import com.avalon.holygrail.excel.norm.ExcelWorkBookExport;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;

/**
 * 导出
 * Created by 白超 on 2018/1/17.
 */
public interface Export {

    /**
     * 构建基于SXSSFWorkbook的Excel导出工作簿
     */
    static ExcelWorkBookExport buildSXSSFExportExcelWorkBook() {
        return new SXSSFExcelWorkBookExport();
    }

    /**
     * 构建基于SXSSFWorkbook的Excel导出工作簿
     * @param rowAccessWindowSize 数据量达到多少时写入磁盘(默认100)
     */
    static ExcelWorkBookExport buildSXSSFExportExcelWorkBook(int rowAccessWindowSize) {
        return new SXSSFExcelWorkBookExport(rowAccessWindowSize);
    }

    /**
     * 根据指定SXSSFWorkbook构建Excel导出工作簿
     * @param workbook
     */
    static ExcelWorkBookExport buildSXSSFExportExcelWorkBook(SXSSFWorkbook workbook) {
        return new SXSSFExcelWorkBookExport(workbook);
    }

}
