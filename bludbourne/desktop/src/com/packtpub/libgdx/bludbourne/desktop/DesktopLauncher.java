package com.packtpub.libgdx.bludbourne.desktop;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.packtpub.libgdx.bludbourne.BloudBourne;

public class DesktopLauncher {
    public static void main(String[] arg) {
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        config.title = "BludBourne";
        config.useGL30 = false;
        config.width = 800;
        config.height = 600;

        Gdx.app = new LwjglApplication(new BloudBourne(), config);
        Gdx.app.setLogLevel(Application.LOG_DEBUG);
    }
}
