package com.ita.edu.speakua.ui;

import com.ita.edu.speakua.ui.Pages.ClubsPO.AddClubModal;
import com.ita.edu.speakua.ui.Pages.ClubsPO.ClubPage;
import com.ita.edu.speakua.ui.runners.BaseTestRunner;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ClubTests extends BaseTestRunner {

    @BeforeClass
    public void setUp(ITestContext context) {
        setDriver(context);
        new HomePage(driver)
                .openGuestProfileMenu()
                .openLoginModel()
                .enterEmail(configProperties.getAdminEmail())
                .enterPassword(configProperties.getAdminPassword())
                .clickLogin();
    }

    @BeforeMethod
    public void goHomePage() {
        driver.get(configProperties.getBaseWebUrl());
    }

    @Test
    public void addVerifyDescriptionClubTest() {
        AddClubModal addClubModal = new HomePage(driver)
                .openUserProfileMenu()
                .openAddClubModal()
                .EnterNameClub("Спорт")
                .selectCategoryByName("Спортивні секції")
                .enterFromAge("5")
                .enterToAge("10")
                .clickNextStep()
                .enterPhoneNumber("0932584213")
                .clickNextStep();


        SoftAssert softAssert = new SoftAssert();
        //TUA-176
        softAssert.assertTrue(addClubModal.enterClubDescription("В гурток ходить 3 людини").isErrorMessageDisplayed("Опис гуртка може містити від 40 до 1500 символів."));
        softAssert.assertTrue(addClubModal.enterClubDescription("!").isErrorMessageDisplayed("Опис гуртка може містити від 40 до 1500 символів."));
        softAssert.assertTrue(addClubModal.enterClubDescription("Заняття проходять тричі рази на тиждень").isErrorMessageDisplayed("Опис гуртка може містити від 40 до 1500 символів."));
        //TUA-177
        softAssert.assertTrue(addClubModal.enterClubDescription("Вихованці гуртка приймають активну участь як у міських, так і у обласних, Всеукраїнських та міжнародних змаганнях, Чемпіонатах та Кубках України серед юнаків де показують стабільно високі результати. Всі вони входять до збірної команди Львівської області з легкої атлетики.\n" +
                "Батьки вихованців беруть дуже активну участь у житті гуртка. Вони відвідують батьківські збори, тренування, допомагають у суддівстві, у придбанні інвентарю, спортивної форми.\n" +
                "Ведення учнями малорухливого способу життя призводить до таких наслідків як: збільшення індексу маси тіла, невпевненість в собі тощо. Одним з шляхів вирішення даної проблеми є створення мережі спортивних гуртків для навчальних закладів, які відповідають інтересам та потребам сучасного молодого покоління.\n" +
                "Наш гурток має низку переваг: \n" +
                "- Фізичний розвиток: сприяють загальному фізичному розвитку, зміцнюють здоров'я, розвивають спритність і координацію рухів, виробляють м'язову силу;\n" +
                "- Психічний розвиток: допомагають виробити силу волі, наполегливість, впевненість у собі, вміння постояти за себе, вміння терпіти біль і втому, долати перешкоди, навички роботи в команді;\n" +
                "- Додаткові переваги: хороший відпочинок після тривалого сидіння за партою, можливість дитині виплеснути накопичену енергію в конструктивній формі. Спортивні секції можуть бути найрізноманітнішими: хокей, волейбол, баскетбол, футбол, теніс, різні види боротьби, легка атлетика, батут, басейн. Всього і не перерахуєш. У кожного виду спорту своя специфіка. \n" +
                "Вибір лише за вами...").successMessageDisplayed());
        softAssert.assertTrue(addClubModal.enterClubDescription("'Education', 'students', 'Школа' 'балету'").successMessageDisplayed());
        softAssert.assertTrue(addClubModal.enterClubDescription("Вихованці гуртка приймають активну участь як у міських, так і у обласних, Всеукраїнських та міжнародних змаганнях, Чемпіонатах та Кубках України серед юнаків де показують стабільно високі результати. Всі вони входять до збірної команди Львівської області з легкої атлетики.\n" +
                "Батьки вихованців беруть дуже активну участь у житті гуртка. Вони відвідують батьківські збори, тренування, допомагають у суддівстві, у придбанні інвентарю, спортивної форми.\n" +
                "Ведення учнями малорухливого способу життя призводить до таких наслідків як: збільшення індексу маси тіла, невпевненість в собі тощо. Одним з шляхів вирішення даної проблеми є створення мережі спортивних гуртків для навчальних закладів, які відповідають інтересам та потребам сучасного молодого покоління.\n" +
                "Наш гурток має низку переваг: \n" +
                "- Фізичний розвиток: сприяють загальному фізичному розвитку, зміцнюють здоров'я, розвивають спритність і координацію рухів, виробляють м'язову силу;\n" +
                "- Психічний розвиток: допомагають виробити силу волі, наполегливість, впевненість у собі, вміння постояти за себе, вміння терпіти біль і втому, долати перешкоди, навички роботи в команді;\n" +
                "- Додаткові переваги: хороший відпочинок після тривалого сидіння за партою, можливість дитині виплеснути накопичену енергію в конструктивній формі. Спортивні секції можуть бути найрізноманітнішими: хокей, волейбол, баскетбол, футбол, теніс, різні види боротьби, легка атлетика, батут, басейн. Всього і не перерахуєш. У кожного виду спорту своя специфіка. \n" +
                "Вибір лише за вами....").isErrorMessageDisplayed("Опис гуртка може містити від 40 до 1500 символів."));
        softAssert.assertTrue(addClubModal.enterClubDescription("Вихованці гуртка приймають активну участь як у міських, так і у обласних, Всеукраїнських та міжнародних змаганнях, Чемпіонатах та Кубках України серед юнаків де показують стабільно високі результати. Всі вони входять до збірної команди Львівської області з легкої атлетики.\n" +
                "Батьки вихованців беруть дуже активну участь у житті гуртка. Вони відвідують батьківські збори, тренування, допомагають у суддівстві, у придбанні інвентарю, спортивної форми.\n" +
                "Ведення учнями малорухливого способу життя призводить до таких наслідків як: збільшення індексу маси тіла, невпевненість в собі тощо. Одним з шляхів вирішення даної проблеми є створення мережі спортивних гуртків для навчальних закладів, які відповідають інтересам та потребам сучасного молодого покоління.\n" +
                "Наш гурток має низку переваг: \n" +
                "- Фізичний розвиток: сприяють загальному фізичному розвитку, зміцнюють здоров'я, розвивають спритність і координацію рухів, виробляють м'язову силу;\n" +
                "- Психічний розвиток: допомагають виробити силу волі, наполегливість, впевненість у собі, вміння постояти за себе, вміння терпіти біль і втому, долати перешкоди, навички роботи в команді;\n" +
                "- Додаткові переваги: хороший відпочинок після тривалого сидіння за партою, можливість дитині виплеснути накопичену енергію в конструктивній формі. Спортивні секції можуть бути найрізноманітнішими: хокей, волейбол, баскетбол, футбол, теніс, різні види боротьби, легка атлетика, батут, басейн. Всього і не перерахуєш. У кожного виду спорту своя специфіка. \n" +
                "Вибір лише за вами, батьки....").isErrorMessageDisplayed("Опис гуртка може містити від 40 до 1500 символів."));
        //TUA-178
        softAssert.assertTrue(addClubModal.enterClubDescription("ё ы э ъ").isErrorMessageDisplayed("Опис гуртка не може містити російські літери"));
        //TUA-172
        softAssert.assertTrue(addClubModal.enterClubDescription("s".repeat(1000)).successMessageDisplayed());
        softAssert.assertTrue(addClubModal.enterClubDescription("s".repeat(40)).successMessageDisplayed());
        softAssert.assertTrue(addClubModal.enterClubDescription("s".repeat(1500)).successMessageDisplayed());
        //TUA-173
        softAssert.assertTrue(addClubModal.enterClubDescription("'Education', 'students', 'Школа' 'балету'").successMessageDisplayed());
        softAssert.assertTrue(addClubModal.enterClubDescription("1234567890123456789012345678901234567890").successMessageDisplayed());
        softAssert.assertTrue(addClubModal.enterClubDescription("!#$%&'()*+,-./:;<=>?@[]^_`{}~%^$#)&&^^(_&($%^#@!").successMessageDisplayed());
        softAssert.assertTrue(addClubModal.completeButtonEnabled());
        softAssert.assertAll();
    }

    @Test
    public void VerifyCreatingClubAndFindingInformationAboutItTest() {
        new HomePage(driver)
                .openUserProfileMenu()
                .openAddClubModal()
                .EnterNameClub("Малявки18.12.2022(22.00)")
                .selectCategoryByName("Спортивні секції")
                .enterFromAge("8")
                .enterToAge("16")
                .enterBelongingToCenter("Курси програмування IT-stat")
                .clickNextStep()
                .enterPhoneNumber("0934444444")
                .clickNextStep()
                .enterClubDescription("Відділення образотворчого та декоративного мистецтва відкрите з моменту заснування Студії.У 2005р. відбулась перша виставка робіт учасників Студії у Львівському обласному палаці мистецтв.")
                .finishAddingCenter();
        new HomePage(driver)
                .openUserProfileMenu()
                .openMyProfileModal()
                .clickLastElementOfTheListOfCenters()
                .getClubsPage()
                .getCardByName("Малявки18.12.2022(22.00)")
                .getDetailInformation();
        String checkInformationAboutCenterByNumber = new ClubPage(driver)
                .getNumberPhone();
        Assert.assertEquals(checkInformationAboutCenterByNumber, "+380934444444");
        boolean checkInformationAboutCenterByDescription = new ClubPage(driver).isDescriptionAboutCenter("Відділення образотворчого та декоративного мистецтва відкрите з моменту заснування Студії.У 2005р. відбулась перша виставка робіт учасників Студії у Львівському обласному палаці мистецтв.");
        Assert.assertTrue(checkInformationAboutCenterByDescription);
    }

    @Test
    public void VerifyEditingClubAndFindingInformationAboutItTest() {
        new HomePage(driver)
                .openUserProfileMenu()
                .openMyProfileModal()
                .clickLastElementOfTheListOfCenters()
                .getClubsPage()
                .getCardByName("Малявки18.12.2022(22.00)")
                .openEditClubModel()
                .openAddressAndContactsSection()
                .enterPhoneNumber("0672222222")
                .clickSaveInContactSectionButton()
                .openDescriptionSection()
                .enterClubDescription("Тестовий гурток для додавання центру Тестовий гурток для додавання центру")
                .clickSaveInDescriptionSectionButton()
                .clickLastElementOfTheListOfCenters()
                .getClubsPage()
                .getCardByName("Малявки18.12.2022(22.00)")
                .getDetailInformation();
        String checkInformationAboutCenterByNumber = new ClubPage(driver)
                .getNumberPhone();
        Assert.assertEquals(checkInformationAboutCenterByNumber, "0672222222");
        boolean checkInformationAboutCenterByDescription = new ClubPage(driver).isDescriptionAboutCenter("Тестовий гурток для додавання центру Тестовий гурток для додавання центру");
        Assert.assertTrue(checkInformationAboutCenterByDescription);


    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}


