import java.util.ArrayList;

interface Player{
    void joinGame();
    void leaveGame();
    void sendMessage(String message);
    void receiveMessage(String message);
    String getPlayerName();
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
    public String getPlayerName(){
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

class GameLobby {
    private ArrayList<Player> players;

    public GameLobby(){
        this.players = new ArrayList<>();
    }
    public void registerPlayer(Player player){
        this.players.add(player);
        System.out.println("[GameLobby] " + player.getPlayerType() + " " + player.getPlayerName() + " has joined the lobby.");
    }

    public void removePlayer(Player player) {
        this.players.remove(player);
        System.out.println("[GameLobby] " + player.getPlayerType() + " " + player.getPlayerName() + " has left the lobby.");
    }

    public void startMatch() {
        ArrayList<String> playerNames = new ArrayList<>();
        int i = 0;

        for (Player player : players) {
            if (!"Spectator".equals(player.getPlayerType())) {
                playerNames.add(player.getPlayerName());
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
        if (!"Spectator".equals(sender.getPlayerType())) {
            System.out.println("[GameLobby] Spectators cannot send messages.");
        }
        else {
            System.out.println("[" + sender.getPlayerName() +  "] sends: \"" + message + "\"");
            System.out.println("[GameLobby] Message from " + sender.getPlayerName() + ": \"" + message + "\"");
            for (Player player : players) {
                if (!player.equals(sender)) {
                    player.receiveMessage(message);
                }
            }
        }
    }
    // Test case:
    // public static void main(String[] args) {
    //     GameLobby lobby = new GameLobby();
    //     Player alice = new HumanPlayer("Alice", lobby);
    //     Player bot = new AIPlayer("BotX", lobby);
    //     Player bob = new Spectator("Bob", lobby);

    //     alice.joinGame();
    //     bot.joinGame();
    //     bob.joinGame();

    //     alice.sendMessage("LOL");
    //     bob.sendMessage("Shut up, Alice");  // Spectator tries to send a message
    //     lobby.startMatch();
    //     bob.leaveGame();
    //     bot.leaveGame();
    //     alice.leaveGame();
    // }
}