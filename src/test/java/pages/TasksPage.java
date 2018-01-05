package pages;

import core.PageBase;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import pages.elements.TaskElement;

public class TasksPage extends PageBase {

    public CreateTaskPage clickAddNewTask(){
        btnAddNewTask().click();
        return new CreateTaskPage(driver);
    }

    public CreateTaskPage openTaskByTitle(String title){
        TaskElement task = getTaskByTitle(title);
        if(task != null){
            task.click();
        }else {
            throw new AssertionError(String.format("Task with title '%s' is missing", title));
        }
        return new CreateTaskPage(driver);
    }

    public TaskElement getTaskByTitle(String title){
        try{
            return new TaskElement(driver.findElementByXPath("//*[@resource-id='org.tasks:id/rowBody' and .//*[@resource-id='org.tasks:id/title' and @text='" + title + "']]"));
        }catch (Exception e){
            return null;
        }

    }

    private MobileElement btnAddNewTask(){
        return driver.findElementByAndroidUIAutomator("new UiSelector().resourceId(\"org.tasks:id/fab\")");
    }
    public TasksPage(AndroidDriver<MobileElement> driver) {
        super(driver);
    }
}
