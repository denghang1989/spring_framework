package com.dhcc.cn.framework.dto.emergency;

import lombok.Data;

@Data
public class EICUData {
/*    病区总人数
            入院人数
    出院人数*/

    /**
     * 病区总人数
     */
    private int item1;
    /**
     * 入院人数
     */
    private int item2;
    /**
     * 出院人数
     */
    private int item3;
}
