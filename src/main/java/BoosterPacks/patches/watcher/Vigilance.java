package BoosterPacks.patches.watcher;

import com.evacipated.cardcrawl.modthespire.lib.*;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.optionCards.ChooseCalm;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.actions.watcher.ChooseOneAction;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import BoosterPacks.cards.tempCards.ChooseCourage;

import java.util.ArrayList;

@SpirePatch(clz = com.megacrit.cardcrawl.cards.purple.Vigilance.class, method = "use")
public class Vigilance {
    public static void Replace(com.megacrit.cardcrawl.cards.purple.Vigilance __instance, AbstractPlayer p, AbstractMonster m) {
        AbstractDungeon.actionManager.addToBottom(new GainBlockAction(AbstractDungeon.player, AbstractDungeon.player, __instance.block));
        ArrayList<AbstractCard> choices = new ArrayList<>();
        choices.add(new ChooseCalm());
        choices.add(new ChooseCourage());
        AbstractDungeon.actionManager.addToBottom(new ChooseOneAction(choices));
    }
}
