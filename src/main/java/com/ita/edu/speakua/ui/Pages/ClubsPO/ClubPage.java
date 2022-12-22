package com.ita.edu.speakua.ui.Pages.ClubsPO;

import com.ita.edu.speakua.ui.BasePageWithHeader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ClubPage extends BasePageWithHeader {

    @FindBy(xpath = "//span[@class='contact-name']")
    private WebElement fieldNumberPhone;

    @FindBy(xpath = "//div[@class='links']//div[3]/span[@class='contact-name']")
    private WebElement fieldLoginSkype;

    @FindBy(xpath = "//div[@class='content']")
    private WebElement fieldDescriptionAboutCenter;

    public ClubPage(WebDriver driver) {
        super(driver);
    }

    public String getDescriptionAboutCenter() {
        wait.visibility(fieldDescriptionAboutCenter);
       return fieldDescriptionAboutCenter.getText();
    }

    public String getNumberPhone() {
        wait.visibility(fieldNumberPhone);
        return fieldNumberPhone.getText();
    }

    public String getLoginOfSkype() {
        wait.visibility(fieldLoginSkype);
        return fieldLoginSkype.getText();
    }

}
