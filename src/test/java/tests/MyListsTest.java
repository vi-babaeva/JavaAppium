package tests;

import lib.CoreTestCase;
import lib.Platform;
import lib.ui.*;
import lib.ui.factories.ArticlePageObjectFactory;
import lib.ui.factories.NavigationUIFactory;
import lib.ui.factories.SearchPageObjectFactory;
import org.junit.Test;

public class MyListsTest extends CoreTestCase {

    private static final String name_of_folder = "Learning programming";
    private static final String
            login = "vi-babaeva",
            password ="qwerty098";

    @Test
    public void testSaveTwoArticlesToTestListAndDeleteOneArticle(){
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);

        if ((Platform.getInstance().isAndroid()) || (Platform.getInstance().isIOS())) {
            SearchPageObject.skipClick();
        }
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.clickByArticleWithSubstring("bject-oriented programming language");

        ArticlePageObject ArticlePageObject = ArticlePageObjectFactory.get(driver);
        ArticlePageObject.waitForSubtitleElement();
        String article_subtitle = ArticlePageObject.getArticleSubtitle();

        if (Platform.getInstance().isAndroid()) {
            ArticlePageObject.addFirstArticleToMyList(name_of_folder);
            MyListsPageObject MyListsPageObject = new MyListsPageObject(driver);
            MyListsPageObject.openFolderByName(name_of_folder);
            NavigationUI NavigationUI = NavigationUIFactory.get(driver);
            NavigationUI.goBackToAddNewArticle(name_of_folder);

            SearchPageObject.initSearchInput();
            SearchPageObject.typeSearchLine("Java");
            SearchPageObject.clickByArticleWithSubstring("igh-level programming language");
            ArticlePageObject.addSecondArticleToMyList(name_of_folder);
            MyListsPageObject.openFolderByName(name_of_folder);
            NavigationUI.goToMyList();
        } else if (Platform.getInstance().isIOS()) {
            ArticlePageObject.addArticlesToMySaved();
            NavigationUI NavigationUI = NavigationUIFactory.get(driver);
            NavigationUI.backToSearchList();
            SearchPageObject.clickByArticleWithSubstring("igh-level programming language");
            ArticlePageObject.addArticlesToMySaved();
            NavigationUI.backToSearchList();
            NavigationUI.clickOnCancelButton();
            NavigationUI.goToMyList();
            NavigationUI.closeSyncSavedArticlesPopUp();
        } else {
            AuthorizationPageObject Auth = new AuthorizationPageObject(driver);
            Auth.clickAuthButton();
            Auth.enterLoginData(login, password);
            Auth.submitForm();

            ArticlePageObject.waitForSubtitleElement();

            assertEquals("We are not on the same page after login",
                    article_subtitle,
                    ArticlePageObject.getArticleSubtitle());

            ArticlePageObject.addArticlesToMySaved();
            SearchPageObject.initSearchInput();
            SearchPageObject.typeSearchLine("Java");
            SearchPageObject.clickByArticleWithSubstring("igh-level programming language");
            ArticlePageObject.addArticlesToMySaved();

            NavigationUI NavigationUI = NavigationUIFactory.get(driver);
            NavigationUI.goToMyList();
        }
        ArticlePageObject.swipeToDeleteOneArticle(article_subtitle);
        ArticlePageObject.checkThatOneArticleWasDeleted();

        assertEquals(
                "We see unexpected subtitle!",
                "High-level programming language",
                article_subtitle);
    }
}
