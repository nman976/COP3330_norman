package App;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

import static java.nio.file.Files.*;

public class TaskList {
    List<TaskItem> tasks;
    private Object TaskItem;
    private String pattern = "[YYYY-MM-DD]";
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

    public TaskList() {
        tasks = new ArrayList<TaskItem>();
    }

    // These are all List Option Commands
    public void printTaskList() {
        System.out.println("Current Tasks");
        System.out.println("-------------");
        for (TaskItem item : tasks) {
            System.out.println(String.format("%s) %s %s: %s", item.getCounter(), item.getDueDate(), item.getTitle(), item.getDescription()));
        }
        System.out.print("\n\n\n");
    }

    public void addTaskListItem(String title, String description, String dueDate) {
        tasks.add(new TaskItem(title, description, dueDate));
    }

    public void editTaskListItem(int taskItemNumber, String title, String description, String dueDate, Integer valueOf) {
        for (TaskItem item : tasks) {
            if (item.getCounter() == taskItemNumber) {
                item.setTitle(title);
                item.setDueDate(dueDate);
                item.setDescription(description);
            }
        }
    }

    public void removeTaskListItem(int taskItemNumber) {
        Iterator<TaskItem> itty = this.tasks.iterator();
        while (itty.hasNext()) {
            if (itty.next().getCounter() == taskItemNumber) {
                itty.remove();
            }
        }
    }
    public void deleteTempTaskList() {
        tasks.clear();
    }

    public void markTaskListItemComplete(int taskItemNumber) {
        for(TaskItem item: tasks){
            if(item.getCounter() == taskItemNumber){
                item.setComplete(true);
            }
        }
    }

    public void unmarkTaskListItemComplete(int taskItemNumber) {
        for(TaskItem item: tasks){
            if(item.getCounter() == taskItemNumber){
                item.setComplete(false);
            }
        }
    }

    public void saveTaskList(String listFileName) throws IOException {
        StringBuffer sb = new StringBuffer();
        int counter = 0;
        for(TaskItem item: tasks){
            sb.append(String.format("%s) [%s] %s: %s", item.getCounter() ,item.getDueDate(), item.getTitle(), item.getDescription()));
            counter++;
            if (counter<tasks.size())
                sb.append("\r\n");
        }

        write(Paths.get(listFileName),sb.toString().getBytes());
        System.out.println("File Saved");
    }

    public static TaskList stringToTaskList(String path) throws IOException{
        TaskList listFile = new TaskList();

        if(new File(path).exists()){
            byte[] b = readAllBytes(Paths.get(path));
            String d = new String (b, Charset.defaultCharset());

            StringTokenizer stringTokenizer = new StringTokenizer(d, "\r\n");
            while(stringTokenizer.hasMoreTokens()){
                String line = stringTokenizer.nextToken();
                Integer counter = Integer.valueOf(line.substring(0, line.indexOf(")")));
                String dateStr = line.substring(line.indexOf("[")+1, line.indexOf("]"));
                String title = line.substring(line.indexOf("]")+2, line.indexOf(":"));
                String description = line.substring(line.indexOf(":")+2);
                TaskItem taskItem = new TaskItem(title, description, dateStr);
                taskItem.setCounter(counter);
                listFile.tasks.add(taskItem);
            }
        }
        return listFile;
    }
}
