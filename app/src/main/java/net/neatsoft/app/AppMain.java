package net.neatsoft.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.PreDestroy;

@Controller
//@EnableAutoConfiguration
@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients
public class AppMain
{

	private final Logger logger = LoggerFactory.getLogger(AppMain.class);

	@ResponseBody
    @RequestMapping(value = "/")
    public String home() {
        return "Hello World!";
    }

//	@Value("${app.message}")
//	String name = "World";

//	@RequestMapping("/say")
//	public String say() {
//		return "Hello " + name;
//	}

	@Autowired
	private DiscoveryClient client;

//	@Bean
//	CommandLineRunner runner() {
//		return args -> {
//			client.getInstances("reservation-service")
//					.forEach(si -> System.out.println(String.format(
//							"Found %s %s:%s", si.getServiceId(), si.getHost(), si.getPort())));
//		};
//	}

	public static void main(String[] args){
		SpringApplication.run(AppMain.class, args);
	}

	//@FeignClient(value = "compute-service")
	@ResponseBody
	@RequestMapping("/user")
	public String GetUser(){
		logger.info("GetUser.....");
		return "user";
	}

	@PreDestroy
	private void Destory(){
		logger.info("AppMain destory !.....");
	}
}