package com.dhcc.cn.framework.dto.result;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class DataGridResult<T> {

    private int total;

    private List<T> rows;

    public DataGridResult(int total, List<T> rows) {
        this.total = total;
        this.rows = rows;
    }
}
