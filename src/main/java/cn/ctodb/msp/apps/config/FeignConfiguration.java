package cn.ctodb.msp.apps.config;

import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients(basePackages = "cn.ctodb.msp.apps")
public class FeignConfiguration {

}
