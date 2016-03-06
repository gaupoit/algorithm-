using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace algorithm.sorting
{
    public class Sorting 
    {
        public static int[] DoInsertionSort(int[] a)
        {
            //algorithm 
            // sort(A)
            // n = A' length
            //   for pos = 1 to n - 1 do
            //     value = A[pos]
            //     i = pos - 1
            //     while i >= 0 and A[i] > value do
            //         A[i+1] = A[i]
            //         i = i - 1
            //     A[i+1] = value
            for (int pos = 0; pos < a.Length; pos++)
            {
                int val = a[pos];
                int i = pos - 1;
                while (i >= 0)
                {
                    if(a[i] > val)
                    {
                        a[i+1] = a[i];
                    }
                    i--;
                }
                a[i+1] = val;
            }
            return a;
        }
    }
}