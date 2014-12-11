package interview;

import java.util.LinkedList;

import static java.util.Arrays.asList;

public class Interview {
    public static boolean matches(String needle, String hayStack) {
        String[] parts = needle.split("\\?");
        boolean endsWithQ = hayStack.endsWith("?");
        return matches(new LinkedList<String>(asList(parts)), hayStack, endsWithQ);
    }

    private static boolean matches(LinkedList<String> parts, String hayStack, boolean endsWithQ) {
        String part = parts.pop();
        int length = part.length();

        if(hayStack.startsWith(part)) {
            return parts.isEmpty() || matches(parts, hayStack.substring(0, length), endsWithQ);
        }

        String skipLast = part.substring(0, Math.max(length - 2, 0));
        if(hayStack.startsWith(skipLast)) {
            return parts.isEmpty() && endsWithQ || matches(parts, skipLast, endsWithQ);
        }

        return false;
    }
}
