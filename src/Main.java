import java.util.*;

public class Main {

    //PULL REQUEST TEST 123456

    private static final String ADD = "add";
    private static final String UPDATE = "update";
    private static final String DELETE = "delete";
    private static final String MARK = "mark";
    private static final String LIST ="list";
    private static final String EXIT = "exit";

    public static void main(String[] args){

        Scanner in = new Scanner(System.in);
        Organizer o1 = new Organizer();

        do {
            readCommand(o1, in);
        } while(!readCommand(o1, in).equals(EXIT));
    }

    private static String readCommand(Organizer o1, Scanner in){
        String input = in.nextLine();
        switch(command(input)){
            case ADD:
                o1.addTask(description(input));
                break;
            case UPDATE:
                setUpdate(o1, description(input));
                break;
            case DELETE:
                o1.deleteTask(description(input));
                break;
            case MARK:
                if(o1.markStatus(description(input))){
                    o1.markStatus(description(input));
                }else {
                    System.out.println("invalid input");
                }
                break;
            case LIST:
                switch(description(input)){
                    case LIST:
                        o1.listAllTasks();
                        break;
                    case "done":
                        listDone(o1);
                        break;
                    case "todo":
                        o1.listTodoTasks();
                        break;
                    case "in-progress":
                        o1.listInProgressTasks();
                        break;
                }
            case EXIT:
                break;

            default:
                System.out.println("invalid command");
                break;
        }
        return command(input);
    }

    public static String command(String input){
        int firstSpaceIndex = input.indexOf(" ");
        if(firstSpaceIndex < 0){
            return input;
        } else {
            String firstWord = input.substring(0, firstSpaceIndex);
            return firstWord;
        }
    }

    private static String description(String input){
        int firstSpaceIndex = input.indexOf(" ");
        String description = input.substring(firstSpaceIndex+1);
        return description;
    }

    private static void listDone(Organizer o1){
        Task[] done = o1.listDoneTasks();
        System.out.println("Id  | Status     | Description        | Created     | Update    ");
        for (Task task : done) {
            System.out.println(task.getId() + "   | " + task.getStatus() + "       | " + task.getDescription() + "          ");
        }
    }

    private static void setUpdate(Organizer o1, String id){
        o1.updateTask(id);
    }
}
