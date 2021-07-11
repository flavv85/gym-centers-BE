package com.flavius.gymcenter.manager;

import com.flavius.gymcenter.dto.GymDto;

import java.util.List;

public interface GymManagerService {
    GymDto addGym(GymDto gymDto);
    GymDto editGym(GymDto gymDto, long id);
    GymDto findGymById(long id);
    List<GymDto> findAllGyms();
    void deleteGym(long id);
}
