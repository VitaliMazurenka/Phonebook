package com.phonebook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DeleteContactTests extends TestBase{
    //precondition
    @BeforeMethod
    public void precondition() {
        if (!isLoginLinkPresent()) {
            clickOnSignOutButton();
        }
        clickOnLoginLink();
        fillLoginRegisterForm(new User()
                .setEmail("kotopes@mail.com")
                .setPassword("Kot124_$!"));
        clickOnLoginButton();
        clickOnAddLink();
        fillContactForm(new Contact()
                .setName("Adam")
                .setLastName("Nickson")
                .setPhone("9998277727")
                .setEmail("adam1@gmail.ru")
                .setAddress("Berlin")
                .setDescription("goalkeeper"));
        clickOnSaveButton();
    }

    @Test
    public void removeContactTest() {
        int sizeBefore = sizeOfContacts();
        removeContact();
        pause(1000);
        int sizeAfter = sizeOfContacts();
        Assert.assertEquals(sizeAfter,sizeBefore-1);
    }

}
