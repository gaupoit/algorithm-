using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using algorithm.sorting;

namespace algorithm
{
    public class Program
    {
        public static void Main(string[] args)
        {
            Console.WriteLine("Algorithm");
            Console.WriteLine("1. Sorting - Samples (5, 4, 3, 2 ,1)");
            Console.WriteLine("a. Insertion");
            int[] samples = { 5, 4, 3, 2 ,1 };
            int[] insertionResult = Sorting.DoInsertionSort(samples);
            for (int i = 0; i < samples.Length; i++)
            {
                Console.Write(samples[i] + " ");
            }
            Console.WriteLine();
        }
    }
}
