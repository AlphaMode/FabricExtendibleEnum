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

package net.alphamode.enums.mixin;

import net.alphamode.enums.IExtensibleEnum;
import net.minecraft.util.Formatting;
import net.minecraft.util.Rarity;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(Rarity.class)
public class RarityMixin implements IExtensibleEnum<Rarity> {

    private static Rarity create(String name, Formatting formatting) {
        throw new IllegalStateException("Enum not extended");
    }

    @Override
    public Rarity createEnum(String name, Object... args) {
        return create(name, (Formatting) args[0]);
    }
}
