package io.github.helyion;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;
import io.github.helyion.login.Login;
import org.junit.jupiter.api.*;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.*;

class TestConnextion {
    // Shared between all tests in this class.
    static Playwright playwright;
    static Browser browser;

    // New instance for each test method.
    BrowserContext context;
    Page page;
    private Login login;

    // Mail + passworld
    private String mail = "test.mail@email.com";
    private String mdp = "motsdepasse";


    @BeforeAll
    static void launchBrowser() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
    }

    @AfterAll
    static void closeBrowser() {
        playwright.close();
    }

    @BeforeEach
    void createContextAndPage() {
        context = browser.newContext();
        page = context.newPage();
        login = new Login(page);
    }

    @AfterEach
    void closeContext() {
        context.close();
    }

    @Test
    void testInscription() {
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("S'inscrire")).click();
        page.getByPlaceholder("Email").click();
        page.getByPlaceholder("Email").fill(mail);
        page.getByPlaceholder("Mot de passe", new Page.GetByPlaceholderOptions().setExact(true)).click();
        page.getByPlaceholder("Mot de passe", new Page.GetByPlaceholderOptions().setExact(true)).fill(mdp);
        page.getByPlaceholder("Confirmer votre mot de passe").click();
        page.getByPlaceholder("Confirmer votre mot de passe").fill(mdp);
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Inscription")).click();
    }

    @Test
    void testLogin() {
        login.Dologin(mail, mdp);
        page.waitForURL("https://ztrain-web.vercel.app/home");
    }

    @Test
    void testLoginErrorPassword() {
        login.Dologin(mail, "wrongpassword12345");
        assertThat(page.getByText("Email ou mot de passe incorrect")).isVisible();
    }

    @Test
    void testLoginErrorMail() {
        login.Dologin("erroremail@email.com", mdp);
        assertThat(page.getByText("Email ou mot de passe incorrect")).isVisible();
    }

    @Test
    void testLoginErrorFormatMail() {
        login.Dologin("erroremail", mdp);
        assertThat(page.getByText("Le format de l'email est invalid")).isVisible();
    }

    @Test
    void testDeconnexion() { //Deconnexion Impossible
        login.Dologin(mail, mdp);
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Se d??connecter")).click();
        page.waitForURL("https://ztrain-web.vercel.app/auth/login");
    }
}