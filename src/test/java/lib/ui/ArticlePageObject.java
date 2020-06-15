package lib.ui;

import org.openqa.selenium.WebElement;
import lib.Platform;
import org.openqa.selenium.remote.RemoteWebDriver;

abstract public class ArticlePageObject extends MainPageObject {

    protected static String
            SUBTITLE,
            FOOTER_ELEMENT,
            OPTIONS_BUTTON,
            OPTIONS_ADD_TO_MY_LIST_BUTTON,
            OPTIONS_REMOVE_FROM_MY_LIST_BUTTON,
            MORE_OPTIONS_BUTTON,
            CREATE_NEW_LIST_OVERLAY,
            MY_LIST_NAME_INPUT,
            GOT_IT_BUTTON,
            MY_LIST_OK_BUTTON,
            SHOW_TAB_BUTTON,
            ADD_ARTICLE_TO_READ_LIST_BUTTON,
            ARTICLE_TO_DELETE,
            REMOVE_FROM_SAVED_BUTTON,
            ARTICLE_WITH_TITLE_TO_STAY;

    public ArticlePageObject(RemoteWebDriver  driver) {
        super(driver);
    }

    public WebElement waitForSubtitleElement(){
        return this.waitForElementPresent(SUBTITLE,
                "Cannot find article subtitle on page", 10);
    }

    public String getArticleSubtitle() {
        WebElement subtitle_element = waitForSubtitleElement();
        if (Platform.getInstance().isAndroid()) {
            return subtitle_element.getAttribute("text");
        } else if (Platform.getInstance().isIOS()) {
            return subtitle_element.getAttribute("name");
        } else {
            return subtitle_element.getText();
        }
    }

    public void swipeToFooter() {
        if (Platform.getInstance().isAndroid()){
            this.swipeUpToFindElement(FOOTER_ELEMENT,
                    "Cannot find the end of article",
                    40);
        } else if (Platform.getInstance().isIOS()){
            this.swipeUpTitleElementAppear(FOOTER_ELEMENT,
                    "Cannot find the end of article",
                    40);
        } else {
            this.scrollWebPageTillElementNotVisible(FOOTER_ELEMENT,
                    "Cannot find the end of article",
                    40);
        }
    }

    public void addArticlesToMySaved(){
        this.waitForElementAndClick(OPTIONS_ADD_TO_MY_LIST_BUTTON,
                "Cannot find option to add article to reading list",5);
    }

    public void addFirstArticleToMyList(String name_of_folder){
        if (Platform.getInstance().isMv()) {
            this.removeArticleFromSavedIfItAdded();
        }

        this.waitForElementAndClick(OPTIONS_BUTTON,
                "Cannot find 'More options' button",
                10);

        this.waitForElementAndClick(OPTIONS_ADD_TO_MY_LIST_BUTTON,
                "Cannot find 'My lists'",
                5);

        this.waitForElementAndClick(MORE_OPTIONS_BUTTON,
                "Cannot find 'More options' button on 'My lists' screen",
                5);

        this.waitForElementAndClick(CREATE_NEW_LIST_OVERLAY,
                "Cannot find 'Create new list'",
                5);

        this.waitForElementAndClear(MY_LIST_NAME_INPUT,
                "Cannot clear title 'My reading list'",
                5);

        this.waitForElementAndSendKeys(MY_LIST_NAME_INPUT,
                name_of_folder,
                "Cannot input title list",
                5);

        this.waitForElementAndClick(MY_LIST_OK_BUTTON,
                "Cannot find 'OK' button",
                5);

        this.waitForElementAndClick(SHOW_TAB_BUTTON,
                "Cannot find 'Show tabs' button",
                5);

        this.waitForElementAndClick(ADD_ARTICLE_TO_READ_LIST_BUTTON,
                "Cannot find 'Add this article to a reading list' button",
                5);

        this.waitForElementAndClick(GOT_IT_BUTTON,
                "Cannot find 'GOT IT' button",
                5);
    }

   public void addSecondArticleToMyList(String name_of_folder) {

        this.waitForElementAndClick(ADD_ARTICLE_TO_READ_LIST_BUTTON,
                "Cannot find 'Add this article to a reading list' button",
                5);
    }

    public void removeArticleFromSavedIfItAdded(){
        if (this.isElementPresent(OPTIONS_ADD_TO_MY_LIST_BUTTON)) {
            this.waitForElementAndClick(OPTIONS_ADD_TO_MY_LIST_BUTTON,
                    "Cannot click button to remove an article from saved",
                    3);
            this.waitForElementPresent(OPTIONS_ADD_TO_MY_LIST_BUTTON,
                    "Cann ot find button to add an article to saved list after removing it from this list before",
                    5);
        }
    }

    private static String getRemoveButtonByTitle(String article_subtitle) {
        return REMOVE_FROM_SAVED_BUTTON.replace("{SUBTITLE}", article_subtitle);
    }

    public void swipeToDeleteOneArticle (String article_subtitle) {
        if ((Platform.getInstance().isIOS()) || (Platform.getInstance().isAndroid())) {
            this.swipeElementToLeft(ARTICLE_TO_DELETE,
                    "Cannot find 'Object-oriented programming language' article topic");
        } else {
            String remove_locator = getRemoveButtonByTitle(article_subtitle);
            this.waitForElementAndClick(remove_locator,
                    "Cannot click button to remove article from saved",
                    10);
        }

        if (Platform.getInstance().isIOS()) {
            this.clickElementToTheRightUpperCorner(ARTICLE_TO_DELETE, "Cannot delete button on article");
        }

        if (Platform.getInstance().isMv()) {
            driver.navigate().refresh();
        }
    }

    public void checkThatOneArticleWasDeleted(){
        this.waitForElementNotPresent(ARTICLE_TO_DELETE,
                "Cannot delete saved article",
                25);

        this.waitForElementPresent(ARTICLE_WITH_TITLE_TO_STAY,
                "Cannot find 'JavaScript' topic in my folder",
                25);

        this.waitForElementAndClick(ARTICLE_WITH_TITLE_TO_STAY,
                "Cannot click 'High-level programming language' topic in my folder",
                5);
    }
}