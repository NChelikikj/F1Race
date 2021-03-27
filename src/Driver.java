/***
 * Driver object
 */
class Driver implements Comparable<Driver>{
    String nameDriver;
    String bestLap;
    /**
     * Constructor for Driver
     * @param name driver name
     * @param lap driver best lap
     */
    public Driver(String name , String lap){
        this.nameDriver=name;
        this.bestLap=lap;
    }
    /**
     * Compares the drivers by theirs bestLap
     */
    @Override
    public int compareTo(Driver o){
        return bestLap.compareTo(o.bestLap);
    }
    @Override
    public String toString(){
        return String.format("%-10s%10s", nameDriver, bestLap);
    }
}