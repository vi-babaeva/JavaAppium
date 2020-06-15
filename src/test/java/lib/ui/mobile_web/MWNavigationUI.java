package lib.ui.mobile_web;

import lib.ui.NavigationUI;
import org.openqa.selenium.remote.RemoteWebDriver;

    public class MWNavigationUI extends NavigationUI {

        static {
            VIEW_LIST_BUTTON = "css:div > div > a:nth-child(2)";
        }
        public MWNavigationUI(RemoteWebDriver driver) {
            super(driver);
        }
    }

