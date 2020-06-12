package com.excel.easyExcel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.Sheet;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.*;

/**
 * String类型使用
 * 参考：https://blog.csdn.net/qq_32258777/article/details/89031479
 */
public class EasyExcelTest {
    private static Logger logger = LoggerFactory.getLogger(EasyExcelTest.class);

    private static Sheet initSheet;

    static {
        initSheet = new Sheet(1, 0);
        initSheet.setSheetName("sheet");
        //设置自适应宽度
        initSheet.setAutoWidth(Boolean.TRUE);
    }

    public static void main(String[] args) {
        List<String> nickNames = new ArrayList<>();
        for (int i = 0; i <= 10000 ; i++) {
            nickNames.add(getStringRandom(12));
        }
        simpleWrite(nickNames);
    }

    public static void simpleWrite(List<String> list) {
        // 写法1
        //String fileName = "/Users/h/Downloads/nickName.xlsx";
        // 这里 需要指定写用哪个class去写，然后写到第一个sheet，名字为模板 然后文件流会自动关闭
        // 如果这里想使用03 则 传入excelType参数即可
        //EasyExcel.write(fileName).sheet().needHead(false).doWrite(list);
        String filePath = "/Users/h/Downloads/nickName5.xlsx";
        List<List<String>> data = new ArrayList<>();
        data.add(list);
        //data.add(Arrays.asList("111","222","333"));
        //data.add(Arrays.asList("111","222","333"));
        List<String> head = Arrays.asList("表头1");

        Sheet sheet = initSheet;

        if(head != null){
            List<List<String>> list1 = new ArrayList<>();
            head.forEach(h -> list1.add(Collections.singletonList(h)));
            sheet.setHead(list1);
        }

        OutputStream outputStream = null;
        ExcelWriter writer = null;
        try {
            outputStream = new FileOutputStream(filePath);
            writer = EasyExcelFactory.getWriter(outputStream);
            writer.write1(data,sheet);
        } catch (FileNotFoundException e) {
            logger.error("找不到文件或文件路径错误, 文件：{}", filePath);
        }finally {
            try {
                if(writer != null){
                    writer.finish();
                }

                if(outputStream != null){
                    outputStream.close();
                }

            } catch (IOException e) {
                logger.error("excel文件导出失败, 失败原因：{}", e);
            }
        }
    }

    //生成随机用户名，数字和字母组成,
    public static String getStringRandom(int length) {

        String val = "";
        Random random = new Random();

        //参数length，表示生成几位随机数
        for(int i = 0; i < length; i++) {

            String charOrNum = random.nextInt(2) % 2 == 0 ? "char" : "num";
            if (i < 3) {
                charOrNum = "char";
            } else if (i > 9) {
                charOrNum = "num";
            }
            //输出字母还是数字
            if( "char".equalsIgnoreCase(charOrNum) ) {
                //输出是大写字母还是小写字母
                //int temp = random.nextInt(2) % 2 == 0 ? 65 : 97;
                int temp = 97;
                if (i == 0 || i == 9) {
                    temp = 65;
                }
                val += (char)(random.nextInt(26) + temp);
            } else if( "num".equalsIgnoreCase(charOrNum) ) {
                val += String.valueOf(random.nextInt(10));
            }
            if (i == 2) {
                val = val + "_";
            }
        }
        return val;
    }

    public static void writeSimpleBySheet(String filePath, List<List<Object>> data, List<String> head, Sheet sheet){
        sheet = (sheet != null) ? sheet : initSheet;

        if(head != null){
            List<List<String>> list = new ArrayList<>();
            head.forEach(h -> list.add(Collections.singletonList(h)));
            sheet.setHead(list);
        }

        OutputStream outputStream = null;
        ExcelWriter writer = null;
        try {
            outputStream = new FileOutputStream(filePath);
            writer = EasyExcelFactory.getWriter(outputStream);
            writer.write1(data,sheet);
        } catch (FileNotFoundException e) {
            logger.error("找不到文件或文件路径错误, 文件：{}", filePath);
        }finally {
            try {
                if(writer != null){
                    writer.finish();
                }

                if(outputStream != null){
                    outputStream.close();
                }

            } catch (IOException e) {
                logger.error("excel文件导出失败, 失败原因：{}", e);
            }
        }

    }
}
