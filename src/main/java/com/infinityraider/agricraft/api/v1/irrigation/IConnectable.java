/*
 */
package com.infinityraider.agricraft.api.v1.irrigation;

import net.minecraft.util.EnumFacing;

/**
 * Root interface for all connectable blocks.
 *
 *
 */
public interface IConnectable {

    /**
     * Determines if a component may connect to another component.
     *
     * @param side the side of the component to connect on.
     * @param connectable the component wishing to connect to this component.
     * @return if the component may connect.
     */
    boolean canConnectTo(EnumFacing side, IConnectable connectable);

    /**
     * Called whenever the component should refresh its connections table.
     * Default implementation does nothing;
     */
    default void checkConnections() {
        // Does nothing.
    }

}
