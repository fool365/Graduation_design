package cn.com.jinkang.module.standard.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;


@AllArgsConstructor
@Getter
public enum RoleTypeEnum {

    USER(1,"普通用户"),
    ADMIN(2,"管理员"),
    REVIEWER(3,"审批员"),
    APPROVER(4,"批准员");
    private Integer code;
    private String message;

    private static final Map<Integer, RoleTypeEnum> lookup = new HashMap<>();

    static {
        for(RoleTypeEnum e : EnumSet.allOf(RoleTypeEnum.class)){
            lookup.put(e.getCode(), e);
        }
    }

    public static RoleTypeEnum find(Integer code){
        return lookup.get(code);
    }
}
