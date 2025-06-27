package com.co.choucair.stepdefinitions;

import com.co.choucair.models.UserLoombokData;
import com.co.choucair.questions.ValidateText;
import com.co.choucair.tasks.Customers;
import com.co.choucair.tasks.Login;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;

import static com.co.choucair.userinterfaces.CustomersPage.TXT_NEW_CUSTOMER;
import static com.co.choucair.userinterfaces.LoginPage.TXT_VALIDATION;
import static com.co.choucair.userinterfaces.LoginPage.TXT_VALIDATION_ERROR;
import static com.co.choucair.userinterfaces.NewCustomerPage.TXT_VALIDATION_ID;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.containsString;

public class CustomerStepDefinitions {


    @Then("^valida el idCustomer en el modulo productos (.*)$")
    public void validElIdCustomerEnElModuloProductos(String text) {
        OnStage.theActorInTheSpotlight().should(seeThat(ValidateText.of(TXT_VALIDATION_ID), containsString(text)));

    }




}
