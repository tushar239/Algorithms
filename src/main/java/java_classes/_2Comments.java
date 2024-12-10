package java_classes;

/*
Comments can be used to explain Java code, and to make it more readable. It can also be used to prevent execution when testing alternative code.

Single-line comments start with two forward slashes (//).
Any text between // and the end of the line is ignored by Java (will not be executed).

 */
public class _2Comments {
    public static void main(String[] args) {
        // This is a comment
        System.out.println("Hello World");

        System.out.println("Hello World"); // This is a comment


        // Multi-line comments start with /* and ends with */. Any text between /* and */ will be ignored by Java.

        /* The code below will print the words Hello World
            to the screen, and it is amazing */
        System.out.println("Hello World");
    }
}
