package com.flavius.gymcenter.managerImpl;

import com.flavius.gymcenter.dao.GymDao;
import com.flavius.gymcenter.dao.InstructorDao;
import com.flavius.gymcenter.dao.SportDao;
import com.flavius.gymcenter.dto.InstructorDto;
import com.flavius.gymcenter.manager.InstructorManagerService;
import com.flavius.gymcenter.model.Gym;
import com.flavius.gymcenter.model.Instructor;
import com.flavius.gymcenter.model.OrikaBeanMapper;
import com.flavius.gymcenter.model.Sport;
import com.flavius.gymcenter.service.InstructorService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class InstructorManagerServiceImpl implements InstructorManagerService {

    private final OrikaBeanMapper orikaBeanMapper;
    private final InstructorService instructorService;
    private final InstructorDao instructorDao;
    private final GymDao gymDao;
    private final SportDao sportDao;

    public InstructorManagerServiceImpl(OrikaBeanMapper orikaBeanMapper, InstructorService instructorService,
                                        InstructorDao instructorDao, GymDao gymDao, SportDao sportDao) {
        this.orikaBeanMapper = orikaBeanMapper;
        this.instructorService = instructorService;
        this.instructorDao = instructorDao;
        this.gymDao = gymDao;
        this.sportDao = sportDao;
    }

    @Override
    public void addInstructorForSport(long idInstructor, long idSport) {
        Sport sport = sportDao.findById(idSport).orElse(null);
        Instructor instructor = instructorDao.findById(idInstructor).orElse(null);
        sport.addInstructor(instructor);
    }

    @Override
    public void deleteInstructor(long id) {
        Instructor existsInstructor = instructorDao.findById(id).orElse(null);
        instructorDao.delete(existsInstructor);
    }

    @Override
    public InstructorDto addInstructorForGym(InstructorDto instructorDto, long idGym) {
        Gym gym = gymDao.findById(idGym).orElse(null);
        Instructor instructor = orikaBeanMapper.map(instructorDto, Instructor.class);
        return orikaBeanMapper.convertDTO(instructorService.addInstructorForGym(instructor, gym), InstructorDto.class);
    }

    @Override
    public InstructorDto editInstructor(InstructorDto instructorDto, long id) {
        Instructor existsInstructor = instructorDao.findById(id).orElse(null);
        Instructor instructor = orikaBeanMapper.map(instructorDto, Instructor.class);
        return orikaBeanMapper.convertDTO(instructorService.editInstructor(instructor, existsInstructor),
                InstructorDto.class);
    }

    @Override
    public InstructorDto findInstructorById(long id) {
        return orikaBeanMapper.convertDTO(instructorDao.findById(id).orElse(null), InstructorDto.class);
    }

    @Override
    public List<InstructorDto> findInstructorForSport(long idSport) {
        Sport sport  = sportDao.findById(idSport).orElse(null);
        List<Instructor> instructors = sport.getInstructors();
        return orikaBeanMapper.convertListDTO(instructors, InstructorDto.class);
    }

    @Override
    public List<InstructorDto> findInstructorForGym(long idGym) {
        Gym gym = gymDao.findById(idGym).orElse(null);
        List<Instructor> instructors = gym.getInstructors();
        return orikaBeanMapper.convertListDTO(instructors, InstructorDto.class);
    }

    @Override
    public List<InstructorDto> findAllInstructors() {
        List<Instructor> instructors = instructorDao.findAll();
        return orikaBeanMapper.convertListDTO(instructors, InstructorDto.class);
    }
}
