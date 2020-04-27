import org.junit.Test;

public class AddNewLineTest extends TableBaseTest {

    @Test
    public void addNewLine() {
        getTableUrl();
        goToPage(tableUrl);
        String s1 = "super";
        String n = "154";
        addNewLine(s1, n);
        openReviewMode();
        assert getTextFromElement("element_003a85d6-5d6d-4c37-2238-ffa119363a00").equals(s1);
        assert getTextFromElement("element_cb2573c6-7f33-dc15-a9c2-bf7c43e702c7").equals(n);
        closeReviewMode();
    }

}
