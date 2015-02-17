package interview;

import java.util.LinkedList;

import static java.util.Arrays.asList;

public class Interview {
    public static boolean matches(String needle, String hayStack) {
        String[] parts = needle.split("\\?");
        boolean endsWithQ = hayStack.endsWith("?");
        if(parts.length == 0) return hayStack.equals("");
        return matches(new LinkedList<>(asList(parts)), hayStack, endsWithQ);
    }

    private static boolean matches(final LinkedList<String> needlParts, final String hayStack, final boolean endsWithQ) {
        if(needlParts.size() == 0) return false;
        String needlePart = needlParts.pop();
        int length = needlePart.length();

        if(hayStack.startsWith(needlePart)) {
            return needlParts.isEmpty() || matches(needlParts, hayStack.substring(0, length), endsWithQ);
        }

        String skipLast = needlePart.substring(0, Math.max(length - 2, 0));
        if(hayStack.startsWith(skipLast)) {
            return (needlParts.isEmpty() && endsWithQ) || matches(needlParts, skipLast, endsWithQ);
        }

        return false;
    }
}
