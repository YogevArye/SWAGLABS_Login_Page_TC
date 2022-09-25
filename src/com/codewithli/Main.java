package com.codewithli;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;

public class Main {
    private static String webDriver = "webdriver.chrome.driver";
    private static String webDriverC = "C:\\\\automation\\\\drivers\\\\chromedriver.exe";
    private static String saucedemo = "https://www.saucedemo.com/";
    private static String incorrectCredentials = "Epic sadface: Username and password do not match any user in this service";
    private static String userNameRequired = "Epic sadface: Username is required";
    private static String passwordRequired = "Epic sadface: Password is required";
    //Incorrect credentials and blank, They both have the same path.
    private static String messagesPath = "div.error-message-container.error > h3";
    //Incorrect credentials skip button and blank skip button, They both have the same path.
    private static String messagesSkipPath = "button>svg>path";

    public static void main(String[] args) throws InterruptedException {

    }

    //Verify that the user cannot log in where one or both credentials are incorrect. This method gets the credentials as strings.
    @Test
    public static void tc_One_Or_Both_Credentials_Incorrect(String userName, String password) {
        System.setProperty(webDriver, webDriverC);
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(saucedemo);
        WebElement UserName = driver.findElement(By.cssSelector("#user-name"));
        WebElement Password = driver.findElement(By.cssSelector("#password"));
        WebElement loginButton = driver.findElement(By.cssSelector("#login-button"));
        UserName.sendKeys(userName);
        Password.sendKeys(password);
        loginButton.click();
        String actualUrl = saucedemo;
        String expectedUrl = driver.getCurrentUrl();
        assertEquals(expectedUrl, actualUrl);
        driver.quit();
    }

    //Verify that the user can log in where a valid username and password.
    @Test
    public static void tc_001_Correct_Credentials() {
        System.setProperty(webDriver, webDriverC);
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(saucedemo);
        WebElement UserName = driver.findElement(By.cssSelector("#user-name"));
        WebElement Password = driver.findElement(By.cssSelector("#password"));
        WebElement loginButton = driver.findElement(By.cssSelector("#login-button"));
        UserName.sendKeys("standard_user");
        Password.sendKeys("secret_sauce");
        loginButton.click();
        String actualUrl = "https://www.saucedemo.com/inventory.html";
        String expectedUrl = driver.getCurrentUrl();
        assertEquals(expectedUrl, actualUrl);
        driver.quit();
    }

    //Verify that the user cannot log in where an invalid username and valid password.
    @Test
    public static void tc_002_User_Name_Is_Invalid() {
        System.setProperty(webDriver, webDriverC);
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(saucedemo);
        WebElement UserName = driver.findElement(By.cssSelector("#user-name"));
        WebElement Password = driver.findElement(By.cssSelector("#password"));
        WebElement loginButton = driver.findElement(By.cssSelector("#login-button"));
        UserName.sendKeys("yoggevvvvvv");
        Password.sendKeys("secret_sauce");
        loginButton.click();
        String actualUrl = saucedemo;
        String expectedUrl = driver.getCurrentUrl();
        assertEquals(expectedUrl, actualUrl);
        driver.quit();
    }

    //Verify that the user cannot log in where a valid username and invalid password.
    @Test
    public static void tc_003_Password_Is_Invalid() {
        System.setProperty(webDriver, webDriverC);
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(saucedemo);
        WebElement UserName = driver.findElement(By.cssSelector("#user-name"));
        WebElement Password = driver.findElement(By.cssSelector("#password"));
        WebElement loginButton = driver.findElement(By.cssSelector("#login-button"));
        UserName.sendKeys("standard_user");
        Password.sendKeys("457g8g7df8ggg");
        loginButton.click();
        String actualUrl = saucedemo;
        String expectedUrl = driver.getCurrentUrl();
        assertEquals(expectedUrl, actualUrl);
        driver.quit();
    }

