package lib.ui.ios;

import lib.ui.ArticlePageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class iOSArticlePageObject extends ArticlePageObject {

    static {
        SUBTITLE = "id:Object-oriented programming language";
        FOOTER_ELEMENT = "id:View article in browser";
        OPTIONS_ADD_TO_MY_LIST_BUTTON = "xpath://XCUIElementTypeButton[@name='Save for later']";
        ARTICLE_TO_DELETE = "id:Java (programming language) Object-oriented programming language";
        ARTICLE_WITH_TITLE_TO_STAY = "id:JavaScript High-level programming language";
    }

    public iOSArticlePageObject(RemoteWebDriver driver){
        super(driver);
    }
}
