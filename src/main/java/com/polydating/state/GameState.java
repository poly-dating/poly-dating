package com.polydating.state;

public class GameState {
    private int favorability;
    private int annoyance;
    private int conversationCount;

    public int getFavorability() {
        return favorability;
    }

    public void setFavorability(int favorability) {
        this.favorability = favorability;
    }

    public int getAnnoyance() {
        return annoyance;
    }

    public void setAnnoyance(int annoyance) {
        this.annoyance = annoyance;
    }

    public int getConversationCount() {
        return conversationCount;
    }

    public void setConversationCount(int conversationCount) {
        this.conversationCount = conversationCount;
    }
}
