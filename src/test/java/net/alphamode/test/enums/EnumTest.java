/*
 * AlphaMode
 * Copyright (c) 2021.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation version 2.1
 * of the License.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301  USA
 */

package net.alphamode.test.enums;

import net.alphamode.enums.EnumUtil;
import net.fabricmc.api.ModInitializer;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.apache.logging.log4j.LogManager;

public class EnumTest implements ModInitializer {

    @Override
    public void onInitialize() {
        Registry.register(Registry.ITEM, new Identifier("enum_adder", "green"), new Item(new Item.Settings().group(ItemGroup.MISC).rarity(EnumUtil.createRarity("GREEN", Formatting.DARK_GREEN))));
        Registry.register(Registry.ITEM, new Identifier("enum_adder", "cyan"), new Item(new Item.Settings().group(ItemGroup.MISC).rarity(EnumUtil.createRarity("CYAN", Formatting.DARK_AQUA))));
        MyEnum.create("BAR");
        LogManager.getLogger().info(MyEnum.values());
    }
}
