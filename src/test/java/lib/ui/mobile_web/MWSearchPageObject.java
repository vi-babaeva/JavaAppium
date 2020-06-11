package lib.ui.mobile_web;

import lib.ui.SearchPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MWSearchPageObject extends SearchPageObject {
    static {
        SEARCH_INIT_ELEMENT = "css:button#searchIcon";
        SEARCH_INPUT = "css:form>input[type='search']";
        SEARCH_RESULT_BY_SUBSTRING_TPL = "xpath://div[contains(@class, 'wikipedia-description')][contains(text(), '{SUBSTRING}')]";
        SEARCH_CANCEL_BUTTON = "css:button.cancel";
        //SEARCH_RESULT_LIST = "xpath://XCUIElementTypeCollectionView//XCUIElementTypeCell";
        SEARCH_RESULT_ELEMENT = "css:ul.page-list>li.page-summary";
        SEARCH_EMPTY_RESULT_ELEMENT = "css:p.without-results";
        //SEARCH_RESULT_TITLE_LOCATOR_TPL = "xpath://XCUIElementTypeLink[contains(@name,'{TITLE}')]";
    }

    public MWSearchPageObject (RemoteWebDriver driver) {
        super(driver);
    }
}
