/*Вывести все простые числа от 1 до 1000 */
public class task2 {

    public static void main(String[] args) {
        int num = 1000;
        boolean b = true;
        for (int i = 2; i <= num; i++) {
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    b = false;
                    break;
                }
            }
            if (b) System.out.print(i + "  ");
            else b = true;
        }
    }
}
