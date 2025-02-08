import java.time.LocalDateTime;

import static java.time.LocalDateTime.now;

public class Task {

    public int id;
    public String description;
    public String status;
    public LocalDateTime createdAt;
    public LocalDateTime updatedAt;
    private static final String TODO = "todo";
    private static final String DONE ="done";
    private static final String INPROGRESS = "in-progress";

    public Task(int id, String description){
        this.id = id;
        this.description = description;
        createdAt = now();
        status = "todo";
    }

    public Task(){

    }

    public String getDescription(){
        return description;
    }

    public int getId(){
        return id;
    }

    public String getStatus(){
        return status;
    }

    public boolean setStatus(String status){
        switch(status) {
            case TODO:
                this.status = status;
                return true;
            case INPROGRESS:
                this.status = status;
                return true;
            case DONE:
                this.status = status;
                return true;
            default:
                return false;
        }
    }

    public void updatedAt(){
        updatedAt = now();
    }

    public void updateDescription(String input){
        description = input;
    }

}
