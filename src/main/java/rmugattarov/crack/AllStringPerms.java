package rmugattarov.crack;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class AllStringPerms {
    private static final Random R = ThreadLocalRandom.current();

    public static void main(String[] args) {
        for (int i = 0; i < 1; i++) {
//            String randomString = RandomStringUtils.random(R.nextInt(10), "abcdefghijklmnopqrstuvwxyz");
//            String randomString = "123";
//            System.out.println("Input string:");
//            System.out.println(randomString);
//            System.out.println("Permutations:");

        }

        char[][] mergeResult = mergePerms('c', new char[][]{{'a', 'b'}, {'1', '2'}});
        for (char[] chars : mergeResult) {
            System.out.println(chars);
        }
    }


    private static char[][] mergePerms(char c, char[][] perms) {
        int resultLength = perms.length;
        for (char[] perm : perms) {
            resultLength += perm.length;
        }
        char[][] result = new char[resultLength][];

        int resultIndex = 0;
        for (char[] perm : perms) {
            char[][] newPerms = mergePerm(c, perm);
            for (char[] newPerm : newPerms) {
                result[resultIndex++] = newPerm;
            }
        }

        return result;
    }


    private static char[][] mergePerm(char c, char[] chars) {
        char[][] result = new char[chars.length + 1][];
        char[] newPerm = new char[chars.length + 1];
        newPerm[0] = c;
        System.arraycopy(chars, 0, newPerm, 1, chars.length);
        result[0] = newPerm;
        int resultIndex = 1;
        for (int j = 0; j < newPerm.length - 1; j++) {
            newPerm = Arrays.copyOf(newPerm, newPerm.length);
            char temp = newPerm[j];
            newPerm[j] = newPerm[j + 1];
            newPerm[j + 1] = temp;
            result[resultIndex++] = newPerm;
        }
        return result;
    }
}
