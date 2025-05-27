package pbjam.beans;

import java.io.Serializable;

public class Tournament implements Serializable {
	private static final long serialVersionUID = 1L;
    private final String name;
    private final String date;
    private final String location;

    public Tournament(String name, String date, String location) {
        this.name = name;
        this.date = date;
        this.location = location;
    }

    @Override
    public String toString() {
        return name + " (" + date + ") at " + location;
    }
}
