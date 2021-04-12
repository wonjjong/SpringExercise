import java.util.Stack;

public class TestMain {
    public static String compress(String word) {

        if (word.length() == 1) {
            return word;
        }

        String answer = new String();
        Stack<Character> s = new Stack<>();
        s.push(word.charAt(0));

        for (int i = 1; i < word.length(); i++) {
            if (word.charAt(i) == s.peek()) continue;
            else
                s.push(word.charAt(i));
        }

        while (!s.empty())
            answer += s.pop();

        return  new StringBuffer(answer).reverse().toString();
    }

    public static void main(String[] args) {
        String word = "abbcbbba";
        System.out.println(compress(word));
    }
}
