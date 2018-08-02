package edu.mbrooks.advanced.model;

/**
 *  A simple container class used to capture form data.
 */
public class Mood {
    
    private Boolean happy;
    private Boolean sad;

    /**
     * Java been pattern needs a default constructor
     */
    public Mood() {
    }

    /**
     * Constructor
     * @param happy boolean for happy
     * @param sad boolean for sad
     */
    public Mood(Boolean happy, Boolean sad) {
        this.happy = happy;
        this.sad = sad;
    }

    /**
     * getter for if the person if happy
     * @return happy boolean value
     */
    public Boolean getHappy() {
        return happy;
    }

    /**
     * setter for happy
     * @param happy boolean value for happy
     */
    public void setHappy(Boolean happy) {
        this.happy = happy;
    }

    /**
     * getter for sad value
     * @return sad boolean value for sad
     */
    public Boolean getSad() {
        return sad;
    }

    /**
     * setter for sad
     * @param sad boolean value
     */
    public void setSad(Boolean sad) {
        this.sad = sad;
    }

    /**
     * provide stand string value for string representatin of this class
     * @return string
     */
    @Override
    public String toString() {
        return "Mood{" +
                "happy=" + happy +
                ", sad=" + sad +
                '}';
    }
}
