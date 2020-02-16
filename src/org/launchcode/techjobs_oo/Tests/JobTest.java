package org.launchcode.techjobs_oo.Tests;

import org.junit.Before;
import org.junit.Test;
import org.launchcode.techjobs_oo.*;

import static org.junit.Assert.*;

public class JobTest {
    Job firstJob;
    Job secondJob;

    @Before
    public void createJobObjects() {
        firstJob = new Job();
        secondJob = new Job();
    }

    @Test
    public void testSettingJobId() {
        assertNotEquals(firstJob, secondJob);
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        firstJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertTrue(firstJob.getEmployer() instanceof  Employer && firstJob.getEmployer().getValue() == "ACME");
        assertTrue(firstJob.getLocation() instanceof  Location && firstJob.getLocation().getValue() == "Desert");
        assertTrue(firstJob.getPositionType() instanceof  PositionType && firstJob.getPositionType().getValue() == "Quality control");
        assertTrue(firstJob.getCoreCompetency() instanceof  CoreCompetency && firstJob.getCoreCompetency().getValue() == "Persistence");
    }

    @Test
    public void testForJobEquality() {
        firstJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        secondJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertFalse(firstJob.equals(secondJob));
    }

}
