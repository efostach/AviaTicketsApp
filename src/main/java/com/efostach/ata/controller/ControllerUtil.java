package com.efostach.ata.controller;

import com.oracle.jrockit.jfr.InvalidValueException;

import java.util.InputMismatchException;

public abstract class ControllerUtil {

    public static Integer getIntegerValue(String value) throws InvalidValueException {
        Integer result;
        try {
            result = Integer.valueOf(value);
        } catch (InputMismatchException | NumberFormatException ex) {
            throw new InvalidValueException("Invalid id value.");
        }
        return result;
    }
}
