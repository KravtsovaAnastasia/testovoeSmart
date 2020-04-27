import org.junit.Test;

public class AddNewLineTest extends TableBaseTest {

    @Test
    public void addNewLine() {

        String pageURL = "http://point3.smart-consulting.ru/#/vis/76516e39-05e9-b3b6-e062-8e389fef560d/5fdf55f2-2a67-a117-f5e5-04e7eb108e0e/";
        goToTaskPage(pageURL);
        String s1 = "super";
        String n = "154";
        addNewLine(s1, n);
        openReviewMode();
        assert getTextFromElement("element_003a85d6-5d6d-4c37-2238-ffa119363a00").equals(s1);
        assert getTextFromElement("element_cb2573c6-7f33-dc15-a9c2-bf7c43e702c7").equals(n);
        closeReviewMode();
    }

}
