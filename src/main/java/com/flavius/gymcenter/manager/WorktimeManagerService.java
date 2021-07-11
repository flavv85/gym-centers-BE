package com.flavius.gymcenter.manager;

import com.flavius.gymcenter.dto.CustomerDto;
import com.flavius.gymcenter.dto.WorktimeDto;
import com.flavius.gymcenter.model.Customer;

import java.util.List;

public interface WorktimeManagerService {
    WorktimeDto addWorktimeForGym(WorktimeDto worktimeDto, long idGym);
    WorktimeDto editWorktime(WorktimeDto worktimeDto, long id, long idGym);
    WorktimeDto findWorktimeById(long id);
    void addCustomerForWorktime(long idCustomer, long idWorktime);
    void deleteWorktime(long id);
    List<WorktimeDto> findWorktimeForGym(long idGym);
    List<CustomerDto> findCustomerForWorktime(long idWorktime);

}
