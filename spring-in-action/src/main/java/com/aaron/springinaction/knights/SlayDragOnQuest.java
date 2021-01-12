package com.aaron.springinaction.knights;

import java.io.PrintStream;

/**
 * 屠龙探险
 */
public class SlayDragOnQuest implements Quest {
    private PrintStream stream;

    public SlayDragOnQuest(PrintStream stream) {
        this.stream = stream;
    }

    @Override
    public void embark() {
        stream.println("Embarking on quest to slay the dragon!");
    }
}
