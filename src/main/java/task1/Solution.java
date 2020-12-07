package task1;

public class Solution {
        public static String moveDomino(int k, String str) {
            char[] dominoes = str.toCharArray();
            char[] copy = new char[dominoes.length];
            System.arraycopy(dominoes, 0, copy, 0, dominoes.length);
            for(int j = 0; j < k; j++) {
                for (int i = 0; i < dominoes.length; i++) {
                    if (dominoes[i] == '|') {
                        if (checkIfShouldFallRight(dominoes, i) && checkIfShouldFallLeft(dominoes, i)) {
                            copy[i] = '|';
                        } else if (checkIfShouldFallRight(dominoes, i)){
                            copy[i] = '\\';
                        } else if (checkIfShouldFallLeft(dominoes, i)){
                            copy[i] = '/';
                        }
                    }
                }
                System.arraycopy(copy, 0, dominoes, 0, dominoes.length);
                System.arraycopy(dominoes, 0, copy, 0, dominoes.length);
                System.out.println(new String(dominoes));
            }
            return new String(dominoes);
        }

        private static boolean checkIfShouldFallRight(char[] dominoes, int index) {
            return index != dominoes.length - 1 && dominoes[index+1] == '\\';
        }

        private static boolean checkIfShouldFallLeft(char[]dominoes, int index) {
            return index!= 0 && dominoes[index-1] == '/';
        }

        public static String reverse(int k, String str) {
            char[] dominoes = str.toCharArray();
            char[] copy = new char[dominoes.length];
            System.arraycopy(dominoes, 0, copy, 0, dominoes.length);

            for (int j = 0; j < k; j++) {
                for(int i = 0; i < dominoes.length; i++) {
                    if (dominoes[i] == '/') {
                        if (shouldSetUpLeft(dominoes, i)) {
                            copy[i] = '|';
                        }
                    } else if (dominoes[i] == '\\') {
                        if (shouldSetUpRight(dominoes, i)) {
                            copy[i] = '|';
                        }
                    }
                }
                System.arraycopy(copy, 0, dominoes, 0, dominoes.length);
                System.arraycopy(dominoes, 0, copy, 0, dominoes.length);
                System.out.println(new String(dominoes));
            }
            return new String(dominoes);
        }

        private static boolean shouldSetUpRight(char[] dominoes, int i) {
            return i == 0 || dominoes[i-1] == '|' || dominoes[i-1] == '/';
        }

        private static boolean shouldSetUpLeft(char[] dominoes, int i) {
            return i == dominoes.length - 1 || dominoes[i+1] == '|' || dominoes[i+1] == '\\';
        }
}
