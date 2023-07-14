package cn.net.luoma.aicarsystemserver.common;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;

public class FileUploadUtil {

    public static String uploadFile(MultipartFile file,String id,String name,String type){
        // 获取原始名字
        String fileName = file.getOriginalFilename();
        // 获取后缀名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        // 文件保存路径
        //获取项目根目录
        String filePath = System.getProperty("user.dir") + "/src/main/resources/static/file/upload/"+type+"/"+id+"/";
        // 文件重命名，防止重复
//        String randomID = "" + UUID.randomUUID();
        fileName = filePath + name +suffixName;

        // 文件对象
        File dest = new File(fileName);
        // 判断路径是否存在，如果不存在则创建
        if(!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }

        try {
            // 保存到服务器中
            file.transferTo(dest);
            return fileName;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "";
    }

    public static String uploadFile(MultipartFile file,String id,String name,String index,String type){
        // 获取原始名字
        String fileName = file.getOriginalFilename();
        // 获取后缀名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        // 文件保存路径
        String filePath = System.getProperty("user.dir") + "/src/main/resources/static/file/upload/"+type+"/"+id+"/";   //获取项目根目录
        // 文件重命名，防止重复
//        String randomID = "" + UUID.randomUUID();
        fileName = filePath + name + index + suffixName;

        // 文件对象
        File dest = new File(fileName);
        // 判断路径是否存在，如果不存在则创建
        if(!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }

        try {
            // 保存到服务器中
            file.transferTo(dest);
            return name + suffixName;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "";
    }
}
