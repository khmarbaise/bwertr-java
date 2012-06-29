package com.opitzconsulting.bwertr.spec;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class BwertrDriver {
    public final WebDriver webDriver = new HtmlUnitDriver();

    public String numberOfRatingsShown() {
        return webDriver.findElement(By.id("numberOfRatings")).getText();
    }

    public void visitBwertr() {
        webDriver.get("http://localhost:8080");
    }
}