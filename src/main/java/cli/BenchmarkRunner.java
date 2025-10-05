package cli;

import algorithms.BoyerMoore;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.*;

public class BenchmarkRunner {

    public static void main(String[] args) {
        int[] sizes = {100, 1000, 10000, 100000};
         // scalability test input sizes
        String[] types = {"Random", "Sorted", "Reverse", "NearlySorted"};

        // Output folder: docs/performance-data
        Path outDir = Paths.get("docs", "performance-data");
        try {
            Files.createDirectories(outDir); // makes folder if not exists
            Path csv = outDir.resolve("boyer_benchmark.csv");

            try (BufferedWriter writer = Files.newBufferedWriter(
                    csv,
                    StandardOpenOption.CREATE,
                    StandardOpenOption.TRUNCATE_EXISTING
            )) {
                // CSV Header
                writer.write("Algorithm,Size,InputType,Time(ms)\n");

                // Run tests
                for (int n : sizes) {
                    for (String type : types) {
                        int[] arr = generateArray(type, n);

                        long start = System.nanoTime();
                        BoyerMoore.findMajority(arr);
                        long end = System.nanoTime();

                        double timeMs = (end - start) / 1_000_000.0;

                        writer.write("BoyerMoore," + n + "," + type + "," + timeMs + "\n");
                        System.out.println("✅ Done: size=" + n + " type=" + type);
                    }
                }
                System.out.println("CSV written to: " + csv.toAbsolutePath());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Helper to generate arrays of different types
    private static int[] generateArray(String type, int size) {
        int[] arr = new int[size];
        switch (type) {
            case "Sorted":
                for (int i = 0; i < size; i++) arr[i] = i;
                break;
            case "Reverse":
                for (int i = 0; i < size; i++) arr[i] = size - i;
                break;
            case "NearlySorted":
                for (int i = 0; i < size; i++) arr[i] = i;
                if (size > 1) { // swap two random elements
                    int temp = arr[0];
                    arr[0] = arr[size - 1];
                    arr[size - 1] = temp;
                }
                break;
            default: // Random
                for (int i = 0; i < size; i++) arr[i] = (int) (Math.random() * size);
        }
        return arr;
    }
}
