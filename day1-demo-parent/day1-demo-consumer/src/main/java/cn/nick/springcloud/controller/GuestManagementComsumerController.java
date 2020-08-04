package cn.nick.springcloud.controller;

import cn.nick.springcloud.entities.CommonResult;
import cn.nick.springcloud.entities.Guest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@Slf4j
public class GuestManagementComsumerController {

    public static final String INVOKE_URL = "http://guest-management-provider";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/guest/add")
    public CommonResult<Guest> add(Guest guest) {
        return restTemplate.postForObject(INVOKE_URL + "/guest/add", guest, CommonResult.class);
    }

    @GetMapping("/guest/get/{id}")
    public CommonResult<Guest> getGuest(@PathVariable("id") Long id) {
        return restTemplate.getForObject(INVOKE_URL + "/guest/get/" + id, CommonResult.class);
    }
}
