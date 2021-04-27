package cn.com.jinkang.module.standard.util.test;


import freemarker.template.Configuration;
import freemarker.template.Template;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class test {
    public Configuration configuration = null;

    @Test
    public void exportTest() {
//        Configuration configuration = null;
        configuration = new Configuration();
        configuration.setDefaultEncoding("utf-8");
//        WordExportSvc dh=new WordExportSvc();
        createDoc();
        System.out.println("end");

    }

    public void createDoc() {
        Map dataMap = new HashMap();
        dataMap.put("hello","大家好");
        try {
            configuration.setDirectoryForTemplateLoading(new File("d:/word"));
        }catch (Exception e){
            e.printStackTrace();
        }

//        configuration.setClassForTemplateLoading(this.getClass(),"D:\\word");
        Template t = null;
        // 输出文档路径及名称
        File outFile = new File("D:/word/aa/test.doc");
        Writer out = null;

        try {
            // test.ftl为要装载的模板
            t = configuration.getTemplate("test.ftl");
            t.setEncoding("utf-8");

            out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile), "utf-8"));
            t.process(dataMap, out);
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

