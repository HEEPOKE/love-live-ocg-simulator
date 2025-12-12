package io.github.llocg.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

import io.github.llocg.LoveLiveGame;

public class MainMenuScreen implements Screen {

    private final LoveLiveGame game;
    private Stage stage;
    private Skin skin;
    private Texture backgroundTexture;
    private Image backgroundImage;

    public MainMenuScreen(LoveLiveGame game) {
        this.game = game;
    }

    @Override
    public void show() {
        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);

        skin = new Skin(Gdx.files.internal("ui/uiskin.json"));

        BitmapFont font = skin.getFont("default");

        font.getData().setScale(1.0f);

        backgroundTexture = new Texture(Gdx.files.internal("bg/bg.jpg"));
        backgroundImage = new Image(backgroundTexture);
        backgroundImage.setFillParent(true);
        stage.addActor(backgroundImage);

        Table table = new Table();
        table.setFillParent(true);
        table.center();
        stage.addActor(table);

        TextButton playBtn = new TextButton("Play", skin);
        TextButton deckBtn = new TextButton("Edit Deck", skin);
        TextButton loginBtn = new TextButton("Login", skin);
        TextButton registerBtn = new TextButton("Register", skin);

        float pad = 15f;
        table.add(registerBtn).width(300).height(50).pad(pad).row();
        table.add(loginBtn).width(300).height(50).pad(pad).row();
        table.add(deckBtn).width(300).height(50).pad(pad).row();
        table.add(playBtn).width(300).height(50).pad(pad);

        playBtn.addListener(e -> {
            if (!playBtn.isPressed()) {
                return false;
            }
            game.setScreen(new PlayScreen(game));
            return true;
        });

        deckBtn.addListener(e -> {
            if (!deckBtn.isPressed()) {
                return false;
            }
            game.setScreen(new DeckEditScreen(game));
            return true;
        });

        loginBtn.addListener(e -> {
            if (!loginBtn.isPressed()) {
                return false;
            }
            game.setScreen(new LoginScreen(game));
            return true;
        });

        registerBtn.addListener(e -> {
            if (!registerBtn.isPressed()) {
                return false;
            }
            game.setScreen(new RegisterScreen(game));
            return true;
        });

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0.1f, 0.1f, 0.15f, 1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        stage.act(delta);
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height, true);
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    @Override
    public void hide() {
        dispose();
    }

    @Override
    public void dispose() {
        if (stage != null) {
            stage.dispose();
        }
        if (skin != null) {
            skin.dispose();
        }
        if (backgroundTexture != null) {
            backgroundTexture.dispose();
        }
    }
}
