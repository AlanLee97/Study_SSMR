package com.study.service.impl;

import com.study.pojo.Role;
import com.study.service.RoleListService;
import com.study.service.RoleService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RoleListServiceImpl implements RoleListService {

    @Autowired
    private RoleService roleService = null;

    Logger log = Logger.getLogger(RoleListServiceImpl.class);


    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
    public int insertRoleList(List<Role> roleList) {
        int count = 0;
        for (Role role : roleList) {
            try {
                count += roleService.insertRole(role);
            } catch (Exception e) {
                log.info(e);
            }
        }
        return count;
    }
}
