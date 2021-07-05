package br.com.aula4.tm.linktracker.utils;

public class Id {
    private static long id = 1l;

    public static long generateId() {
        return id++;
    }
}
