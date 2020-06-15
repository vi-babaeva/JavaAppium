package lib.ui.ios;

import lib.ui.SearchPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class iOSSearchPageObject extends SearchPageObject {
    static {
        SKIP_BUTTON = "id:Skip";
        SEARCH_INIT_ELEMENT = "id:Search Wikipedia";
        SEARCH_INPUT = "id:Search Wikipedia";
        SEARCH_RESULT_BY_SUBSTRING_TPL = "xpath://XCUIElementTypeLink[contains(@name,'{SUBSTRING}')]";
        SEARCH_CANCEL_BUTTON = "id:Clear text";
        SEARCH_RESULT_LIST = "xpath://XCUIElementTypeCollectionView//XCUIElementTypeCell";
        SEARCH_RESULT_ELEMENT = "xpath://XCUIElementTypeLink";
        SEARCH_EMPTY_RESULT_ELEMENT = "id:No results found";
        SEARCH_RESULT_TITLE_LOCATOR_TPL = "xpath://XCUIElementTypeLink[contains(@name,'{TITLE}')]";
    }

    public iOSSearchPageObject(RemoteWebDriver driver) {
        super(driver);
    }
}
