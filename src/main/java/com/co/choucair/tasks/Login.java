package com.co.choucair.tasks;

import com.co.choucair.models.UserLoombokData;
import com.co.choucair.userinterfaces.CustomersPage;
import com.co.choucair.userinterfaces.LoginPage;
import com.co.choucair.userinterfaces.NewCustomerPage;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;

import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class Login implements Task {

    UserLoombokData userLoombokData;

    public Login(UserLoombokData userLoombokData) {
        this.userLoombokData = userLoombokData;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(LoginPage.TXT_USER, isVisible()).forNoMoreThan(10).seconds(),
                Enter.theValue(userLoombokData.getUser()).into(LoginPage.TXT_USER),
                Enter.theValue(userLoombokData.getPass()).into(LoginPage.TXT_PASS),
                JavaScriptClick.on(LoginPage.BTN_SUBMIT),
               // WaitUntil.the(LoginPage.TXT_VALIDATION, isVisible()).forNoMoreThan(10).seconds(),
                //-------
                JavaScriptClick.on(CustomersPage.BTN_NORTHWIND),
                JavaScriptClick.on(CustomersPage.BTN_CUSTOMER),
                JavaScriptClick.on(CustomersPage.BTN_NEW_CUSTOMER),
                WaitUntil.the(CustomersPage.TXT_NEW_CUSTOMER, isVisible()).forNoMoreThan(10).seconds(),
                Enter.theValue(userLoombokData.getCustomer()).into(NewCustomerPage.TXT_CUSTOMER_ID),
                Enter.theValue(userLoombokData.getCompany()).into(NewCustomerPage.TXT_COMPANY_NAME),
                JavaScriptClick.on(NewCustomerPage.BTN_SAVE),
                Enter.theValue(userLoombokData.getCompany()).into(NewCustomerPage.TXT_FILTRO),
                WaitUntil.the(NewCustomerPage.TXT_VALIDATION_ID, isVisible()).forNoMoreThan(10).seconds()
        );
    }



    public static Login onTheSite(UserLoombokData userLoombokData){
        return Instrumented.instanceOf(Login.class).withProperties(userLoombokData);
    }
}
