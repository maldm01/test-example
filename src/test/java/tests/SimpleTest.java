package tests;

import core.DriverFactory;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.CreateTaskPage;
import pages.TasksPage;
import pages.elements.TaskElement;

/*
* Tests should be independent, but in this case i don't have test data for task editing, so, in first test task is creating, in second - editing
*/

import static org.testng.Assert.*;

public class SimpleTest{

    AndroidDriver driver;
    TasksPage tasksPage;
    CreateTaskPage createTaskPage;
    String taskTitle;

    @BeforeClass
    public void before() throws Exception {
        driver = new DriverFactory().getDriver();
        tasksPage = new TasksPage(driver);
        createTaskPage = new CreateTaskPage(driver);
        taskTitle = "taskTitle";
    }

    @Test(priority = 1, description = "Verify creating simple task without date/time pickers etc")
    public void createTask(){
        tasksPage
                .clickAddNewTask()
                .setTaskTitle(taskTitle)
                .setTaskDateToday()
                .setTaskTimeEvening()
                .clickBtnSave();

        TaskElement taskElement = tasksPage.getTaskByTitle(taskTitle);
        assertNotNull(taskElement, String.format("Task with title '%s' not found", taskTitle));
        assertEquals(taskElement.getDueDate(), "Today 5 PM", "Task date is different");
    }

    @Test(priority = 2, description = "Verify task title editing")
    public void editTask(){
        String taskTitleEdited = "taskTitleEdited";
        tasksPage
                .openTaskByTitle(taskTitle)
                .setTaskTitle(taskTitleEdited)
                .clickBtnSave();

        TaskElement taskElement = tasksPage.getTaskByTitle(taskTitleEdited);
        assertNotNull(taskElement, String.format("Task with edited title '%s' not found", taskTitleEdited));
        assertEquals(taskElement.getDueDate(), "Today 5 PM", "Task date is different after title editing");
    }

    @AfterClass
    public void after(){
        driver.quit();
    }
}
