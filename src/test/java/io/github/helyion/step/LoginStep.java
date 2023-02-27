package io.github.helyion.step;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStep {

    static Playwright playwright;
    static Browser browser;

    private BrowserContext context;
    private Page page;

    @BeforeAll
    public static void BeforeAll() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
    }

    @Before
    public void Before(){
        context = browser.newContext();
        page = context.newPage();
    }

    @Given("User launched ZTrain application")
    public void user_launched_ztrain_application(){
        this.page.navigate("https://ztrain-web.vercel.app/auth/login");
    }

    @When("User logged in the app using mail {string} and password {string}")
    public void userLoggedInTheAppUsingMailAndPassword(String mail, String password) {
        this.page.getByPlaceholder("Email").click();
        this.page.getByPlaceholder("Email").fill(mail);
        this.page.getByPlaceholder("Mot de passe").click();
        this.page.getByPlaceholder("Mot de passe").fill(password);
        this.page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Connexion").setExact(true)).click();
    }

    @Then("User is logged in the app")
    public void User_is_logged_in_the_app(){
        page.waitForURL("https://ztrain-web.vercel.app/home");
    }
}
