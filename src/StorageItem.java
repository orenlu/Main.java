
import java.io.File;
import java.sql.Timestamp;
import java.util.*;


public class StorageItem{
    private String name;
    private final Date createDate;
    private int Size;

    public StorageItem(String name) {
        this.name = name;
        this.Size=Size;
        this.createDate = randomDate();
    }

    public String get_Name() {
        return name;
    }
    public Date getCreateDate(){
        return this.createDate;
    }
    public  int getSize() {
        return Size;
    }
    public Date randomDate() {
        long rndDate = Main.rnd.nextLong();
        int startYear = 2017;                                    //Starting year of specified random date
        int endYear = 2022;                                    //Starting year of specified random date (including)
        long start = Timestamp.valueOf(startYear + 1 + "-1-1 0:0:0").getTime();
        long end = Timestamp.valueOf(endYear + "-1-1 0:0:0").getTime();
        long ms = (long)(start+(rndDate)%(end-start));    //The qualified number of 13-bit milliseconds is obtained.
        Date createDate = new Date(ms);
        return createDate;
    }
/**Only problem with function is inheriting the 'Folder' used to call function and giving its values to "items" created here*/
    public void printTree(SortingField field) {
        ArrayList<Folder> items = new ArrayList<>();
            sortSub(field,items);
            /** level variable used to indicate how many "|   " sequences must be printed each time*/
            int level = 1;
            for(int i=0;i<items.size();i++) {
                System.out.println(items.get(i).get_Name());
                /** if current file is a folder*/
                if (!(isFile(items.get(i)))) {
                    level++;
                    /** If current folder is the last one,print all its files*/
                    if (lastFolder(items, i,field)) {
                        printLast(items.get(i), field);
                        level--;
                    }
                }
                for (int k = 1; k < level; k++) {
                    System.out.print("|    ");
                }
            }

        }
        /**Function will print all the files of the last folder*/
        public void printLast(Folder folder,SortingField field){
    for(int i=0;i< folder.getSize();i++) {
        System.out.print("|    ");
        System.out.println(folder.Items.get(i));
    }
        }
        /** Function will check if folder is that last in the hierarchy, if it is then its files wil be sorted,return accordingly*/
        public boolean lastFolder(ArrayList<Folder> items,int index,SortingField field){
        for(int i=index+1;i<items.size();i++) {
            if (!(isFile(items.get(i))))
                return false;
        }
            sortSub(field,items);
        return true;
    }
    /** Function will sort according to field recieved*/
    public void sortSub(SortingField field,ArrayList<Folder> items){
        if(field==SortingField.NAME)
            Collections.sort(items, Comparator.comparing(Folder::get_Name));
        if(field==SortingField.SIZE)
            Collections.sort(items, Comparator.comparing(Folder::getSize));
        if(field==SortingField.DATE)
            Collections.sort(items, Comparator.comparing(Folder::getCreateDate));

    }
    /** Function checks if the given item contains '.' in its name and return boolean value accordingly*/
    public boolean isFile(StorageItem item)
    {
        if(item.get_Name().indexOf('.')!=-1)
            return true;
        return false;
    }
}
