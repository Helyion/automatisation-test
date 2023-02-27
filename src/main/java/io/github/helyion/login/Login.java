package io.github.helyion.login;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class Login {

    private String mail;
    private String password;
    private Page page;

    public Login(Page page, String mail, String password){
        this.page = page;
        this.mail = mail;
        this.password = password;
    }

    public void Dologin(){
        this.page.navigate("https://ztrain-web.vercel.app/auth/login");
        this.page.getByPlaceholder("Email").click();
        this.page.getByPlaceholder("Email").fill(this.mail);
        this.page.getByPlaceholder("Mot de passe").click();
        this.page.getByPlaceholder("Mot de passe").fill(this.password);
        this.page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Connexion").setExact(true)).click();
    }

    public String getMail() {
        return mail;
    }

    public String getPassword() {
        return password;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
