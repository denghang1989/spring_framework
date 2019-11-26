package com.dhcc.cn.framework.datechanged;

import com.dhcc.cn.framework.dto.MedicalRescueForm;

public class MedicalRescueImpl implements DataChangedInterface<MedicalRescueForm> {

    @Override
    public void handleInsert(MedicalRescueForm medicalRescueForm) {
        //需要审批的审核院领导
        String approver = medicalRescueForm.getApprover();

    }

    @Override
    public void handleUpdate(MedicalRescueForm medicalRescueForm) {

    }
}
