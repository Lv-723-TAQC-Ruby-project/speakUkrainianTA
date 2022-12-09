package com.ita.edu.speakua.ui.headercomponent;

import com.ita.edu.speakua.ui.BasePO;
import com.ita.edu.speakua.ui.ClubsPO.ClubsPage;
import com.ita.edu.speakua.ui.ExtendedSearchPage;
import com.ita.edu.speakua.ui.profilemenu.AdminProfileMenu;
import com.ita.edu.speakua.ui.profilemenu.GuestProfileMenu;
import com.ita.edu.speakua.ui.profilemenu.UserProfileMenu;
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
    public AdminProfileMenu openAdminProfileMenu() {
        profileMenuButton.click();
        return new AdminProfileMenu(driver);
    }

    public ClubsPage clickClub(){
        clubButton.click();
        sleep(3);
        return new ClubsPage(this.driver);
    }

    public ExtendedSearchPage openExtendedSearch(){
        extendedSearchButton.click();
        return new ExtendedSearchPage(driver);
    }

    public UserProfileMenu openUserProfileMenu(){
        profileMenuButton.click();
        return new UserProfileMenu(driver);
    }

}
