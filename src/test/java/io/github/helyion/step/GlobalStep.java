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

public class GlobalStep {

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

    //-------------------------------------------------------------------------------------------
    //-----------------------------------------LOGIN---------------------------------------------
    //-------------------------------------------------------------------------------------------
    @Given("User launched login page of ZTrain application")
    public void userLaunchedLoginPageOfZTrainApplication(){
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

    @When("User should be able to login")
    public void userShouldBeAbleToLogin(){
        page.waitForURL("https://ztrain-web.vercel.app/home");
    }

    @Then("User shouldn't be able to login due to incorrect password or login")
    public void userShouldnTBeAbleToLoginDueToIncorrectPasswordOrLogin(){
        assertThat(page.getByText("Email ou mot de passe incorrect")).isVisible();
    }

    @Then("User shouldn't be able to login due to incorrect email format")
    public void userShouldnTBeAbleToLoginDueToIncorrectEmailFormat(){
        assertThat(page.getByText("Le format de l'email est invalid")).isVisible();
    }

    @Then("User is logged in the app")
    public void UserIsLoggedInTheApp(){
        page.waitForURL("https://ztrain-web.vercel.app/home");
    }

    //-------------------------------------------------------------------------------------------
    //--------------------------------------REGISTER---------------------------------------------
    //-------------------------------------------------------------------------------------------

    @Given("User launched register page of ZTrain application")
    public void userLaunchedRegisterPageOfZTrainApplication(){
        this.page.navigate("https://ztrain-web.vercel.app/auth/register");
    }

    @When("User click on register button")
    public void userClickOnRegisterButton() {
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

    //-------------------------------------------------------------------------------------------
    //------------------------------------PRODUCT-RESEARCH---------------------------------------
    //-------------------------------------------------------------------------------------------

    @When("User do a research {string}")
    public void UserDoAResearch(String research){
        page.getByPlaceholder("Rechecher un produit").click();
        page.getByPlaceholder("Rechecher un produit").type(research, new Locator.TypeOptions().setDelay(100));
    }

    @When("User select the all category")
    public void UserSelectTheAllCategory(){
        page.locator("#style_select_cat__vyiIE").selectOption("all");
    }

    @Then("The all category is selected")
    public void TheAllCategoryIsSelected(){
        assertThat(page.locator("#style_select_cat__vyiIE")).isVisible();
    }

    @When("User select the electronic category")
    public void UserSelectTheElectronicCategory(){
        page.locator("#style_select_cat__vyiIE").selectOption("6267ba6a774b917c18ef6a5a");
    }

    @When("User select the electromenager category")
    public void UserSelectTheElectromenagerCategory(){
        page.locator("#style_select_cat__vyiIE").selectOption("6267bd9864a9f9ca3bc737cd");
    }

    @When("User select the mode homme category")
    public void UserSelectTheModeHommeCategory(){
        page.locator("#style_select_cat__vyiIE").selectOption("6267bb40774b917c18ef6a5d");
    }

    @Then("User find {string} article")
    public void UserFindArticle(String article){
        assertThat(page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName(article))).isVisible();
    }

    //-------------------------------------------------------------------------------------------
    //-------------------------------------------PRODUCT-----------------------------------------
    //-------------------------------------------------------------------------------------------

    @When("User add {string} product")
    public void UserAddPorduct(String product){
        page.locator("#style_popular_product_wrapper__z6J0h").getByRole(AriaRole.BUTTON).click();
        page.locator("#style_content_cart_wrapper__mqNbf").click();
        page.locator("#style_card_wrapper__hrc1I svg").first().click();
        page.locator("#style_card_wrapper__hrc1I svg").first().click();
        page.locator("#style_card_wrapper__hrc1I svg").nth(1).click();
        page.locator("#style_card_wrapper__hrc1I svg").nth(1).click();
        page.locator("#style_card_wrapper__hrc1I svg").nth(2).click();
        page.getByRole(AriaRole.BUTTON).click();
        page.locator("#style_content_cart_wrapper__mqNbf").click();
    }

    @Then("Product should be in the cart")
    public void ProductShouldBeInTheCart(){

    }

    @Then("User should see the adding notification")
    public void UserShouldSeeTheAddingNotificaiton(){
        assertThat(page.getByText("Votre panier à été mis à jour")).isVisible();
    }

    @When("User open his cart")
    public void UserOpenHisCart(){
        page.locator("#style_content_cart_wrapper__mqNbf").click();
    }

    @Then("User cart should be visible")
    public void UserCartShouldBeVisible(){
        assertThat(page.locator("#style_content_cart_header__NIJbw")).isVisible();
    }

    @Then("User cart shouldn't be visible")
    public void UserCartShouldnTBeVisible(){
        assertThat(page.locator("#style_content_cart_header__NIJbw")).not().isVisible();
    }

    @When("User clear his cart")
    public void UserClearHisCart(){
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Vider le panier")).click();
    }

    @When("User remove a product form his cart")
    public void UserRemoveAProductFromHisCart(){

    }

    @When("User select price range {int} to {int}")
    public void UserSelectPriceRange(int low, int high){
        page.locator("#MuiSlider-track css-1t2bqnt");

    }

    @After
    public void After(){
        page.close();
    }
}
