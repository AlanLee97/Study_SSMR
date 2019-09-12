package com.study.service.impl;

import com.study.dao.RoleDao;
import com.study.pojo.Role;
import com.study.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleDao roleDao = null;

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
    public Role getRole(int id) {
        Role role = roleDao.getRole(id);
        System.out.println("RoleServiceImpl: " + role);
        return role;
    }
}
