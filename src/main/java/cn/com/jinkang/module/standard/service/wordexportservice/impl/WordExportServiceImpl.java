package cn.com.jinkang.module.standard.service.wordexportservice.impl;

import cn.com.jinkang.module.standard.service.wordexportservice.WordExportService;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import freemarker.template.Configuration;
import freemarker.template.Template;
import org.springframework.stereotype.Service;

@Service
public class WordExportServiceImpl implements WordExportService {
    public Configuration configuration = null;
    @Override
    public String exportWord() {
        configuration = new Configuration();
        configuration.setDefaultEncoding("utf-8");
        createDoc();
        return "Success";
    }
    public void createDoc() {
        Map dataMap = new HashMap();
        dataMap.put("hello","你们大家好");
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

    /**
     * 浏览器下载文件
     * @param response http请求
     * @param varrealname 文件名
     * @param file 文件路劲
     */
    public void download(HttpServletResponse response,String varrealname,String file){
        try {
            //设置Http响应头告诉浏览器下载这个附件,下载的文件名也是在这里设置的
            response.setContentType("application/vnd.ms-excel");
            //文件名
            response.setHeader("Content-Disposition", "attachment;filename="+ URLEncoder.encode(varrealname, "utf-8"));
            byte[] bytes = new byte[2048];
            FileInputStream fis = null;
            BufferedInputStream bis = null;
            //文件路劲
            fis = new FileInputStream(file);
            bis = new BufferedInputStream(fis);
            OutputStream os = response.getOutputStream();
            int len = 0;
            while ((len = bis.read(bytes)) > 0) {
                os.write(bytes, 0, len);
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
