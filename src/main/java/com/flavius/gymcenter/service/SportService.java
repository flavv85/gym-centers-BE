package com.flavius.gymcenter.service;

import com.flavius.gymcenter.model.Gym;
import com.flavius.gymcenter.model.Sport;

public interface SportService {
    Sport addSport(Sport sport, Gym gym);

    Sport editSport(Sport sport, Sport existsSport);
}
