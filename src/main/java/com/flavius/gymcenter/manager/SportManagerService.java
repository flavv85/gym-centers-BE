package com.flavius.gymcenter.manager;

import com.flavius.gymcenter.dto.SportDto;

import java.util.List;

public interface SportManagerService {
    SportDto addSportFogGym(SportDto sportDto, long idGym);
    SportDto editSport(SportDto sportDto, long id);
    SportDto findSportById(long id);
    void addSportForCustomer(long idSport, long idCustomer);
    void deleteSport(long id);
    List<SportDto> findSportForCustomer(long idCustomer);
    List<SportDto> findSportForGym(long idGym);
}
