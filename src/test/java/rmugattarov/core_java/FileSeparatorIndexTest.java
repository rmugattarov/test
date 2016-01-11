package rmugattarov.core_java;

import org.junit.Test;

import java.io.File;

/**
 * Created by rmugattarov on 05.01.16.
 */
public class FileSeparatorIndexTest {
    @Test
    public void should_find_separator_in_path() {
        System.out.printf("file separator : %s\n", File.separator);
        System.out.printf("file separatorChar : %s\n", File.separatorChar);
        System.out.printf("file pathSeparator : %s\n", File.pathSeparator);
        System.out.printf("file pathSeparatorChar : %s\n", File.pathSeparatorChar);
        System.out.printf("code source location : %s\n", this.getClass().getProtectionDomain().getCodeSource().getLocation());

    }
}
