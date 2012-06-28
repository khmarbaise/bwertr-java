package com.opitzconsulting.bwertr.spec;

public class BwertrDriver {
    public final WebDriver webDriver = new HtmlUnitDriver();

    public String numberOfRatingsShown() {
        return webDriver.findElement(By.id("numberOfRatings")).getText();
    }

    public void visitBwertr() {
        webDriver.get("http://localhost:8080");
    }
}