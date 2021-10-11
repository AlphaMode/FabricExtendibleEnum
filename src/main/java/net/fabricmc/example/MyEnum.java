package net.fabricmc.example;

import net.minecraft.util.Rarity;

public enum MyEnum implements IExtensibleEnum {
    FART,
    SHIT;

    public static MyEnum create(String name) {
        throw new IllegalStateException("Enum not extended");
    }
}
