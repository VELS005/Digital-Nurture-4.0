import java.util.*;
import java.io.*;
import java.sql.*;
import java.net.*;
import java.net.http.*;
import java.net.URI;
import java.util.concurrent.*;
import java.util.stream.*;

public class CoreJavaExercises {

    // 2. Simple Calculator
    static void simpleCalculator() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first number: ");
        double a = sc.nextDouble();
        System.out.print("Enter second number: ");
        double b = sc.nextDouble();
        System.out.print("Choose operation (+, -, *, /): ");
        char op = sc.next().charAt(0);
        double result = switch (op) {
            case '+' -> a + b;
            case '-' -> a - b;
            case '*' -> a * b;
            case '/' -> b != 0 ? a / b : Double.NaN;
            default -> { System.out.println("Invalid operation."); yield Double.NaN; }
        };
        System.out.println("Result: " + result);
    }

    // 3. Even or Odd Checker
    static void evenOddChecker() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        int n = sc.nextInt();
        System.out.println(n % 2 == 0 ? "Even" : "Odd");
    }

    // 4. Leap Year Checker
    static void leapYearChecker() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a year: ");
        int year = sc.nextInt();
        boolean isLeap = (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
        System.out.println(isLeap ? "Leap year" : "Not a leap year");
    }

    // 5. Multiplication Table
    static void multiplicationTable() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = sc.nextInt();
        for (int i = 1; i <= 10; i++)
            System.out.println(n + " x " + i + " = " + (n * i));
    }

    // 6. Data Type Demonstration
    static void dataTypeDemo() {
        int i = 42;
        float f = 3.14f;
        double d = 2.71828;
        char c = 'A';
        boolean b = true;
        System.out.println("int: " + i);
        System.out.println("float: " + f);
        System.out.println("double: " + d);
        System.out.println("char: " + c);
        System.out.println("boolean: " + b);
    }

    // 7. Type Casting Example
    static void typeCastingExample() {
        double d = 9.99;
        int i = (int) d;
        System.out.println("Double to int: " + i);
        int j = 7;
        double d2 = (double) j;
        System.out.println("Int to double: " + d2);
    }

    // 8. Operator Precedence
    static void operatorPrecedence() {
        int result = 10 + 5 * 2;
        System.out.println("10 + 5 * 2 = " + result + " (Multiplication before addition)");
        int result2 = (10 + 5) * 2;
        System.out.println("(10 + 5) * 2 = " + result2);
    }

    // 9. Grade Calculator
    static void gradeCalculator() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter marks out of 100: ");
        int marks = sc.nextInt();
        char grade;
        if (marks >= 90) grade = 'A';
        else if (marks >= 80) grade = 'B';
        else if (marks >= 70) grade = 'C';
        else if (marks >= 60) grade = 'D';
        else grade = 'F';
        System.out.println("Grade: " + grade);
    }

    // 10. Number Guessing Game
    static void numberGuessingGame() {
        Random rand = new Random();
        int number = rand.nextInt(100) + 1;
        Scanner sc = new Scanner(System.in);
        int guess;
        do {
            System.out.print("Guess the number (1-100): ");
            guess = sc.nextInt();
            if (guess < number) System.out.println("Too low!");
            else if (guess > number) System.out.println("Too high!");
        } while (guess != number);
        System.out.println("Correct!");
    }

    // 11. Factorial Calculator
    static void factorialCalculator() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a non-negative integer: ");
        int n = sc.nextInt();
        long fact = 1;
        for (int i = 2; i <= n; i++) fact *= i;
        System.out.println("Factorial: " + fact);
    }

    // 12. Method Overloading
    static int add(int a, int b) { return a + b; }
    static double add(double a, double b) { return a + b; }
    static int add(int a, int b, int c) { return a + b + c; }
    static void methodOverloading() {
        System.out.println(add(2, 3));
        System.out.println(add(2.5, 3.5));
        System.out.println(add(1, 2, 3));
    }

    // 13. Recursive Fibonacci
    static int fibonacci(int n) {
        if (n <= 1) return n;
        return fibonacci(n-1) + fibonacci(n-2);
    }
    static void recursiveFibonacci() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = sc.nextInt();
        System.out.println("Fibonacci(" + n + ") = " + fibonacci(n));
    }

    // 14. Array Sum and Average
    static void arraySumAverage() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Number of elements: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            sum += arr[i];
        }
        System.out.println("Sum: " + sum);
        System.out.println("Average: " + (sum / (double)n));
    }

    // 15. String Reversal
    static void stringReversal() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String s = sc.nextLine();
        StringBuilder sb = new StringBuilder(s);
        System.out.println("Reversed: " + sb.reverse());
    }

    // 16. Palindrome Checker
    static void palindromeChecker() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String s = sc.nextLine().replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        String rev = new StringBuilder(s).reverse().toString();
        System.out.println(s.equals(rev) ? "Palindrome" : "Not a palindrome");
    }

    // 17. Class and Object Creation
    static class Car {
        String make, model;
        int year;
        Car(String make, String model, int year) {
            this.make = make; this.model = model; this.year = year;
        }
        void displayDetails() {
            System.out.println(year + " " + make + " " + model);
        }
    }
    static void classAndObjectCreation() {
        Car c = new Car("Toyota", "Corolla", 2020);
        c.displayDetails();
    }

    // 18. Inheritance Example
    static class Animal {
        void makeSound() { System.out.println("Some sound"); }
    }
    static class Dog extends Animal {
        void makeSound() { System.out.println("Bark"); }
    }
    static void inheritanceExample() {
        Animal a = new Animal();
        Dog d = new Dog();
        a.makeSound();
        d.makeSound();
    }

    // 19. Interface Implementation
    interface Playable { void play(); }
    static class Guitar implements Playable {
        public void play() { System.out.println("Guitar playing"); }
    }
    static class Piano implements Playable {
        public void play() { System.out.println("Piano playing"); }
    }
    static void interfaceImplementation() {
        Playable g = new Guitar(), p = new Piano();
        g.play(); p.play();
    }

    // 20. Try-Catch Example
    static void tryCatchExample() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter two integers: ");
        int a = sc.nextInt(), b = sc.nextInt();
        try {
            System.out.println("Result: " + (a / b));
        } catch (ArithmeticException e) {
            System.out.println("Cannot divide by zero.");
        }
    }

    // 21. Custom Exception
    static class InvalidAgeException extends Exception {
        public InvalidAgeException(String msg) { super(msg); }
    }
    static void customException() {
        int age = 16;
        try {
            if (age < 18) throw new InvalidAgeException("Age < 18");
            System.out.println("Valid age");
        } catch (InvalidAgeException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }

    // 22. File Writing
    static void fileWriting() throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String s = sc.nextLine();
        try (FileWriter fw = new FileWriter("output.txt")) {
            fw.write(s);
        }
        System.out.println("Data written to output.txt");
    }

    // 23. File Reading
    static void fileReading() throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader("output.txt"))) {
            String line;
            while ((line = br.readLine()) != null)
                System.out.println(line);
        }
    }

    // 24. ArrayList Example
    static void arrayListExample() {
        ArrayList<String> names = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter names (type 'end' to stop):");
        while (true) {
            String name = sc.nextLine();
            if (name.equals("end")) break;
            names.add(name);
        }
        System.out.println("Names: " + names);
    }

    // 25. HashMap Example
    static void hashMapExample() {
        HashMap<Integer, String> map = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter ID and name (0 to stop):");
        while (true) {
            int id = sc.nextInt();
            if (id == 0) break;
            String name = sc.next();
            map.put(id, name);
        }
        System.out.print("Enter ID to search: ");
        int searchId = sc.nextInt();
        System.out.println("Name: " + map.get(searchId));
    }

    // 26. Thread Creation
    static class MyThread extends Thread {
        String msg;
        MyThread(String msg) { this.msg = msg; }
        public void run() {
            for (int i = 0; i < 5; i++)
                System.out.println(msg + " " + i);
        }
    }
    static void threadCreation() {
        new MyThread("Thread 1").start();
        new MyThread("Thread 2").start();
    }

    // 27. Lambda Expressions
    static void lambdaExpressions() {
        List<String> list = Arrays.asList("Banana", "Apple", "Cherry");
        list.sort((a, b) -> a.compareTo(b));
        System.out.println(list);
    }

    // 28. Stream API
    static void streamAPI() {
        List<Integer> nums = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        List<Integer> evens = nums.stream().filter(n -> n % 2 == 0).collect(Collectors.toList());
        System.out.println(evens);
    }

    // 29. Records (Java 16+)
    record Person(String name, int age) {}
    static void personRecord() {
        List<Person> people = List.of(new Person("Alice", 30), new Person("Bob", 17));
        people.forEach(System.out::println);
        List<Person> adults = people.stream().filter(p -> p.age() >= 18).toList();
        System.out.println("Adults: " + adults);
    }

    // 30. Pattern Matching for switch (Java 21)
    static void patternMatchingSwitch() {
        Object[] objs = {42, "hello", 3.14};
        for (Object obj : objs) {
            switch (obj) {
                case Integer i -> System.out.println("Integer: " + i);
                case String s -> System.out.println("String: " + s);
                case Double d -> System.out.println("Double: " + d);
                default -> System.out.println("Other type");
            }
        }
    }

    // 31. Basic JDBC Connection
    static void basicJDBCConnection() throws Exception {
        Connection conn = DriverManager.getConnection("jdbc:sqlite:students.db");
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM students");
        while (rs.next()) {
            System.out.println(rs.getInt(1) + " " + rs.getString(2));
        }
        rs.close(); stmt.close(); conn.close();
    }

    // 32. Insert and Update Operations in JDBC
    static void insertAndUpdateJDBC() throws Exception {
        Connection conn = DriverManager.getConnection("jdbc:sqlite:students.db");
        PreparedStatement ps = conn.prepareStatement("INSERT INTO students VALUES (?,?)");
        ps.setInt(1, 1); ps.setString(2, "Alice"); ps.executeUpdate(); ps.close();
        ps = conn.prepareStatement("UPDATE students SET name=? WHERE id=?");
        ps.setString(1, "Alicia"); ps.setInt(2, 1); ps.executeUpdate(); ps.close();
        conn.close();
    }

    // 33. Transaction Handling in JDBC
    static void jdbcTransaction() throws Exception {
        Connection conn = DriverManager.getConnection("jdbc:sqlite:bank.db");
        conn.setAutoCommit(false);
        try {
            PreparedStatement ps1 = conn.prepareStatement("UPDATE accounts SET balance=balance-? WHERE id=?");
            ps1.setDouble(1, 100); ps1.setInt(2, 1); ps1.executeUpdate();
            PreparedStatement ps2 = conn.prepareStatement("UPDATE accounts SET balance=balance+? WHERE id=?");
            ps2.setDouble(1, 100); ps2.setInt(2, 2); ps2.executeUpdate();
            conn.commit();
        } catch (Exception e) {
            conn.rollback();
        }
        conn.close();
    }

    // 34. Create and Use Java Modules (see README or documentation for steps)
    static void javaModules() {
        System.out.println("See documentation for Java modules setup.");
    }

    // 35. TCP Client-Server Chat (server)
    static void tcpChatServer() throws Exception {
        ServerSocket server = new ServerSocket(5000);
        Socket client = server.accept();
        BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
        PrintWriter out = new PrintWriter(client.getOutputStream(), true);
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            System.out.println("Client: " + line);
            out.println(stdin.readLine());
        }
        client.close(); server.close();
    }

    // 35. TCP Client-Server Chat (client)
    static void tcpChatClient() throws Exception {
        Socket socket = new Socket("localhost", 5000);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = stdin.readLine()) != null) {
            out.println(line);
            System.out.println("Server: " + in.readLine());
        }
        socket.close();
    }

    // 36. HTTP Client API (Java 11+)
    static void httpClientExample() throws Exception {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest req = HttpRequest.newBuilder().uri(URI.create("https://api.github.com")).build();
        HttpResponse<String> res = client.send(req, HttpResponse.BodyHandlers.ofString());
        System.out.println("Status: " + res.statusCode());
        System.out.println("Body: " + res.body());
    }

    // 37. Using javap to Inspect Bytecode
    static int square(int x) { return x * x; }
    static void javapDemo() {
        System.out.println("Compile and run: javap -c CoreJavaExercises");
    }

    // 38. Decompile a Class File
    static String greet() { return "Hello"; }
    static void decompileDemo() {
        System.out.println("Compile and open .class in JD-GUI or CFR.");
    }

    // 39. Reflection in Java
    static void reflectionDemo() throws Exception {
        Class<?> cls = Class.forName("CoreJavaExercises");
        for (var m : cls.getDeclaredMethods())
            System.out.println(m.getName());
        Object obj = cls.getDeclaredConstructor().newInstance();
        var m = cls.getMethod("greet");
        System.out.println(m.invoke(obj));
    }

    // 40. Virtual Threads (Java 21)
    static void virtualThreadsDemo() throws Exception {
        for (int i = 0; i < 100_000; i++) {
            Thread.startVirtualThread(() -> System.out.println("Hello from virtual thread"));
        }
        Thread.sleep(1000);
    }

    // 41. Executor Service and Callable
    static void executorServiceCallable() throws Exception {
        ExecutorService es = Executors.newFixedThreadPool(3);
        List<Callable<Integer>> tasks = Arrays.asList(
            () -> 1 + 1, () -> 2 + 2, () -> 3 + 3
        );
        List<Future<Integer>> results = es.invokeAll(tasks);
        for (Future<Integer> f : results)
            System.out.println(f.get());
        es.shutdown();
    }

    // Main menu to select exercises
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String[] menu = {
            "2. Simple Calculator", "3. Even or Odd Checker", "4. Leap Year Checker",
            "5. Multiplication Table", "6. Data Type Demonstration", "7. Type Casting Example",
            "8. Operator Precedence", "9. Grade Calculator", "10. Number Guessing Game",
            "11. Factorial Calculator", "12. Method Overloading", "13. Recursive Fibonacci",
            "14. Array Sum and Average", "15. String Reversal", "16. Palindrome Checker",
            "17. Class and Object Creation", "18. Inheritance Example", "19. Interface Implementation",
            "20. Try-Catch Example", "21. Custom Exception", "22. File Writing", "23. File Reading",
            "24. ArrayList Example", "25. HashMap Example", "26. Thread Creation", "27. Lambda Expressions",
            "28. Stream API", "29. Records", "30. Pattern Matching for switch", "31. Basic JDBC Connection",
            "32. Insert and Update Operations in JDBC", "33. Transaction Handling in JDBC",
            "34. Create and Use Java Modules", "35. TCP Chat Server", "36. HTTP Client API",
            "37. Using javap to Inspect Bytecode", "38. Decompile a Class File", "39. Reflection in Java",
            "40. Virtual Threads", "41. Executor Service and Callable"
        };
        while (true) {
            System.out.println("\nSelect exercise (2-41, 0 to exit):");
            for (int i = 0; i < menu.length; i++)
                System.out.printf("%2d. %s\n", i + 2, menu[i]);
            int choice = sc.nextInt();
            if (choice == 0) break;
            switch (choice) {
                case 2 -> simpleCalculator();
                case 3 -> evenOddChecker();
                case 4 -> leapYearChecker();
                case 5 -> multiplicationTable();
                case 6 -> dataTypeDemo();
                case 7 -> typeCastingExample();
                case 8 -> operatorPrecedence();
                case 9 -> gradeCalculator();
                case 10 -> numberGuessingGame();
                case 11 -> factorialCalculator();
                case 12 -> methodOverloading();
                case 13 -> recursiveFibonacci();
                case 14 -> arraySumAverage();
                case 15 -> stringReversal();
                case 16 -> palindromeChecker();
                case 17 -> classAndObjectCreation();
                case 18 -> inheritanceExample();
                case 19 -> interfaceImplementation();
                case 20 -> tryCatchExample();
                case 21 -> customException();
                case 22 -> fileWriting();
                case 23 -> fileReading();
                case 24 -> arrayListExample();
                case 25 -> hashMapExample();
                case 26 -> threadCreation();
                case 27 -> lambdaExpressions();
                case 28 -> streamAPI();
                case 29 -> personRecord();
                case 30 -> patternMatchingSwitch();
                case 31 -> basicJDBCConnection();
                case 32 -> insertAndUpdateJDBC();
                case 33 -> jdbcTransaction();
                case 34 -> javaModules();
                case 35 -> {
                    System.out.print("1. Server 2. Client: ");
                    int t = sc.nextInt();
                    if (t == 1) tcpChatServer(); else tcpChatClient();
                }
                case 36 -> httpClientExample();
                case 37 -> javapDemo();
                case 38 -> decompileDemo();
                case 39 -> reflectionDemo();
                case 40 -> virtualThreadsDemo();
                case 41 -> executorServiceCallable();
                default -> System.out.println("Invalid choice.");
            }
        }
    }
}
