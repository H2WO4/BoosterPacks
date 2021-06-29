package BoosterPacks.relics.shared;

import BoosterPacks.BoosterPacks;
import BoosterPacks.cards.tempCards.Defense;
import BoosterPacks.cards.tempCards.Offense;
import BoosterPacks.util.TextureLoader;
import basemod.abstracts.CustomRelic;
import com.badlogic.gdx.graphics.Texture;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInHandAction;

import static BoosterPacks.BoosterPacks.makeRelicOutlinePath;
import static BoosterPacks.BoosterPacks.makeRelicPath;

public class PieceOfMind extends CustomRelic {

    public static final String ID = BoosterPacks.makeID("PieceOfMind");
    private static final Texture IMG = TextureLoader.getTexture(makeRelicPath("OilLamp.png"));
    private static final Texture OUTLINE = TextureLoader.getTexture(makeRelicOutlinePath("OilLamp.png"));

    public PieceOfMind() {
        super(ID, IMG, OUTLINE, RelicTier.UNCOMMON, LandingSound.MAGICAL);
    }

    @Override
    public void atTurnStart() {
        this.addToBot(new MakeTempCardInHandAction(new Offense()));
        this.addToBot(new MakeTempCardInHandAction(new Defense()));
    }

    @Override
    public String getUpdatedDescription() {
        return DESCRIPTIONS[0];
    }

}
