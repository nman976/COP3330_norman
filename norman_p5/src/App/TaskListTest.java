package App;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TaskListTest {
    @Test
    public void addingItemsIncreasesSize(){
       // List<TaskItem> tasks = new ArrayList<TaskItem>();

        TaskList tasks = new TaskList();
        tasks.addTaskListItem( "task1", "description 1", "2020-12-25");
        //assertEquals(tasks.size() == 1);
    }
    @Test
    public void editingItemsFailsWithAllBlankValues(){

    }
    @Test
    public void editingItemsFailsWithInvalidIndex(){

    }

    @Test
    public void editingSucceedsWithBlankFirstName(){

    }

    @Test
    public void editingSucceedsWithBlankLastName(){

    }

    @Test
    public void editingSucceedsWithBlankPhone(){

    }
    @Test
    public void editingSucceedsWithNonBlankValues(){

    }
    @Test
    public void removingItemsDecreasesSize(){

    }
    @Test
    public void removingItemsFailsWithInvalidIndex(){

    }
    @Test
    public void savedContactListCanBeLoaded(){

    }
}