package io.github.helyion.step;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.ar.لكن;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.helyion.login.Login;

public class LoginStep {

    private Playwright playwright;
    private Browser browser;

    private BrowserContext context;
    private Page page;
    private Login login;

    private String mail = "test.mail@email.com";
    private String password = "motsdepasse";

    @BeforeAll
    public void BeforeAll() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
    }

    @Before
    public void Before(){
        context = browser.newContext();
        page = context.newPage();
        login = new Login(page);
    }

    @Given("User launched ZTrain application")
    public void user_launched_ztrain_application(){
        this.page.navigate("https://ztrain-web.vercel.app/auth/login");
    }

    @When("User logged in the app using the correct mail and password")
    public void user_logged_in_the_app_using_the_correct_mail_and_password(){
        this.page.getByPlaceholder("Email").click();
        this.page.getByPlaceholder("Email").fill(mail);
        this.page.getByPlaceholder("Mot de passe").click();
        this.page.getByPlaceholder("Mot de passe").fill(password);
        this.page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Connexion").setExact(true)).click();
    }

    @Then("User is logged in the app")
    public void User_is_logged_in_the_app(){

    }
}
