package com.avalon.holygrail.excel.norm;

import com.avalon.holygrail.excel.exception.ExcelException;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Excel导入工作簿
 * Created by 白超 on 2018/1/24.
 */
public interface ExcelWorkBookImport extends ExcelWorkBook {

    /**
     * 解析文件
     *
     * @param inputStream 输入流
     * @return
     * @throws IOException
     */
    ExcelWorkBookImport parseFile(InputStream inputStream) throws IOException;

    @Override
    ExcelSheetImport getSheet(int index);

    /**
     * 解析文件
     *
     * @param file 文件
     * @return
     * @throws IOException
     */
    default ExcelWorkBookImport parseFile(File file) throws IOException {
        return this.parseFile(new FileInputStream(file));
    }

    /**
     * 解析文件
     *
     * @param path 文件路径
     * @return
     * @throws IOException
     */
    default ExcelWorkBookImport parseFile(String path) throws IOException {
        return this.parseFile(new File(path));
    }

    @FunctionalInterface
    interface HandlerSheetA {
        /**
         * 接收当前读取的Sheet
         *
         * @param sheet 读取的Sheet
         * @param index 当前Sheet下标
         */
        void accept(ExcelSheetImport sheet, int index) throws IOException, ExcelException, InstantiationException, IllegalAccessException;
    }

    @FunctionalInterface
    interface HandlerSheetB {

        /**
         * 接收当前读取的Sheet,返回false不继续读取
         *
         * @param sheet 读取的Sheet
         * @param index 当前Sheet下标
         * @return
         */
        boolean apply(ExcelSheetImport sheet, int index) throws ExcelException, IllegalAccessException, InstantiationException, IOException;
    }

    /**
     * 批量读取Sheet
     *
     * @param handlerSheet 操作读取的Sheet
     * @return
     * @throws IOException
     * @throws ExcelException
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    default ExcelWorkBookImport readSheets(HandlerSheetA handlerSheet) throws IOException, ExcelException, IllegalAccessException, InstantiationException {
        int totalSheetSize = this.getSheetSize();
        for (int i = 0; i < totalSheetSize; i++) {
            ExcelSheetImport sheet = this.getSheet(i);
            handlerSheet.accept(sheet, i);
        }
        return this;
    }

    /**
     * 批量读取Sheet
     *
     * @param handlerSheet 操作读取的Sheet,返回false不继续读取
     * @return
     */
    default ExcelWorkBookImport readSheets(HandlerSheetB handlerSheet) throws IOException, ExcelException, IllegalAccessException, InstantiationException {
        int totalSheetSize = this.getSheetSize();
        for (int i = 0; i < totalSheetSize; i++) {
            ExcelSheetImport sheet = this.getSheet(i);
            boolean goon = handlerSheet.apply(sheet, i);
            if (!goon) {
                break;
            }
        }
        return this;
    }
}
