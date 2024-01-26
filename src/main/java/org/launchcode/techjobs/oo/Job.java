package org.launchcode.techjobs.oo;

import java.nio.file.SecureDirectoryStream;
import java.util.Objects;

public class Job {

    private int id;
    private static int nextId = 1;

    private String name;
    private Employer employer;
    private Location location;
    private PositionType positionType;
    private CoreCompetency coreCompetency;

    public Job() {
        this.id = nextId;
        nextId++;
    }

    public Job(String name, Employer employer, Location location, PositionType positionType, CoreCompetency coreCompetency) {
        this();
        this.name = name;
        this.employer = employer;
        this.location = location;
        this.positionType = positionType;
        this.coreCompetency= coreCompetency;

    }

    @Override
    public String toString() {
        String noData = "Data not available";
        int missingData = 0;
        String idString = "\n" +
                "ID: " + getId() + "\n";
        String nameString;
        String employerString;
        String locationString;
        String positionTypeString;
        String coreCompencyString;
        if (!name.isEmpty()) {
            nameString = "Name: " + getName() + "\n";
        } else {
            nameString = "Name: "+ noData + "\n";
            missingData++;
        }
        if (!(getEmployer().getValue().isEmpty()) && !(getEmployer().getValue() == null)) {
            employerString = "Employer: " + getEmployer() + "\n";
        } else {
            employerString = "Employer: "+ noData + "\n";
            missingData++;
        }
        if (!(getLocation().getValue().isEmpty()) && !(getLocation().getValue() == null)) {
            locationString = "Location: " + getLocation() + "\n";
        } else {
            locationString = "Location: "+ noData + "\n";
            missingData++;
        }
        if (!(getPositionType().getValue().isEmpty()) && !(getPositionType().getValue() == null)) {
            positionTypeString = "Position Type: " + getPositionType() + "\n";
        } else {
            positionTypeString = "Position Type: " + noData + "\n";
            missingData++;
        }
        if (!(getCoreCompetency().getValue().isEmpty()) && !(getCoreCompetency().getValue() == null)) {
            coreCompencyString = "Core Competency: " + getCoreCompetency() + "\n";
        } else {
            coreCompencyString = "Core Competency: " + noData + "\n";
            missingData++;
        }
        if (missingData == 5) {
            return "OOPS! This job does not seem to exist.";
        } else {
            return idString + nameString + employerString + locationString + positionTypeString + coreCompencyString;
        }


    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Job job = (Job) o;
        return getId() == job.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public PositionType getPositionType() {
        return positionType;
    }

    public void setPositionType(PositionType positionType) {
        this.positionType = positionType;
    }

    public CoreCompetency getCoreCompetency() {
        return coreCompetency;
    }

    public void setCoreCompetency(CoreCompetency coreCompetency) {
        this.coreCompetency = coreCompetency;
    }

    public int getId() {
        return id;
    }
}
