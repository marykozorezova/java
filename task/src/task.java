public class task {
    public static void main(String[] args) {
        String str = "А роза упала на лапу Азора";
        System.out.println(polindrom(str));
    }

    public static boolean polindrom(String str){
        str = str.toLowerCase().replace(" ", "");
        boolean pol = true;
        for (int i = 0; i < str.length() / 2; i++) {
            if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
                pol=false;
            }
        }
        return pol;
    }

}