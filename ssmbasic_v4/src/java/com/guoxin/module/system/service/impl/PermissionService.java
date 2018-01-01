package com.guoxin.module.system.service.impl;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import java.util.List;
import com.guoxin.common.page.PageInfo;
import com.guoxin.module.system.condition.PermissionCondition;
import com.guoxin.module.system.dao.IPermissionDao;
import com.guoxin.module.system.entity.Permission;
import com.guoxin.module.system.service.IPermissionService;

/**
 * 权限信息 Service层实现类
 * @author Corey
 * @createTime 2016-12-03
 */
@Service("permissionService")
public class PermissionService implements IPermissionService {
    
    @Resource
    private IPermissionDao permissionDao;     //权限信息持久层
    
    /**
     * 得到记录通过主键ID
     * @author Corey
     * @param Integer 
     * @createTime 2016-12-03
     * @return 
     */
    public Permission getPermissionById(Integer id){
        return this.permissionDao.getPermissionById(id);
    }
    
    /**
     * 添加权限信息信息
     * @author Corey
     * @param permission 权限信息实例
     * @createTime 2016-12-03
     * @return 
     */
    public int addPermission(Permission permission) {
        return this.permissionDao.insertPermission(permission);
    }
    
    /**
     * 根据条件得到所有权限信息的分页列表
     * @author Corey
     * @param permissionCondition 查询条件
     * @createTime 2016-12-03
     * @return PageInfo 分页对象
     */
    public PageInfo getPermissionPageList(PermissionCondition condition) {
        PageInfo pageInfo = new PageInfo(condition);
        pageInfo.setTotalRows(this.permissionDao.getPermissionCount(condition));
        
        if(condition.getPageNum() != null){
            if(pageInfo.getTotalRows() > 0 && condition.getPageNum() > pageInfo.getTotalPages()){
                condition.setPageNum(pageInfo.getTotalPages());
                condition.setLimitOffset();
            }
        }
        
        pageInfo.setItems(this.permissionDao.getPermissionPageList(condition));
        return pageInfo;
    }
    
    /**
     * 根据条件得到所有权限信息
     * @author Corey
     * @param permissionCondition 查询条件
     * @createTime 2016-12-03
     * @return List 权限信息列表
     */
    public List<Permission> getPermissionList(PermissionCondition condition) {
        return this.permissionDao.getPermissionPageList(condition);
    }
    
    /**
     * 根据条件得到所有权限信息
     * @author Corey
     * @param permission 权限信息实例
     * @createTime 2016-12-03
     * @return List 权限信息列表
     */
    public List<Permission> getPermissionList(Permission permission) {
        return this.permissionDao.getPermissionList(permission);
    }
    
    /**
     * 根据条件得到所有权限信息数量
     * @author Corey
     * @param permission 查询条件
     * @createTime 2016-12-03
     * @return Integer 记录数
     */
    public Integer getPermissionCount(PermissionCondition condition){
        return this.getPermissionCount(condition);
    }
    
    /**
     * 更新权限信息信息
     * @author Corey
     * @param permission 权限信息实例
     * @createTime 2016-12-03
     * @return 
     */
    public int updatePermission(Permission permission){
        return this.permissionDao.updatePermission(permission);
    }
    
    /**
     * 删除指定ID的实例
     * @author Corey
     * @param id 要删除实例的ID
     * @createTime 2016-12-03
     */
    public int deletePermissionById(Integer id){
        return this.permissionDao.deletePermissionById(id);
    }
    
}
