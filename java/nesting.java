package com.prudencio;

import java.util.Stack;

/*
Nesting
A string S consisting of N characters is called properly nested if:

S is empty;
S has the form "(U)" where U is a properly nested string;
S has the form "VW" where V and W are properly nested strings.
For example, string "(()(())())" is properly nested but string "())" isn't.

Write a function:

class Solution { public int solution(String S); }
that, given a string S consisting of N characters, returns 1 if string S is properly nested and 0 otherwise.

For example, given S = "(()(())())", the function should return 1 and given S = "())", the function should return 0, as explained above.

Assume that:

N is an integer within the range [0..1,000,000];
string S consists only of the characters "(" and/or ")".
Complexity:

expected worst-case time complexity is O(N);
expected worst-case space complexity is O(1) (not counting the storage required for input arguments).
*/
public class Solution {
    public int solution(String S) {
        Stack<Character> brackets = new Stack<>();
        for (int i = 0; i < S.length(); i++) {
            char str = S.charAt(i);
            if (str == '(') {
                brackets.push(str);
            } else if (str == ')') {
                if (brackets.isEmpty()) {
                    return 0;
                }
                Character openBracket = brackets.pop();
                if (str == ')' && openBracket != '(') {
                    return 0;
                }
            }
        }
        return brackets.size() == 0 ? 1 : 0;
    }
}