package org.launchcode.enumerableplanets.controllers;

public enum Planets {

    MERCURY("Mercury", 88),
    VENUS("Venus", 225),
    EARTH("Earth", 365),
    MARS("Mars", 687),
    JUPITER("Jupiter", 4333),
    SATURN("Saturn", 10759),
    URANUS("Uranus", 30687),
    NEPTUNE("Neptune", 60200);

    private final String displayName;
    private final int yearLength;

    Planets(String displayName, int yearLength) {
        this.displayName = displayName;
        this.yearLength = yearLength;
    }

    public String getDisplayName() {
        return displayName;
    }

    public int getYearLength() {
        return yearLength;
    }
}
