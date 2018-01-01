package com.guoxin.module.system.service;

import java.util.List;
import com.guoxin.common.page.PageInfo;
import com.guoxin.module.system.condition.RoleCondition;
import com.guoxin.module.system.entity.Role;

/**
 * 角色信息 Service层接口
 * @author Corey
 * @createTime 2016-12-03
 */
public interface IRoleService {
    
    /**
     * 得到记录通过主键ID
     * @author Corey
     * @param Integer 
     * @createTime 2016-12-03
     * @return 
     */
    public Role getRoleById(Integer id);
    
    /**
     * 添加角色信息信息
     * @author Corey
     * @param role 角色信息实例
     * @createTime 2016-12-03
     * @return 
     */
    public int addRole(Role role);
    
    /**
     * 根据条件得到所有角色信息的分页列表
     * @author Corey
     * @param roleCondition 查询条件
     * @createTime 2016-12-03
     * @return PageInfo 分页对象
     */
    public PageInfo getRolePageList(RoleCondition condition);
    
    /**
     * 根据条件得到所有角色信息
     * @author Corey
     * @param role 角色信息实例
     * @createTime 2016-12-03
     * @return List 角色信息列表
     */
    public List<Role> getRoleList(Role role);
    
    /**
     * 根据条件得到所有角色信息
     * @author Corey
     * @param roleCondition 查询条件
     * @createTime 2016-12-03
     * @return List 角色信息列表
     */
    public List<Role> getRoleList(RoleCondition condition);
    
    /**
     * 根据条件得到所有角色信息数量
     * @author Corey
     * @param role 查询条件
     * @createTime 2016-12-03
     * @return Integer 记录数
     */
    public Integer getRoleCount(RoleCondition condition);
    
    /**
     * 删除指定ID的实例
     * @author Corey
     * @param id 要删除实例的ID
     * @createTime 2016-12-03
     */
    public int deleteRoleById(Integer id);
    
    /**
     * 更新角色信息信息
     * @author Corey
     * @param role 角色信息实例
     * @createTime 2016-12-03
     * @return 
     */
    public int updateRole(Role role);
    
}
