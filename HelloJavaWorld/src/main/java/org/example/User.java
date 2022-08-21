package org.example;

public class User extends Human {
    private String Name;
    private  String LastName;
    private String SSN = "0009999";
    public void setName(String name) {
        if (name != "") {
            Name = name;
        }
    }
    public String getName() {

        if (Name == null)
            return "no name";
        else
            return Name;
    }
    public String getSSN() {
        return SSN;
    }

    public void Speak(String mes) {
        System.out.println("Hi, i am "+Name+" and my message is "+mes);
    }
}