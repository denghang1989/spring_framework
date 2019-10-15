package com.dhcc.cn.framework.dto.emergency;

import lombok.Data;

/**
 * 24小时输液清创人数
 */
@Data
public class InjectData {

    /*
    *   肌肉注射量
        门诊静推量
        门诊输液量
        急诊输液量
        总输液量
          清创
        入院人数
    * */

    /**
     * 肌肉注射量
     */
    private int intramuscular;
    /**
     * 门诊静推量
     */
    private int intravenous;
    /**
     * 门诊输液量
     */
    private int transfusion;
    /**
     * 急诊输液量
     */
    private int emergencyInfusion;
    /**
     * 总输液量
     */
    private int totalInfusion;
    /**
     * 清创
     */
    private int debridement;
    /**
     * 入院人数
     */
    private int inpatient;
}
