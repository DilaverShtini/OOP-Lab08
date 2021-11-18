package it.unibo.oop.lab.mvc;

import java.util.LinkedList;
import java.util.List;

public class ControllerImpl implements Controller {

    private String nextString;
    private final List<String> history = new LinkedList<>();

    /**
     * @param string
     * set the next string to print.
     */
    public void setNextString(final String string) {
        if (string.isEmpty()) {
            throw new IllegalArgumentException();
        }
        this.nextString = string;
    }

    /**
     * @return the next string to print.
     */
    public String getNextString() {
        return this.nextString;
    }

    /**
     * @return the history of printed strings.
     */
    public List<String> getHistory() {
        return history;
    }

    /**
    * Print the current string only if the string hasn't empty.
    */
    @Override
    public void printString() {
        if (this.nextString == null) {
            throw new IllegalStateException();
        }
        System.out.println("Current string > " + this.nextString);
        history.add(this.nextString);
    }

}
