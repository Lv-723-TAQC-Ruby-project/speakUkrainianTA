package com.ita.edu.speakua;

import com.ita.edu.speakua.jdbc.entity.ClubsEntity;
import com.ita.edu.speakua.jdbc.entity.TasksEntity;
import com.ita.edu.speakua.jdbc.entity.UsersEntity;
import com.ita.edu.speakua.jdbc.services.ClubsService;
import com.ita.edu.speakua.jdbc.services.TasksService;
import com.ita.edu.speakua.jdbc.services.UsersService;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MyTest {


    @Test
    public void DBUser() {
        UsersService service = new UsersService();
        UsersEntity user = service.getByEmail("galamagal86@gmail.com");
        Assert.assertEquals(user.getId(), 292);
        user = service.getByEmail("galamagal86+1@gmail.com");
        Assert.assertNull(user);


    }

    @Test
    public void DBTask() {
        TasksService service = new TasksService();
        TasksEntity task = service.getByName("Task test checking");
        Assert.assertNotNull(task);
        Assert.assertEquals(task.getId(),1019);
    }
    @Test
    public void DBCenter() {
        ClubsService service = new ClubsService();
        ClubsEntity club = service.getByName("test123456");
        Assert.assertNotNull(club);
        Assert.assertEquals(club.getId(), 498);
    }
    @Test
    public void DBClub() {
    ClubsService service = new ClubsService();
    ClubsEntity club = service.getByName("syyygsyy");
        Assert.assertTrue(club.getDescription().contains("Тестовий гурток для додавання центру Тестовий гурток для додавання центру"));
        Assert.assertTrue(club.getContacts().contains("speakUA"));
        Assert.assertNotNull(club);
        Assert.assertEquals(club.getName(), "syyygsyy");
}

    @Test
    public void DBClubRating() {
        ClubsService service = new ClubsService();
        ClubsEntity club = service.getByRatingDSC().get(0);
        Assert.assertNotNull(club);
        Assert.assertEquals(club.getId(), 1);
    }

}
