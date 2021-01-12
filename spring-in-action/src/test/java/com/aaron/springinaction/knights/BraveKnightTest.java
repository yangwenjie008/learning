package com.aaron.springinaction.knights;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class BraveKnightTest {

    @Test
    void embarkOnQuest() {
        Quest mockQuest = mock(Quest.class);
        BraveKnight knigh = new BraveKnight(mockQuest);
        knigh.embarkOnQuest();
        verify(mockQuest,times(1)).embark();
    }
}