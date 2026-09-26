class Solution {
    public String decodeString(String s) {
        Stack<String> stC = new Stack<>();
        Stack<Integer> st = new Stack<>();
        StringBuilder res = new StringBuilder();
        String curr = "";
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + Character.getNumericValue(c);
            } else if (c == ']') {
                // my processing
                int multiplier = st.pop();
                String previous = stC.pop();
                
                StringBuilder currAns = new StringBuilder();
                for (int j = 0; j < multiplier; j++) {
                    currAns.append(curr);
                }
                curr = previous + currAns.toString();

            } else if (c == '[') {
                st.add(num);
                stC.add(curr);

                num = 0;
                curr = "";
            } else if (Character.isLetter(c)) {
                 curr += c;
            }
        }
        return curr;
    }
}