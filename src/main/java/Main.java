import helper.PaginationHelper;

import java.util.Arrays;
import java.util.List;

import static brackets.BracketsStaticUtils.bracketEncoding;
import static brackets.BracketsStaticUtils.bracketSequenceValidator;

public class Main {
    public static void main(String[] args) {
        /**
         * Пример использования класса PaginationHelper
         */
        List<Integer> data = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Integer itemPerPage = 3;

        PaginationHelper<Integer> helper = new PaginationHelper<>(data, itemPerPage);
        System.out.println("-----------Pagination Class-----------");
        System.out.println("Data: " + Arrays.toString(new List[]{data}));
        System.out.println("Number of Pages: " + itemPerPage);
        System.out.println();
        System.out.println("Results: ");
        // Использование методов класса для получения информации о пагинации
        System.out.println("--Total elements in the array: " + helper.itemCount());
        System.out.println("--Total pages: " + helper.pageCount());
        System.out.println("--Elements on page 4: " + helper.pageItemCount(3));
        System.out.println("--Page index where the element 5 is located: " + helper.pageIndex(6));
        System.out.println("______________________________________________________");
        System.out.println();

        /**
         * Пример использования кодировки скобками
         */
        System.out.println("-----------Bracket Encoding-----------");
        String[] stringArray = {"din", "Success", "pip", "((@"};
        System.out.println("before processing | after processing");
        for (String s : stringArray) {
            System.out.printf("%17s | %-12s\n", s, bracketEncoding(s));
        }
        System.out.println("______________________________________________________");
        System.out.println();

        /**
         * Пример использования кодировки скобками
         */
        System.out.println("-----------Bracket Sequence Validator Operation-----------");
        String[] secondStringArray = {"([{}])", "(){}[]", "(}", "[(])", "[({})](]"};
        System.out.println("Sequence | Is it valid?");
        for (String s : secondStringArray) {
            System.out.printf("%8s | %-12s\n", s, bracketSequenceValidator(s));
        }
    }
}
