package BoosterPacks.patches.defect;

import BoosterPacks.patches.BoosterTags;
import basemod.ReflectionHacks;
import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.megacrit.cardcrawl.actions.defect.GashAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;

@SpirePatch(clz = GashAction.class, method = "update")
public class Gash {
    public static void Replace(com.megacrit.cardcrawl.actions.defect.GashAction __instance) {
        AbstractCard card = ReflectionHacks.getPrivate(__instance, GashAction.class, "card");
        card.baseDamage += __instance.amount;
        card.applyPowers();

        AbstractPlayer p = AbstractDungeon.player;
        for (AbstractCard c: p.hand.group) {
            if (c.hasTag(BoosterTags.CLAW)) {
                c.baseDamage += __instance.amount;
                c.applyPowers();
            }
        }
        for (AbstractCard c: p.discardPile.group) {
            if (c.hasTag(BoosterTags.CLAW)) {
                c.baseDamage += __instance.amount;
                c.applyPowers();
            }
        }
        for (AbstractCard c: p.drawPile.group) {
            if (c.hasTag(BoosterTags.CLAW)) {
                c.baseDamage += __instance.amount;
                c.applyPowers();
            }
        }

        __instance.isDone = true;
    }
}