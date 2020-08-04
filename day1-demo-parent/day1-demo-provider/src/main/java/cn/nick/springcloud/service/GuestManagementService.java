package cn.nick.springcloud.service;

import cn.nick.springcloud.entities.Guest;
import org.apache.ibatis.annotations.Param;

public interface GuestManagementService {

    int addGuest(Guest guest);

    Guest getGuestById(@Param("id") Long id);

}
