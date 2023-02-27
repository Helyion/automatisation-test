package io.github.helyion;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class TestConnextionTest {
    // Shared between all tests in this class.
    static Playwright playwright;
    static Browser browser;

    // New instance for each test method.
    BrowserContext context;
    Page page;

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
        page.navigate("https://ztrain-web.vercel.app/auth/login");
        page.getByPlaceholder("Email").click();
        page.getByPlaceholder("Email").fill(mail);
        page.getByPlaceholder("Mot de passe").click();
        page.getByPlaceholder("Mot de passe").fill(mdp);
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Connexion").setExact(true)).click();
        //assertEquals("https://ztrain-web.vercel.app/",page.locator());*/
    }

    @Test
    void testDeConnexion() {

    }
}