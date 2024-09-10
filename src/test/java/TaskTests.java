import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.Epic;
import ru.netology.Meeting;
import ru.netology.SimpleTask;

public class TaskTests {

    @Test
    public void shouldMatchSimpleTask() {
        SimpleTask task = new SimpleTask(1, "Позвонить маме");

        Assertions.assertTrue(task.matches("маме"));
        Assertions.assertFalse(task.matches("сходить в магазин"));
    }

    @Test
    public void shouldMatchEpicTask() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(2, subtasks);

        Assertions.assertTrue(epic.matches("Яйца"));
        Assertions.assertFalse(epic.matches("Кофе"));
    }

    @Test
    public void shouldMatchMeetingTask() {
        Meeting meeting = new Meeting(3, "Обсуждение проекта", "Нетология", "Понедельник утром");

        Assertions.assertTrue(meeting.matches("Нетология"));
        Assertions.assertFalse(meeting.matches("Тинькофф"));
    }
}
