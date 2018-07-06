package cn.mghio.servicefeign.controller;

import cn.mghio.servicefeign.service.SchedualServiceHi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>****************************************************************************</p>
 * <p><b>Copyright © 2018 102 programmer team All Rights Reserved<b></p>
 * <ul style="margin:15px;">
 * <li>Description : cn.mghio.servicefeign.controller</li>
 * <li>Version     : 1.0</li>
 * <li>Creation    : 2018年07月06日</li>
 * <li>@author     : 追（☆_☆）梦 <maguihai1920@gmail.com></li>
 * </ul>
 * <p>****************************************************************************</p>
 */
@RestController
public class HiController {

    @Autowired
    private SchedualServiceHi schedualServiceHi;

    @RequestMapping(value = "/hi", method = RequestMethod.GET)
    public String sayHi(@RequestParam String name) {
        return schedualServiceHi.sayHiFromClientOne(name);
    }

}
