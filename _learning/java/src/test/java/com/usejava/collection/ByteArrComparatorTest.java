/*
 * \$Id$
 *
 * ByteArrComparatorTest.java - created on Aug 1, 2011 2:25:58 PM
 * Copyright (c)2011, Chealwoo Lee (Daniel). All rights reserved. Use is subject to license terms.
 */
package com.usejava.collection;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ByteArrComparatorTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void test() {
        ByteArrComparator arrComparator = new ByteArrComparator();
        byte[] o1, o2 = "test".getBytes();

        assertEquals(-1, arrComparator.compare(null, o2));
    }

}
