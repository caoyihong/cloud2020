package cn.springcloud.consumer.util;

import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Scanner;

public class ImageDownload {
    private static WebClient webClient = WebClient.builder().exchangeStrategies(ExchangeStrategies.builder()
            .codecs(configurer -> configurer
                    .defaultCodecs()
                    .maxInMemorySize(10 * 1024 * 1024))
            .build()).build();
    public static void main(String[] args) {
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
