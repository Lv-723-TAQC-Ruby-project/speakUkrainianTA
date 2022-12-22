package com.ita.edu.speakua.ui.Pages.ClubsPO;

import com.ita.edu.speakua.ui.BasePageWithHeader;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ClubsPage extends BasePageWithHeader {


    @FindBy(xpath = "//div[contains(@class,'ant-card ant-card-bordered card')]")
    protected List<WebElement> cardsBody;
    private List<ClubCard> cards;
    private AdvancedSearchComponent advancedSearchComponent;

    public ClubsPage(WebDriver driver) {
        super(driver);
    }

    public List<ClubCard> getCards() {
        this.cards = new ArrayList<>();
        for (WebElement cardBody : cardsBody) {
            this.cards.add(new ClubCard(this.driver, cardBody));
        }
        return cards;
    }

    public ClubCard getCard(int id) {
        return getCards().get(id);
    }
    public ClubCard getLastCard() {
        int lastCard = getCards().size()-1;
        return getCards().get(lastCard);
    }

    @Step
    public ClubCard getCardByName(String name) {
        for (ClubCard card : getCards()) {
            if (Objects.equals(card.getTitleInMyProfile(), name)) {
                return card;
            }
        }
        return null;
    }

    public AdvancedSearchComponent getAdvancedSearchComponent() {
        advancedSearchComponent = new AdvancedSearchComponent(driver);
        return advancedSearchComponent;
    }

}