    //Verify that the user cannot log in where an invalid username and an invalid password.
    @Test
    public static void tc_004_Incorrect_Credentials() {
        System.setProperty(webDriver, webDriverC);
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(saucedemo);
        WebElement UserName = driver.findElement(By.cssSelector("#user-name"));
        WebElement Password = driver.findElement(By.cssSelector("#password"));
        WebElement loginButton = driver.findElement(By.cssSelector("#login-button"));
        UserName.sendKeys("standard_user");
        Password.sendKeys("457g8g7df8ggg");
        loginButton.click();
        String actualUrl = saucedemo;
        String expectedUrl = driver.getCurrentUrl();
        assertEquals(expectedUrl, actualUrl);
        driver.quit();
    }

    //Verify that the user cannot log in where a blank username and valid password.
    @Test
    public static void tc_005_Blank_User_Name_Valid_Password() {
        System.setProperty(webDriver, webDriverC);
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(saucedemo);
        WebElement UserName = driver.findElement(By.cssSelector("#user-name"));
        WebElement Password = driver.findElement(By.cssSelector("#password"));
        WebElement loginButton = driver.findElement(By.cssSelector("#login-button"));
        UserName.sendKeys("");
        Password.sendKeys("secret_sauce");
        loginButton.click();
        String actualUrl = saucedemo;
        String expectedUrl = driver.getCurrentUrl();
        assertEquals(expectedUrl, actualUrl);
        driver.quit();
    }

    //Verify that the user cannot log in where a blank username and invalid password.
    @Test
    public static void tc_006_Blank_User_Name_Invalid_Password() {
        System.setProperty(webDriver, webDriverC);
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(saucedemo);
        WebElement UserName = driver.findElement(By.cssSelector("#user-name"));
        WebElement Password = driver.findElement(By.cssSelector("#password"));
        WebElement loginButton = driver.findElement(By.cssSelector("#login-button"));
        UserName.sendKeys("");
        Password.sendKeys("4555444546");
        loginButton.click();
        String actualUrl = saucedemo;
        String expectedUrl = driver.getCurrentUrl();
        assertEquals(expectedUrl, actualUrl);
        driver.quit();
    }

    //Verify that the user cannot log in where a blank password and valid username.
    @Test
    public static void tc_007_Blank_Password_Valid_Username() {
        System.setProperty(webDriver, webDriverC);
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(saucedemo);
        WebElement UserName = driver.findElement(By.cssSelector("#user-name"));
        WebElement Password = driver.findElement(By.cssSelector("#password"));
        WebElement loginButton = driver.findElement(By.cssSelector("#login-button"));
        UserName.sendKeys("standard_user");
        Password.sendKeys("");
        loginButton.click();
        String actualUrl = saucedemo;
        String expectedUrl = driver.getCurrentUrl();
        assertEquals(expectedUrl, actualUrl);
        driver.quit();
    }

    //Verify that the user cannot log in where a blank password and invalid username.
    @Test
    public static void tc_008_Blank_Password_Invalid_Username() {
        System.setProperty(webDriver, webDriverC);
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(saucedemo);
        WebElement UserName = driver.findElement(By.cssSelector("#user-name"));
        WebElement Password = driver.findElement(By.cssSelector("#password"));
        WebElement loginButton = driver.findElement(By.cssSelector("#login-button"));
        UserName.sendKeys("Yogev");
        Password.sendKeys("");
        loginButton.click();
        String actualUrl = saucedemo;
        String expectedUrl = driver.getCurrentUrl();
        assertEquals(expectedUrl, actualUrl);
        driver.quit();
    }

    //Verify that the user cannot log in where a blank username and password.
    @Test
    public static void tc_009_Blank_Text_Boxes() {
        System.setProperty(webDriver, webDriverC);
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(saucedemo);
        WebElement UserName = driver.findElement(By.cssSelector("#user-name"));
        WebElement Password = driver.findElement(By.cssSelector("#password"));
        WebElement loginButton = driver.findElement(By.cssSelector("#login-button"));
        UserName.sendKeys("");
        Password.sendKeys("");
        loginButton.click();
        String actualUrl = saucedemo;
        String expectedUrl = driver.getCurrentUrl();
        assertEquals(expectedUrl, actualUrl);
        driver.quit();
    }


