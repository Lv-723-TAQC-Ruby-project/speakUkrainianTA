package com.ita.edu.speakua.ui.headercomponent;

import com.ita.edu.speakua.ui.BasePO;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserProfileMenu extends BasePO {

    @FindBy(xpath = "//div[contains(text(), 'Додати гурток')]")
    private WebElement addClubButton;

    public UserProfileMenu(WebDriver driver) {
        super(driver);
    }
}
