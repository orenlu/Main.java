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
    @Override
    public String getName() {
        return name + "." + suffix;
    }
    /** return the size of the file**/
    public int getSize(){
        return this.content.length();
    }
    public String getDate(){return this.getCreateDate();}
    /**adding required content to the existing content of the file**/
    public void addContent(String contentToAdd){
        this.content= this.content + contentToAdd;
    }
    public void printContent(){
        System.out.print(this.getName() + " Size: " + this.getSize() + "MB " + "Created: " + this.getCreateDate() +"\n");
        System.out.println(this.content);
    }

}
