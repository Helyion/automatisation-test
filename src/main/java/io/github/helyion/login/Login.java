package io.github.helyion.login;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class Login {


    private Page page;

    public Login(Page page){
        this.page = page;
    }

    public void Dologin(String mail, String password){
        this.page.navigate("https://ztrain-web.vercel.app/auth/login");
        this.page.getByPlaceholder("Email").click();
        this.page.getByPlaceholder("Email").fill(mail);
        this.page.getByPlaceholder("Mot de passe").click();
        this.page.getByPlaceholder("Mot de passe").fill(password);
        this.page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Connexion").setExact(true)).click();
    }

}
