package com.ita.edu.speakua.ui;

import com.ita.edu.speakua.ui.BasePO;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ExtendedSearchPage extends BasePO {

    @FindBy(xpath = "//span[text()='Центр']")
    private WebElement centerButton;

    public ExtendedSearchPage(WebDriver driver) {
        super(driver);
    }

    public ExtendedSearchPage clickCenter() {
        centerButton.click();
        return this;
    }

    public boolean isOpenedExtendedSearchPage(String name) {
        try {
            driver.findElement(By.xpath(String.format("//div[text()='Розширений пошук']", name)));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
