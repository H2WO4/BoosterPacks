package BoosterPacks.patches.watcher;

import BoosterPacks.relics.watcher.PaperStatiou;
import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.stances.DivinityStance;

@SpirePatch(clz = DivinityStance.class, method = "atDamageGive")
public class Divinity {
    public static float Replace(DivinityStance __instance, float damage, DamageInfo.DamageType type) {
        if (type == DamageInfo.DamageType.NORMAL) {
            if (AbstractDungeon.player.hasRelic(PaperStatiou.ID)) {
                return damage * 4F;
            }
            return damage * 3F;
        }
        return damage;
    }
}