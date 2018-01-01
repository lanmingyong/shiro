package com.guoxin.module.system.service;

import java.util.List;
import com.guoxin.common.page.PageInfo;
import com.guoxin.module.system.condition.PermissionCondition;
import com.guoxin.module.system.entity.Permission;

/**
 * 权限信息 Service层接口
 * @author Corey
 * @createTime 2016-12-03
 */
public interface IPermissionService {
    
    /**
     * 得到记录通过主键ID
     * @author Corey
     * @param Integer 
     * @createTime 2016-12-03
     * @return 
     */
    public Permission getPermissionById(Integer id);
    
    /**
     * 添加权限信息信息
     * @author Corey
     * @param permission 权限信息实例
     * @createTime 2016-12-03
     * @return 
     */
    public int addPermission(Permission permission);
    
    /**
     * 根据条件得到所有权限信息的分页列表
     * @author Corey
     * @param permissionCondition 查询条件
     * @createTime 2016-12-03
     * @return PageInfo 分页对象
     */
    public PageInfo getPermissionPageList(PermissionCondition condition);
    
    /**
     * 根据条件得到所有权限信息
     * @author Corey
     * @param permission 权限信息实例
     * @createTime 2016-12-03
     * @return List 权限信息列表
     */
    public List<Permission> getPermissionList(Permission permission);
    
    /**
     * 根据条件得到所有权限信息
     * @author Corey
     * @param permissionCondition 查询条件
     * @createTime 2016-12-03
     * @return List 权限信息列表
     */
    public List<Permission> getPermissionList(PermissionCondition condition);
    
    /**
     * 根据条件得到所有权限信息数量
     * @author Corey
     * @param permission 查询条件
     * @createTime 2016-12-03
     * @return Integer 记录数
     */
    public Integer getPermissionCount(PermissionCondition condition);
    
    /**
     * 删除指定ID的实例
     * @author Corey
     * @param id 要删除实例的ID
     * @createTime 2016-12-03
     */
    public int deletePermissionById(Integer id);
    
    /**
     * 更新权限信息信息
     * @author Corey
     * @param permission 权限信息实例
     * @createTime 2016-12-03
     * @return 
     */
    public int updatePermission(Permission permission);
    
}
