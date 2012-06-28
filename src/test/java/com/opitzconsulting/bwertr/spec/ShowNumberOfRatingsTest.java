package com.opitzconsulting.bwertr.spec;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class ShowNumberOfRatingsTest extends AbstractSpringBwertrSpec {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private final WebDriver webDriver = new HtmlUnitDriver();

    public String numberOfRatingsShownWhenThereAre(int numberOfRatings) {
        
        ensureNumberOfRatingsExist(numberOfRatings);

        visitBwertr();

        return numberOfRatingsShown();
    }

	private String numberOfRatingsShown() {
		return webDriver.findElement(By.id("numberOfRatings")).getText();
	}

	private void visitBwertr() {
		webDriver.get("http://localhost:8080");
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
