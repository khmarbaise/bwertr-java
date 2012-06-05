package com.opitzconsulting.bwertr.model;

import org.junit.Before;
import org.junit.Test;
import org.mockito.stubbing.OngoingStubbing;
import org.springframework.jdbc.core.JdbcTemplate;

import static java.util.Arrays.asList;
import static junit.framework.Assert.assertEquals;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class JdbcPresentationTest {

    private Ratings ratings;
    private JdbcTemplate jdbcTemplate;
    private JdbcPresentation jdbcPresentation;

    @Before
    public void setUp() throws Exception {
        ratings = mock(Ratings.class);
        jdbcTemplate = mock(JdbcTemplate.class);
        jdbcPresentation = new JdbcPresentation(jdbcTemplate, ratings);
    }

    @Test
    public void averageRating_withRatingOne_isTextForOne() {
        String textForOne = "foo";
        givenRatings(1);
        andTextForValue(textForOne, 1);
        assertEquals(textForOne, jdbcPresentation.averageRating());
    }

    @Test
    public void averageRating_withRatingOneAndThree_isTextForTwo() {
        String textForTwo = "bar";
        givenRatings(1, 3);
        andTextForValue(textForTwo, 2);
        assertEquals(textForTwo, jdbcPresentation.averageRating());
    }

    @Test
    public void averageRating_withRatingOneAndTwo_isTextForTwo() {
        String textForTwo = "Average";
        givenRatings(1, 2);
        andTextForValue(textForTwo, 2);
        assertEquals(textForTwo, jdbcPresentation.averageRating());
    }

    private OngoingStubbing<String> andTextForValue(String text, int value) {
        return when(ratings.textFor(value)).thenReturn(text);
    }

    private void givenRatings(Integer... someRatings) {
        when(jdbcTemplate.queryForList(anyString(), eq(Integer.class)))
                .thenReturn(asList(someRatings));
    }

}