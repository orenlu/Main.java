
import java.io.File;
import java.sql.Timestamp;
import java.util.*;
import java.text.SimpleDateFormat;
import java.util.Comparator;

 public class StorageItem {
     String name;
    private Date createDate;
    private int Size;
     SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

    public StorageItem(String name) {
        this.name = name;
        this.Size = Size;
        this.createDate = randomDate();
    }

    public String getName() {
        return name;
    }

    public String getCreateDate() {
        return this.format.format(this.createDate.getTime());
    }

    public int getSize() {
        return Size;
    }
     public Date randomDate() {
         long rndDate = Main.rnd.nextLong();
         rndDate=Math.abs(rndDate);
         int startYear = 2017;                                    //Starting year of specified random date
         int endYear = 2021;                                    //Starting year of specified random date (including)
         long start = Timestamp.valueOf(startYear + "-1-1 0:0:0").getTime();
         long end = Timestamp.valueOf(endYear + "-12-31 23:59:59").getTime();
         long ms = (long)(start+(Math.abs(rndDate))%(end-start));    //The qualified number of 13-bit milliseconds is obtained.
         Date createDate = new Date(ms);
         return createDate;
     }
      public void printTree(SortingField field) {
    }

}
