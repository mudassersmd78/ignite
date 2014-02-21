// @java.file.header

/*  _________        _____ __________________        _____
 *  __  ____/___________(_)______  /__  ____/______ ____(_)_______
 *  _  / __  __  ___/__  / _  __  / _  / __  _  __ `/__  / __  __ \
 *  / /_/ /  _  /    _  /  / /_/ /  / /_/ /  / /_/ / _  /  _  / / /
 *  \____/   /_/     /_/   \_,__/   \____/   \__,_/  /_/   /_/ /_/
 */

package org.gridgain.grid.kernal.processors.streamer;

import org.gridgain.grid.util.direct.*;
import org.gridgain.grid.util.*;

import java.io.*;
import java.nio.*;

/**
 * Streamer cancel request.
 *
 * @author @java.author
 * @version @java.version
 */
public class GridStreamerCancelRequest extends GridTcpCommunicationMessageAdapter {
    /** Cancelled future ID. */
    private GridUuid cancelledFutId;

    /**
     * Empty constructor required by {@link Externalizable}.
     */
    public GridStreamerCancelRequest() {
        // No-op.
    }

    /**
     * @param cancelledFutId Cancelled future ID.
     */
    public GridStreamerCancelRequest(GridUuid cancelledFutId) {
        this.cancelledFutId = cancelledFutId;
    }

    /**
     * @return Cancelled future ID.
     */
    public GridUuid cancelledFutureId() {
        return cancelledFutId;
    }

    /** {@inheritDoc} */
    @SuppressWarnings({"CloneDoesntCallSuperClone", "CloneCallsConstructors"})
    @Override public GridTcpCommunicationMessageAdapter clone() {
        GridStreamerCancelRequest _clone = new GridStreamerCancelRequest();

        clone0(_clone);

        return _clone;
    }

    /** {@inheritDoc} */
    @Override protected void clone0(GridTcpCommunicationMessageAdapter _msg) {
        GridStreamerCancelRequest _clone = (GridStreamerCancelRequest)_msg;

        _clone.cancelledFutId = cancelledFutId;
    }

    /** {@inheritDoc} */
    @SuppressWarnings("all")
    @Override public boolean writeTo(ByteBuffer buf) {
        commState.setBuffer(buf);

        if (!commState.typeWritten) {
            if (!commState.putByte(directType()))
                return false;

            commState.typeWritten = true;
        }

        switch (commState.idx) {
            case 0:
                if (!commState.putGridUuid(cancelledFutId))
                    return false;

                commState.idx++;

        }

        return true;
    }

    /** {@inheritDoc} */
    @SuppressWarnings("all")
    @Override public boolean readFrom(ByteBuffer buf) {
        commState.setBuffer(buf);

        switch (commState.idx) {
            case 0:
                GridUuid cancelledFutId0 = commState.getGridUuid();

                if (cancelledFutId0 == GRID_UUID_NOT_READ)
                    return false;

                cancelledFutId = cancelledFutId0;

                commState.idx++;

        }

        return true;
    }

    /** {@inheritDoc} */
    @Override public byte directType() {
        return 79;
    }
}
