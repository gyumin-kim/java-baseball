public class ApplicationContext {

    /*
     * Input을 인터페이스로 다양하게 활용할 수 있는 여지는 매우 좋네요!
     * 다만 인스턴스에 할당된 채로 박혀있어서 그 의도는 살짝 희미해지지 않나 싶습니다.
     * ApplicationContext를 생성하면서 input을 주입받는 방향은 어떨까요?
     */
    private static final Input input = new KeyboardInput();

    public static GameManager getGameManager() {
        return new GameManager(input);
    }
}
