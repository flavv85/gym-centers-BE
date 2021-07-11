package com.flavius.gymcenter.managerImpl;

import com.flavius.gymcenter.dao.GymDao;
import com.flavius.gymcenter.dto.GymDto;
import com.flavius.gymcenter.manager.GymManagerService;
import com.flavius.gymcenter.model.Gym;
import com.flavius.gymcenter.model.OrikaBeanMapper;
import com.flavius.gymcenter.service.GymService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class GymManagerServiceImpl implements GymManagerService {

    private final OrikaBeanMapper orikaBeanMapper;
    private final GymService gymService;
    private final GymDao gymDao;

    public GymManagerServiceImpl(OrikaBeanMapper orikaBeanMapper, GymService gymService, GymDao gymDao) {
        this.orikaBeanMapper = orikaBeanMapper;
        this.gymService = gymService;
        this.gymDao = gymDao;
    }

    @Override
    public GymDto addGym(GymDto gymDto) {
        Gym gym = orikaBeanMapper.map(gymDto, Gym.class);
        return orikaBeanMapper.convertDTO(gymService.addGym(gym), GymDto.class);
    }

    @Override
    public GymDto editGym(GymDto gymDto, long id) {
        Gym gym = orikaBeanMapper.map(gymDto, Gym.class);
        Gym existsGym = gymDao.findById(id).orElse(null);
        return orikaBeanMapper.convertDTO(gymService.editGym(gym, existsGym), GymDto.class);
    }

    @Override
    public GymDto findGymById(long id) {
        return orikaBeanMapper.convertDTO(gymDao.findById(id).orElse(null), GymDto.class);
    }

    @Override
    public List<GymDto> findAllGyms() {
        List<Gym> gyms = gymDao.findAll();
        return orikaBeanMapper.convertListDTO(gyms, GymDto.class);
    }

    @Override
    public void deleteGym(long id) {
        Gym gym = gymDao.findById(id).orElse(null);
        gymDao.delete(gym);
    }
}
