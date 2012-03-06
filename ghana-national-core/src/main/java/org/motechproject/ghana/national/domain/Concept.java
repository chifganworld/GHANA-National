package org.motechproject.ghana.national.domain;

public enum Concept {
    OPV("ORAL POLIO VACCINATION DOSE"),
    PENTA("PENTA VACCINATION DOSE"),
    IPTI("INTERMITTENT PREVENTATIVE TREATMENT INFANTS DOSE"),
    MEASLES("MEASLES VACCINATION"),
    YF("YELLOW FEVER VACCINATION"),
    VITA("VITAMIN A"),
    BCG("BACILLE CAMILE-GUERIN VACCINATION"),
    IMMUNIZATIONS_ORDERED("IMMUNIZATIONS ORDERED"),
    CSM("CEREBRO-SPINAL MENINGITIS VACCINATION"),
    CWC_REG_NUMBER("CWC REGISTRATION NUMBER"),
    GRAVIDA("GRAVIDA"),
    HEIGHT("HEIGHT (CM)"),
    MUAC("MID-UPPER ARM CIRCUMFERENCE"),
    PARITY("PARITY"),
    EDD("ESTIMATED DATE OF CONFINEMENT"),
    ANC_REG_NUM("ANC REGISTRATION NUMBER"),
    IPT("INTERMITTENT PREVENTATIVE TREATMENT DOSE"),
    TT("TETANUS TOXOID DOSE"),
    CONFINEMENT_CONFIRMED("DATE OF CONFINEMENT CONFIRMED"),
    PREGNANCY("PREGNANCY"),
    NEW_CASE("NEW CASE"),
    NEW_PATIENT("NEW PATIENT"),
    REFERRED("REFERRED"),
    PRIMARY_DIAGNOSIS("PRIMARY DIAGNOSIS "),
    SECONDARY_DIAGNOSIS("SECONDARY DIAGNOSIS"),
    COMMENTS("COMMENTS"),
    MALARIA_RAPID_TEST("MALARIA RAPID TEST"),
    POSITIVE("POSITIVE"),
    NEGATIVE("NEGATIVE"),
    ACT_TREATMENT("ACT TREATMENT"),
    PREGNANCY_STATUS("PREGNANCY STATUS"),
    TERMINATION_TYPE("TERMINATION TYPE"),
    TERMINATION_PROCEDURE("PREGNANCY, TERMINATION PROCEDURE"),
    TERMINATION_COMPLICATION("TERMINATION COMPLICATION"),
    MATERNAL_DEATH("MATERNAL DEATH"),
    POST_ABORTION_FP_COUNSELING("POST-ABORTION FP COUNSELING"),
    SERIAL_NUMBER("SERIAL NUMBER"),
    VISIT_NUMBER("VISIT NUMBER"),
    SYSTOLIC_BLOOD_PRESSURE("SYSTOLIC BLOOD PRESSURE"),
    DIASTOLIC_BLOOD_PRESSURE("DIASTOLIC BLOOD PRESSURE"),
    WEIGHT_KG("WEIGHT (KG)"),
    IPT_REACTION("IPT REACTION"),
    NON_REACTIVE("NON-REACTIVE"),
    REACTIVE("REACTIVE"),
    INSECTICIDE_TREATED_NET_USAGE("INSECTICIDE TREATED NET USAGE"),
    FHR("FETAL HEART RATE"),
    FHT("FUNDAL HEIGHT"),
    URINE_PROTEIN_TEST("URINE PROTEIN TEST"),
    TRACE("TRACE"),
    URINE_GLUCOSE_TEST("URINE GLUCOSE TEST"),
    HEMOGLOBIN("HEMOGLOBIN"),
    VDRL_TREATMENT("VDRL TREATMENT"),
    VDRL("VDRL"),
    DEWORMER("DEWORMER"),
    PMTCT("PMTCT"),
    HIV_PRE_TEST_COUNSELING("HIV PRE-TEST COUNSELING"),
    HIV_POST_TEST_COUNSELING("HIV POST-TEST COUNSELING"),
    HIV_TEST_RESULT("HIV TEST RESULT"),
    PMTCT_TREATMENT("PMTCT TREATMENT"),
    HOUSE("HOUSE"),
    COMMUNITY("COMMUNITY"),
    MALE_INVOLVEMENT("MALE INVOLVEMENT"),
    NEXT_ANC_DATE("NEXT ANC DATE"),
    ANC_PNC_LOCATION("ANC PNC LOCATION"),
    CWC_LOCATION("CWC LOCATION"),
    POST_ABORTION_FP_ACCEPTED("POST-ABORTION FP ACCEPTED"),
    TETANUS_TOXOID_DOSE("TETANUS TOXOID DOSE"),
    DELIVERY_MODE("DELIVERY MODE"),
    DELIVERY_LOCATION("DELIVERY LOCATION"),
    DELIVERED_BY("DELIVERED BY"),
    DELIVERY_OUTCOME("DELIVERY OUTCOME"),
    BIRTH_OUTCOME("BIRTH OUTCOME"),
    DELIVERY_COMPLICATION("DELIVERY COMPLICATION"),
    VVF_REPAIR("VVF REPAIR"),
    RESPIRATION("RESPIRATORY RATE"),
    CORD_CONDITION("CORD CONDITION"),
    BABY_CONDITION("CONDITION OF BABY"),
    TEMPERATURE("TEMPERATURE (C)");

    private String name;

    Concept(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
