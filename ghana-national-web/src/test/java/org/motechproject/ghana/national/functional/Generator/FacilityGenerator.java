package org.motechproject.ghana.national.functional.Generator;

import org.motechproject.functional.data.TestFacility;
import org.motechproject.functional.framework.Browser;
import org.motechproject.functional.pages.facility.FacilityPage;
import org.motechproject.functional.pages.facility.SearchFacilityPage;
import org.motechproject.functional.pages.home.HomePage;
import org.motechproject.functional.util.DataGenerator;
import org.motechproject.openmrs.advice.ApiSession;
import org.motechproject.openmrs.advice.LoginAsAdmin;
import org.springframework.stereotype.Component;

@Component
public class FacilityGenerator {

    FacilityPage facilityPage;
    DataGenerator dataGenerator;
    TestFacility facility;

    @LoginAsAdmin
    @ApiSession
    public String createFacilityAndReturnFacilityId(Browser browser, HomePage homePage) {
        dataGenerator = new DataGenerator();
        facilityPage = browser.toFacilityPage(homePage);
        facility = TestFacility.with("facility ghana" + dataGenerator.randomString(2));
        facilityPage.save(facility);
        return facilityPage.facilityId();
    }

    public String getFacilityId(String facilityMotechId, Browser browser) {
        SearchFacilityPage searchFacilityPage = browser.toSearchFacility(facilityPage);
        searchFacilityPage.withFacilityId(facilityMotechId).search();
        searchFacilityPage.clickEditLink(facility);
        FacilityPage facilityPage = browser.getFacilityPage();
        return facilityPage.id();
    }
}
