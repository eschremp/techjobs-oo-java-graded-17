package org.launchcode.techjobs.oo;

import org.junit.Test;
import org.junit.Assert;

public class JobTest {
    //TODO: Create your unit tests here
    @Test
    public void testSettingJobId() {
        Job job1 = new Job();
        Job job2 = new Job();

        Assert.assertNotEquals(job1, job2);
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        Job testJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Assert.assertEquals(testJob.getName(), "Product tester");
        Assert.assertEquals(testJob.getEmployer().getValue(), "ACME");
        Assert.assertEquals(testJob.getLocation().getValue(), "Desert");
        Assert.assertEquals(testJob.getPositionType().getValue(), "Quality control");
        Assert.assertEquals(testJob.getCoreCompetency().getValue(), "Persistence");
        Assert.assertTrue(testJob.getEmployer() instanceof Employer);
        Assert.assertTrue(testJob.getLocation() instanceof Location);
        Assert.assertTrue(testJob.getPositionType() instanceof PositionType);
        Assert.assertTrue(testJob.getCoreCompetency() instanceof CoreCompetency);
        Assert.assertTrue(testJob.getName() instanceof String);
    }

    @Test
    public void testJobsForEquality() {
        Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job job2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Assert.assertFalse(job1.equals(job2));
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine() {
        Job testJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        Assert.assertEquals(testJob.toString().startsWith("\n"), true);
        Assert.assertEquals(testJob.toString().endsWith("\n"), true);
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData() {

        Job testJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String output = "\n" +
                "ID: " + testJob.getId() + "\n" +
                "Name: " + testJob.getName() + "\n" +
                "Employer: " + testJob.getEmployer() + "\n" +
                "Location: " + testJob.getLocation() + "\n" +
                "Position Type: " + testJob.getPositionType() + "\n" +
                "Core Competency: " + testJob.getCoreCompetency() + "\n";
        Assert.assertEquals(output, testJob.toString());
    }

    @Test
    public void testToStringHandlesEmptyField(){
        Job testJob = new Job("Product tester", new Employer("    "), new Location(""), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String output = "\n" +
                "ID: " + testJob.getId() + "\n" +
                "Name: " + testJob.getName() + "\n" +
                "Employer: Data not available\n" +
                "Location: Data not available\n" +
                "Position Type: " + testJob.getPositionType() + "\n" +
                "Core Competency: " + testJob.getCoreCompetency() +
                "\n";
        Assert.assertEquals(output, testJob.toString());
    }

    @Test
    public void testToStringHandlesEmptyJob() {
        Job testJob = new Job("", new Employer(""), new Location(""), new PositionType(""), new CoreCompetency(""));
        String output = "OOPS! This job does not seem to exist.";
        Assert.assertEquals(output, testJob.toString());
    }
}