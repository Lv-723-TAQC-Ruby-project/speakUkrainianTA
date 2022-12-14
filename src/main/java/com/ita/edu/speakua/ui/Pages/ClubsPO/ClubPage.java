package com.ita.edu.speakua.ui.Pages.ClubsPO;

import com.ita.edu.speakua.ui.BasePageWithHeader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ClubPage extends BasePageWithHeader {

    @FindBy(xpath = "//span[@class='contact-name']")
    private WebElement fieldNumberPhone;
    public ClubPage(WebDriver driver) {
        super(driver);
    }
    public boolean getDescriptionAboutCenter(String name) {
        try {
            driver.findElement(By.xpath(String.format("//div[@class='content']", name)));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public String getNumberPhone() {
        return fieldNumberPhone.getText();
    }
}
