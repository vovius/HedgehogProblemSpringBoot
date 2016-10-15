package com.training.hedgehogproblem.util;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.Arrays;

import static org.junit.Assert.assertFalse;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.times;
import static org.powermock.api.mockito.PowerMockito.when;

/**
 * Created by sony on 10/11/2016.
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(HedgehogWalkHelper.class)
public class HedgehogWalkHelperTest {

    @Test
    public void testPrintArray() {
        int[][] array = new int[3][3];
        PowerMockito.mockStatic(Arrays.class);
        when(Arrays.toString(array[0])).thenReturn(anyString());

        HedgehogWalkHelper.printArray(array, "");

        PowerMockito.verifyStatic(times(3));
        Arrays.toString(array[0]);
    }


    @Test
    public void testRandomizeArray() {
        int[][] array = new int[3][3];
        HedgehogWalkHelper.randomizeArray(array);

        assertFalse(Arrays.equals(array, new int[3][3]));
    }
}
