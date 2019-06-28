package com.tedu.sp06;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

//@EnableCircuitBreaker
//@EnableDiscoveryClient
//@SpringBootApplication

@SpringCloudApplication
public class Sp06RibbonApplication {

		//生成一个动态代理对象,切入负载均衡代码.
		@LoadBalanced
		//创建 RestTemplate 实例，并存入 spring 容器
		@Bean
		public RestTemplate getRestTemplate() {
			//设置 RestTemplate 的请求工厂的超时属性
			SimpleClientHttpRequestFactory f = new SimpleClientHttpRequestFactory();
			f.setConnectTimeout(1000);
			f.setReadTimeout(1000);//接收响应数据的超时时间
			return new RestTemplate(f);
			//return new RestTemplate();
		}
		
	public static void main(String[] args) {
		SpringApplication.run(Sp06RibbonApplication.class, args);
	}

}
