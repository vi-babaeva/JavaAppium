package lib.ui.mobile_web;

import lib.ui.ArticlePageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MWArticlePageObject extends ArticlePageObject {
    static {
        SUBTITLE = "css:#content h1";
        FOOTER_ELEMENT = "css:footer ";
        OPTIONS_ADD_TO_MY_LIST_BUTTON = "css:#page-actions li#ca-watch button";
        //ARTICLE_TO_DELETE = "id:Java (programming language) Object-oriented programming language";
        //ARTICLE_WITH_TITLE_TO_STAY = "id:JavaScript High-level programming language";
    }

    public MWArticlePageObject(RemoteWebDriver driver){
        super(driver);
    }
}
