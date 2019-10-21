package com.dhcc.cn.framework.dto.emergency;

import lombok.Data;

/**
 * 24小时就诊人数
 */
@Data
public class EmergencyData {

    /*
    *
    * 急诊内科		131
急诊外科	总就诊人数	176
	其中急诊人数	77
	其中狂犬疫苗数	99
急诊妇产		7
急诊五官		21
急诊抢救室		18
合计		355
其  中
Ⅰ级患者		0
Ⅱ级患者		4
Ⅲ级患者		197
Ⅳ级患者		154
胸痛病人		6
胸痛住院数		1

    *
    *
    * */



    /**
     * 急诊内科
     */
    private int geriatrics;

    /**
     * 急诊外科	总就诊人数
     */
    private int surgeryTotal;

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


    /**
     * 总计
     */
    private int total;

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
