package org.great.face;



import java.util.HashMap;
import java.util.Map;

import org.great.face.utils.AuthService;
import org.great.face.utils.Base64Util;
import org.great.face.utils.FileUtil;
import org.great.face.utils.GsonUtils;
import org.great.face.utils.HttpUtil;

/**
* 人脸注册
*/
public class FaceAdd {

 
    public static String add(String image,String username,String userinfo) {
        // 请求url
        String url = "https://aip.baidubce.com/rest/2.0/face/v3/faceset/user/add";
        try {
            Map<String, Object> map = new HashMap<String, Object>();
            byte[] bytes1 = FileUtil.readFileByBytes(image);
            String image1 = Base64Util.encode(bytes1);
            map.put("image",image1);
            map.put("group_id", "user");
            map.put("user_id",username);
            map.put("user_info",userinfo);
            map.put("liveness_control", "NORMAL");
            map.put("image_type", "BASE64");
            map.put("quality_control", "LOW");

            String param = GsonUtils.toJson(map);

            // 注意这里仅为了简化编码每一次请求都去获取access_token，线上环境access_token有过期时间， 客户端可自行缓存，过期后重新获取。
            String accessToken =AuthService.getAuth();

            String result = HttpUtil.post(url, accessToken, "application/json", param);
            System.out.println(result);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


}