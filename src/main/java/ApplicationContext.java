public class ApplicationContext {

    private final Input input;

    public ApplicationContext() {
        this.input = new KeyboardInput();
    }

    public GameManager getGameManager() {
        return new GameManager(input);
    }
}
