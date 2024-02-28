package com.phonebook.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {
    @BeforeMethod
    public void ensurePrecondition() {
        if (!isLoginLinkPresent()) {
            clickOnSignOutButton();
        }
    }

    @Test
    public void loginPositiveTest() {
        clickOnLoginLink();
        fillLoginRegisterForm(new User()
                .setEmail("kotopes@mail.com")
                .setPassword("Kot124_$!"));
        clickOnLoginButton();
        //assert Sign Out is present
        Assert.assertTrue(isSignOutButtonPresent());
    }
    @Test
    public void loginNegativeTestWithoutEmail() {
        clickOnLoginLink();
        fillLoginRegisterForm(new User()
                .setPassword("Kot124_$!"));
        clickOnLoginButton();
        //assert Sign Out is present
        Assert.assertTrue(isAlertAppears());
    }

}