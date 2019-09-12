package com.study.mapper;

import com.study.pojo.Role;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleMapper {
    //增：插入
    public int insert(Role role);
    //删：删除
    public int delete(@Param("id") int id);
    //查：查询
    public Role getRole(@Param("id") int id);
    //改：更新
    public int update(Role role);
}
