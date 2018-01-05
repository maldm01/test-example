package pages;

import core.PageBase;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import pages.elements.TaskElement;

public class CreateTaskPage extends PageBase {

    public CreateTaskPage setTaskTitle(String taskTitle){
        inpTaskTitle().sendKeys(taskTitle);
        return new CreateTaskPage(driver);
    }

    public CreateTaskPage setTaskDateToday(){
        btnDate().click();
        MobileElement todayOption = getListView().findElements(By.xpath("descendant::*[@class='android.widget.RelativeLayout']")).get(0);
        todayOption.click();
        return new CreateTaskPage(driver);
    }

    public CreateTaskPage setTaskTimeEvening(){
        btnTime().click();
        MobileElement eveningOption = getListView().findElements(By.xpath("descendant::*[@class='android.widget.RelativeLayout']")).get(3);
        eveningOption.click();
        return new CreateTaskPage(driver);
    }

    public CreateTaskPage setTaskPriority(TaskElement.TaskPriority priority){
        MobileElement priorityButton = driver.findElement(By.id("org.tasks:id/priority_" + priority.toString() + ""));
        priorityButton.click();
        return new CreateTaskPage(driver);
    }

    public TasksPage clickBtnSave(){
        btnSave().click();
        return new TasksPage(driver);
    }



    private MobileElement inpTaskTitle(){
        return driver.findElementByAndroidUIAutomator("new UiSelector().resourceId(\"org.tasks:id/title\")");
    }

    private MobileElement btnDate(){
        return driver.findElementByAndroidUIAutomator("new UiSelector().resourceId(\"org.tasks:id/due_date\")");
    }

    private MobileElement btnTime(){
        return driver.findElementByAndroidUIAutomator("new UiSelector().resourceId(\"org.tasks:id/due_time\")");
    }

    private MobileElement btnSave(){
        return driver.findElementById("org.tasks:id/toolbar").findElementByXPath("descendant::android.widget.ImageButton");
    }

    public CreateTaskPage(AndroidDriver<MobileElement> driver) {
        super(driver);
    }
}
