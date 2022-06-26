import stdlib.jar;

public class ReadFile {

    public static void main(String[] unused) {
        // Open the file "para1.txt" stored in the root folder of this project
        In file = new In("test/para1.txt");
        // While there is still something to read...
        while (!file.isEmpty()) {
            // Read 1 line from the file
            String s = file.readLine();
            // Do something with line
            System.out.println(s);
        }
    }


}
