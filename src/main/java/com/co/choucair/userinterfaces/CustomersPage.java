package com.co.choucair.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CustomersPage {
    public static final Target BTN_NORTHWIND = Target.the("txt")
            .located(By.xpath("//a[@class='s-sidebar-link' and @href='#nav_menu1_2_1']"));
    public static final Target BTN_CUSTOMER = Target.the("txt")
            .located(By.xpath("//a[@class='s-sidebar-link' and @href='/Northwind/Customer']"));
    public static final Target TXT_NEW_CUSTOMER = Target.the("txt")
            .located(By.xpath("//div[@class='panel-titlebar-text']"));
    public static final Target BTN_NEW_CUSTOMER = Target.the("txt")
            .located(By.xpath("//div[@class='tool-button add-button icon-tool-button']/span"));
    public static final Target TXT_VALIDATION_CUSTOMER = Target.the("txt")
            .located(By.xpath("//div[@class='title-text']"));
}
