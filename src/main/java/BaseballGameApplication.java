public class BaseballGameApplication {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ApplicationContext();
        GameManager gameManager = applicationContext.getGameManager();
        boolean playerWantsToPlayNewGame;
        do {
            playerWantsToPlayNewGame = gameManager.start();
        } while (playerWantsToPlayNewGame);
    }
}
