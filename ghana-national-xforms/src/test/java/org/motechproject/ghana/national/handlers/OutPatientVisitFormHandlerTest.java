package org.motechproject.ghana.national.handlers;


import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.motechproject.ghana.national.bean.OutPatientVisitForm;
import org.motechproject.ghana.national.domain.Constants;
import org.motechproject.ghana.national.service.EncounterService;
import org.motechproject.model.MotechEvent;
import org.motechproject.mrs.model.MRSObservation;
import org.motechproject.mrs.model.MRSPatient;
import org.motechproject.mrs.services.MRSPatientAdaptor;
import org.motechproject.util.DateUtil;
import org.springframework.test.util.ReflectionTestUtils;
import org.unitils.reflectionassert.ReflectionComparatorMode;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;
import static org.unitils.reflectionassert.ReflectionAssert.assertReflectionEquals;

public class OutPatientVisitFormHandlerTest {

    OutPatientVisitFormHandler handler;

    @Mock
    EncounterService mockEncounterService;

    @Mock
    MRSPatientAdaptor mockMRSPatientAdaptor;

    @Before
    public void setUp() {
        initMocks(this);
        handler = new OutPatientVisitFormHandler();
        ReflectionTestUtils.setField(handler, "encounterService", mockEncounterService);
        ReflectionTestUtils.setField(handler, "patientAdaptor", mockMRSPatientAdaptor);
    }

    @Test
    public void shouldHandleEvent() {

        final OutPatientVisitForm form = new OutPatientVisitForm();
        String staffId = "staffId";
        String facilityId = "facilityId";
        Date visitDate = DateUtil.today().toDate();
        int secondDiagnosis = 65;
        boolean isNewCase = true;
        boolean isNewPatient = true;
        boolean isReferred = true;
        boolean isInsured = true;
        int diagnosis = 10;
        String motechId="motechId";

        form.setNewCase(isNewCase);
        form.setStaffId(staffId);
        form.setFacilityId(facilityId);
        form.setMotechId(motechId);
        form.setVisitDate(visitDate);
        String comments = "comments";
        form.setComments(comments);
        form.setDiagnosis(OutPatientVisitFormHandler.OTHER_DIAGNOSIS);
        form.setOtherDiagnosis(diagnosis);
        form.setSecondDiagnosis(secondDiagnosis);
        form.setNewPatient(isNewPatient);
        form.setReferred(isReferred);
        form.setInsured(isInsured);
        MotechEvent motechEvent = new MotechEvent("form.validation.successful.NurseDataEntry.opvVisit", new HashMap<String, Object>() {{
            put(Constants.FORM_BEAN, form);
        }});
        MRSPatient mockMrsPatient = mock(MRSPatient.class);
        when(mockMRSPatientAdaptor.getPatientByMotechId(motechId)).thenReturn(mockMrsPatient);

        handler.handleFormEvent(motechEvent);

        ArgumentCaptor<Set> argumentCaptor = ArgumentCaptor.forClass(Set.class);

        verify(mockEncounterService).persistEncounter(eq(mockMrsPatient), eq(staffId), eq(facilityId), eq(OutPatientVisitFormHandler.ENCOUNTER_TYPE), eq(visitDate), argumentCaptor.capture());

        Set<MRSObservation> actualObservations = argumentCaptor.getValue();

        Set<MRSObservation> expectedObservations = new HashSet<MRSObservation>();
        expectedObservations.add(new MRSObservation(visitDate, Constants.CONCEPT_NEW_CASE, isNewCase));
        expectedObservations.add(new MRSObservation(visitDate, Constants.CONCEPT_INSURED, isInsured));
        expectedObservations.add(new MRSObservation(visitDate, Constants.CONCEPT_NEW_PATIENT, isNewPatient));
        expectedObservations.add(new MRSObservation(visitDate, Constants.CONCEPT_PRIMARY_DIAGNOSIS, diagnosis));
        expectedObservations.add(new MRSObservation(visitDate, Constants.CONCEPT_SECONDARY_DIAGNOSIS, secondDiagnosis));
        expectedObservations.add(new MRSObservation(visitDate, Constants.CONCEPT_REFERRED, isReferred));
        expectedObservations.add(new MRSObservation(visitDate, Constants.CONCEPT_COMMENTS, comments));
        assertReflectionEquals(actualObservations, expectedObservations, ReflectionComparatorMode.LENIENT_DATES,
                ReflectionComparatorMode.LENIENT_ORDER);
    }
}
