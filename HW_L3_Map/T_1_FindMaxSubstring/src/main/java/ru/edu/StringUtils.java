package ru.edu;

import java.util.HashSet;
import java.util.Set;

public class StringUtils {

    /**
     * Find substring of string with unique symbols.
     * Return maximum length substring with unique symbols.
     * If several results exists return first.
     *
     * @param str - string without delimiters (spaces, new lines, etc)
     */
    public String findMaxSubstring(String str) {
        if (str == null || str.length() == 0)
            return null;
        String resSub = "";
        for (int startIndex = 0; startIndex < str.length(); startIndex++) {
            Set<Character> tmpSub = new HashSet<>();
            int endIndex = startIndex;
            for (; endIndex < str.length(); endIndex++) {
                char currentChar = str.charAt(endIndex);
                if (tmpSub.contains(currentChar)) {
                    break;
                } else {
                    tmpSub.add(currentChar);
                }
            }
            if (resSub.length() < endIndex - startIndex) {
                resSub = str.substring(startIndex, endIndex);
            }
        }
        return resSub.equals("") ? null : resSub;
    }
}