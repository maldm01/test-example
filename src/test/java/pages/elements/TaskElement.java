package pages.elements;

import io.appium.java_client.MobileElement;

/**
 * represents existing task item on Tasks Page
 */
public class TaskElement extends MobileElement {
    private MobileElement taskElement;

    public TaskPriority getPriority(){
        //there is no explicit way to get task priority, so we need to take task 'checkbox' color and define task priority
        //but after investigation i find that Google UiAutomator framework currently doesn't support getting element color
        String taskColor = taskElement.findElementByXPath("descendant::*[@resource-id='org.tasks:id/completeBox']").getCssValue("color");
        switch (taskColor){
            case "someValue1":
                return TaskPriority.NONE;
            case "someValue2":
                return TaskPriority.LOW;
            case "someValue3":
                return TaskPriority.MEDIUM;
            case "someValue4":
                return TaskPriority.HIGH;
            default:
                throw new AssertionError("Can not determine task priority based on color, current color is: " + taskColor);
        }
    }

    public String getDueDate(){
        return taskElement.findElementByXPath("descendant::*[@resource-id='org.tasks:id/due_date']").getAttribute("text");
    }

    @Override
    public void click(){
        taskElement.click();
    }

    public enum TaskPriority{
        NONE("none"), LOW("low"), MEDIUM("medium"), HIGH("high");
        private String priority;
        private TaskPriority(String priority){
            this.priority = priority;
        }
        @Override
        public String toString(){
            return priority;
        }
    }

    public TaskElement(MobileElement mobileElement){
        this.taskElement = mobileElement;
    }
}
