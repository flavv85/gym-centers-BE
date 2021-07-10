package com.flavius.gymcenter.service;

import com.flavius.gymcenter.model.Gym;

public interface GymService {
    Gym addGym(Gym gym);

    Gym editGym(Gym gym, Gym existsGym);
}
