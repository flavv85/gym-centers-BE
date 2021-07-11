package com.flavius.gymcenter.impl;

import com.flavius.gymcenter.dao.SportDao;
import com.flavius.gymcenter.model.Gym;
import com.flavius.gymcenter.model.Sport;
import com.flavius.gymcenter.service.SportService;
import org.springframework.stereotype.Component;

@Component
public class SportServiceImpl implements SportService {

    private final SportDao sportDao;

    public SportServiceImpl(SportDao sportDao){
        this.sportDao = sportDao;
    }

    @Override
    public Sport addSport(Sport sport, Gym gym) {
        gym.addSportForGym(sport);
        return sportDao.save(sport);
    }

    @Override
    public Sport editSport(Sport sport, Sport existsSport) {
        existsSport.setName(sport.getName());
        existsSport.setDescription(sport.getDescription());
        existsSport.setPhoto(sport.getPhoto());
        return sportDao.save(existsSport);
    }
}
