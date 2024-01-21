package test;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import org.testng.annotations.Test;
import utils.TestData;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static utils.TestData.BASE_URL;

public final class NavigationTest extends BaseTest {

    @Test
    public void testBaseUrlLanding() {
        getPage().navigate(BASE_URL);

        assertThat(getPage()).hasURL(BASE_URL + TestData.HOME_END_POINT);
    }

    @Test
    public void testForHimMenuNavigatesToForHimPage() {
        getPage().navigate(BASE_URL);

        getPage().getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName(TestData.FOR_HIM).setExact(true)).click();

        assertThat(getPage()).hasURL(BASE_URL + TestData.FOR_HIM_END_POINT);
    }

}
