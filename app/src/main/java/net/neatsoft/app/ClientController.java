package net.neatsoft.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Created by zhouwei on 2017/1/11.
 */

@RestController
@EnableFeignClients
public class ClientController {

	@Autowired
	HelloClient client;

	@RequestMapping("/hello")
	public String hello() {
		return client.hello();
	}

	@FeignClient("compute-service")
	interface HelloClient {
		@RequestMapping(value = "/", method = GET)
		String hello();
	}
}
