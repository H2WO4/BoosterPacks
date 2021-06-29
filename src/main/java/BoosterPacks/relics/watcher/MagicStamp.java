package BoosterPacks.relics.watcher;

import BoosterPacks.BoosterPacks;
import BoosterPacks.util.TextureLoader;
import basemod.abstracts.CustomRelic;
import com.badlogic.gdx.graphics.Texture;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.watcher.MarkPower;

import static BoosterPacks.BoosterPacks.makeRelicOutlinePath;
import static BoosterPacks.BoosterPacks.makeRelicPath;

public class MagicStamp extends CustomRelic {

    public static final String ID = BoosterPacks.makeID("MagicStamp");
    private static final Texture IMG = TextureLoader.getTexture(makeRelicPath("OilLamp.png"));
    private static final Texture OUTLINE = TextureLoader.getTexture(makeRelicOutlinePath("OilLamp.png"));

    public MagicStamp() {
        super(ID, IMG, OUTLINE, RelicTier.UNCOMMON, LandingSound.MAGICAL);
    }

    @Override
    public String getUpdatedDescription() {
        return DESCRIPTIONS[0];
    }

    @Override
    public void atBattleStart() {
        AbstractPlayer p = AbstractDungeon.player;
        for (AbstractMonster mo : AbstractDungeon.getCurrRoom().monsters.monsters)
        {
            this.addToBot(new ApplyPowerAction(mo, p, new MarkPower(mo, 8), 8));
        }
    }
}
