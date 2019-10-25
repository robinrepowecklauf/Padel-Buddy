package com.danielkarlkvist.padelbuddy.UI;

/**
 * The ITimePickerDialogListener interface defines the method that should be able to put the text from TimePickerDialog in another class
 *
 * @author Robin Repo Wecklauf, Marcus Axelsson, Daniel Karlkvist
 * Carl-Johan Björnson och Fredrik Lilliecreutz
 * @version 1.0
 * @since 2019-09-05
 */
public interface ITimePickerDialogListener {

    /**
     * Put the text from the TimePickerDialog in
     *
     * @param time   current time
     * @param length current length
     */
    void applyTexts(String time, String length);
}
