package com.flavius.gymcenter.manager;

import com.flavius.gymcenter.dto.SportDto;

import java.util.List;

public interface SportManagerService {
    SportDto addSportFogGym(SportDto sportDto, Long idGym);
    SportDto editSport(SportDto sportDto, Long id);
    SportDto findSportById(long id);
    void addSportForCustomer(Long idSport, Long idCustomer);
    void deleteSport(long id);
    List<SportDto> findSportForCustomer(long idCustomer);
    List<SportDto> findSportForGym(long idGym);
}
