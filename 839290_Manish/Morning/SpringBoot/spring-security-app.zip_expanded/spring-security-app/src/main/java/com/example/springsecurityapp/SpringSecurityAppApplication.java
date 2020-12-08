package com.example.springsecurityapp;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableAuthorizationServer
@EnableResourceServer
@RestController
public class SpringSecurityAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityAppApplication.class, args);
	}
	
	@RequestMapping(value="/user",produces = MediaType.APPLICATION_JSON_VALUE)
	public Map<String, Object> userInformation(OAuth2Authentication oAuth2){
		Map<String,Object> userInfo = new HashMap<String, Object>();
		userInfo.put("user", oAuth2.getUserAuthentication().getPrincipal());
		userInfo.put("Authorities",AuthorityUtils.authorityListToSet(oAuth2.getUserAuthentication().getAuthorities()));
		return userInfo;
	}
	
	
	@GetMapping(value="/userLogin")
	public String PrintMessage()
	{
		return "Hello, You reached here";
	}
	

}
