package CLASSWORK25;

public enum Game {
    ROCK("Rock"),
    PAPER("Paper"),
    SCISSORS("Scissors");

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    Game(String name) {
        this.name = name;
    }
}
