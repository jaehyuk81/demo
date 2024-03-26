package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@SpringBootApplication
public class DemoApplication {

	@RequestMapping("/")
    String home() {
        return "Hello World!";
    }
	
	@RequestMapping("/test")
    String test() {
		// 외부 API의 URL
        String apiUrl = "http://localhost:8081/data";

        // RestTemplate을 통해 GET 요청을 보내고 응답을 문자열로 받음
        RestTemplate restTemplate = restTemplate(new RestTemplateBuilder());
        String response = restTemplate.getForObject(apiUrl, String.class);

        // 응답 출력
        System.out.println("응답: " + response);
        return response;
    }
	
	
	@Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }
 
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
