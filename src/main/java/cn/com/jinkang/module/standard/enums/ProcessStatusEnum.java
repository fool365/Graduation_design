package cn.com.jinkang.module.standard.enums;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

@AllArgsConstructor
@Getter
public enum ProcessStatusEnum {
    INITIATE(1,"待发起"),
    TOAUDIT(2,"待审核"),
    AUDITFAIL(3,"审核失败"),
    AUDITSUCESS(4,"审核成功"),
    APPROVAL(5,"待批准"),
    APPROVALFAIL(6,"批准失败"),
    APPROVALSUCCESS(7,"批准成功");
    private Integer code;
    private String message;

    private static final Map<Integer, ProcessStatusEnum> lookup = new HashMap<>();

    static {
        for(ProcessStatusEnum e : EnumSet.allOf(ProcessStatusEnum.class)){
            lookup.put(e.getCode(), e);
        }
    }

    public static ProcessStatusEnum find(Integer code){
        return lookup.get(code);
    }
}
