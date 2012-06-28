package com.opitzconsulting.bwertr.spec;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class ShowNumberOfRatingsTest extends AbstractSpringBwertrSpec {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public String numberOfRatingsShownWhenThereAre(int numberOfRatings) {
        
        ensureNumberOfRatingsExist(numberOfRatings);

        // Visit bwertr
        WebDriver webDriver = visitBwertr();
        // Return number of ratings shown
        return numberOfRatingsShown(webDriver);
    }

	private String numberOfRatingsShown(WebDriver webDriver) {
		return webDriver.findElement(By.id("numberOfRatings")).getText();
	}

	private WebDriver visitBwertr() {
		WebDriver webDriver = new HtmlUnitDriver();
        webDriver.get("http://localhost:8080");
		return webDriver;
	}

	private void ensureNumberOfRatingsExist(int numberOfRatings) {
		resetBwertr();
		for (int count = 0; count < numberOfRatings; count ++) {
            rateWith();
        }
	}

	private int rateWith() {
		return jdbcTemplate.update("INSERT INTO RATINGS (RATING) VALUES (?)", 1);
	}

	private void resetBwertr() {
		jdbcTemplate.update("DELETE FROM RATINGS");
	}

}
