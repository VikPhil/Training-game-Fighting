package config;

public enum Constants {

    IDLE(0),
    WALK(0),
    JUMP(0),
    BLOCK(4),
    KICK_FIST_1(1),
    KICK_FIST_2(3),
    KICK_LEG_1(1),
    KICK_LEG_2(2);

    private final int volume;
    Constants(int volume) {
        this.volume = volume;
    }

    public int getVolume() {
        return this.volume;
    }

    public static int getNumberFrames(Constants choiceAction) {
        switch (choiceAction) {
            case WALK:
            case BLOCK:
                return 2;
            case JUMP:
            case KICK_LEG_1:
                return 3;
            case KICK_FIST_1:
            case KICK_LEG_2:
                return 4;
            case KICK_FIST_2:
                return 6;
            case IDLE:
            default:
                return 0;
        }

    }
}
