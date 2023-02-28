package io.github.helyion.step;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class RegisterStep {
    /*static Playwright playwright;
    static Browser browser;

    private BrowserContext context;
    private Page page;

    @BeforeAll
    public static void BeforeAll() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
    }

    @Before
    public void BeforeRegister(){
        context = browser.newContext();
        page = context.newPage();
    }

    @Given("User launched register page of ZTrain application")
    public void userLaunchedLoginPageOfZTrainApplication(){
        this.page.navigate("https://ztrain-web.vercel.app/auth/register");
    }

    @When("User go to the register page")
    public void userGoToTheRegisterPage() {
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("S'inscrire")).click();
    }

    @When("User fill the register form with the email {string} and password {string} and the confirmation password {string}")
    public void userFillTheRegisterFormWithTheEmailAndPasswordAndTheConfirmationPassword(String arg0, String arg1, String arg2) {
        page.getByPlaceholder("Email").click();
        page.getByPlaceholder("Email").fill(arg0);
        page.getByPlaceholder("Mot de passe", new Page.GetByPlaceholderOptions().setExact(true)).click();
        page.getByPlaceholder("Mot de passe", new Page.GetByPlaceholderOptions().setExact(true)).fill(arg1);
        page.getByPlaceholder("Confirmer votre mot de passe").click();
        page.getByPlaceholder("Confirmer votre mot de passe").fill(arg2);
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Inscription")).click();
    }

    @Then("User is register")
    public void UserIsRegister(){
        page.waitForURL("https://ztrain-web.vercel.app/home");
    }

    @Then("User shouldn't be able to register due to incorrect email format")
    public void UserShouldnTBeAbleToRegisterDueToIncorrectEmailFormat(){
        assertThat(page.getByText("Le format de l'email est invalid")).isVisible();
    }

    @Then("User shouldn't be able to register due to the email already register")
    public void UserShouldnTBeAbleToRegisterDueToTheEmailAlreadyRegister(){
        assertThat(page.getByText("Cet utilisateur existe déjà")).isVisible();
    }

    @Then("User shouldn't be able to register due to the two password not being identical")
    public void UserShouldnTBeAbleToRegisterDueToTheTwoPasswordNotBeingIdentical(){
        assertThat(page.getByText("Les deux mots de passe ne sont pas identiques")).isVisible();
    }

    @Then("User shouldn't be able to register due to the two password not being long enough")
    public void UserShouldnTBeAbleToRegisterDueToTheTwoPasswordNotBeingLongEnough(){
        assertThat(page.getByText("Le mot de passe doit avoir au moins 8 caractères")).isVisible();
    }

    @After
    public void After(){
        page.close();
    }*/
}
