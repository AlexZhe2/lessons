package lesson27.prototype;

public class Book implements IClone<Book> {
    private int pageCount;
    private String title;

    public Book(int pageCount, String title) {
        this.pageCount = pageCount;
        this.title = title;
    }

    public Book() {
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public Book cloneObj() {

        return ;
    }
}
