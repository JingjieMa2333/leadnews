package com.heima.minio.test;

import com.heima.file.service.FileStorageService;
import com.heima.minio.MinIOApplication;
import io.minio.MinioClient;
import io.minio.PutObjectArgs;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
//import org.junit.Test;
//import org.springframework.beans.factory.annotation.Autowired;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
//import java.io.FileNotFoundException;


@SpringBootTest(classes = MinIOApplication.class)
@RunWith(SpringRunner.class)
public class MinIOTest {

//    @Autowired
//    private FileStorageService fileStorageService;
//
//    @Test
//    public void test() throws FileNotFoundException {
//        //文件所在地址
//        FileInputStream fileInputStream =  new FileInputStream("C:/itheima/list.html");
//        String path = fileStorageService.uploadHtmlFile("", "list.html", fileInputStream);
//        System.out.println(path);
//    }






    /**
     * 上传list.html文件到minio中
     * @param args
     */
    public static void main(String[] args) {

        FileInputStream fileInputStream = null;
        try {
            //文件所在地址
            fileInputStream =  new FileInputStream("C:\\itheima\\temp\\js\\axios.min.js");

            //1.创建minio链接客户端，需要知道用户名，密码，连接的url
            MinioClient minioClient = MinioClient.builder().credentials("minio", "minio123").endpoint("http://192.168.200.130:9000").build();
            //2.上传
            PutObjectArgs putObjectArgs = PutObjectArgs.builder()
                    .object("plugins/js/axios.min.js")//上传到minio的目录和文件名
                    .contentType("text/js")//文件类型
                    .bucket("leadnews")//桶名词  与minio创建的名词一致
                    .stream(fileInputStream, fileInputStream.available(), -1) //文件流,-1（不限制字节数），大于0指定文件流读取的最大字节数
                    .build();

            minioClient.putObject(putObjectArgs);

            //输出访问路径
            //System.out.println("http://192.168.200.130:9000/leadnews/list.html");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

//    @Autowired
//    private FileStorageService fileStorageService;
//
//    @Test
//    public void testUpdateImgFile() {
//        try {
//            FileInputStream fileInputStream = new FileInputStream("E:\\tmp\\ak47.jpg");
//            String filePath = fileStorageService.uploadImgFile("", "ak47.jpg", fileInputStream);
//            System.out.println(filePath);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//    }

}