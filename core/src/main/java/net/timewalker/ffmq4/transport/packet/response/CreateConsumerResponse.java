/*
 * This file is part of FFMQ.
 *
 * FFMQ is free software; you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * FFMQ is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public License
 * along with FFMQ; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA
 */
package net.timewalker.ffmq4.transport.packet.response;

import net.timewalker.ffmq4.transport.packet.AbstractResponsePacket;
import net.timewalker.ffmq4.transport.packet.PacketType;
import net.timewalker.ffmq4.utils.RawDataBuffer;

/**
 * CreateConsumerResponse
 */
public final class CreateConsumerResponse extends AbstractResponsePacket
{
    private int prefetchSize;
    
    /* (non-Javadoc)
     * @see net.timewalker.ffmq4.network.packet.AbstractPacket#getType()
     */
    @Override
	public byte getType()
    {
        return PacketType.R_CREATE_CONSUMER;
    }

    /* (non-Javadoc)
     * @see net.timewalker.ffmq4.network.packet.AbstractResponsePacket#serializeTo(net.timewalker.ffmq4.utils.RawDataOutputStream)
     */
    @Override
	protected void serializeTo(RawDataBuffer out)
    {
        super.serializeTo(out);
        out.writeInt(prefetchSize);
    }

    /* (non-Javadoc)
     * @see net.timewalker.ffmq4.network.packet.AbstractResponsePacket#unserializeFrom(net.timewalker.ffmq4.utils.RawDataInputStream)
     */
    @Override
	protected void unserializeFrom(RawDataBuffer in)
    {
        super.unserializeFrom(in);
        prefetchSize = in.readInt();
    }

    /**
	 * @return the prefetchSize
	 */
	public int getPrefetchSize()
	{
		return prefetchSize;
	}
	
	/**
	 * @param prefetchSize the prefetchSize to set
	 */
	public void setPrefetchSize(int prefetchSize)
	{
		this.prefetchSize = prefetchSize;
	}
    
    /*
     *  (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
	public String toString()
    {
    	StringBuilder sb = new StringBuilder();
        
        sb.append(super.toString());
        sb.append(" prefetchSize=");
        sb.append(prefetchSize);
        
        return sb.toString();
    }
}
