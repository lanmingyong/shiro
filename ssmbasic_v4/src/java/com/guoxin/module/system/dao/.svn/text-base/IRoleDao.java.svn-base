package com.guoxin.module.system.dao;

import java.util.List;
import com.guoxin.module.system.condition.RoleCondition;
import com.guoxin.module.system.entity.Role;

/**
 * 角色信息 DAO层接口
 * @author Corey
 * @createTime 2016-12-03
 */
public interface IRoleDao {
    
    /**
     * 得到记录通过主键ID
     * @author Corey
     * @param 
     * @createTime 2016-12-03
     * @return Role
     */
    public Role getRoleById(Integer id);
    
    /**
     * 添加角色信息信息
     * @author Corey
     * @param role 角色信息实例
     * @createTime 2016-12-03
     * @return 
     */
    public int insertRole(Role role);
    
    /**
     * 更新角色信息信息
     * @author Corey
     * @param role 角色信息实例
     * @createTime 2016-12-03
     * @return 
     */
    public int updateRole(Role role);
    
    /**
     * 根据条件得到所有角色信息的分页列表
     * @author Corey
     * @param roleCondition 查询条件
     * @createTime 2016-12-03
     * @return List 角色信息列表
     */
    public List<Role> getRolePageList(RoleCondition condition);
    
    /**
     * 根据条件得到所有角色信息数量
     * @author Corey
     * @param role 查询条件
     * @createTime 2016-12-03
     * @return Integer 记录数
     */
    public Integer getRoleCount(RoleCondition condition);
    
    /**
     * 根据条件得到所有角色信息列表
     * @author Corey
     * @param role 查询条件
     * @createTime 2016-12-03
     * @return List 角色信息列表
     */
    public List<Role> getRoleList(Role role);
    
    /**
     * 删除指定ID的实例
     * @author Corey
     * @param id 要删除实例的ID
     * @createTime 2016-12-03
     */
    public int deleteRoleById(Integer id);
    
}
