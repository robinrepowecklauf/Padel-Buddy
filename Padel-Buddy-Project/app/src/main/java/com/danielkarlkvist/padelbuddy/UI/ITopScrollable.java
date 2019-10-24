package com.danielkarlkvist.padelbuddy.UI;

/**
 * The ITopScrollable interface defines the method that allows
 * the user to press on current tab to arrive at the top of the
 * tab
 *
 * @author Marcus Axelsson
 * @version 1.0
 * @since 2019-10-09
 */
interface ITopScrollable {

    /**
     * Scrolls to the top of the page if the user click
     * on the BottomNavigationView icon that they are already inside of
     */
    void scrollToTop();
}
