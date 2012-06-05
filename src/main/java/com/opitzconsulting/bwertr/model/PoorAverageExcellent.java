package com.opitzconsulting.bwertr.model;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class PoorAverageExcellent implements Ratings {

    @Override
    public String textFor(int value) {
        return possibleRatings().get(value);
    }

    @Override
    public List<String> possibleRatings() {
        return Arrays.asList("Poor", "Average", "Excellent");
    }

    @Override
    public int valueOf(String rating) {
        return possibleRatings().indexOf(rating);
    }
}
