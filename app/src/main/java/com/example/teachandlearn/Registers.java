package com.example.teachandlearn;

import java.util.Calendar;

public class Registers
{
    private int registers_1ID;
    private String registers_1Name;
    private String registers_1Certificate;
    private String registers_1Email;
    private String registers_1Subject;
    private String registers_1Birthday;
    private String registers_1Grade;

    private int registers_2ID;
    private String registers_2Name;
    private String registers_2Certificate;
    private String registers_2Email;
    private String registers_2Subject;
    private String registers_2Birthday;


    //.......................................................................................


    public Registers() {
        this.registers_1ID = -1;
        this.registers_2ID = -1;
    }


    //.......................................................................................


    public int getRegisters_1ID() {
        return registers_1ID;
    }

    public void setRegisters_1ID(int registers_1ID) {
        this.registers_1ID = registers_1ID;
    }

    public int getRegisters_2ID() {
        return registers_2ID;
    }

    public void setRegisters_2ID(int registers_2ID) {
        this.registers_2ID = registers_2ID;
    }

    //.......................................................................................

    public String getRegisters_1Name() {
        return registers_1Name;
    }

    public void setRegisters_1Name(String registers_1Name) {
        this.registers_1Name = registers_1Name;
    }

    public String getRegisters_1Certificate() {
        return registers_1Certificate;
    }

    public void setRegisters_1Certificate(String registers_1Certificate) {
        this.registers_1Certificate = registers_1Certificate;
    }

    public String getRegisters_1Email() {
        return registers_1Email;
    }

    public void setRegisters_1Email(String registers_1Email) {
        this.registers_1Email = registers_1Email;
    }

    public String getRegisters_1Subject() {
        return registers_1Subject;
    }

    public void setRegisters_1Subject(String registers_1Subject) {
        this.registers_1Subject = registers_1Subject;
    }

    public String getRegisters_1Birthday() {
        return registers_1Birthday;
    }

    public void setRegisters_1Birthday(String registers_1Birthday) {
        this.registers_1Birthday = registers_1Birthday;
    }

    public String getRegisters_1Grade() {
        return registers_1Grade;
    }

    public void setRegisters_1Grade(String registers_1Grade) {
        this.registers_1Grade = registers_1Grade;
    }


    //.......................................................................................


    public String getRegisters_2Name() {
        return registers_2Name;
    }

    public void setRegisters_2Name(String registers_2Name) {
        this.registers_2Name = registers_2Name;
    }

    public String getRegisters_2Certificate() {
        return registers_2Certificate;
    }

    public void setRegisters_2Certificate(String registers_2Certificate) {
        this.registers_2Certificate = registers_2Certificate;
    }

    public String getRegisters_2Email() {
        return registers_2Email;
    }

    public void setRegisters_2Email(String registers_2Email) {
        this.registers_2Email = registers_2Email;
    }

    public String getRegisters_2Subject() {
        return registers_2Subject;
    }

    public void setRegisters_2Subject(String registers_2Subject) {
        this.registers_2Subject = registers_2Subject;
    }

    public String getRegisters_2Birthday() {
        return registers_2Birthday;
    }

    public void setRegisters_2Birthday(String registers_2Birthday) {
        this.registers_2Birthday = registers_2Birthday;
    }
}
