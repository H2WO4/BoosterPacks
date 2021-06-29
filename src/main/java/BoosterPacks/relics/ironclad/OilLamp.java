package BoosterPacks.relics.ironclad;

import BoosterPacks.BoosterPacks;
import BoosterPacks.cards.tempCards.DarkFlames;
import BoosterPacks.util.TextureLoader;
import basemod.abstracts.CustomRelic;
import com.badlogic.gdx.graphics.Texture;
import com.megacrit.cardcrawl.cards.CardGroup;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;

import static BoosterPacks.BoosterPacks.makeRelicOutlinePath;
import static BoosterPacks.BoosterPacks.makeRelicPath;

public class OilLamp extends CustomRelic {

    public static final String ID = BoosterPacks.makeID("OilLamp");
    private static final Texture IMG = TextureLoader.getTexture(makeRelicPath("OilLamp.png"));
    private static final Texture OUTLINE = TextureLoader.getTexture(makeRelicOutlinePath("OilLamp.png"));

    public OilLamp() {
        super(ID, IMG, OUTLINE, RelicTier.UNCOMMON, LandingSound.MAGICAL);
    }

    @Override
    public void atBattleStart() {
        CardGroup exhaust = AbstractDungeon.player.exhaustPile;
        for (int i = 0; i < 6; i++) {
            exhaust.addToTop(new DarkFlames());
        }
    }

    @Override
    public String getUpdatedDescription() {
        return DESCRIPTIONS[0];
    }

}
