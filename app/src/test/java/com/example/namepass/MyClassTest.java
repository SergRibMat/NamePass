package com.example.namepass;

import org.junit.Test;

import static org.junit.Assert.*;

public class MyClassTest {

    @Test
    public void returnWord() {
        assertFalse(MyClass.emailExists(""));
    }

    @Test
    public void passIsLongEnought() {
        assertFalse(MyClass.passIsLongEnought("ghj"));
    }

    @Test
    public void passHasUppercase() {
        assertFalse(MyClass.passHasUppercase("dsd"));
    }

    @Test
    public void passHaslowercase() {
        assertFalse(MyClass.passHaslowercase("SDW3"));
    }

    @Test
    public void passHasSymbol() {
        assertFalse(MyClass.passHasSymbol("dsdwq3D"));
    }

    @Test
    public void passHasNumber() {
        assertFalse(MyClass.passHasNumber("dsdwqD"));
    }
}