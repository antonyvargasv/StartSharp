package com.co.choucair.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class NewCustomerPage {
    public static final Target TXT_CUSTOMER_ID = Target.the("txt")
            .located(By.xpath("//input[@id='Serenity_Demo_Northwind_CustomerDialog9_CustomerID']"));
    public static final Target TXT_COMPANY_NAME = Target.the("txt")
            .located(By.id("Serenity_Demo_Northwind_CustomerDialog9_CompanyName"));
    public static final Target TXT_CONTACT_NAME = Target.the("txt")
            .located(By.id("Serenity_Demo_Northwind_CustomerDialog9_ContactName"));
    public static final Target TXT_CONTACT_TITLE = Target.the("txt")
            .located(By.id("Serenity_Demo_Northwind_CustomerDialog9_ContactTitle"));
    public static final Target BTN_SAVE = Target.the("txt")
            .located(By.xpath("//div[@class='tool-button save-and-close-button icon-tool-button']"));
    public static final Target TXT_FILTRO = Target.the("txt")
            .located(By.xpath("//input[@class='s-Serenity-QuickSearchInput s-QuickSearchInput']"));
    public static final Target TXT_VALIDATION_ID = Target.the("txt")
            .located(By.xpath("//div[@class='slick-row even']/div[1]"));


}

