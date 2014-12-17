package interview;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Grep {

    public static List<String> grep(String pattern, List<String> lines) {
        List<String> result = new ArrayList<>();
        int numMatches = 0;
        for(int i = -3; i < lines.size() + 3; i++) {
            if(i + 3 < lines.size() && lines.get(i + 3).matches(pattern)) {
                numMatches++;
            }
            if(i >= 0 && i < lines.size() && numMatches > 0) {
                result.add(lines.get(i));
            }
            if(i - 3 >= 0 && lines.get(i - 3).matches(pattern)) {
                numMatches--;
            }
        }
        return result;
    }

    public static List<String> grep_bad(String pattern, List<String> lines) {
        List<String> result = new ArrayList<>();
        LinkedList<String> buffer = new LinkedList<>();
        String line;
        String last;
        int numMatches = 0;
        for(int i = 0; i < 3; i++) {
            line = lines.get(i);
            buffer.addFirst(line);
            if(line.matches(pattern)) numMatches++;
        }
        for(int i = 3; i < lines.size() - 3; i++) {
            if(i >= lines.size()) break;
            line = lines.get(i);
            buffer.addFirst(line);
            if(line.matches(pattern)) numMatches++;
            last = buffer.removeLast();
            if(numMatches > 0) result.add(last);
            if(last.matches(pattern)) numMatches--;
        }
        for(int i = lines.size() - 3; i < lines.size(); i++) {
            last = buffer.removeLast();
            if(numMatches > 0) result.add(last);
            if(last.matches(pattern)) numMatches--;
        }
        return result;
    }

    public static List<String> grep_bad2(String pattern, ArrayList<String> lines) {
        lines.add(0, "");
        lines.add(0, "");
        lines.add(0, "");
        lines.add(lines.size(), "");
        lines.add(lines.size(), "");
        lines.add(lines.size(), "");

        List<String> result = new ArrayList<>();
        int numMatches = 0;

        for(int i = 0; i < lines.size(); i++) {
            if(i + 3 < lines.size() && lines.get(i + 3).matches(pattern)) {
                numMatches++;
            }
            if(numMatches > 0) result.add(lines.get(i));
            if(i - 3 >= 0 && lines.get(i - 3).matches(pattern)) {
                numMatches--;
            }
        }
        return result;
    }
}
