package pers.luchuan.hello.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created By Lu Chuan On 2019/11/7
 */
@RestController
@RequestMapping("user")
@PropertySource(value = "classpath:custom.properties")
public class HelloController {
	
	@Value("${day}")
	private int day;
	@Value("${year}")
	private String year;
	
	@GetMapping("sayHello")
	public String sayHello(String name) {
		return "Hello1,"+name;
	}
	
	@GetMapping("test")
	public String test() {
		return "year:" + year + ",day:" + day;
	}
	
	@GetMapping("wx")
	public void test(String signature,String timestamp,String nonce,String echostr ) {
		/*signature	微信加密签名，signature结合了开发者填写的token参数和请求中的timestamp参数、nonce参数。
		timestamp	时间戳
		nonce	随机数
		echostr	随机字符串*/
		System.out.println(signature);
		System.out.println(timestamp);
		System.out.println(nonce);
		System.out.println(echostr);
	}
}
