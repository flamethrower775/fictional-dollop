package com.mygdx.game.entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.mygdx.game.world.GameMap;
import java.util.ArrayList;

public class Runner2 extends Entity {
    public static final int SPEED = 40;
    private static final int FRAME_COLS = 7;
    Animation<TextureRegion> runAnimation;
    Texture runSheet;
    SpriteBatch sb;
    SpriteBatch batch;
    float stateTime;
    ArrayList<Image> frames;

    public Runner2(float x, float y,
                  GameMap map) {
        super(x, y, EntityType.RUNNER, map);
        runSheet = new Texture(Gdx.files.internal("gabe.png"));
        TextureRegion[][] tmp = TextureRegion.split(runSheet,
                runSheet.getWidth() / FRAME_COLS,
                runSheet.getHeight());

        TextureRegion[] runFrames = new TextureRegion[FRAME_COLS * 1];
        int index = 0;
        for (int i = 0; i < 1; i++) {
            for (int j = 0; j < FRAME_COLS; j++) {
                runFrames[index++] = tmp[i][j];
            }
        }

        runAnimation = new Animation<TextureRegion>(0.1f, runFrames);
        sb = new SpriteBatch();
        stateTime = 0f;
    }

    public void update(float deltaTime) {
        super.update(deltaTime);

        if (Gdx.input.isKeyPressed(Input.Keys.W) && !(isDead())) {
            moveY(SPEED * deltaTime);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.S) && !(isDead())) {
            moveY(-SPEED * deltaTime);
        }
        if (isOnPotion()) {
            this.score += 10;
            System.out.println("GOT IT!!!" + this.score);
        }
        if (isDead()) {
            //ScreenUtils.clear(0,0,0,1);
            System.out.println("DEAD!!");
        }

    }


    @Override
    public void render(OrthographicCamera cam, SpriteBatch batch) {
        // Accumulate elapsed animation time
        stateTime += Gdx.graphics.getDeltaTime();
        // Get current frame of animation for the current stateTime
        TextureRegion idle = runAnimation.getKeyFrame(0, true);
        sb.begin();
        sb.draw(idle, pos.x, pos.y, getWidth(), getHeight());
        sb.end();

        if (Gdx.input.isKeyPressed(Input.Keys.D) && !(isDead())) {
            TextureRegion currFrame = runAnimation.getKeyFrame(stateTime, true);
            if (currFrame.isFlipX()) {
                currFrame.flip(true, false);
            }
            sb.begin();

            if (map.doesRectCollideWithMap
                    (pos.x + 0.45f, pos.y, getWidth(), getHeight())) {
                pos.x = pos.x + 0.45f;
            }
            sb.draw(currFrame, pos.x, pos.y);
            sb.end();
        }

        if (Gdx.input.isKeyPressed(Input.Keys.A) && !(isDead())) {
            TextureRegion currFrame = runAnimation.getKeyFrame(stateTime, true);
            if (!currFrame.isFlipX()) {
                currFrame.flip(true, false);
            }
            sb.begin();

            if (map.doesRectCollideWithMap
                    (pos.x - 0.45f, pos.y, getWidth(), getHeight())) {
                pos.x = pos.x - 0.45f;
            }
            sb.draw(currFrame, pos.x, pos.y);
            sb.end();
        }

    }
}
