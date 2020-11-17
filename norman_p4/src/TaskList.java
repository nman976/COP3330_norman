package src;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;

public class TaskList {
    List<TaskItem> tasks;

    public TaskList() {
        tasks = new ArrayList<TaskItem>();
    }

    public void printTaskList(String fileName) {
        System.out.println("Current Tasks");
        System.out.println("-------------");
        try (Formatter output = new Formatter(fileName)) {
            for (int i = 0; i < tasks.size(); i++) {
                TaskList tasks = tasks.get(i);
                System.out.println("%s %s; %s", tasks.getDueDate(), tasks.getTitle(), tasks.getDescription());
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Unable to find the file...");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public String getTitle(){
        return this.title;
    }

    public String getDueDate(){
        return this.dueDate;
    }

    public String getDescription(){
        return this.description;
    }
    public void addTaskListItem(String title, String description, String dueDate) {

    }

    public void editTaskListItem(String taskItemNumber, String title, String description, String dueDate) {
    }

    public void removeTaskListItem(String taskItemNumber) {
    }

    public void markTaskListItemComplete(String taskItemNumber) {
    }

    public void unmarkTaskListItemComplete(String taskItemNumber) {
    }

    public void saveTaskList(String listFileName) {
    }
}




