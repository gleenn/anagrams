package interview;

public class Interview {
    public static boolean matches(final String needle, final String hayStack) {
        if(needle == null || hayStack == null) throw new IllegalArgumentException("args can't be null");
        return matches(needle, hayStack, 0, 0);
    }

    private static boolean matches(final String needle, final String hayStack, final int needlePos, final int hayStackPos) {
        if(needlePos == needle.length() && hayStackPos == hayStack.length()) return true;

        if(needlePos >= needle.length()) return false;
        if(needle.charAt(needlePos) == '?') return matches(needle, hayStack, needlePos + 1, hayStackPos);
        if(hayStackPos < hayStack.length() && needle.charAt(needlePos) == hayStack.charAt(hayStackPos) &&
                matches(needle, hayStack, needlePos + 1, hayStackPos + 1))
            return true;
        if((needlePos + 1 < needle.length() && needle.charAt(needlePos + 1) == '?' &&
                matches(needle, hayStack, needlePos + 2, hayStackPos)))
            return true;

        return false;
    }
}
