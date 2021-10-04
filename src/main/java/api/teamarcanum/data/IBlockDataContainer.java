package api.teamarcanum.data;

import com.teamarcanum.mobuildingblocks.data.BlockStateProvider;

public interface IBlockDataContainer {

    void generateData(BlockStateProvider _provider);
    default void generateItem(BlockStateProvider _provider) {}
    default boolean customItem() { return false; }
}

