package Math2;

public class NthTile {

    public static String getColumnName(int num) {
        StringBuilder ans = new StringBuilder();
        while (num > 0) {
            num--;
            char ch = (char) ((num % 26) + 'A');
            ans.append(ch);
            num /= 26;
        }
        return ans.reverse().toString();
    }

    public static int getColumnNumber(String A) {
        int ans = 0;
        int pow = 1;
        int n = A.length();
        for (int i = n - 1; i >= 0; i--) {
            ans += pow * (A.charAt(i) - 'A' + 1);
            pow *= 26;
        }
        return ans;
    }

    public static void main(String[] args) {
        String str = getColumnName(50);
        System.out.println(str);
        System.out.println(getColumnNumber(str));
    }
}
