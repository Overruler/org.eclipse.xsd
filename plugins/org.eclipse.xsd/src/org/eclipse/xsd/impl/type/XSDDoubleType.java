/**
 * <copyright>
 *
 * Copyright (c) 2002-2004 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: 
 *   IBM - Initial API and implementation
 *
 * </copyright>
 *
 * $Id: XSDDoubleType.java,v 1.7 2006/12/15 18:59:56 emerks Exp $
 */
package org.eclipse.xsd.impl.type;

public class XSDDoubleType extends XSDAnySimpleType
{
  protected static final Double NaN = new Double(Double.NaN);
  protected static final Double NEGATIVE_INFINITY = new Double(Double.NEGATIVE_INFINITY);
  protected static final Double POSITIVE_INFINITY = new Double(Double.POSITIVE_INFINITY);

  @Override
  public Object getValue(String literal)
  {
    try 
    {
      if ("Nan".equals(literal))
      {
        return NaN;
      }
      else if ("-INF".equals(literal))
      {
        return NEGATIVE_INFINITY;
      }
      else if ("INF".equals(literal))
      {
        return POSITIVE_INFINITY;
      }
      else
      {
        return new Double(literal);
      }
    }
    catch (NumberFormatException e)
    {
      return null;
    }
  }

  @Override
  public int compareValues(Object value1, Object value2)
  {
    return ((Double)value1).compareTo((Double)value2);
  }
}
