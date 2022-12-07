package com.ita.edu.speakua.ui.headercomponent;

import com.ita.edu.speakua.ui.AdminProfileMenu;
import com.ita.edu.speakua.ui.BasePO;
import com.ita.edu.speakua.ui.ClubsPO.ClubsPO;
import com.ita.edu.speakua.ui.GuestProfileMenu;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HeaderComponent extends BasePO {
    @FindBy(xpath = "//div[contains(@class, 'user-profile')]")
    private WebElement profileMenuButton;

    @FindBy(xpath = "//a[contains(text(), 'Гуртки')]")
    private WebElement clubButton;


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

    public ClubsPO clickClub(){
        clubButton.click();
        sleep(3);
        return new ClubsPO(this.driver);
    }

}
