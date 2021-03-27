import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;
/**
 *  F1Race
 * <p>
 *     We are given data about F1 race drivers
 *     in format: Driver_name, time_of_lap1, time_of_lap2, time_of_lap3.
 * </p>
 * <p>
 * <b>Note:</b> The time is in format: mm:ss:nnn (minutes,seconds,milliseconds)
 *
 *  <h2>Task</h2>
 *  <p>
 *      Our task is to print all the drivers sorted by theirs best lap
 *      in format: Driver_name, time_of_best_lap.
 *  </p>
 *
 *   Uses the {@link Driver} object
 */
class F1Race {
    // vashiot kod ovde
    List<Driver> drivers;
    /**
     * Constructor for F1Race
     */
    public F1Race() {
        this.drivers = new ArrayList<>();
    }
    /**
     * Reads input
     * <p>
     * Input example:<br>
     * Massa 1:57:563 1:55:187 1:55:634<br>
     * Vettel 1:55:523 1:54:987 1:56:134<br>
     * Alonso 1:53:563 1:56:187 1:54:139<br>
     * Hamilton 1:56:174 1:54:371 1:56:199<br>
     * STOP
     * </p>
     * <b>Note:</b> It expects correct input for the program to work
     */
    void readResults(InputStream inputStream) {
        Scanner scanner = new Scanner(inputStream);
        String line = scanner.nextLine();

//      so scanner.hasNextLine() ne chitashe koga snemuva linija poradi nekoja prichina..
        while (!line.equals("STOP")) {
            String[] parts = line.split("\\s+");
            List<String> laps = new ArrayList<>(Arrays.asList(parts).subList(1, parts.length));

//          frlashe exception vo main deka array[0] nemashe element, pa morav da dodadam rachno
            laps.add(0,"9:99:999");

            laps.sort(String::compareTo);
            drivers.add(new Driver(parts[0], laps.get(0)));
            line = scanner.nextLine();
        }
        scanner.close();
    }
    /**
     * Prints
     * <p>
     *     Sorts the drivers by their best lap and prints the drivers.
     * </p>*/
    void printSorted(OutputStream outputStream) {
        PrintWriter printWriter = new PrintWriter(outputStream);
        drivers.sort(Driver::compareTo);
//        for(int i=0;i<drivers.size();i++)
//            printWriter.println(String.format("%d. %s",i+1,drivers.get(i)));
        IntStream.range(0, drivers.size()).forEach(i -> printWriter.println(String.format("%d. %s",i+1,drivers.get(i))));
        printWriter.close();
    }
}

