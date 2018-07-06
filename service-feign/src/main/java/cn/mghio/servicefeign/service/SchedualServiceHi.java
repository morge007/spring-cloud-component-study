package cn.mghio.servicefeign.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * <p>****************************************************************************</p>
 * <p><b>Copyright © 2018 102 programmer team All Rights Reserved<b></p>
 * <ul style="margin:15px;">
 * <li>Description : cn.mghio.servicefeign.service</li>
 * <li>Version     : 1.0</li>
 * <li>Creation    : 2018年07月06日</li>
 * <li>@author     : 追（☆_☆）梦 <maguihai1920@gmail.com></li>
 * </ul>
 * <p>****************************************************************************</p>
 */
@FeignClient("eureka-client")
public interface SchedualServiceHi {

    @RequestMapping(value = "/hi", method = RequestMethod.GET)
    String sayHiFromClientOne(@RequestParam(value = "name") String name);
}
