package io.github.llocg.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import io.github.llocg.LoveLiveGame;

public class LoginScreen implements Screen {

    private final LoveLiveGame game;
    private Stage stage;
    private Skin skin;

    public LoginScreen(LoveLiveGame game) {
        this.game = game;
    }

    @Override
    public void show() {
        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);
        skin = new Skin(Gdx.files.internal("ui/uiskin.json"));

        Table table = new Table();
        table.setFillParent(true);
        stage.addActor(table);

        Label title = new Label("Login (TODO: form here)", skin);
        TextButton backBtn = new TextButton("Back", skin);

        table.center();
        table.add(title).pad(20).row();
        table.add(backBtn).width(150).pad(10);

        backBtn.addListener(e -> {
            if (!backBtn.isPressed()) return false;
            game.setScreen(new MainMenuScreen(game));
            return true;
        });
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0f, 0f, 0f, 1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        stage.act(delta);
        stage.draw();
    }

    @Override public void resize(int width, int height) { stage.getViewport().update(width, height, true); }
    @Override public void pause() {}
    @Override public void resume() {}
    @Override public void hide() { dispose(); }
    @Override public void dispose() { if (stage != null) stage.dispose(); if (skin != null) skin.dispose(); }
}