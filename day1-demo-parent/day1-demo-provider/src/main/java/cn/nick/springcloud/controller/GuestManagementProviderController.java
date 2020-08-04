package cn.nick.springcloud.controller;

import cn.nick.springcloud.entities.CommonResult;
import cn.nick.springcloud.entities.Guest;
import cn.nick.springcloud.service.GuestManagementService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@Slf4j
public class GuestManagementProviderController {

    @Resource
    private GuestManagementService guestManagementService;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping("/guest/add")
    public CommonResult add(@RequestBody Guest guest) {
        int result = guestManagementService.addGuest(guest);
        log.info("**** 插入结果：" + result);

        if (result > 0) {
            return new CommonResult(200, "插入DB成功，服务器端口：" + serverPort, result);
        } else {
            return new CommonResult(400, "插入DB失败", null);
        }
    }

    @GetMapping("/guest/get/{id}")
    public CommonResult getGuestById(@PathVariable("id") Long id) {
        Guest guest = guestManagementService.getGuestById(id);
        log.info("**** 插入结果" + guest);

        if (guest != null) {
            return new CommonResult(200, "查询DB成功，服务器端口号：" + serverPort, guest);
        } else {
            return new CommonResult(400, "查询DB失败，查询ID：" + id, null);
        }
    }

}
