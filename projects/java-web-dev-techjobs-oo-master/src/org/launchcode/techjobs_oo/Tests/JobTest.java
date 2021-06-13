package org.launchcode.techjobs_oo.Tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.launchcode.techjobs_oo.*;

import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;

public class JobTest {

    @Test
    public void testSettingJobId() {
       Job testJobA = new Job();
       Job testJobB = new Job();

       assertEquals(testJobA.getId(), testJobB.getId()-1, .001);
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        Job test_job_constructor = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        Assert.assertEquals("Product tester", test_job_constructor.getName());
        Assert.assertEquals("ACME", (test_job_constructor.getEmployer().getValue()));
        Assert.assertEquals("Desert", test_job_constructor.getLocation().getValue());
        Assert.assertEquals("Quality control", test_job_constructor.getPositionType().getValue());
        Assert.assertEquals("Persistence", test_job_constructor.getCoreCompetency().getValue());
        assertTrue(test_job_constructor.getEmployer() instanceof Employer);
        assertTrue(test_job_constructor.getLocation() instanceof Location);
        assertTrue(test_job_constructor.getPositionType() instanceof PositionType);
        assertTrue(test_job_constructor.getCoreCompetency() instanceof CoreCompetency);

    }

    @Test
    public void testJobsForEquality() {
        Job testIdEquality1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job tesIdEquality2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        Assert.assertFalse(testIdEquality1.equals(tesIdEquality2));
    }

    @Test
    public void testToStringMethod() {
        Job testToString = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job testToString2 = new Job("", new Employer(""), new Location(""), new PositionType(""), new CoreCompetency("Persistence"));
        Job testToString3 = new Job("", new Employer(""), new Location(""), new PositionType(""), new CoreCompetency(""));
        Job testToString4 = new Job("", new Employer("ACME"), new Location(""), new PositionType(""), new CoreCompetency(""));


        String[] stringArray = testToString.toString().split("\\n");
        String[] stringArray2 = testToString2.toString().split("\\n");
        String[] stringArray4 = testToString4.toString().split("\\n");

//First requirement:
        assertEquals(stringArray[0], "");
        assertEquals(stringArray[7], " ");
//Second requirement:
        assertEquals(stringArray[1], "ID: " + testToString.getId());
        assertEquals(stringArray[2], "Name: " + testToString.getName());
        assertEquals(stringArray[3], "Employer: " + testToString.getEmployer());
        assertEquals(stringArray[4], "Location: " + testToString.getLocation());
        assertEquals(stringArray[5], "Position Type: " + testToString.getPositionType());
        assertEquals(stringArray[6], "Core Competency: " + testToString.getCoreCompetency());
//Third requirement:
        assertEquals(stringArray2[2], "Name: Data not available");
        assertEquals(stringArray2[3], "Employer: Data not available");
        assertEquals(stringArray2[4], "Location: Data not available");
        assertEquals(stringArray2[5], "Position Type: Data not available");
        assertEquals(stringArray4[6], "Core Competency: Data not available");

//Fourth requirement (Bonus):
        assertEquals(testToString3.toString(), "OOPS! This job does not seem to exist.");

    }


}
