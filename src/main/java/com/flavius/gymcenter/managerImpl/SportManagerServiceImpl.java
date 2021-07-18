package com.flavius.gymcenter.managerImpl;

import com.flavius.gymcenter.dao.CustomerDao;
import com.flavius.gymcenter.dao.GymDao;
import com.flavius.gymcenter.dao.SportDao;
import com.flavius.gymcenter.dto.SportDto;
import com.flavius.gymcenter.manager.SportManagerService;
import com.flavius.gymcenter.model.Customer;
import com.flavius.gymcenter.model.Gym;
import com.flavius.gymcenter.model.OrikaBeanMapper;
import com.flavius.gymcenter.model.Sport;
import com.flavius.gymcenter.service.SportService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class SportManagerServiceImpl implements SportManagerService {

    private final OrikaBeanMapper orikaBeanMapper;
    private final SportService sportService;
    private final SportDao sportDao;
    private final CustomerDao customerDao;
    private final GymDao gymDao;

    public SportManagerServiceImpl(OrikaBeanMapper orikaBeanMapper, SportService sportService, SportDao sportDao, CustomerDao customerDao, GymDao gymDao) {
        this.orikaBeanMapper = orikaBeanMapper;
        this.sportService = sportService;
        this.sportDao = sportDao;
        this.customerDao = customerDao;
        this.gymDao = gymDao;
    }

    @Override
    public SportDto addSportFogGym(SportDto sportDto, Long idGym) {
        Sport sport = orikaBeanMapper.map(sportDto, Sport.class);
        Gym gym = gymDao.findById(idGym).orElse(null);
        return orikaBeanMapper.convertDTO(sportService.addSport(sport, gym), SportDto.class);
    }

    @Override
    public SportDto editSport(SportDto sportDto, Long id) {
        Sport sport = orikaBeanMapper.map(sportDto, Sport.class);
        Sport existsSport = sportDao.findById(id).orElse(null);
        return orikaBeanMapper.convertDTO(sportService.editSport(sport, existsSport), SportDto.class);
    }

    @Override
    public SportDto findSportById(long id) {
        return orikaBeanMapper.convertDTO(sportDao.findById(id).orElse(null), SportDto.class);
    }

    @Override
    public void addSportForCustomer(Long idSport, Long idCustomer) {
        Customer customer = customerDao.findById(idCustomer).orElse(null);
        Sport existsSport = sportDao.findById(idSport).orElse(null);
        customer.addSport(existsSport);

    }

    @Override
    public void deleteSport(long id) {
        Sport existsSport = sportDao.findById(id).orElse(null);
        sportDao.delete(existsSport);

    }

    @Override
    public List<SportDto> findSportForCustomer(long idCustomer) {
        Customer customer = customerDao.findById(idCustomer).orElse(null);
        List<Sport> sports = customer.getSports();
        return orikaBeanMapper.convertListDTO(sports, SportDto.class);
    }

    @Override
    public List<SportDto> findSportForGym(long idGym) {
        Gym gym  = gymDao.findById(idGym).orElse(null);
        List<Sport> sports = gym.getSports();
        return orikaBeanMapper.convertListDTO(sports, SportDto.class);
    }
}
