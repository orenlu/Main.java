import javafx.css.StyleOrigin;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

public class Folder extends StorageItem {
    public ArrayList<StorageItem> Items;

    /**
     * constructor
     **/
    public Folder(String name) {
        super(name);
        this.Items = new ArrayList<>();
    }

    /**
     * return the size of all Storage items in the folder
     **/
    public int getSize() {
        int sum = 0;
        for (StorageItem item : Items) {
            sum += item.getSize();
        }
        return sum;
    }

    /**
     * gets an item and adds it to the folder if there is no item with the same name
     * returns if the item was added
     **/
    public boolean addItem(StorageItem item) {
        for (StorageItem item1 : Items) {
            if (item1.getName() == item.getName()) {
                if (item1 instanceof File && item instanceof File) {
                    if (((File) item1).getName() == ((File) item).getName()) {
                        return false;
                    }
                } else {
                    return false;
                }
            }
        }
        return Items.add(item);
    }

    public File findFile(String path) {
        if (path.contains("/")) {    //if the path contains more then one 'level' of files name
            String[] folders = path.split("/", 2);   //splitting the name of the item to find from the rest of the path**/
            Folder nextFold = (Folder) this.findFolderByName(folders[0]); //find the next folder to go to
            if (nextFold != null) {                               // if the folder exists
                return nextFold.findFile(folders[1]);                  //recoursively starts the function again in the new folder with the oter part of the path
            }
        } else { //if the path contain only one 'level' of files
            return findFileByName(path);           // search the file by name and return the file
        }
        return null; // otherwise return null

    }

    /*finding a folder in the current folder by its name*/
    private Folder findFolderByName(String name) {
        for (StorageItem item : this.Items) {     // iterates all the items in the folder
            if (item instanceof Folder) {        // only for the folders in it
                if (name.equals(item.getName())) {    //check if the required folder
                    return (Folder) item;
                }
            }
        }
        return null; // otherwise return null
    }

    /**
     * if the folder contains a file with the required name it will return the file
     * otherwise it'll return null
     **/
    private File findFileByName(String name) {
        if (name.contains(".")) {
            for (StorageItem item : this.Items) {     // iterates all storage items in the folder
                if (item instanceof File) {      // only for the files
                    File itemFile = (File) item;
                    if (name.equals(itemFile.getName())) {   //checks if this is the required file
                        return itemFile;
                    }
                }
            }
        }
        return null; // otherwise return null
    }
static int numFolders;
    @Override
    public void printTree(SortingField field) {
        sortSub(field);
        System.out.println(getName());
        for (int i = 0; i < Items.size(); i++) {
            if (Items.get(i) instanceof Folder) {
                numFolders++;
                for (int j = 0; j < numFolders; j++) {
                    System.out.print("|    ");
                }
                ((Folder)Items.get(i)).printTree(field);
                numFolders--;
            }

            if (Items.get(i) instanceof File) {
                for (int j = 0; j < numFolders + 1; j++) {
                    System.out.print("|    ");
                }
                System.out.println(((File) Items.get(i)).getName());
            }
        }
    }

    public void sortSub(SortingField field) {
        if (field == SortingField.NAME) {
            Items.sort(Comparator.comparing(StorageItem::getName).thenComparing(StorageItem::getName));
        }
        if (field == SortingField.DATE) {
            Items.sort(Comparator.comparing(StorageItem::getCreateDate).thenComparing(StorageItem::getName));
        }
        if (field == SortingField.SIZE) {
            Items.sort(Comparator.comparing(StorageItem::getSize).thenComparing(StorageItem::getName));
        }
    }
}

