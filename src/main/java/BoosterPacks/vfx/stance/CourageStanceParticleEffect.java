package BoosterPacks.vfx.stance;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.math.MathUtils;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.helpers.ImageMaster;
import com.megacrit.cardcrawl.vfx.AbstractGameEffect;

public class CourageStanceParticleEffect extends AbstractGameEffect {
    private float x;
    private float y;
    private float vX;
    private float vY;
    private final float dur_div2;
    private float dvy;
    private float dvx;

    public CourageStanceParticleEffect() {
        TextureAtlas.AtlasRegion img = ImageMaster.GLOW_SPARK;
        this.duration = MathUtils.random(1.3F, 1.8F);
        this.scale = MathUtils.random(0.6F, 1.0F) * Settings.scale;
        this.dur_div2 = this.duration / 2.0F;
        this.color = new Color(MathUtils.random(0.2F, 0.3F), 1.0F, MathUtils.random(0.2F, 0.3F), 0.0F);
        this.x = AbstractDungeon.player.hb.cX + MathUtils.random(-AbstractDungeon.player.hb.width / 2.0F - 30.0F * Settings.scale, AbstractDungeon.player.hb.width / 2.0F + 30.0F * Settings.scale);
        this.y = AbstractDungeon.player.hb.cY + MathUtils.random(-AbstractDungeon.player.hb.height / 2.0F - -10.0F * Settings.scale, AbstractDungeon.player.hb.height / 2.0F - 10.0F * Settings.scale);
        this.x -= (float) img.packedWidth / 2.0F;
        this.y -= (float) img.packedHeight / 2.0F;
        this.renderBehind = MathUtils.randomBoolean(0.2F + (this.scale - 0.5F));
        this.rotation = MathUtils.random(-8.0F, 8.0F);
    }

    public void update() {
        if (this.duration > this.dur_div2) {
            this.color.a = Interpolation.fade.apply(1.0F, 0.0F, (this.duration - this.dur_div2) / this.dur_div2);
        } else {
            this.color.a = Interpolation.fade.apply(0.0F, 1.0F, this.duration / this.dur_div2);
        }
        this.vY += Gdx.graphics.getDeltaTime() * 40.0F * Settings.scale;
        this.duration -= Gdx.graphics.getDeltaTime();
        if (this.duration < 0.0F) {
            this.isDone = true;
        }
    }

    public void render(SpriteBatch sb) {
        sb.setColor(this.color);
        sb.setBlendFunction(770, 1);
        sb.draw(ImageMaster.FROST_ACTIVATE_VFX_1, this.x, this.y, 32.0F, 32.0F, 25.0F, 128.0F, this.scale, this.scale + (this.dur_div2 * 0.4F - this.duration) * Settings.scale, this.rotation, 0, 0, 64, 64, false, false);
        sb.setBlendFunction(770, 771);
    }

    public void dispose() {
    }
}
