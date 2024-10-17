package cn.xf._05File;

import java.io.File;
import java.io.FileWriter;
import java.util.UUID;

public class FileW {
    public static void main(String[] args) {
        String uuid = UUID.randomUUID().toString().replace("-", "");
        String fileName = uuid + "_" + "xxxx" + "_" + 123;
        String filePath = "E:\\File\\Other\\Tencent\\weChat\\WeChat Files\\wxid_it2vuwnjstek22\\FileStorage\\File\\2021-11" + fileName + ".txt";
        File file = new File(filePath);
        String content = "{\"casecode\":\"(2020)川16民初121602号\",\"courtcode\":\"3189\",\"method\":\"updateTrial\",\"param\":[{\"ah\":\"(2020)川16民初121602号\",\"ajlx\":\"1\",\"ajms\":\"\",\"ay\":\"生命权纠纷\",\"cabs\":\"null\",\"cbbm\":\"技术室\",\"cbr\":\"121602\",\"fydm\":\"3189\",\"fymc\":\"广安市中级人民法院\",\"jhkssj\":\"2020-12-17 17:02:13\",\"ktdd\":\"第一审判庭\",\"larq\":\"2020-12-16\",\"party\":\"1216021\",\"pqbs\":\"K202012161659037-A90FA68A70D3D43CFE8\",\"psy\":\"\",\"sfca\":\"0\",\"sjy\":\"121602\",\"spcx\":\"21\",\"spy\":\"\",\"spz\":\"121602\",\"tc\":1}],\"pqbs\":\"K202012161659037-A90FA68A70D3D43CFE8\"}";
        FileWriter fw = null;

        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            fw = new FileWriter(filePath);
            fw.write(content);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                fw.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
}
