package io.github.helyion;

import com.microsoft.playwright.*;

public class Main {
    public static void main(String[] args) {// Test Playwright
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                    .setHeadless(false));
            BrowserContext context = browser.newContext();
            Page page = context.newPage();
            page.navigate("https://ztrain-web.vercel.app/home");
            page.navigate("https://ztrain-web.vercel.app/auth/login");
            page.getByPlaceholder("Email").click();
            page.getByPlaceholder("Email").fill("EmailError");
            page.getByPlaceholder("Mot de passe").click();
            page.getByText("Le format de l'email est invalid").click();

            System.out.println(page.getByText("Le format de l'email est invalid"));
            System.out.println(page.getByText("Le forZEGZEGmat de l'emzezegGJOIail est invé223124alid"));
        }
    }
}
