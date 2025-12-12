package io.github.llocg;

import com.badlogic.gdx.Game;
import io.github.llocg.screens.MainMenuScreen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;


public class LoveLiveGame extends Game {

    @Override
    public void create() {
        setScreen(new MainMenuScreen(this));
    }

    @Override
    public void render() {
        super.render();
    }

    @Override
    public void dispose() {
   if (getScreen() != null) {
            getScreen().dispose(); 
        }
    }
}