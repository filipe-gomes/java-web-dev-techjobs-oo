package org.launchcode.techjobs_oo;

import java.util.Objects;

public class Employer extends JobField {

    public Employer(String value) {
        super(value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

}
