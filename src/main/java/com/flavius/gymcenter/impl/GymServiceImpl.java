package com.flavius.gymcenter.impl;

import com.flavius.gymcenter.dao.GymDao;
import com.flavius.gymcenter.model.Gym;
import com.flavius.gymcenter.service.GymService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GymServiceImpl implements GymService {

    private final GymDao gymDao;

    public GymServiceImpl(GymDao gymDao) {
        this.gymDao = gymDao;
    }

    @Override
    public Gym addGym(Gym gym) {
        return gymDao.save(gym);
    }

    @Override
    public Gym editGym(Gym gym, Gym existsGym) {
        existsGym.setName(gym.getName());
        existsGym.setAddress(gym.getAddress());
        existsGym.setCity(gym.getCity());
        existsGym.setArea(gym.getArea());
        existsGym.setLogo(gym.getLogo());
        return gymDao.save(existsGym);
    }
}
