package com.teamarcanum.mobuildingblocks.common.block;

import net.minecraft.tags.Tag;

public interface ITagHolder<TAG> {

    Tag.Named<TAG>[] tags();
}
