public class Organizer {

    public static int id = 0;
    public static Task[] array = new Task[100];

    public Organizer(){
    }

    public void addTask(String description){
        array[id] = new Task(id+1, description);
        id++;
    }

    public boolean markStatus(String input){
        int firstSpaceIndex = input.indexOf(" ");
        int id = Integer.valueOf(input.substring(firstSpaceIndex+1));
        String firstWord = input.substring(0, firstSpaceIndex);
        return getTaskById(id).setStatus(firstWord);
    }

    public Task getTaskById(int id) {
        Task Task1 = null;
        for (int i = 0; i < id; i++) {
            if (array[i].getId() == id) {
                Task1 = array[i];
            }
        }
        return Task1;
    }

    public void listAllTasks(){
        for(int i = 0; i < array.length; i++){
            if(array[i] != null){
                System.out.println(array[i].getDescription());
            }else{
                break;
            }
        }
    }

    public void listTodoTasks() {
        for (int i = 0; i < array.length; i++) {
            if (array[i].getStatus() == "todo" && array[i] != null) {
                System.out.println(array[i].getDescription());
            } else {
                break;
            }
        }
    }

    public Task[] listDoneTasks() {
        int j = 0;
        int k = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] != null && array[i].getStatus().equals("done")) {
                j++;
            } else {
                if (array[i] == null) {
                    break;
                }
            }
        }
        Task[] tempArr = new Task[j];
        for (int i = 0; i < array.length; i++) {
            if (array[i] != null && array[i].getStatus().equals("done")) {
                tempArr[k] = array[i];
                k++;
            } else {
                if (array[i] == null) {
                    break;
                }
            }
        }
        return tempArr;
    }

    public void listInProgressTasks() {
        for (int i = 0; i < array.length; i++) {
            if (array[i].getStatus() == "in-progress" && array[i] != null) {
                System.out.println(array[i].getDescription());
            } else {
                break;
            }
        }
    }

}
