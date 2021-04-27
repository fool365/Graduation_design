package cn.com.jinkang.module.standard.common.constants.result;

import java.io.Serializable;

public interface IResultCode extends Serializable {
    String getMessage();

    int getCode();
}