    //Verify that the validation message is displayed where when a username is invalid.
    @Test
    public static void tc_010_Err_Mess_Invalid_Username() {
        System.setProperty(webDriver, webDriverC);
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(saucedemo);
        WebElement userName = driver.findElement(By.cssSelector("#user-name"));
        WebElement password = driver.findElement(By.cssSelector("#password"));
        WebElement loginButton = driver.findElement(By.cssSelector("#login-button"));
        userName.sendKeys("fdsfs");
        password.sendKeys("secret_sauce");
        loginButton.click();
        String actualMessage = incorrectCredentials;
        String expectedMessage = driver.findElement(By.cssSelector(messagesPath)).getText();
        assertEquals(expectedMessage, actualMessage);
        driver.quit();
    }

    //Verify that the validation message is displayed where a password is invalid.
    @Test
    public static void tc_011_Err_Mess_Invalid_Password() {
        System.setProperty(webDriver, webDriverC);
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(saucedemo);
        WebElement UserName = driver.findElement(By.cssSelector("#user-name"));
        WebElement Password = driver.findElement(By.cssSelector("#password"));
        WebElement loginButton = driver.findElement(By.cssSelector("#login-button"));
        UserName.sendKeys("standard_user");
        Password.sendKeys("55f5dg");
        loginButton.click();
        String actualMessage = incorrectCredentials;
        String expectedMessage = driver.findElement(By.cssSelector(messagesPath)).getText();
        assertEquals(expectedMessage, actualMessage);
        driver.quit();
    }

    //Verify that the validation message is displayed where an invalid username and password.
    @Test
    public static void tc_012_Err_Mess_Incorrect_Credentials(){
        System.setProperty(webDriver, webDriverC);
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(saucedemo);
        WebElement UserName = driver.findElement(By.cssSelector("#user-name"));
        WebElement Password = driver.findElement(By.cssSelector("#password"));
        WebElement loginButton = driver.findElement(By.cssSelector("#login-button"));
        UserName.sendKeys("545455");
        Password.sendKeys("55f5dg");
        loginButton.click();
        String actualMessage = incorrectCredentials;
        String expectedMessage = driver.findElement(By.cssSelector(messagesPath)).getText();
        assertEquals(expectedMessage, actualMessage);
        driver.quit();
    }

    //Verify that the validation message is displayed where a blank username and password.
    @Test
    public static void tc_013_Err_Mess_Blank_Text_Boxes(){
        System.setProperty(webDriver, webDriverC);
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(saucedemo);
        WebElement UserName = driver.findElement(By.cssSelector("#user-name"));
        WebElement Password = driver.findElement(By.cssSelector("#password"));
        WebElement loginButton = driver.findElement(By.cssSelector("#login-button"));
        UserName.sendKeys("");
        Password.sendKeys("");
        loginButton.click();
        String actualMessage = userNameRequired;
        String expectedMessage = driver.findElement(By.cssSelector(messagesPath)).getText();
        assertEquals(expectedMessage, actualMessage);
        driver.quit();
    }

    //Verify that the validation message is displayed where a blank username and valid password.
    @Test
    public static void tc_014_Err_Mess_Blank_User_Name_Valid_Password(){
        System.setProperty(webDriver, webDriverC);
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(saucedemo);
        WebElement UserName = driver.findElement(By.cssSelector("#user-name"));
        WebElement Password = driver.findElement(By.cssSelector("#password"));
        WebElement loginButton = driver.findElement(By.cssSelector("#login-button"));
        UserName.sendKeys("");
        Password.sendKeys("secret_sauce");
        loginButton.click();
        String actualMessage = userNameRequired;
        String expectedMessage = driver.findElement(By.cssSelector(messagesPath)).getText();
        assertEquals(expectedMessage, actualMessage);
        driver.quit();
    }

    //Verify that the validation message is displayed where a blank username and invalid password.
    @Test
    public static void tc_015_Err_Mess_Blank_User_Name_Invalid_Password(){
        System.setProperty(webDriver, webDriverC);
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(saucedemo);
        WebElement UserName = driver.findElement(By.cssSelector("#user-name"));
        WebElement Password = driver.findElement(By.cssSelector("#password"));
        WebElement loginButton = driver.findElement(By.cssSelector("#login-button"));
        UserName.sendKeys("");
        Password.sendKeys("5454");
        loginButton.click();
        String actualMessage = userNameRequired;
        String expectedMessage = driver.findElement(By.cssSelector(messagesPath)).getText();
        assertEquals(expectedMessage, actualMessage);
        driver.quit();
    }

