package com.guoxin.module.system.dao;

import java.util.List;
import com.guoxin.module.system.condition.PermissionCondition;
import com.guoxin.module.system.entity.Permission;

/**
 * 权限信息 DAO层接口
 * @author Corey
 * @createTime 2016-12-03
 */
public interface IPermissionDao {
    
    /**
     * 得到记录通过主键ID
     * @author Corey
     * @param 
     * @createTime 2016-12-03
     * @return Permission
     */
    public Permission getPermissionById(Integer id);
    
    /**
     * 添加权限信息信息
     * @author Corey
     * @param permission 权限信息实例
     * @createTime 2016-12-03
     * @return 
     */
    public int insertPermission(Permission permission);
    
    /**
     * 更新权限信息信息
     * @author Corey
     * @param permission 权限信息实例
     * @createTime 2016-12-03
     * @return 
     */
    public int updatePermission(Permission permission);
    
    /**
     * 根据条件得到所有权限信息的分页列表
     * @author Corey
     * @param permissionCondition 查询条件
     * @createTime 2016-12-03
     * @return List 权限信息列表
     */
    public List<Permission> getPermissionPageList(PermissionCondition condition);
    
    /**
     * 根据条件得到所有权限信息数量
     * @author Corey
     * @param permission 查询条件
     * @createTime 2016-12-03
     * @return Integer 记录数
     */
    public Integer getPermissionCount(PermissionCondition condition);
    
    /**
     * 根据条件得到所有权限信息列表
     * @author Corey
     * @param permission 查询条件
     * @createTime 2016-12-03
     * @return List 权限信息列表
     */
    public List<Permission> getPermissionList(Permission permission);
    
    /**
     * 删除指定ID的实例
     * @author Corey
     * @param id 要删除实例的ID
     * @createTime 2016-12-03
     */
    public int deletePermissionById(Integer id);
    
}
