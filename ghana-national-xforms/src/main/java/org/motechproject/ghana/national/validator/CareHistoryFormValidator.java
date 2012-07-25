package org.motechproject.ghana.national.validator;

import org.motechproject.ghana.national.bean.CareHistoryForm;
import org.motechproject.ghana.national.domain.Patient;
import org.motechproject.ghana.national.validator.patient.ExistsInDb;
import org.motechproject.ghana.national.validator.patient.HistoryDateValidator;
import org.motechproject.ghana.national.validator.patient.IsAlive;
import org.motechproject.ghana.national.validator.patient.RegClientFormSubmittedInSameUpload;
import org.motechproject.mobileforms.api.domain.FormBean;
import org.motechproject.mobileforms.api.domain.FormBeanGroup;
import org.motechproject.mobileforms.api.domain.FormError;
import org.motechproject.mobileforms.api.validator.FormValidator;
import org.motechproject.openmrs.advice.ApiSession;
import org.motechproject.openmrs.advice.LoginAsAdmin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class CareHistoryFormValidator extends FormValidator<CareHistoryForm> {

    @Autowired
    private org.motechproject.ghana.national.validator.FormValidator formValidator;

    @Override
    @LoginAsAdmin
    @ApiSession
    public List<FormError> validate(CareHistoryForm formBean, FormBeanGroup group, List<FormBean> allForms) {
        List<FormError> formErrors = super.validate(formBean, group, allForms);
        formErrors.addAll(formValidator.validateIfStaffExists(formBean.getStaffId()));
        formErrors.addAll(formValidator.validateIfFacilityExists(formBean.getFacilityId()));
        Patient patient = formValidator.getPatient(formBean.getMotechId());
        formErrors.addAll(dependentValidator().validate(patient, group.getFormBeans(),
                allForms, new ExistsInDb().onSuccess(new IsAlive()).onFailure(new RegClientFormSubmittedInSameUpload())));
        formErrors.addAll(historyDateValidator(formBean).validate(patient,group.getFormBeans(),allForms));
        return formErrors;
    }

    DependentValidator dependentValidator() {
        return new DependentValidator();
    }

    HistoryDateValidator historyDateValidator(CareHistoryForm form) {
        return new HistoryDateValidator(form);
    }
}
