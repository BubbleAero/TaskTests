import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.*;

public class TodosTest {

    @Test
    public void shouldAddThreeTasksOfDifferentType() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchTasks() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] result = todos.search("Выкатка");
        Task[] expected = {meeting};
        Assertions.assertArrayEquals(expected, result);
    }

    @Test
    public void shouldFindManyTasks() {
        SimpleTask simpleTask1 = new SimpleTask(1, "Купить молоко");
        SimpleTask simpleTask2 = new SimpleTask(2, "Купить хлеб");
        SimpleTask simpleTask3 = new SimpleTask(3, "Купить яйца");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(3, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask1);
        todos.add(simpleTask2);
        todos.add(simpleTask3);
        todos.add(epic);
        todos.add(meeting);

        Task[] result = todos.search("Купить");
        Task[] expected = {simpleTask1, simpleTask2, simpleTask3};

        Assertions.assertArrayEquals(expected, result);
    }

    @Test
    public void shouldFindOneTask() {
        SimpleTask simpleTask = new SimpleTask(1, "Позвонить родителям");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(3, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] result = todos.search("Позвонить");
        Task[] expected = {simpleTask};

        Assertions.assertArrayEquals(expected, result);
    }

    @Test
    public void shouldFindNoTasks() {
        SimpleTask simpleTask = new SimpleTask(1, "Позвонить родителям");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(3, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] result = todos.search("Мужу");
        Task[] expected = {};

        Assertions.assertArrayEquals(expected, result);
    }
}
