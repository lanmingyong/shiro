package com.guoxin.module.system.condition;
import com.guoxin.common.page.BaseCondition;
import com.guoxin.module.system.entity.Permission;

/**
 * 权限信息 Condition
 * @author Corey
 * @createTime 2016-12-03
 */
public class PermissionCondition extends BaseCondition {
    private Permission permission;
    
    public PermissionCondition() {
        this.permission = new Permission();
    }
    
    public PermissionCondition(Permission permission) {
        this.permission = permission;
    }
    
    public Permission getPermission() {
        return permission;
    }
    public void setPermission(Permission permission) {
        this.permission = permission;
    }
}
