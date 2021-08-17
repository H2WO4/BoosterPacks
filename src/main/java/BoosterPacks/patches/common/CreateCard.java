package BoosterPacks.patches.common;

import BoosterPacks.powers.silent.MasteryPower;
import basemod.ReflectionHacks;
import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.*;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;

@SpirePatch(clz = MakeTempCardInHandAction.class, method = "update")
public class CreateCard {
    public static void Prefix(MakeTempCardInHandAction __instance)
    {
        AbstractCard c = ReflectionHacks.getPrivate(__instance, MakeTempCardInHandAction.class, "c");
        if (AbstractDungeon.player.hasPower(MasteryPower.POWER_ID) && c.cardID.equals(com.megacrit.cardcrawl.cards.tempCards.Shiv.ID) && __instance.amount > 1) {
            AbstractDungeon.player.getPower(MasteryPower.POWER_ID).flash();
            __instance.amount += 1;
        }
    }
}