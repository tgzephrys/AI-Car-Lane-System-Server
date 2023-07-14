package cn.net.luoma.aicarsystemserver.common;



import com.baidu.aip.face.AipFace;
import com.baidu.aip.util.Base64Util;
import org.json.JSONObject;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;

/**
 * 人脸模块
 *
 * @author luoma
 * @since 2020-02-01 22:25
 */
public class FaceUtil {
    public static final String APP_ID = "18374356";
    public static final String API_KEY = "xjPdUx87pB84lAbbHxremTj5";
    public static final String SECRET_KEY = "ixCS1yHDxDSLXmez7iLFlSd2Q9qG8Rl6";

    /**
     * 添加用户
     *
     * @param img     图片（BASE64格式）
     * @param groupId 用户组ID
     * @param userId  用户ID（对应用户名）
     * @return 调用结果
     */
    public static JSONObject addUser(String img, String groupId, String userId) {

        AipFace client = new AipFace(APP_ID, API_KEY, SECRET_KEY);

        // 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);

        //        // 传入可选参数调用接口
        HashMap<String, String> options = new HashMap<String, String>();
        options.put("user_info", "user's info");
        options.put("quality_control", "NONE");
        options.put("liveness_control", "LOW");
        options.put("action_type", "REPLACE");

        return client.addUser(img, "BASE64", groupId, userId, options);
    }

    /**
     * 搜索人脸库
     *
     * @param img     图片（BASE64格式）
     * @param groupId 用户组ID
     * @return 调用结果
     */
    public static JSONObject search(String img, String groupId) {
        AipFace client = new AipFace(APP_ID, API_KEY, SECRET_KEY);

        // 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);

        HashMap<String, String> options = new HashMap<String, String>();
        options.put("max_face_num", "3");
        options.put("match_threshold", "70");
        options.put("quality_control", "NONE");
        options.put("liveness_control", "LOW");
        options.put("max_user_num", "3");

        // 人脸检测
        return client.search(img, "BASE64", groupId, options);
    }

    /**
     * 图片转为BASE64格式
     *
     * @param img 图片Path
     * @return BASE64格式图片
     */
    public static String convImgToBase64(String img) {

        InputStream in = null;
        byte[] data = null;
        //读取图片字节数组
        try {
            in = new FileInputStream(img);
            data = new byte[in.available()];
            in.read(data);
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Base64Util.encode(data);
    }
}
