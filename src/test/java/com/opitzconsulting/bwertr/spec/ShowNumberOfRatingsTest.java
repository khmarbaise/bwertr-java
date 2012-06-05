package com.opitzconsulting.bwertr.spec;

public class ShowNumberOfRatingsTest extends AbstractSpringBwertrSpec {

    public String numberOfRatingsShownWhenThereAre(int numberOfRatings) {
        resetBwertr();
        ensureNumberOfRatingsExist(numberOfRatings);
        bwertrDriver.visitBwertr();
        return bwertrDriver.numberOfRatingsShown();
    }

    private void ensureNumberOfRatingsExist(int numberOfRatings) {
        for (int count = 0; count < numberOfRatings; count++) {
            bwertrDriver.rateWith("Average");
        }
    }

}
