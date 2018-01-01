package com.guoxin.module.system.service.impl;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import java.util.List;
import com.guoxin.common.page.PageInfo;
import com.guoxin.module.system.condition.RoleCondition;
import com.guoxin.module.system.dao.IRoleDao;
import com.guoxin.module.system.entity.Role;
import com.guoxin.module.system.service.IRoleService;

/**
 * 角色信息 Service层实现类
 * @author Corey
 * @createTime 2016-12-03
 */
@Service("roleService")
public class RoleService implements IRoleService {
    
    @Resource
    private IRoleDao roleDao;     //角色信息持久层
    
    /**
     * 得到记录通过主键ID
     * @author Corey
     * @param Integer 
     * @createTime 2016-12-03
     * @return 
     */
    public Role getRoleById(Integer id){
        return this.roleDao.getRoleById(id);
    }
    
    /**
     * 添加角色信息信息
     * @author Corey
     * @param role 角色信息实例
     * @createTime 2016-12-03
     * @return 
     */
    public int addRole(Role role) {
        return this.roleDao.insertRole(role);
    }
    
    /**
     * 根据条件得到所有角色信息的分页列表
     * @author Corey
     * @param roleCondition 查询条件
     * @createTime 2016-12-03
     * @return PageInfo 分页对象
     */
    public PageInfo getRolePageList(RoleCondition condition) {
        PageInfo pageInfo = new PageInfo(condition);
        pageInfo.setTotalRows(this.roleDao.getRoleCount(condition));
        
        if(condition.getPageNum() != null){
            if(pageInfo.getTotalRows() > 0 && condition.getPageNum() > pageInfo.getTotalPages()){
                condition.setPageNum(pageInfo.getTotalPages());
                condition.setLimitOffset();
            }
        }
        
        pageInfo.setItems(this.roleDao.getRolePageList(condition));
        return pageInfo;
    }
    
    /**
     * 根据条件得到所有角色信息
     * @author Corey
     * @param roleCondition 查询条件
     * @createTime 2016-12-03
     * @return List 角色信息列表
     */
    public List<Role> getRoleList(RoleCondition condition) {
        return this.roleDao.getRolePageList(condition);
    }
    
    /**
     * 根据条件得到所有角色信息
     * @author Corey
     * @param role 角色信息实例
     * @createTime 2016-12-03
     * @return List 角色信息列表
     */
    public List<Role> getRoleList(Role role) {
        return this.roleDao.getRoleList(role);
    }
    
    /**
     * 根据条件得到所有角色信息数量
     * @author Corey
     * @param role 查询条件
     * @createTime 2016-12-03
     * @return Integer 记录数
     */
    public Integer getRoleCount(RoleCondition condition){
        return this.getRoleCount(condition);
    }
    
    /**
     * 更新角色信息信息
     * @author Corey
     * @param role 角色信息实例
     * @createTime 2016-12-03
     * @return 
     */
    public int updateRole(Role role){
        return this.roleDao.updateRole(role);
    }
    
    /**
     * 删除指定ID的实例
     * @author Corey
     * @param id 要删除实例的ID
     * @createTime 2016-12-03
     */
    public int deleteRoleById(Integer id){
        return this.roleDao.deleteRoleById(id);
    }
    
}
