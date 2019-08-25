package com.imooc.web1.error;

import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;

public interface CommonError {
    int getErrCode();

    String getErrMsg();

    CommonError setErrMsg(String msg);
}
