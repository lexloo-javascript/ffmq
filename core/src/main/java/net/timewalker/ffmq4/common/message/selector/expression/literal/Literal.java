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
package net.timewalker.ffmq4.common.message.selector.expression.literal;


import javax.jms.Message;

import net.timewalker.ffmq4.common.message.selector.expression.AtomicOperand;
import net.timewalker.ffmq4.common.message.selector.expression.SelectorNode;

/**
 * Literal
 */
public abstract class Literal extends SelectorNode implements AtomicOperand
{
    protected Object value;
    
    /**
     * Constructor
     */
    public Literal( Object value )
    {
        super();
        this.value = value;
    }

    /**
	 * @return the value
	 */
	public final Object getValue()
	{
		return value;
	}
    
    /*
     * (non-Javadoc)
     * @see net.timewalker.ffmq4.common.message.selector.expression.SelectorNode#evaluate(javax.jms.Message)
     */
    @Override
	public final Object evaluate( Message message )
    {
        return value;
    }
    
    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
	public String toString()
    {
        return String.valueOf(value);
    }
}
