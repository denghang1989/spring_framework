package com.dhcc.cn.framework.datechanged;

public interface DataChangedInterface<T> {

    void handleInsert(T t);

    void handleUpdate(T t);

}