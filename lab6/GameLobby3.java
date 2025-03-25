import java.util.ArrayList;

interface Player{
    void joinGame();
    void leaveGame();
    void sendMessage(String message);
    void receiveMessage(String message);
    String getName();
    String getPlayerType();
}

abstract class AbstractPlayer implements Player {
    protected String name;
    protected GameLobby lobby;

    public AbstractPlayer(String name, GameLobby lobby) {
        this.name = name;
        this.lobby = lobby;
    }

    @Override
    public String getName(){
        return this.name;
    }

    @Override
    public void sendMessage(String message) {
        this.lobby.sendMessage(message, this);
    }

    @Override
    public void receiveMessage(String message) {
        System.out.println("[" + this.name + "] received: \"" + message + "\"");
    }

    public abstract String getPlayerType();
}

class HumanPlayer extends AbstractPlayer {
    public HumanPlayer(String name, GameLobby lobby){
        super(name, lobby);
    }

    public void joinGame(){
        this.lobby.registerPlayer(this);
    }

    public void leaveGame(){
        this.lobby.removePlayer(this);
    }

    public String getPlayerType(){
        return "HumanPlayer";
    }
}
class AIPlayer extends AbstractPlayer {
    public AIPlayer(String name, GameLobby lobby){
        super(name, lobby);
    }

    public void joinGame(){
        this.lobby.registerPlayer(this);
    }

    public void leaveGame(){
        this.lobby.removePlayer(this);
    }

    public String getPlayerType(){
        return "AIPlayer";
    }
}
class Spectator extends AbstractPlayer {
    public Spectator(String name, GameLobby lobby){
        super(name, lobby);
    }

    public void joinGame(){
        this.lobby.registerPlayer(this);
    }

    public void leaveGame(){
        this.lobby.removePlayer(this);
    }

    public String getPlayerType(){
        return "Spectator";
    }
}

class AdminPlayer extends AbstractPlayer {
    public AdminPlayer(String name, GameLobby lobby) {
        super(name, lobby);
    }

    public void joinGame(){
        this.lobby.registerPlayer(this);
    }

    public void leaveGame(){
        this.lobby.removePlayer(this);
    }

    public String getPlayerType() {
        return "AdminPlayer";
    }

    public void kickPlayer(String name) {
        lobby.kickPlayer(name, this);
    }
}

class PlayerFactory {
    public static Player createPlayer(String type, String name, GameLobby lobby) {
        switch (type.toLowerCase()) {
            case "human":
                return new HumanPlayer(name, lobby);
            case "ai":
                return new AIPlayer(name, lobby);
            case "spectator":
                return new Spectator(name, lobby);
            case "admin":
                return new AdminPlayer(name, lobby);
            default:
                System.out.println("Type not found");
                return null;
        }
    }
}

class GameLobby {
    private ArrayList<Player> players;

    public GameLobby(){
        this.players = new ArrayList<>();
    }
    public void registerPlayer(Player player){
        this.players.add(player);
        System.out.println("[GameLobby] " + player.getPlayerType() + " " + player.getName() + " has joined the lobby.");
    }

    public void removePlayer(Player player) {
        this.players.remove(player);
        System.out.println("[GameLobby] " + player.getPlayerType() + " " + player.getName() + " has left the lobby.");
    }

    public void startMatch() {
        ArrayList<String> playerNames = new ArrayList<>();
        int i = 0;

        for (Player player : players) {
            if (!"Spectator".equals(player.getPlayerType()) && !"AdminPlayer".equals(player.getPlayerType())) {
                playerNames.add(player.getName());
                i++;
            }
        }
        if (i >= 2) {
            System.out.println("[GameLobby] Starting game with players: " + String.join(", ", playerNames));
        } else {
            System.out.println("[GameLobby] Not enough players to start a match.");
        }
    }

    public void sendMessage(String message, Player sender) {
        if ("Spectator".equals(sender.getPlayerType())) {
            System.out.println("[GameLobby] Spectators cannot send messages.");
        }
        else {
            System.out.println("[" + sender.getName() +  "] sends: \"" + message + "\"");
            System.out.println("[GameLobby] Message from " + sender.getName() + ": \"" + message + "\"");
            for (Player player : players) {
                if (!player.equals(sender)) {
                    player.receiveMessage(message);
                }
            }
        }
    }

    public void kickPlayer(String name, AdminPlayer admin){
        for (Player player : players){
            if (player.getName().equals(name) && !(player.getPlayerType().equals("AdminPlayer"))) {
                System.out.println("[GameLobby] Admin " + admin.getName() + " kicked " + player.getPlayerType() + " " + player.getName() + " from the lobby.");
                this.removePlayer(player);
                return;
            }
        }
        System.out.println("[GameLobby] Player " + name + " not found.");
    }
    // Test case:
    // public static void main(String[] args) {
    //     GameLobby lobby = new GameLobby();

    //     Player alice = PlayerFactory.createPlayer("human", "Alice", lobby);
    //     Player bot = PlayerFactory.createPlayer("ai", "BotX", lobby);
    //     Player bob = PlayerFactory.createPlayer("spectator", "Bob", lobby);
    //     Player admin = PlayerFactory.createPlayer("admin", "Charlie", lobby);

    //     alice.joinGame();
    //     bot.joinGame();
    //     bob.joinGame();
    //     admin.joinGame();

    //     admin.sendMessage("Hello, everyone!");
    //     ((AdminPlayer) admin).kickPlayer("Bob");

    //     lobby.startMatch();
    // }
}