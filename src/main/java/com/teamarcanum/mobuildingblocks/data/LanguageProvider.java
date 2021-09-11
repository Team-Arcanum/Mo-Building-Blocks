package com.teamarcanum.mobuildingblocks.data;

import com.teamarcanum.mobuildingblocks.MoBuildingBlocks;
import com.teamarcanum.mobuildingblocks.common.registry.Blocks;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.fmllegacy.RegistryObject;

import java.util.Objects;

public class LanguageProvider extends net.minecraftforge.common.data.LanguageProvider {

    private final String[] ignoredSuffixes =
            {
                    "_block",
                    "_item",
                    "_side"
            };

    public LanguageProvider(DataGenerator gen) {

        super(gen, MoBuildingBlocks.MODID, "en_us");
    }

    @Override
    protected void addTranslations() {

        Blocks.BLOCKS.getEntries().stream().map(RegistryObject::get).forEach(_block -> add(_block, generateName(Objects.requireNonNull(_block.getRegistryName()).getPath())));

        add("itemGroup." + MoBuildingBlocks.MODID, "Mo' Building Blocks");
    }

    private String generateName(String _registryName) {

        String name = _registryName;
        for(String toReplace : ignoredSuffixes) {
            name = name.replaceAll("", toReplace);
        }

        String[] splitName = _registryName.split("_");
        for(int i = 0; i < splitName.length; i++) {

            char[] characters = splitName[i].toCharArray();
            characters[0] = Character.toUpperCase(characters[0]);
            splitName[i] = new String(characters);
        }

        return String.join(" ", splitName);
    }
}