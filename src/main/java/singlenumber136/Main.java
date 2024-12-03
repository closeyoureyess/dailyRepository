package singlenumber136;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int result = solution.singleNumber(new int[]{1, 1, 3, 3, 2, 5, 5}); // 1 1 2 2 3 3 5 5
        System.out.println(result);
    }
}

// Учитывая непустой массив целых чисел nums, каждый элемент появляется дважды, за исключением одного.
// Найдите этот единственный элемент.
//
//Необходимо реализовать решение с линейной сложностью во время выполнения и использовать только постоянное
// дополнительное пространство.