import java.util.*;
public enum SortingField{
    NAME {
        /**Function will receive arraylist of files and sort it according to lexicographical order*/
        public void sortName(ArrayList<File> folder) {

            ArrayList<File> folderSortName = new ArrayList<File>();
            folderSortName.addAll(folder);
            //Sort
            Collections.sort(folderSortName, Comparator.comparing(File::getName));
        }
    },
    SIZE {
        /**Function will receive arraylist of files and sort it according to the size of each file*/
        public void sortSize(ArrayList<File> folder) {

            ArrayList<File> folderSortSize = new ArrayList<File>();
            folderSortSize.addAll(folder);
            //Sort
            Collections.sort(folderSortSize, Comparator.comparing(File::getSize));
            for(int i=0;i<folderSortSize.size()-1;i++) {
                /**If the size of two files is identical,then sorting will be based on lexicographical order of names*/
                if (folderSortSize.get(i).getSize() == folderSortSize.get(i + 1).getSize()) {
                    if(compare_name(folderSortSize.get(i),folderSortSize.get(i+1))>0)
                        Collections.swap(folderSortSize,i,i+1);
                }
            }
        }
    },

    DATE{
        /**Function will receive arraylist of files and sort it according to the date each file was created*/
        public void sortDate(ArrayList<File> folder) {

            ArrayList<File> folderSortDate = new ArrayList<File>();
            folderSortDate.addAll(folder);
            //Sort
            Collections.sort(folderSortDate, Comparator.comparing(File::getDate));
            for(int i=0;i<folderSortDate.size()-1;i++) {
                /**If the date of two files is identical,then sorting will be based on lexicographical order of names*/
                if (folderSortDate.get(i).getSize() == folderSortDate.get(i + 1).getSize()) {
                    if(compare_name(folderSortDate.get(i),folderSortDate.get(i+1))>0)
                        Collections.swap(folderSortDate,i,i+1);
                }
            }
        }
    };
    /**Method will return positive value if second file's name is lexicographically before first file's name,
    negative value if second file's name is lexicographically after first file's name, and 0 otherwise*/
     public int compare_name(File file1, File file2){
       return (file1.getName().compareTo(file2.getName()));
    }

}