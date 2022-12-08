package com.ita.edu.speakua.ui.headercomponent;

import com.ita.edu.speakua.ui.BasePO;
import com.ita.edu.speakua.ui.ClubsPO.ClubsPO;
import com.ita.edu.speakua.ui.ExtendedSearch;
import com.ita.edu.speakua.ui.GuestProfileMenu;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HeaderComponent extends BasePO {
    @FindBy(xpath = "//div[contains(@class, 'user-profile')]")
    private WebElement profileMenuButton;

    @FindBy(xpath = "//a[contains(text(), 'Гуртки')]")
    private WebElement clubButton;

    @FindBy(xpath = "//*[@data-icon='control']")
    private WebElement extendedSearchButton;


    public HeaderComponent(WebDriver driver) {
        super(driver);
    }

    public GuestProfileMenu openGuestProfileMenu() {
        profileMenuButton.click();
        return new GuestProfileMenu(driver);
    }

    public ClubsPO clickClub(){
        clubButton.click();
        sleep(3);
        return new ClubsPO(this.driver);
    }

    public ExtendedSearch openExtendedSearch(){
        extendedSearchButton.click();
        return new ExtendedSearch(driver);
    }

    public UserProfileMenu openUserProfileMenu(){
        profileMenuButton.click();
        return new UserProfileMenu(driver);
    }

}
