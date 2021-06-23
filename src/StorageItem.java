
import java.io.File;
import java.sql.Timestamp;
import java.util.*;
import java.util.Comparator;

public class StorageItem {
    private String name;
    private final Date createDate;
    private int Size;

    public StorageItem(String name) {
        this.name = name;
        this.Size = Size;
        this.createDate = randomDate();
    }

    public String get_Name() {
        return name;
    }

    public Date getCreateDate() {
        return this.createDate;
    }

    public int getSize() {
        return Size;
    }

    public Date randomDate() {
        long rndDate = Main.rnd.nextLong();
        rndDate = Math.abs(rndDate);
        int startYear = 2017;                                    //Starting year of specified random date
        int endYear = 2022;                                    //Starting year of specified random date (including)
        long start = Timestamp.valueOf(startYear + 1 + "-1-1 0:0:0").getTime();
        long end = Timestamp.valueOf(endYear + "-1-1 0:0:0").getTime();
        long ms = (long) (start + (rndDate) % (end - start));    //The qualified number of 13-bit milliseconds is obtained.
        Date createDate = new Date(ms);
        return createDate;
    }
    public void printTree(SortingField field) {
    }

}
