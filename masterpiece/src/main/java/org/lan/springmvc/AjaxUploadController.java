package org.lan.springmvc;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

@Controller
@RequestMapping("/tmpInfo") 
public class AjaxUploadController {
	@RequestMapping("/input")
    public String input(){
	    return "redirect:/static/jsp/ajaxUpload2.jsp";
    }

	
    @RequestMapping(value = "/method2")
    @ResponseBody
    public String method2(@RequestParam( required=true) MultipartFile uploadFile,
                          @RequestParam String messageContent, HttpServletRequest request) {
            //多个参数的话只要多个@RequestParam即可，注意参数名要和表单里面的属性名一致
     JSONObject json =new JSONObject();
     StringBuffer sbr=null;
     System.out.println(messageContent);
        // 获得原始文件名
        String orgiginalFileName = uploadFile.getOriginalFilename();
        System.out.println("原始文件名:" + orgiginalFileName);

        // 新文件名
        String newFileName = UUID.randomUUID() + orgiginalFileName;

        // 获得项目的路径
        ServletContext sc = request.getSession().getServletContext();
        System.out.println("<**************************************************>");
        System.out.println("request.getRequestURI()="+request.getRequestURI());
        System.out.println("request.getRequestURL()="+request.getRequestURL() );
        System.out.println("request.getContextPath()="+request.getContextPath() );
        System.out.println("request.getRealPath(\"\")="+request.getRealPath("") );
        System.out.println("<**************************************************>");

        // 上传位置
        String path = sc.getRealPath("\\upload") + "\\"; // 设定文件保存的目录

        //获得文件类型（可以判断如果不是图片，禁止上传）
        String contentType=uploadFile.getContentType();
        //获得文件后缀名称
        String ext=contentType.substring(contentType.indexOf("/")+1);

        File newFile = new File(path+ newFileName);
        sbr=new StringBuffer(path+ newFileName);
        if (!newFile.exists())
            newFile.mkdirs();
        try {

            uploadFile.transferTo(newFile);


            InputStream inputStream = uploadFile.getInputStream();
            String content = uploadFile.getContentType();
            String fileName=uploadFile.getName();
            orgiginalFileName = uploadFile.getOriginalFilename();
           System.out.println("fileName: "+fileName+", inputStream: "+ inputStream  
                        +"\r\n content: "+content+", orgiginalFileName: ="+ orgiginalFileName  
                        +"\r\n projectName: ");      
        } catch (IOException e) {
            e.printStackTrace();  
        }
        json.put("flag", true);
        json.put("message", "success");
        json.put("testString","返回汉字测试中文乱码");
        json.put("ext",ext);
        if (ext.equalsIgnoreCase("jpeg")) { json.put("url",sbr.toString());}
        System.out.println(json.toJSONString());

        return json.toJSONString();  
    }  
}
