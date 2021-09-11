package com.teamarcanum.mobuildingblocks.data;

public interface IBlockDataContainer {

    void generateData(BlockStateProvider _provider);
    default void generateItem(BlockStateProvider _provider) {}
    default boolean customItem() { return false; }
}

