package homework2;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class BracketsValidator {

    private static final Predicate<Character> thisCharacterIsNotBracket =
            c -> c != '(' && c != '[' && c != '{' && c != ')' && c != ']' && c != '}';

    private static final Predicate<Character> thisCharacterIsOpenBracket = c -> c == '(' || c == '[' || c == '{';

    private static final BiPredicate<Character, Character> thoseCharactersAreNormalBracketPair =
            (c1,c2) -> c1 == '(' && c2 == ')' || c1 == '[' && c2 == ']' || c1 == '{' && c2 == '}';

    /**
     * Method for check is brackets in text aren't breaks the rules for brackets
     * @param text - the source text that should be validate
     * @return -1 if text is valid. If isn't - position of first invalid bracket
     */
    static int validate(final String text) {

        final Stack<Character> stack = new ArrayStack<>();
        final char[] chars = text.toCharArray();
        int failPlace = 0;
        int pos = 0;
        boolean success = true;
        for (char c : chars) {
            pos++;
            if (thisCharacterIsNotBracket.test(c)) {
                continue;
            }
            if (thisCharacterIsOpenBracket.test(c)) {
                if (stack.isEmpty())
                    failPlace = pos;
                stack.push(c);
                continue;
            }
            if (!stack.isEmpty()){
                char prevChar = stack.pop();
                if (thoseCharactersAreNormalBracketPair.test(prevChar, c)) {
                    continue;
                }
            }
            success = false;
            failPlace = pos;
            break;
        }
        if (chars.length != pos || !stack.isEmpty())
            success = false;
        return success ? -1 : failPlace;
    }

}
