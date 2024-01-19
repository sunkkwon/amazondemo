package com.study.spring.demo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Profile("production")		// 설정파일에서 production가 active일때만 생성
public class ProductionHelloController {
	// spring.profiles.active=dev 에 의해서 application-dev.properties를 미리 찾고 없으면
	// application.properties 에서 찾는다.

	@Value("${hello.message}")
	private String helloMessage;

	@Value("${hello.countries}")
	private List<String> countries;

	@Value("#{${hello.account}}")
	private Map<String, String> accounMap;

	@GetMapping("/hello")
	public String getHello() {

		return "[ProductionHelloController]" + helloMessage + " " + countries + " " + " name:" + accounMap.get("name")
				+ ", password:" + accounMap.get("password");
	}

}
