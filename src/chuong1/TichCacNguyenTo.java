package chuong1;

public class TichCacNguyenTo {
    public static void main(String[] args) {
        int[] numbers = {2, 3, 5, 7, 11, 13, 17};

        long product = tichNguyenTo(numbers);

        System.out.println("Tích của các số nguyên tố là: " + product);
    }

    public static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static long tichNguyenTo(int[] numbers) {
        long product = 1;
        for (int num : numbers) {
            if (isPrime(num)) {
                product *= num;
            }
        }
        return product;
    }
}
