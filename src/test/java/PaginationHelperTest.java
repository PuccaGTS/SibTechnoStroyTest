import helper.PaginationHelper;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PaginationHelperTest {
    private final List<Integer> data = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    private final int itemsPerPage = 3;
    private final PaginationHelper<Integer> helper = new PaginationHelper<>(data, itemsPerPage);

    @Test
    public void testItemCount() {
        assertEquals(10, helper.itemCount());
    }

    @Test
    public void testPageCount() {
        assertEquals(4, helper.pageCount());
    }

    @Test
    public void testPageItemCount() {
        assertEquals(3, helper.pageItemCount(1));
        assertEquals(1, helper.pageItemCount(3));
        assertEquals(-1, helper.pageItemCount(5));
    }

    @Test
    public void testPageIndex() {
        assertEquals(1, helper.pageIndex(4));
        assertEquals(2, helper.pageIndex(8));
        assertEquals(-1, helper.pageIndex(12));
    }
}
