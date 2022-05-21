public enum UserChoice {
    BRUTEFORCE("brute"),
    ENCRYPTION ("encrypt"),
    DECRYPT("decrypt");

    private final String choice;

    UserChoice(String choice) {
        this.choice = choice;
    }

    public String getChoice() {
        return choice;
    }
}
