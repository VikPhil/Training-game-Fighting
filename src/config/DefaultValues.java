package config;

public interface DefaultValues {

    float SCALE = 1.0f;
    int CELL_WIDTH = 32;
    int CELL_HEIGHT = 20;
    int CELL_SIZE = (int)(CELL_WIDTH * SCALE);
    int WINDOW_WIDTH = CELL_SIZE * CELL_WIDTH;
    int WINDOW_HEIGHT = CELL_SIZE * CELL_HEIGHT;
    int FRAME_WIDTH = 105;
    int FRAME_HEIGHT = 100;
    float FLOOR_HEIGHT = WINDOW_HEIGHT - (FRAME_HEIGHT + CELL_SIZE);
    float DEFAULT_POSITION_LEFT = WINDOW_WIDTH / 3;

    String SPRITE_FIGHTER_ONE = "fighter_one_sprites.png";
    String SPRITE_LEVEL = "cyberpunk-street.png";

}
