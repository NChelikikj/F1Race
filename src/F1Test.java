// javadoc -d doc src\*   (site files vo src)
/** Tests the {@link F1Race} class
 *
 * @author Nikola
 * @version 1.0
 * @see F1Race
 */
public class F1Test {
    /**
     * main()
     * @param args main args*/
    public static void main(String[] args) {
        F1Race f1Race = new F1Race();
        f1Race.readResults(System.in);
        f1Race.printSorted(System.out);
    }

}
