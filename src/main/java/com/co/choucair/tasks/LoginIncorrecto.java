package com.co.choucair.tasks;

import com.co.choucair.models.UserLoombokData;
import com.co.choucair.userinterfaces.LoginPage;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;

import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;


public class LoginIncorrecto implements Task {
    UserLoombokData userLoombokData;

    public LoginIncorrecto(UserLoombokData userLoombokData) {
        this.userLoombokData = userLoombokData;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(LoginPage.TXT_USER, isVisible()).forNoMoreThan(10).seconds(),
                Enter.theValue(userLoombokData.getUser()).into(LoginPage.TXT_USER),
                Enter.theValue(userLoombokData.getPass()).into(LoginPage.TXT_PASS),
                JavaScriptClick.on(LoginPage.BTN_SUBMIT),
                WaitUntil.the(LoginPage.TXT_VALIDATION_ERROR, isVisible()).forNoMoreThan(10).seconds()
        );
    }


    public static LoginIncorrecto onTheSite(UserLoombokData userLoombokData){
        return Instrumented.instanceOf(LoginIncorrecto.class).withProperties(userLoombokData);
    }
}
