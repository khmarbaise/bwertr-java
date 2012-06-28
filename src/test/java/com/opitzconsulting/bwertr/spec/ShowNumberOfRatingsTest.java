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

        bwertrDriver.visitBwertr();

        return bwertrDriver.numberOfRatingsShown();
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
