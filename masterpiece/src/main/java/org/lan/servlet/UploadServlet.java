package org.lan.servlet;

import org.lan.exception.ExtException;
import org.lan.exception.NullFileException;
import org.lan.pojo.UploadItemInfo;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.*;

public class UploadServlet extends HttpServlet {
 
	private static final long serialVersionUID = -3249585793061278229L;
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
    	List<UploadItemInfo> uploadInfos=new ArrayList<>();
    	
        //判断请求类型是否是"multipart/form-data"类型
        boolean isMultipart = ServletFileUpload.isMultipartContent(req);
        //创建上传路径
        String uploadFilePath = req.getSession().getServletContext().getRealPath("/upload");
        //创建缓存路径
        String tempFilePath = req.getSession().getServletContext().getRealPath("/temp");
        
        //System.out.println(uploadFilePath);
        //创建一个集合，封装限制上传文件类型数据
        List<String> exts = Arrays.asList("jpg", "bmp", "jar", "txt", "avi", "pdf", "exe", "xml","zip","rar","mp4");
        //创建临时文件夹
        File tempDirectory = new File(tempFilePath);
        if (!tempDirectory.exists()) {
            tempDirectory.mkdirs();
        }
        if (isMultipart) {
        	
            //为基于磁盘的文件项目创建一个工厂
            DiskFileItemFactory factory = new DiskFileItemFactory();
            //设置工厂约束
            factory.setSizeThreshold(4096);
            //设置缓冲文件夹路径
            factory.setRepository(tempDirectory);
            //创建一个新的文件上传处理程序
            ServletFileUpload upload = new ServletFileUpload(factory);
           
            //设置解析器的字符集
            upload.setHeaderEncoding("UTF-8");
            //设置单个上传文件最大容量
            upload.setFileSizeMax(1024 * 1024 * 1024 * 5);
            //设置多个上传文件最大容量
            upload.setSizeMax(1024 * 1024 * 1024 * 10);
            //解析form表单提交的数据，返回一个FileItem实例的集合
            List<FileItem> items = null;
            try {
                items = upload.parseRequest(req);
            } catch (FileUploadException e) {
                e.printStackTrace();
            }
            System.out.println(items.size());
            for(FileItem fi:items) {
            	System.out.println(fi);
            }
            //处理上传的项目
            Iterator<FileItem> iter = items.iterator();
         
            while (iter.hasNext()) {
                FileItem item = iter.next();
              //如果是普通表单字段
                if (item.isFormField()) {
                    String name = item.getFieldName();
                    String value = item.getString();
                   
                    //System.out.println("name==" + name + "   " + "value==" + value);
                    
                } 
              //如果是文件表单字段
                if (!item.isFormField()) {
                    String fileName = item.getName();
                   
                    if (fileName.equals("")){
                        throw new NullFileException("上传文件不能为空！");
                    }
                    
                    //System.out.println(fileName);
                    //根据上传文件名获得文件类型，判断exts集合中是否允许该类型上传，如果不支持，抛一个自定义异常
                    String ext = fileName.substring(fileName.lastIndexOf(".") + 1).toLowerCase();
                    if (!exts.contains(ext)) {
                        throw new ExtException("文件类型不匹配！不能是"+ext+"类型的文件");
                    }


                    int index = fileName.lastIndexOf(File.separator);
                    if (index > 0) {
                        fileName = fileName.substring(index + 1, fileName.length());
                    }
                    if (fileName != null && !fileName.equals("")) {
                        
                        //传入文件名返回一个随即生成带ID的唯一保存文件名
                        String saveFilename = generateFilename(fileName);
                        //传入输出路径和保存文件名，根据hash算法创建目录，返回一个用于将传入文件打散保存的保存路径
                        String savePath = generateFilepath(uploadFilePath, saveFilename);
                        
                        
                        //创建输出流到指定保存地址
                        File saveFile = new File(savePath, saveFilename);
                        //System.out.println("文件上传后保存的路径:" + saveFile.getPath() + "   " + "文件上传后保存的名称:" + saveFile.getName());
                        //System.out.println("上传成功后的文件名是" + uploadFileName.getName() + "，文件大小是" + item.getSize() + "bytes!");
                        try {
                            item.write(saveFile);

                        } catch (FileUploadBase.SizeLimitExceededException ex) {
                            System.out.println("上传失败，文件太大，全部文件的最大限制是" + upload.getSizeMax() + "bytes!");
                            ex.printStackTrace();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        uploadInfos.add(new UploadItemInfo(null, null, savePath, saveFilename, null, fileName, item.getSize()/1024/1024));
                    }

                    	item.delete();
                }
                
               
                

            }
            

        }
       
        req.getSession().setAttribute("uploadInfos",uploadInfos);
        ServletContext context=getServletContext();
        String path=context.getContextPath();
        //System.out.println(path);
        resp.sendRedirect(path+"/jsp/uploadInfo.jsp");

    }

    //为避免在一个目录保存多个文件，影响文件读取的性能，应把文件打散到多个目录存储
    public String generateFilepath(String uploadpath, String filename) {  //upload

        int hashcode = filename.hashCode();
        int dir1 = hashcode & 0xf;
        int dir2 = (hashcode >> 4) & 0xf;
        //  http://  c:\\
        String savepath = uploadpath + "\\" + dir1 + "\\" + dir2;
        File file = new File(savepath);
        if (!file.exists()) {
            file.mkdirs();
        }
        return savepath;
    }

    //为防止多用户上传相同文件名的文件，而导致文件覆盖的情况发生，文件上传程序应保证上传文件具有唯一文件名。
    public String generateFilename(String filename) {
        return UUID.randomUUID().toString() + "_" + filename;  //83743_9834834_9u34_9834-1.avi
    }
}
