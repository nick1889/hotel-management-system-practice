package cn.nick.springcloud.dao;

import cn.nick.springcloud.entities.Guest;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface GuestManagementDao {

    int addGuest(Guest guest);

    Guest getGuestById(@Param("id") Long id);

}
