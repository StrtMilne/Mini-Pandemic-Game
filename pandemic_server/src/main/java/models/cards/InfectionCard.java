package models.cards;

public class InfectionCard {

    private String name;
    private boolean epidemic;

    public InfectionCard(String name, boolean epidemic) {
        this.name = name;
        this.epidemic = epidemic;
    }

    public String getName() {
        return name;
    }

    public boolean isEpidemic() {
        return epidemic;
    }
}