    //Verify that the validation message is displayed where a blank password and valid username.
    @Test
    public static void tc_016_Err_Mess_Blank_Password_valid_User_Name(){
        System.setProperty(webDriver, webDriverC);
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(saucedemo);
        WebElement UserName = driver.findElement(By.cssSelector("#user-name"));
        WebElement Password = driver.findElement(By.cssSelector("#password"));
        WebElement loginButton = driver.findElement(By.cssSelector("#login-button"));
        UserName.sendKeys("standard_user");
        Password.sendKeys("");
        loginButton.click();
        String actualMessage = passwordRequired;
        String expectedMessage = driver.findElement(By.cssSelector(messagesPath)).getText();
        assertEquals(expectedMessage, actualMessage);
        driver.quit();
    }

    //Verify that the validation message is displayed where a blank password and invalid username.
    @Test
    public static void tc_017_Err_Mess_Blank_Password_invalid_User_Name() {
        System.setProperty(webDriver, webDriverC);
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(saucedemo);
        WebElement UserName = driver.findElement(By.cssSelector("#user-name"));
        WebElement Password = driver.findElement(By.cssSelector("#password"));
        WebElement loginButton = driver.findElement(By.cssSelector("#login-button"));
        UserName.sendKeys("yogevvvvvvv");
        Password.sendKeys("");
        loginButton.click();
        String actualMessage = passwordRequired;
        String expectedMessage = driver.findElement(By.cssSelector(messagesPath)).getText();
        assertEquals(expectedMessage, actualMessage);
        driver.quit();
    }

    //Verify that the "x" button skips the "Epic sadface: Username is required" message.
    public static void tc_018_User_Name_Required_Skip() {
        System.setProperty(webDriver, webDriverC);
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(saucedemo);
        WebElement UserName = driver.findElement(By.cssSelector("#user-name"));
        WebElement Password = driver.findElement(By.cssSelector("#password"));
        WebElement loginButton = driver.findElement(By.cssSelector("#login-button"));
        UserName.sendKeys("");
        Password.sendKeys("");
        loginButton.click();
        WebElement userNameRequired = driver.findElement(By.cssSelector(messagesPath));
        WebElement userNameRequiredSkip = driver.findElement(By.cssSelector(messagesSkipPath));
        userNameRequiredSkip.click();
        //If the message "Epic sadface: Username is required" skipped, an exception will throw and the test pass. else, the test failed.
        userNameRequired.isDisplayed();
        driver.quit();
    }

    //Verify that the "x" button skips the "Epic sadface: Password is required" message.
    public static void tc_019_Password_Required_Skip() {
        System.setProperty(webDriver, webDriverC);
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(saucedemo);
        WebElement UserName = driver.findElement(By.cssSelector("#user-name"));
        WebElement Password = driver.findElement(By.cssSelector("#password"));
        WebElement loginButton = driver.findElement(By.cssSelector("#login-button"));
        UserName.sendKeys("standard_user");
        Password.sendKeys("");
        loginButton.click();
        WebElement passwordRequired = driver.findElement(By.cssSelector(messagesPath));
        WebElement passwordRequiredSkip = driver.findElement(By.cssSelector(messagesSkipPath));
        passwordRequiredSkip.click();
        passwordRequired.isDisplayed();
        driver.quit();
    }

    //Verify that the "x" button skips the "Epic sadface: Username and password do not match any user in this service" message.
    public static void tc_020_Incorrect_Credentials_Skip() {
        System.setProperty(webDriver, webDriverC);
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(saucedemo);
        WebElement UserName = driver.findElement(By.cssSelector("#user-name"));
        WebElement Password = driver.findElement(By.cssSelector("#password"));
        WebElement loginButton = driver.findElement(By.cssSelector("#login-button"));
        UserName.sendKeys("yogevv");
        Password.sendKeys("54619749455");
        loginButton.click();
        WebElement incorrectCredentials = driver.findElement(By.cssSelector(messagesPath));
        WebElement incorrectCredentialsSkip = driver.findElement(By.cssSelector(messagesSkipPath));
        incorrectCredentialsSkip.click();
        incorrectCredentials.isDisplayed();
        driver.quit();
    }
}
