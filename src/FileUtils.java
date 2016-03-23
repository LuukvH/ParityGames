import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by laj on 12-3-2016.
 */
public class FileUtils {
    public static File[] getFiles(String dirName, final String extension) {
        File dir = new File(dirName);

        return dir.listFiles(new FilenameFilter() {
            public boolean accept(File dir, String filename) {
                return filename.endsWith(extension);
            }
        });
    }

    public static File[] OrderBySize(File[]files) {
        Arrays.sort(files, new FileSizeComparator());
        return files;
    }

    public static class FileSizeComparator implements Comparator<File> {
        public int compare( File a, File b ) {

            Long aSize = a.length();
            Long bSize = b.length();
            if ( aSize == bSize ) {
                return 0;
            }
            else {
                return Long.compare(aSize, bSize);
            }
        }
    }

}
