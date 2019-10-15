package com.dhcc.cn.framework.dto.emergency;

import lombok.Data;

/**
 * 24小时就诊人数
 */
@Data
public class EmergencyData {

    /**
     * 急诊内科
     */
    private int geriatrics;

    /**
     * 外科急诊人数
     */
    private int surgery;

    /**
     * 外科狂犬疫苗数
     */
    private int rabiesVaccine;

    /*
    急诊妇产
    急诊五官
    急诊抢救室
    */

    /**
     * 急诊妇产
     */
    private int maternity;

    /**
     * 急诊五官
     */
    private int otolaryngology;

    /**
     * 急诊抢救室
     */
    private int salvage;

    /*
    *   Ⅰ级患者
        Ⅱ级患者
        Ⅲ级患者
        Ⅳ级患者
        胸痛病人
        胸痛住院数
    *
    * */

    /**
     * Ⅰ级患者
     */
    private int onePatient;

    /**
     * Ⅱ级患者
     */
    private int twoPatient;

    /**
     * Ⅲ级患者
     */
    private int threePatient;

    /**
     * Ⅳ级患者
     */
    private int fourPatient;

    /**
     * 胸痛病人
     */
    private int thoracalgia;

    /**
     * 胸痛住院数
     */
    private int inPatient;

}
