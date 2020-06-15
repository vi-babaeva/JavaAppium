package lib.ui.mobile_web;

import lib.ui.ArticlePageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MWArticlePageObject extends ArticlePageObject {
    static {
        SUBTITLE = "css:#content h1";
        FOOTER_ELEMENT = "css:footer ";
        OPTIONS_ADD_TO_MY_LIST_BUTTON = "css:#page-actions li#ca-watch.mw-ui-icon-wikimedia-star-base20 button";
        OPTIONS_REMOVE_FROM_MY_LIST_BUTTON = "css:#page-actions li#ca-watch.mw-ui-icon-wikimedia-unStar-progressive watched button";
        ARTICLE_WITH_TITLE_TO_STAY = "css:#mw-content-text > ul > li:nth-child(1) > a.title > h3";
        ARTICLE_TO_DELETE = "";
    }

    public MWArticlePageObject(RemoteWebDriver driver){
        super(driver);
    }
}
