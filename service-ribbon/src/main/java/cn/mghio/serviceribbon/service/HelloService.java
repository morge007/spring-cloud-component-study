package cn.mghio.serviceribbon.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * <p>****************************************************************************</p>
 * <p><b>Copyright © 2018 102 programmer team All Rights Reserved<b></p>
 * <ul style="margin:15px;">
 * <li>Description : cn.mghio.serviceribbon.service</li>
 * <li>Version     : 1.0</li>
 * <li>Creation    : 2018年07月06日</li>
 * <li>@author     : 追（☆_☆）梦 <maguihai1920@gmail.com></li>
 * </ul>
 * <p>****************************************************************************</p>
 */
@Service
public class HelloService {

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "hiError")
    public String hiService(String name) {
        return restTemplate.getForObject("http://eureka-client/hi?name=" + name, String.class);

    }

    public String hiError(String name) {
        return "hi," + name + ",sorry,error!";
    }
}
