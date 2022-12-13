package com.ita.edu.speakua.ui;

import com.ita.edu.speakua.ui.Pages.ClubsPO.ClubCard;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class AdvancedSearchModel extends BasePO{
    private List<ClubCard> cards;

    @FindBy(xpath = "//span[text()='Центр']")
    private WebElement centerButton;

    @FindBy(xpath = "//input[@class='ant-input-number-input']")
    private WebElement inputAgeChildField;

    @FindBy(xpath = "//span[@id='basic_age']")
    private WebElement valueAgeChildField;

    @FindBy(xpath = "//span[text()='за алфавітом']")
    private WebElement sortAlphabetical;
    @FindBy(xpath = "//span[@aria-label='arrow-up']")
    private WebElement sortDescending;
    @FindBy(xpath = "//span[@aria-label='arrow-down']")
    private WebElement sortAscending;
    @FindBy(xpath = "//span[text()='за рейтингом']")
    private WebElement sortByRating;
    @FindBy(xpath = "//div[contains(@class,'ant-card ant-card-bordered card')]")
    protected List<WebElement> cardsBody;


    public AdvancedSearchModel(WebDriver driver) {
        super(driver);
    }

    public AdvancedSearchModel clickCenter() {
        centerButton.click();
        return this;
    }
    public boolean isAdvancedSearchOpen() {
        try {
            wait.visibility(By.xpath("//div[contains(text(), 'Розширений пошук')]"));
            sleep(3);
            driver.findElement(By.xpath("//div[contains(text(), 'Розширений пошук')]"));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public String getAgeChildField(){
        return valueAgeChildField.getAttribute("value");
    }

    public AdvancedSearchModel EnterNumberAge(String ageNumber) {
        inputAgeChildField.sendKeys(ageNumber);
        sleep(2);
        return this;
    }

    public AdvancedSearchModel clickSortAlphabetical() {
        sortAlphabetical.click();
        return this;
    }

    public AdvancedSearchModel clickSortDescending() {
        sortDescending.click();
        return this;
    }

    public AdvancedSearchModel clickSortAscending() {
        sortAscending.click();
        return this;
    }

    public AdvancedSearchModel clickSortByRating() {
        sortByRating.click();
        return this;
    }

    public List<ClubCard> getCards() {
        this.cards = new ArrayList<>();
        for(WebElement cardBody: cardsBody) {
            this.cards.add(new ClubCard(this.driver, cardBody));
        }
        return cards;
    }









}
