package java_classes;
/*
Every line of code that runs in Java must be inside a class. In our example, we named the class Main. A class should always start with an uppercase first letter.

Note: Java is case-sensitive: "MyClass" and "myclass" has different meaning.

The name of the java file must match the class name. When saving the file, save it using the class name and add ".java" to the end of the filename.

Any code inside the main() method will be executed. Don't worry about the keywords before and after main.
For now, just remember that every Java program has a class name which must match the filename, and that every program must contain the main() method.
*/

public class _1MainMethod {
    public static void main(String[] args) { // Note: The curly braces {} marks the beginning and the end of a block of code.
        // System is a built-in Java class that contains useful members, such as out, which is short for "output". The println() method, short for "print line", is used to print a value to the screen (or a file).
        // Don't worry too much about System, out and println(). Just know that you need them together to print stuff to the screen.
        // You can add as many println() methods as you want. Note that it will add a new line for each method:
        System.out.println("Hello World"); // You should also note that each code statement must end with a semicolon (;).

        // You can also output numbers, and perform mathematical calculations:
        // Note that we don't use double quotes ("") inside println() to output numbers.
        System.out.println(3 + 3);

        // There is also a print() method, which is similar to println().
        //The only difference is that it does not insert a new line at the end of the output:
        System.out.print("Hello World! ");
        System.out.print("I will print on the same line.");
    }
}
