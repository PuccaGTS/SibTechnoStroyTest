package helper;

import java.util.List;

public record PaginationHelper<T>(List<T> data, int itemsPerPage) {

    public int itemCount() {
        return data.size();
    }

    public int pageCount() {
        return (int) Math.ceil((double) data.size() / itemsPerPage);
    }

    public int pageItemCount(int pageIndex) {
        if (pageIndex < 0 || pageIndex >= pageCount()) {
            return -1;
        }
        if (pageIndex == pageCount() - 1) {
            return data.size() % itemsPerPage == 0 ? itemsPerPage : data.size() % itemsPerPage;
        }
        return itemsPerPage;
    }

    public int pageIndex(int itemIndex) {
        if (itemIndex < 0 || itemIndex >= data.size()) {
            return -1;
        }
        return itemIndex / itemsPerPage;
    }
}
