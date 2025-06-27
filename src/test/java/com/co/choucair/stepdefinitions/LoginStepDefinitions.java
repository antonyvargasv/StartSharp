package com.co.choucair.stepdefinitions;

import com.co.choucair.models.UserLoombokData;
import com.co.choucair.questions.ValidateText;
import com.co.choucair.tasks.Customers;
import com.co.choucair.tasks.Login;
import com.co.choucair.tasks.LoginIncorrecto;
import com.co.choucair.utils.KillBrowser;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.core.webdriver.SerenityWebdriverManager;

import java.io.IOException;
import java.util.List;

import static com.co.choucair.userinterfaces.LoginPage.*;
import static com.co.choucair.utils.GlobalData.*;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.containsString;

public class LoginStepDefinitions {

    @Before
    public void setup() {
        OnStage.setTheStage(new OnlineCast());
    }

    @After
    public static void CloseDriver() throws IOException, InterruptedException {
        SerenityWebdriverManager.inThisTestThread().getCurrentDriver().quit();
        KillBrowser.processes(List.of((SerenityWebdriverManager.inThisTestThread().getCurrentDriverName()).split(":")).get(0));
    }

    @Given("el usuario ingresa al sitio web")
    public void elUsuarioIngresaAlSitioWeb() {
        OnStage.theActorCalled(ACTOR).wasAbleTo(Open.url(URL));
    }

    @When("ingresa credenciales correctas")
    public void ingresaCredencialesCorrectas(DataTable dataTable) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Login.onTheSite(UserLoombokData.setData(dataTable).get(0))
        );
    }

    @Then("^valida el texto en el modulo producto (.*)$")
    public void validaElTextoEnElModuloProducto(String text) {
        OnStage.theActorInTheSpotlight().should(seeThat(ValidateText.of(TXT_VALIDATION), containsString(text)));

    }

    @When("ingresa credenciales incorrectas")
    public void ingresaCredencialesIncorrectas(DataTable dataTable) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                LoginIncorrecto.onTheSite(UserLoombokData.setData(dataTable).get(0))
        );
    }

    @Then("^valida el error en el modulo productos (.*)$")
    public void validaElErrorEnElModuloProductos(String text) {
        OnStage.theActorInTheSpotlight().should(seeThat(ValidateText.of(TXT_VALIDATION_ERROR), containsString(text)));

    }



}
