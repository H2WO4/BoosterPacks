package BoosterPacks.stances;

import BoosterPacks.vfx.stance.CourageAuraEffect;
import BoosterPacks.vfx.stance.CourageStanceParticleEffect;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.MathUtils;
import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.stances.AbstractStance;
import com.megacrit.cardcrawl.vfx.BorderFlashEffect;

public class CourageStance extends AbstractStance {
    public static final String STANCE_ID = "Courage";
    private static long sfxId;

    public CourageStance() {
        this.ID = "Courage";
        this.name = "Courage";
        this.updateDescription();
    }

    public void updateDescription() {
        this.description = "Upon exiting this Stance, draw #b1 card. NL At the start of your turn, draw #b1 additional card.";
    }

    public void updateAnimation() {
        if (!Settings.DISABLE_EFFECTS) {
            this.particleTimer -= Gdx.graphics.getDeltaTime();
            if (this.particleTimer < 0.0F) {
                this.particleTimer = 0.04F;
                AbstractDungeon.effectsQueue.add(new CourageStanceParticleEffect());
            }
        }

        this.particleTimer2 -= Gdx.graphics.getDeltaTime();
        if (this.particleTimer2 < 0.0F) {
            this.particleTimer2 = MathUtils.random(0.45F, 0.55F);
            AbstractDungeon.effectsQueue.add(new CourageAuraEffect());
        }

    }

    public void onEnterStance() {
        if (sfxId != -1L) {
            this.stopIdleSfx();
        }
        CardCrawlGame.sound.play("STANCE_ENTER_CALM");
        sfxId = CardCrawlGame.sound.playAndLoop("STANCE_LOOP_CALM");
        AbstractDungeon.effectsQueue.add(new BorderFlashEffect(Color.GREEN, true));
    }

    public void onExitStance() {
        AbstractDungeon.actionManager.addToBottom(new DrawCardAction(1));
        this.stopIdleSfx();
    }

    public void atStartOfTurn() {
        AbstractDungeon.actionManager.addToBottom(new DrawCardAction(1));
    }

    public void stopIdleSfx() {
        if (sfxId != -1L) {
            CardCrawlGame.sound.stop("STANCE_LOOP_CALM", sfxId);
            sfxId = -1L;
        }

    }

    static {
        sfxId = -1L;
    }
}
