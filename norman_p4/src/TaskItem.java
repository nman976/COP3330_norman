package src;

public class TaskItem {
    private String title;
    private String description;
    private String dueDate;

    public TaskItem(String TaskItemNumber, String title, String description, String dueDate){
        if(isTitleValid(title)){
            this.title = title;
        } else {
            throw new InvalidTitleException("Title is not valid. Must be 1+ characters long");
        }

        if(isdueDateValid(dueDate)){
            this.dueDate = dueDate;
        } else {
            throw new InvalidDueDateException("due Date not valid. must be in MM-DD-YYYY format");
        }
    }

    //public String toString(){
        //return "["+ dueDate + "]" + " " + title + ": "+ description;
    //}
    private boolean isTitleValid(String title) {
        return title.length() >0;
    }
    private boolean isdueDateValid(String dueDate) {
        return true;
    }
    public void setTitle(String title){

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