package course.rcc.cis18b.chess.Entities;

public class Player
{
    private String name = "";
    private PlayerTeam team = null;

    public Player(PlayerTeam team) {
        this.team = team;
    }

    public Player(String name, PlayerTeam team) {
        this.name = name;
        this.team = team;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PlayerTeam getTeam() {
        return team;
    }
}