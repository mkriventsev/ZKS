package cz.cvut.fel.still.sqa.arastta.pageobjects;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

/**
 * @author Maksym Kriventsev
 */
public class SearchForm extends PageObject {

    public static Target SEARCH_BUTTON = Target.the("Search button").located(By.xpath("//*[@data-target=\"#searchmenu\"]"));
    public static Target TEXT_FIELD = Target.the("Search input").located(By.xpath("//div[@id=\"search\"]/input[@name=\"search\"]"));
    public static Target FIRST_SEARCH_RESULT_ELEMENNT = Target.the("First search result from search autocomplite ").locatedBy("//div[@id=\"search\"]/ul[@class=\"dropdown-menu\"]/li[1]/a");
    public static Target SUBMIT = Target.the("Search the i registartion form").locatedBy("//input[@type='submit']");
}


