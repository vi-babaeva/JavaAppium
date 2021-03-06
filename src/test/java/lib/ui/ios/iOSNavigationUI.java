package lib.ui.ios;

import lib.ui.NavigationUI;
import org.openqa.selenium.remote.RemoteWebDriver;

public class iOSNavigationUI extends NavigationUI {

    static {
        BACK_BUTTON = "id:Back";
        CANCEL_BUTTON = "id:Cancel";
        VIEW_LIST_BUTTON = "id:Saved";
        CLOSE_POPUP_ICON = "xpath://XCUIElementTypeButton[@name='Close']";
    }
    public iOSNavigationUI(RemoteWebDriver driver) {
        super(driver);
    }
}
