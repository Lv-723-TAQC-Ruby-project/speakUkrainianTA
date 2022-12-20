package com.ita.edu.speakua.ui.profilemenu;


import com.ita.edu.speakua.ui.BasePO;
import com.ita.edu.speakua.ui.Pages.CenterPO.AddCenterModal;
import com.ita.edu.speakua.ui.Pages.ClubsPO.AddClubModal;
import com.ita.edu.speakua.ui.Pages.ProfilePO.MyProfilePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserProfileMenu extends BasePO {

    @FindBy(xpath = "//div[contains(text(), 'Додати гурток')]")
    private WebElement addClubButton;

    @FindBy(xpath = "//div[contains(text(), 'Додати центр')]")
    private WebElement addCenterButton;

    @FindBy(xpath = "//div[contains(text(), 'Пошук сертифікатів')]")
    private WebElement searchCertificatesButton;

    @FindBy(xpath = "//a[contains(text(), 'Мій Профіль')]")
    private WebElement myProfileButton;

    @FindBy(xpath = "//span[contains(text(), 'Вийти')]")
    private WebElement quitButton;

    public UserProfileMenu(WebDriver driver) {
        super(driver);
    }

    public AddClubModal openAddClubModel() {
        addClubButton.click();
        return new AddClubModal(driver);
    }
    @Step("open add center modal")
    public AddCenterModal openAddCenterModel() {
        addCenterButton.click();
        return new AddCenterModal(driver);
    }

     public MyProfilePage openMyProfileModel() {
        wait.visibility(myProfileButton);
        action.click(myProfileButton);
        return new MyProfilePage(driver);
    }


}
