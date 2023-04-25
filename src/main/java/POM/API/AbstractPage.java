package POM.API;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

public abstract class AbstractPage implements PrimekraftAPI {

    public static SelenideElement $(String cssSelector) {
        return Selenide.$(cssSelector);
    }

    public static SelenideElement $(By locator) {
        return Selenide.$(locator);
    }

    public SelenideElement $(String cssSelector, int index) {
        return Selenide.$(cssSelector, index);
    }

    public SelenideElement $(By locator, int index) {
        return Selenide.$(locator, index);
    }

    public void open(String url) {
        Selenide.open(url);
    }

    public void refresh() {
        Selenide.refresh();
    }

    public void back() {
        Selenide.back();
    }

    public void forward() {
        Selenide.forward();
    }

    public String getTitle() {
        return Selenide.title();
    }

    @Override
    public abstract void submit();


}

