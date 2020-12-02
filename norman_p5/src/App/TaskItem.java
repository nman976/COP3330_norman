package App;

public class TaskItem {
    private String title;
    private String description;
    private String dueDate;
    private Boolean complete = false;
    private static int index =0;
    private int counter = 0;

    // constructor for TaskItem object
    public TaskItem(String title, String description, String dueDate) {
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        index++;
        counter = index;
    }

    public boolean isComplete(){
        return complete;
    }
    //getters
    public int getCounter(){
        return counter;
    }

    public String getTitle(){
        return title;
    }

    public String getDueDate() {
        return dueDate;
    }
    public String getDescription(){
        return description;
    }

    //setters
    public void setComplete(boolean complete){
        this.complete = complete;
    }
    public void setCounter(int counter) {
        this.counter = counter;
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

