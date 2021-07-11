package com.flavius.gymcenter.managerImpl;

import com.flavius.gymcenter.dao.CustomerDao;
import com.flavius.gymcenter.dao.GymDao;
import com.flavius.gymcenter.dao.WorktimeDao;
import com.flavius.gymcenter.dto.CustomerDto;
import com.flavius.gymcenter.dto.WorktimeDto;
import com.flavius.gymcenter.manager.WorktimeManagerService;
import com.flavius.gymcenter.model.Customer;
import com.flavius.gymcenter.model.Gym;
import com.flavius.gymcenter.model.OrikaBeanMapper;
import com.flavius.gymcenter.model.Worktime;
import com.flavius.gymcenter.service.WorktimeService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class WorktimeManagerServiceImpl implements WorktimeManagerService {

    private final OrikaBeanMapper orikaBeanMapper;
    private final WorktimeService worktimeService;
    private final WorktimeDao worktimeDao;
    private final GymDao gymDao;
    private final CustomerDao customerDao;

    public WorktimeManagerServiceImpl(OrikaBeanMapper orikaBeanMapper, WorktimeService worktimeService, WorktimeDao worktimeDao, GymDao gymDao, CustomerDao customerDao) {
        this.orikaBeanMapper = orikaBeanMapper;
        this.worktimeService = worktimeService;
        this.worktimeDao = worktimeDao;
        this.gymDao = gymDao;
        this.customerDao = customerDao;
    }

    @Override
    public WorktimeDto addWorktimeForGym(WorktimeDto worktimeDto, long idGym) {
        Gym gym = gymDao.findById(idGym).orElse(null);
        Worktime worktime = orikaBeanMapper.map(worktimeDto, Worktime.class);
        return orikaBeanMapper.convertDTO(worktimeService.addWorktime(worktime, gym), WorktimeDto.class);
    }

    @Override
    public WorktimeDto editWorktime(WorktimeDto worktimeDto, long id, long idGym) {
        Worktime worktime = orikaBeanMapper.map(worktimeDto, Worktime.class);
        Worktime existsWorktime = worktimeDao.findById(id).orElse(null);
        Gym gym = gymDao.findById(idGym).orElse(null);
        return orikaBeanMapper.convertDTO(worktimeService.editWorktime(worktime, existsWorktime, gym),
                WorktimeDto.class);
    }

    @Override
    public WorktimeDto findWorktimeById(long id) {
        return orikaBeanMapper.convertDTO(worktimeDao.findById(id).orElse(null), WorktimeDto.class);
    }

    @Override
    public void addCustomerForWorktime(long idCustomer, long idWorktime) {
        Customer customer = customerDao.findById(idCustomer).orElse(null);
        Worktime worktime = worktimeDao.findById(idWorktime).orElse(null);
        worktime.addCustomerForWork(customer);
    }

    @Override
    public void deleteWorktime(long id) {
        Worktime existsWorktime = worktimeDao.findById(id).orElse(null);
        worktimeDao.delete(existsWorktime);

    }

    @Override
    public List<WorktimeDto> findWorktimeForGym(long idGym) {
        Gym gym = gymDao.findById(idGym).orElse(null);
        List<Worktime> worktimes = gym.getWorktimes();
        return orikaBeanMapper.convertListDTO(worktimes, WorktimeDto.class);
    }

    @Override
    public List<CustomerDto> findCustomerForWorktime(long idWorktime) {
        Worktime worktime = worktimeDao.findById(idWorktime).orElse(null);
        List<Customer> customers = worktime.getCustomers();
        return orikaBeanMapper.convertListDTO(customers, CustomerDto.class);
    }
}
