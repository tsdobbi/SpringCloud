package com.example.edge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.edge.filters.SimplePostFilter;
import com.example.edge.filters.SimplePreFilter;
@RestController
@EnableDiscoveryClient
@EnableZuulProxy
@SpringBootApplication
public class EdgeServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EdgeServiceApplication.class, args);
	}
	
	@Bean
	public SimplePreFilter simplePreFilter() {
		return new SimplePreFilter();
	}
	
	@Bean
	public SimplePostFilter simplePostFilter() {
		return new SimplePostFilter();
	}
	
	@RequestMapping(value = "/available")
	public String available() {
		return "This is available response";
	}
	
	@RequestMapping(value = "/checkout")
	public String checkout() {
		return "This is checkout response";		
	}

}
