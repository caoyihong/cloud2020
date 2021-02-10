package cn.springcloud.consumer.util;

import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ImageDownload {
    private static WebClient webClient = WebClient.builder().exchangeStrategies(ExchangeStrategies.builder()
            .codecs(configurer -> configurer
                    .defaultCodecs()
                    .maxInMemorySize(10 * 1024 * 1024))
            .build()).build();

    //    private static ArrayList<Integer> tmpArr = new ArrayList<>();
    private static ArrayList<Character> tmpArr = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        Writer writer = new BufferedWriter(new FileWriter("D:\\tmp\\filename\\name.txt"));
        int [] com = {1,2,3,4};
        int k = 3;
        char[] arr = {'0','a','b'};
        System.out.println("\n可重复排列结果：");
        ImageDownload imageDownload = new ImageDownload();
        imageDownload.repeatableArrangement(k, arr, writer);
        writer.close();
    }


    /**
     * 可重复排列
     * 类似自己和自己笛卡尔积，类似k层循环拼接的结果,元素个数[arr.len^3]
     * @param k 选取的元素个数（k层循环）
     * @param arr 数组
     */
    public void repeatableArrangement(int k,char []arr, Writer writer) throws IOException {
        if(k==1){
            for(int i=0;i<arr.length;i++){
                tmpArr.add(arr[i]);
                System.out.print(tmpArr.toString());
                System.out.println();
//                writer.write(tmpArr.toString());
                tmpArr.stream().collect(Collectors.joining(""));
                writer.write("\n");
                tmpArr.remove(tmpArr.size()-1); //移除尾部元素
            }
        }else if(k >1){
            for(int i=0;i<arr.length;i++){
                tmpArr.add(arr[i]);
                repeatableArrangement(k - 1, arr, writer); //不去重
                tmpArr.remove(tmpArr.size()-1); //移除尾部元素,不能用remove(Object),因为它会移除头部出现的元素，我们这里需要移除的是尾部元素
            }
        }else{
            return;
        }
    }
    public static void download() {
        // 记录下开始下载时的时间
        Instant now = Instant.now();

        Mono<Resource> mono = webClient
                .get() // GET 请求
                .uri("https://orderimg.picbling.cn/original_162951_2111848946_b8113331-2a8f-46af-81f0-08a6f22ea518.jpg")  // 请求路径
                .accept(MediaType.IMAGE_JPEG)
                .retrieve() // 获取响应体
                .bodyToMono(Resource.class); //响应数据类型转换

        Resource resource = mono.block();
        try {
            // 文件保存的本地路径
            String targetPath = "/Users/zhangni/tmp.jpg";
            // 将下载下来的图片保存到本地
            BufferedImage bufferedImage = ImageIO.read(resource.getInputStream());
            ImageIO.write(bufferedImage, "jpg", new File(targetPath));
        } catch (IOException e) {
            System.out.println("文件写入失败：" + e.getMessage());
        }

        System.out.println("文件下载完成，耗时：" + ChronoUnit.MILLIS.between(now, Instant.now())
                + " 毫秒");
    }

}
