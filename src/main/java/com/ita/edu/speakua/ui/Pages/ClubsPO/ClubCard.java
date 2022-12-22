package com.ita.edu.speakua.ui.Pages.ClubsPO;

import com.ita.edu.speakua.ui.BasePO;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;

import java.util.List;

public class ClubCard extends BasePO {
    protected WebElement cardBody;
    @FindBy(xpath = ".//div[@class='title']")
    protected WebElement title;

    @FindBy(xpath = ".//div[@class='center-name']")
    protected WebElement titleOfCenter;

    @FindBy(xpath = ".//div[@class='title-name']")
    protected WebElement titleCardInMyProfile;

    @FindBy(xpath = ".//ul[@class='ant-rate ant-rate-disabled']")
    private WebElement ratingStars;

    @FindBy(xpath = ".//li[@class='ant-rate-star ant-rate-star-full']")
    private List<WebElement> fullRatingStars;

    @FindBy(xpath = ".//li[@class='ant-rate-star ant-rate-star-zero']")
    private List<WebElement> emptyRatingStar;

    @FindBy(xpath = ".//div[@class='ant-card ant-card-bordered card']")
    private WebElement clubCard;

    @FindBy(xpath = ".//a[text()='Детальніше']")
    private WebElement detailButton;

    @FindBy(xpath = "//div[text()='Редагувати гурток']")
    private WebElement editClubButton;
    @FindBy(xpath = ".//div[@class='update-club-dropdown']")
    private WebElement menuClubButton;

    public ClubCard(WebDriver driver) {
        super(driver);
    }

    public ClubCard(WebDriver driver, WebElement cardBody) {
        super(driver);
        this.cardBody = cardBody;
        PageFactory.initElements(new DefaultElementLocatorFactory(this.cardBody), this);
    }

    public int getRatingStars() {
        return fullRatingStars.size();
    }


    public String getTitle() {
        return this.title.getText();
    }

    public String getTitleOfCenter() {
        wait.visibility(titleOfCenter);
        return this.titleOfCenter.getText();
    }
    public String getTitleInMyProfile() {
        wait.visibility(titleCardInMyProfile);
        return this.titleCardInMyProfile.getText();
    }
    public ClubPage getDetailInformation() {
        wait.visibility(detailButton);
        action.click(detailButton);
        sleep(3);
        return new ClubPage(driver);
    }

    public EditClubModal openEditClubModel() {
        wait.visibility(menuClubButton);
        action.click(menuClubButton);
        editClubButton.click();
        return new EditClubModal(driver);
    }


}
