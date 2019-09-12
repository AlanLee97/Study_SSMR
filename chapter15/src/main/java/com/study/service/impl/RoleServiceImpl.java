package com.study.service.impl;

import com.study.dao.RoleDao;
import com.study.pojo.Role;
import com.study.pojo.RoleParams;
import com.study.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao = null;

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
    public Role getRole(int id) {
        return roleDao.getRole(id);
    }

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
    public List<Role> findRoles(RoleParams roleParams) {
        return roleDao.findRoles(roleParams);
    }

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
    public int deleteRoles(List<Integer> idList) {
        int count = 0;
        for (int id : idList) {
            count += roleDao.deleteRoles(id);
        }
        return count;
    }

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
    public int insertRoles(List<Role> roleList) {
        int count = 0;
        for (Role role : roleList) {
            count += roleDao.insertRoles(role);
        }
        return count;
    }

    public int insertRole(Role role) {
        return roleDao.insertRole(role);
    }


}
