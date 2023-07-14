package cn.net.luoma.aicarsystemserver.controller;

import cn.net.luoma.aicarsystemserver.response.BaseResponse;
import cn.net.luoma.aicarsystemserver.common.FileUploadUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/file/")
public class VolunteerUploaderController {
    @RequestMapping("upload")
    @ResponseBody
    public BaseResponse upload (
            @RequestParam("file") MultipartFile file,
            @RequestParam(value = "id", defaultValue = "") String id,
            @RequestParam(value = "name", defaultValue = "") String name
            ) {
        String fileName = FileUploadUtil.uploadFile(file,id,name,"volunteer");
        if(fileName.equals("")) {
            return BaseResponse.fail("上传失败");
        }else{
            return BaseResponse.ok("上传成功");
        }
    }
}
