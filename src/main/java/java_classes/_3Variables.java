package java_classes;

/*
In Java, there are different types of variables, for example:

String - stores text, such as "Hello". String values are surrounded by double quotes
int,long,short,byte - stores integers (whole numbers), without decimals, such as 123 or -123
float,double - stores floating point numbers, with decimals, such as 19.99 or -19.99
char - stores single characters, such as 'a' or 'B'. Char values are surrounded by single quotes
boolean - stores values with two states: true or false

To create a variable, you must specify the type and assign it a value:
type variableName = value;

Where type is one of Java's types (such as int or String), and variableName is the name of the variable (such as x or name).
The equal sign is used to assign values to the variable.
*/
public class _3Variables {
    public static void main(String[] args) {
        String name = "John";
        System.out.println(name);

        {
            int myNum = 15;
            System.out.println(myNum);
        }

        {
            // You can also declare a variable without assigning the value, and assign the value later:
            int myNum;
            myNum = 15;
            System.out.println(myNum);
        }

        {

            // Change the value of myNum from 15 to 20:
            int myNum = 15;
            myNum = 20;  // myNum is now 20
            System.out.println(myNum);
        }

    }
}
