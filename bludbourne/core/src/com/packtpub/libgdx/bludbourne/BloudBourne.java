package com.packtpub.libgdx.bludbourne;

import com.badlogic.gdx.Game;
import com.packtpub.libgdx.bludbourne.screen.MainGameScreen;

/**
 * Created by dastaniqbal on 11/11/2017.
 */
public class BloudBourne extends Game {
    public static final MainGameScreen _mainGameScreen = new MainGameScreen();

    @Override
    public void create() {
        setScreen(_mainGameScreen);
    }

    @Override
    public void dispose() {
        _mainGameScreen.dispose();
    }
}
