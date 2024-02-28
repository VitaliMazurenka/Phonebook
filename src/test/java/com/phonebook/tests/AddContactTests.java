package com.phonebook.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class AddContactTests extends TestBase {
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
    }
    @Test
    public void addContactPositiveTest() {
        clickOnAddLink();
        fillContactForm(new Contact()
                .setName("Adam")
                .setLastName("Nickson")
                .setPhone("9998277727")
                .setEmail("adam1@gmail.ru")
                .setAddress("Berlin")
                .setDescription("goalkeeper"));
        clickOnSaveButton();
        Assert.assertTrue(isContactCreatedByText("Adam"));
    }

    @AfterMethod
    public void postCondition() {
        removeContact();
    }

}
