package src;

public class TaskItem {
    private String title;
    private String description;
    private String dueDate;
    private Boolean complete = false;
    private static int index =0;
    private int counter = 0;

    public TaskItem(String title, String description, String dueDate) {
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        index++;
        counter = index;
    }
    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete){
        this.complete = complete;
    }
    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public String getTitle(){
        return title;
    }

    public String getDueDate(){
        return dueDate;
    }

    public String getDescription(){
        return description;
    }

    private boolean isTitleValid(String title) {
        return title.length() >0;
    }
    private boolean isdueDateValid(String dueDate) {
        return true;
    }
    public void setTitle(String title){
    this.title = title;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}


class InvalidTitleException extends IllegalArgumentException {
    public InvalidTitleException(String msg){
        super(msg);
    }
}

class InvalidDueDateException extends IllegalArgumentException {
    public InvalidDueDateException(String msg){
        super(msg);
    }
}