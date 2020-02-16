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

    @Test
    public void checkForBlankSpaces() {
        Job job = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertTrue(job.toString().startsWith("\n"));
        assertTrue(job.toString().endsWith("\n"));
    }

    @Test
    public void toStringValue() {
        Job job = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String[] splitString = job.toString().split("\\n");
        assertEquals("ID: " + job.getId(), splitString[1]);
        assertEquals("Name: " + job.getName(), splitString[2]);
        assertEquals("Employer: " + job.getEmployer(), splitString[3]);
        assertEquals("Location: " + job.getLocation(), splitString[4]);
        assertEquals("Position Type: " + job.getPositionType(), splitString[5]);
        assertEquals("Core Competency: " + job.getCoreCompetency(), splitString[6]);
    }

    @Test
    public void nameUnavailable() {
        Job job = new Job("", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String[] splitString = job.toString().split("\\n");
        assertEquals("Name: Data not available", splitString[2]);
    }

    @Test
    public void employerUnavailable() {
        Job job = new Job("", new Employer(""), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String[] splitString = job.toString().split("\\n");
        assertEquals("Employer: Data not available", splitString[3]);
    }

    @Test
    public void locationUnavailable() {
        Job job = new Job("", new Employer(""), new Location(""), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String[] splitString = job.toString().split("\\n");
        assertEquals("Location: Data not available", splitString[4]);
    }

    @Test
    public void positionTypeUnavailable() {
        Job job = new Job("", new Employer(""), new Location(""), new PositionType(""), new CoreCompetency("Persistence"));
        String[] splitString = job.toString().split("\\n");
        assertEquals("Position Type: Data not available", splitString[5]);
    }

    @Test
    public void coreCompetencyUnavailable() {
        Job job = new Job("", new Employer(""), new Location(""), new PositionType(""), new CoreCompetency(""));
        String[] splitString = job.toString().split("\\n");
        assertEquals("Core Competency: Data not available", splitString[6]);
    }

}
