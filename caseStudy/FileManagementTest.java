
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;


public class FileManagementTest {
    
    @Test
   //AddTesting for Directory
    public void FileAdd(){
    String str = "A";
    File f = new File(str);
    String dirName = "dir1";
    Directory d = new Directory(dirName);
    d.add(f);
    assertTrue(d.dir.contains(f));
   }

   @Test
  //RemoveTesting for Directory
    public  void FileRemove(){
    String str = "A";
    File f = new File(str);
    String dirName = "dir1";
    Directory d = new Directory(dirName);
    d.add(f);
    d.remove(f);
    assertFalse(d.dir.contains(f));
   }

    

}
