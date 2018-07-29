package edu.mbrooks.advanced.model;

/**
 * This class used for processing form data.
 *
 */
public class Person {

    private int Id;
    private String firstName;
    private String lastName;

    /**
     * getFirstName() is the getter for the person's first name
     * @return firstname
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * setFirstName() is the setter for the person's first name
     * @param firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * getLastName() is the getter for the person's last name
     * @return lastname
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * setLastName() is setter for the person's last name
     * @param lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * processData() is a stub
     */
    public void processData() {
        System.out.println("going to process data");
    }

    /**
     * getId() is a the getter for the record ID
     * @return Id
     */
    public int getId() {
        return Id;
    }

    /**
     * setId is the setting record Id - this is used for testing purposes only
     * @param id
     */
    public void setId(int id) {
        Id = id;
    }

    /**
     * toString() is used to return a standard string for this class
     * @return String
     */
    @Override
    public String toString() {
        return "Person{firstName= '" + firstName + "', lastName= '" + lastName + "'}";
    }

    /**
     * validateData() is used to ensure neither the first nor the last names are not set
     * @return boolean
     */
    public boolean validateData() {

        if ((this.firstName == null) || (this.lastName == null))
            return false;

        return true;

    }
}