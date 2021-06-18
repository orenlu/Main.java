import java.util.ArrayList;
import java.util.Date;

public class Folder extends StorageItem{
    private ArrayList<StorageItem> Items;

    /**constructor**/
    public Folder(String name){
        super(name);
        this.Items=new ArrayList<>();
    }
    /**return the size of all Storage items in the folder**/
    public int getSize(){
        int sum=0;
        for (StorageItem item:Items){
            sum+=item.getSize();
        }
        return sum;
    }
    /** gets an item and adds it to the folder if there is no item with the same name
     * returns if the item was added **/
    public boolean addItem(StorageItem item) {
        for (StorageItem item1 : Items) {
            if (item1.get_Name() == item.get_Name()) {
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
    public File findFile(String path){
        String[] folders = path.split("/",2);   //splitting the name of the item to find from the rest of the path**/
        int len= (folders[1].split("/")).length;    //gets how many folders 'in' do we have to go
        if(len==1){                                      //if we've got to the last one
           return findFileByName(folders[1]);           // search the file by name and return the file
        }
        // otherwise
        Folder nextFold = (Folder) this.findFolderByName(folders[0]); //find the next folder to go to
        if(nextFold != null){                               // if the folder exists
            nextFold.findFile(folders[1]);                  //recoursivley starts the function again in the new folder with the oter part of the path
        }
        return null; // otherwise return null

    }
    /**finding a folder in the current folder by its name**/
    private Folder findFolderByName(String name){
        for (StorageItem item:this.Items) {     // iterates all the items in the folder
            if(item instanceof Folder) {        // only for the folders in it
                if(item.get_Name() == name){    //check if the required folder
                    return (Folder) item;
                }
            }
        }
        return null; // otherwise return null
    }
    /** if the folder contains a file with the required name it will return the file
     * otherwise it'll return null**/
    private File findFileByName(String name){
        String[] splited = name.split("."); //splits the name into name and suffix
        String fileName=splited[0];
        String fileSuf=splited[1];
        File file=new File(fileName,fileSuf);   //creates a file with the required name and suffix
        File itemFile;
        for (StorageItem item:this.Items) {     // iterates all storage items in the folder
            if(item instanceof File) {      // only for the files
                itemFile=(File)item;
                if(itemFile.getName() == file.getName()){   //checks if this is the required file
                    return itemFile;
                }
            }
        }
        return null; // otherwise return null
    }

}