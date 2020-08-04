package cn.nick.springcloud.service.impl;

import cn.nick.springcloud.dao.GuestManagementDao;
import cn.nick.springcloud.entities.Guest;
import cn.nick.springcloud.service.GuestManagementService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class GuestManagementServiceImpl implements GuestManagementService {

    @Resource
    private GuestManagementDao guestManagementDao;

    @Override
    public int addGuest(Guest guest) {
        return guestManagementDao.addGuest(guest);
    }

    @Override
    public Guest getGuestById(Long id) {
        return guestManagementDao.getGuestById(id);
    }
}
