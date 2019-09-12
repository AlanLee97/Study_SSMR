package com.study.mapper;

import com.study.pojo.PageParams;
import com.study.pojo.Role;
import com.study.pojo.RoleParams;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;
import java.util.Map;

public interface RoleMapper {
//    public int insertRole(Role role);
    public int deleteRole(int id);
    public int updateRole(Role role);
    public Role getRole(int id);
    public List<Role> findRoles();

    /**
     * 使用map传递多个参数
     * @param parameterMap map参数类型
     * @return
     */
    public List<Role> findRolesByNameAndNote(Map<String, Object> parameterMap);


    /**
     * 使用注解传递多个参数
     */
    public List<Role> findRolesByAnnotation(@Param("roleName") String roleName,@Param("com.study.note") String note);


    /**
     * 通过JavaBean的方式传递多个参数
     */
    public List<Role> findRolesByJavaBean(RoleParams roleParams);


    /**
     * 通过几种方法混合传递多个参数
     */
    public List<Role> findRolesByMix(@Param("params") RoleParams roleParams,@Param("page") PageParams pageParams);

    /**
     * 使用resultMap作为映射结果集
     */
    public Role findRolesUseResultMap(int id);


    /**
     * 分页参数 RowBounds
     */
    public List<Role> findRolesByRowBounds(@Param("roleName") String roleName,
                                     @Param("com.study.note") String note,
                                     RowBounds rowBounds);

    /**
     * 插入数据：返回主键
     */
    public int insertRole(Role role);

    /**
     * 插入数据：修改主键递增规则
     */
    public int insertRole2(Role role);

}
