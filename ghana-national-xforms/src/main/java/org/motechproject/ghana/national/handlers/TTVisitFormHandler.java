package org.motechproject.ghana.national.handlers;

import org.motechproject.ghana.national.bean.TTVisitForm;
import org.motechproject.ghana.national.domain.Constants;
import org.motechproject.ghana.national.domain.Facility;
import org.motechproject.ghana.national.domain.Patient;
import org.motechproject.ghana.national.domain.TTVaccineDosage;
import org.motechproject.ghana.national.service.MotherVisitService;
import org.motechproject.ghana.national.service.FacilityService;
import org.motechproject.ghana.national.service.PatientService;
import org.motechproject.ghana.national.service.StaffService;
import org.motechproject.mobileforms.api.callbacks.FormPublishHandler;
import org.motechproject.model.MotechEvent;
import org.motechproject.mrs.model.MRSUser;
import org.motechproject.openmrs.advice.ApiSession;
import org.motechproject.openmrs.advice.LoginAsAdmin;
import org.motechproject.server.event.annotations.MotechListener;
import org.motechproject.util.DateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TTVisitFormHandler implements FormPublishHandler {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    private MotherVisitService motherVisitService;
    private PatientService patientService;
    private FacilityService facilityService;
    private StaffService staffService;

    public TTVisitFormHandler() {
    }

    @Autowired
    public TTVisitFormHandler(MotherVisitService motherVisitService, PatientService patientService, FacilityService facilityService, StaffService staffService) {
        this.motherVisitService = motherVisitService;
        this.patientService = patientService;
        this.facilityService = facilityService;
        this.staffService = staffService;
    }

    @Override
    @MotechListener(subjects = "form.validation.successful.NurseDataEntry.TTVisit")
    @LoginAsAdmin
    @ApiSession
    public void handleFormEvent(MotechEvent event) {
        try{
            TTVisitForm ttVisitForm = (TTVisitForm) event.getParameters().get(Constants.FORM_BEAN);
            final Facility facility = facilityService.getFacilityByMotechId(ttVisitForm.getFacilityId());
            final Patient patient = patientService.getPatientByMotechId(ttVisitForm.getMotechId());
            final MRSUser staff = staffService.getUserByEmailIdOrMotechId(ttVisitForm.getStaffId());
            motherVisitService.receivedTT(TTVaccineDosage.byValue(Integer.parseInt(ttVisitForm.getTtDose())),
                    patient, staff, facility, DateUtil.newDate(ttVisitForm.getDate()));
        }catch (Exception e){
            log.error("Encountered error while recording TT vaccination visit", e);
        }
    }
}
