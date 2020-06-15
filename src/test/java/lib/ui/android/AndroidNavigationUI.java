package lib.ui.android;

import lib.ui.NavigationUI;
import org.openqa.selenium.remote.RemoteWebDriver;

public class AndroidNavigationUI extends NavigationUI {
    static {
        NAVIGATE_UP_BUTTON ="xpath://android.widget.ImageButton[@content-desc='Navigate up']";
        NO_THANKS_BUTTON = "id:android:id/button2";
        VIEW_LIST_BUTTON = "id:org.wikipedia:id/snackbar_action";
        EXPLORE_BUTTON = "xpath://android.widget.FrameLayout[@content-desc='Explore']/android.widget.ImageView";
    }

    public AndroidNavigationUI(RemoteWebDriver driver){
        super(driver);
    }
}
