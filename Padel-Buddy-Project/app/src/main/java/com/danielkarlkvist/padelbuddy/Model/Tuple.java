package com.danielkarlkvist.padelbuddy.Model;

/**
 * The Tuple class enable us to use pairs of different (or the same) object.
 *
 * @author Robin Repo Wecklauf, Marcus Axelsson, Daniel Karlkvist
 * Carl-Johan Björnson och Fredrik Lilliecreutz
 * @version 1.0
 * @since 2019-09-05
 */

class Tuple<X, Y> {

    private final X x;
    private final Y y;

    Tuple(X x, Y y) {
        this.x = x;
        this.y = y;
    }

    public X getX() {
        return x;
    }

    public Y getY() {
        return y;
    }
}
