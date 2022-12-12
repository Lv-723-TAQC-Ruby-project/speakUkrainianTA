package com.ita.edu.speakua.ui.ProfilePO;

import com.ita.edu.speakua.ui.BasePO;
import com.ita.edu.speakua.ui.BasePageWithHeader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyProfilePage extends BasePO {

    @FindBy(xpath = "//span[text()='Редагувати профіль']")
    private WebElement editProfileButton;

    @FindBy(xpath = "//a[@href='/dev/club/948']")
    private WebElement detailedSecondCenterButton;

    @FindBy(xpath = "//span[@class='contact-name']")
    private WebElement fieldNumberPhone;


    public MyProfilePage(WebDriver driver) {
        super(driver);
    }

    public EditProfileModel openEditProfileModel(){
        editProfileButton.click();
        return new EditProfileModel(driver);
    }

    public MyProfilePage clickDetailedSecondCenter(){
        wait.visibility(detailedSecondCenterButton);
        action.click(detailedSecondCenterButton);
        return this;
    }

    public String getNumberPhone() {
        return fieldNumberPhone.getText();
    }

    public boolean getDescriptionAboutCenter(String name) {
        try {
            driver.findElement(By.xpath(String.format("//div[@class='content']", name)));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
