package com.ita.edu.speakua.ui;

import com.ita.edu.speakua.ui.TaskPO.AddTaskPage;
import com.ita.edu.speakua.ui.runners.BaseTestRunner;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TaskTests extends BaseTestRunner {
    @BeforeClass
    public void setUp() {
        setDriver();
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
public void addTaskWithoutChallenge(){
      new HomePage(driver)
            .openAdminProfileMenu()
            .openTasksPage()
            .clickAddTask()
            .taskFieldsEmpty();
   Assert.assertEquals("","");
   AddTaskPage addTaskPage = new HomePage(driver)
           .openAdminProfileMenu()
           .openTasksPage()
           .clickAddTask()
           .enterStartDate("2023-03-03")
           .uploadImage("C:\\Users\\lovel\\IdeaProjects\\speakUkrainianTA723\\R.jpeg")
           .enterTaskName("LearnTest")
           .enterTaskTitle("Positive emotions like curiosity, satisfaction, and liveliness have a massive\n impact on how your brain processes your\n learning.")
           .enterTaskDescription("One of the key benefits of having fun while learning is that it creates a sense of reward in learning.\n That inherently motivates people.")
           .saveTaskClick();
Assert.assertTrue(addTaskPage.isContainErrorMessage(""),"Please,select challenge");
}




    @Test
    public void OpenAddTaskPage() {
        new HomePage(driver)
                .openAdminProfileMenu()
                .openTasksPage()
                .clickAddTask()
                .enterTaskDescription("12345");

    }



    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
