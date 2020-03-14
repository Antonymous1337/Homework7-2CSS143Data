import org.junit.Test;

import static org.junit.Assert.*;

public class MaxHeapTest {
    // homework
    @Test
    public void testMethods() {
        MaxHeap test1 = new MaxHeap(5);

        assertTrue(test1.get() == null);
        for (int i = 0; i < test1.size; i++) {
            test1.add(i);
            assertTrue(test1.get() == i);
            if (i == test1.size-1) {
                assertTrue(!test1.add(5));
            }
        }
        for (int i = test1.size-1; i >= 0; i--) {
            assertTrue(test1.pop() == i);
        }
        assertTrue(test1.pop() == null);


        Integer[] data = {0, 1, 2, 3, 4, 5, 6, 7,};
        test1.MaxHeapLogN(data);
        // 7  6 5  3 2 1 4   0
        Integer[] expected1 = {7, 6, 5, 3, 2, 1, 4, 0};
        assertTrue(test1.isEqualToArray(expected1));
        for (int i = 0; i < data.length; i++) {
            assertTrue(data[i] == i);
        }

        MaxHeap test2 = new MaxHeap(8);
        test2.MaxHeapN(data);
        // 7  4 6  3 0 5 2  1
        Integer[] expected2 = {7, 4, 6, 3, 0, 5, 2, 1};
        assertTrue(test2.isEqualToArray(expected2));
        for (int i = 0; i < data.length; i++) {
            assertTrue(data[i] == i);
        }


        MaxHeap testsNLogN = new MaxHeap(0);
        Integer[] nums = {0};
        testsNLogN.MaxHeapLogN(nums);
        Integer[] expected = {0};
        assertTrue(testsNLogN.isEqualToArray(expected));

        testsNLogN = new MaxHeap(0);
        nums = new Integer[]{0, 1};
        testsNLogN.MaxHeapLogN(nums);
        expected = new Integer[]{1, 0};
        assertTrue(testsNLogN.isEqualToArray(expected));

        testsNLogN = new MaxHeap(0);
        nums = new Integer[]{0, 1, 2};
        testsNLogN.MaxHeapLogN(nums);
        expected = new Integer[]{2, 0, 1};
        assertTrue(testsNLogN.isEqualToArray(expected));

        testsNLogN = new MaxHeap(0);
        nums = new Integer[]{0, 1, 2, 3};
        testsNLogN.MaxHeapLogN(nums);
        expected = new Integer[]{3, 2, 1, 0};
        assertTrue(testsNLogN.isEqualToArray(expected));

        testsNLogN = new MaxHeap(0);
        nums = new Integer[]{0, 1, 2, 3, 4};
        testsNLogN.MaxHeapLogN(nums);
        expected = new Integer[]{4, 3, 1, 0, 2};
        assertTrue(testsNLogN.isEqualToArray(expected));

        testsNLogN = new MaxHeap(0);
        nums = new Integer[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
        testsNLogN.MaxHeapLogN(nums);
        //printHeap(testsNLogN);
        expected = new Integer[]{20,  19, 13,  16, 18, 10, 12,  9, 15, 17, 7, 1, 5, 4, 11,   0, 6, 3, 14, 2, 8};
        assertTrue(testsNLogN.isEqualToArray(expected));



        MaxHeap testsN = new MaxHeap(0);
        nums = new Integer[]{0};
        testsN.MaxHeapN(nums);
        expected = new Integer[]{0};
        assertTrue(testsN.isEqualToArray(expected));

        testsN = new MaxHeap(0);
        nums = new Integer[]{0, 1};
        testsN.MaxHeapN(nums);
        expected = new Integer[]{1, 0};
        assertTrue(testsN.isEqualToArray(expected));

        testsN = new MaxHeap(0);
        nums = new Integer[]{0, 1, 2};
        testsN.MaxHeapN(nums);
        expected = new Integer[]{2, 1, 0};
        assertTrue(testsN.isEqualToArray(expected));

        testsN = new MaxHeap(0);
        nums = new Integer[]{0, 1, 2, 3};
        testsN.MaxHeapN(nums);
        expected = new Integer[]{3, 1, 2, 0};
        assertTrue(testsN.isEqualToArray(expected));

        testsN = new MaxHeap(0);
        nums = new Integer[]{0, 1, 2, 3, 4};
        testsN.MaxHeapN(nums);
        expected = new Integer[]{4, 3, 2, 0, 1};
        assertTrue(testsN.isEqualToArray(expected));

        testsN = new MaxHeap(0);
        nums = new Integer[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
        testsN.MaxHeapN(nums);
        //printHeap(testsN);
        expected = new Integer[]{20,  19, 13,  16, 18, 10, 12,  9, 15, 17, 7, 1, 5, 4, 11,   0, 6, 3, 14, 2, 8};
        assertTrue(testsNLogN.isEqualToArray(expected));

    }

    @Test
    public void timeNvsNLogN() {

        int howManyTests = 31;
        int minimumDataSize = 100;
        int maximumDataSize = 100000;
        int changeInDataSizePerTest = (maximumDataSize-minimumDataSize)/(howManyTests-1);

        int dataSize = minimumDataSize;

        for (int i = 0; i < howManyTests; i++) {

            Integer[] testArrayForNLogN = new Integer[dataSize];
            Integer[] testArrayForN = new Integer[dataSize];
            for (int j = 0; j < dataSize; j++) {
                testArrayForNLogN[j] = j;
                testArrayForN[j] = j;
            }

            MaxHeap NLogN = new MaxHeap(dataSize);
            MaxHeap N = new MaxHeap(dataSize);

            long startTimeNLogN = System.nanoTime();
            NLogN.MaxHeapLogN(testArrayForNLogN);
            long endTimeNLogN = System.nanoTime();
            long totalTimeNLogN = endTimeNLogN - startTimeNLogN;

            long startTimeN = System.nanoTime();
            N.MaxHeapN(testArrayForN);
            long endTimeN = System.nanoTime();
            long totalTimeN = endTimeN - startTimeN;

            if (totalTimeN > totalTimeNLogN)System.out.println("NOTICE N is " + (totalTimeN - totalTimeNLogN) + " bigger");
            System.out.println("Test #" + (i+1) + "; Data Size of " + dataSize + "\n" + "NLogN: " + totalTimeNLogN + "\nN: " + totalTimeN + "\n");

            dataSize += changeInDataSizePerTest;

            testArrayForNLogN = null;
            testArrayForN = null;
            NLogN = null;
            N = null;
        }

    }

    public void printHeap(MaxHeap heap) {
        System.out.println();
        int countsTillLine = 1;
        int countsInLine = 0;
        for (int i = 0; i < heap.data.length; i++) {
            System.out.print(heap.data[i] + " ");
            countsInLine++;
            if (countsInLine == countsTillLine) {
                System.out.println();
                countsTillLine *= 2;
                countsInLine = 0;
            }
        }
    }
}