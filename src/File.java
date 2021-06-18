import java.util.Date;

public class File extends StorageItem {

    private String suffix;
    private String content;

    /**constructor**/
    public File(String name,String suffix){
        super(name);
        this.suffix=suffix;
        content="";
    }
    /**return the full name of the file with the suffix**/
    public String getName(){
        StringBuilder fileName=new StringBuilder();
        fileName.append(this.get_Name());
        fileName.append('.');
        fileName.append(this.suffix);
        String fullname= fileName.toString();
        return fullname;
    }
    /** return the size of the file**/
    public int getSize(){
        return this.content.length();
    }
    /**adding required content to the existing content of the file**/
    public void addContent(String contentToAdd){
        this.content= this.content + contentToAdd;
    }
    public void printContent(){
        System.out.println(this.getName() + "Size: " + this.getSize() + "Created: " + this.getCreateDate() +"\n");
        System.out.println(this.content);
    }

}
