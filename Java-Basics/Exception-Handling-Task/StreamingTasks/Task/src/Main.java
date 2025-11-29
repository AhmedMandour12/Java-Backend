
void main() {
    List<Integer> numbers = Arrays.asList(10, 5, 3, 7, 2, 10, 5, 8, 9, 0, -3, 4);

    List<String> names = Arrays.asList("Ali", "Mona", "Ahmed", "Sara", "Amr", "Laila", "Kareem", "Nada", "Nour", "Samy", "", null);

    List<Student> students = Arrays.asList(
            new Student("Ali", "IT", 85),
            new Student("Mona", "CS", 92),
            new Student("Ahmed", "IT", 60),
            new Student("Sara", "CS", 70),
            new Student("Omar", "IS", 45),
            new Student("Laila", "IS", 78)
    );
    List<Employee> employees = Arrays.asList(
            new Employee("Ali", 30, "HR", 5000),
            new Employee("Mona", 25, "IT", 7000),
            new Employee("Ahmed", 30, "HR", 5500),
            new Employee("Sara", 27, "IT", 7200),
            new Employee("Omar", 40, "Finance", 8000),
            new Employee("Laila", 35, "Finance", 8200)
    );
    List<List<String>> nestedWords = Arrays.asList(
            Arrays.asList("Java", "Stream"),
            Arrays.asList("API", "Lambda"),
            Arrays.asList("FlatMap", "Map")
    );
//----------------------------------------Excution------------------------------------------------//
    List<Integer> getEvenNumbers = numbers.stream().filter(n -> n % 2 == 0 && n != 0).collect(Collectors.toList());
    System.out.println("1- Even numbers is: " + getEvenNumbers);
    System.out.println("__________________________________________________");

    List<String> getNamesStartWith_A = names.stream().filter(n -> n != null && n.startsWith("A")).collect(Collectors.toList());
    System.out.println("2- Names starting with A is: " + getNamesStartWith_A);
    System.out.println("__________________________________________________");

    List<String> convertToUpperCase = names.stream().filter(n -> n != null && n != "").map(n -> n.toUpperCase()).collect(Collectors.toList());
    System.out.println("3- Converting is: " + convertToUpperCase);
    System.out.println("__________________________________________________");

    List<Integer> Sorting = numbers.stream().sorted(Comparator.naturalOrder()).collect(Collectors.toList());
    System.out.println("4- Sorting is: " + Sorting);
    System.out.println("__________________________________________________");

    List<Integer> removeDuplicates = numbers.stream().distinct().collect(Collectors.toList());
    System.out.println("5- Removing Duplicates is: " + removeDuplicates);
    System.out.println("__________________________________________________");

    List<Integer> countStringsLongerThan5 = numbers.stream().filter(n -> n > 5).collect(Collectors.toList());
    System.out.println("6- Count strings longer than 5 is: " + countStringsLongerThan5);
    System.out.println("__________________________________________________");

//Find the first element in a stream that matches a given condition...Check if any number is divisible by 5 in a list...Collect elements into a Set instead of a List
    Set<Integer> numberIsDivisibleBy5 = numbers.stream().filter(n -> n % 5 == 0).collect(Collectors.toSet());
    System.out.println("Number Is Divisible By5 Is: " + numberIsDivisibleBy5);
    System.out.println("__________________________________________________");

    // Skip the first 3 elements and return the rest.
    List<Integer> skippingFirst3Elements = numbers.stream().skip(3).collect(Collectors.toList());
    System.out.println("7- Skipping first 3 elements is: " + skippingFirst3Elements);
    System.out.println("__________________________________________________");

    //Calculate the sum of a list of integers using reduce.
    List<Integer> sumOfList = Collections.singletonList(numbers.stream().reduce(0, (a, b) -> a + b));
    System.out.println("8- Sum of list is: " + sumOfList);
    System.out.println("__________________________________________________");

    //Find the maximum and minimum value in a list.
    List<Integer> maximumValue = numbers.stream().max(Comparator.naturalOrder()).stream().collect(Collectors.toList());
    List<Integer> minimumValue = numbers.stream().min(Comparator.naturalOrder()).stream().collect(Collectors.toList());
    System.out.println("9- Maximum and Minimum value is: " + maximumValue + "," + minimumValue);
    System.out.println("__________________________________________________");

    //Calculate the average of a list of doubles.
    OptionalDouble average = numbers.stream().mapToInt(n -> n).average();
    System.out.println("10- Average Is :" + average.getAsDouble());
    System.out.println("__________________________________________________");

    //Multiply all integers in a list together using reduce.
    List<Integer> Multiply = Collections.singletonList(numbers.stream().reduce(0, (a, b) -> a * b));
    System.out.println("11- Multiply is: " + Multiply);
    System.out.println("__________________________________________________");

    //Count how many numbers are positive in a list
    long positiveNumbers = numbers.stream().filter(n -> n > 0).count();
    System.out.println("12- Numbers Of Positive Numbers is: " + positiveNumbers);
    System.out.println("__________________________________________________");

//Group a list of students by their department.
    Map<String, List<Student>> studentsByDept = students.stream().collect(Collectors.groupingBy(Student -> Student.getDepartment()));
    System.out.println("studentsByDept: " + studentsByDept);  //OverRide->toString in Student Class
    System.out.println("__________________________________________________");

    //Partition a list of numbers into even and odd using partitioningBy.
    Map<Boolean, List<Integer>> evenOddPartition = numbers.stream().filter(n -> n != 0).distinct().collect(Collectors.partitioningBy(n -> n % 2 == 0));
    System.out.println("Even: " + evenOddPartition.get(true));
    System.out.println("Odd: " + evenOddPartition.get(false));
    System.out.println("__________________________________________________");

    //Create a comma-separated string from a list of strings.
    List<String> joiner = Collections.singletonList(names.stream().filter(n -> n != null).collect(Collectors.joining(",")));
    System.out.println("joiner: " + joiner);
    System.out.println("__________________________________________________");

    //Group employees by age and count how many per age.
    Map<Integer, List<Employee>> countAge = employees.stream().collect(Collectors.groupingBy(s -> (int) s.getAge()));
    System.out.println("countAge: " + countAge);
    System.out.println("__________________________________________________");

    //Find the average salary per department in a list of employees.
    Map<String, Double> averageSalary = employees.stream().collect(Collectors.groupingBy(e -> e.getDepartment(), Collectors.averagingDouble(e -> e.getSalary())));
    System.out.println("averageSalary: " + averageSalary);
    System.out.println("__________________________________________________");

    //Flatten a list of lists into a single list.
    List<String> flattenedList = nestedWords.stream().flatMap(List::stream).collect(Collectors.toList());
    System.out.println("flattenedList: " + flattenedList);
    System.out.println("__________________________________________________");

    //Filter a list of Optionals and collect non-empty values.
    List<String> nonEmptyValues = names.stream().filter(n -> n != null).collect(Collectors.toList());
    System.out.println("nonEmptyValues: " + nonEmptyValues);
    System.out.println("__________________________________________________");

    //Map a list of strings to their lengths.

    List<Integer> nameLengths = names.stream().filter(n -> n != null).map(n -> n.length()).collect(Collectors.toList());
    System.out.println("nameLengths: " + nameLengths);
    System.out.println("__________________________________________________");

    //Return a list of uppercased words that start with “A”.
    List<String> upperAWords = names.stream().filter(n -> n != null && n.startsWith("A")).map(n -> n.toUpperCase()).collect(Collectors.toList());
    System.out.println("upperAWords: " + upperAWords);
    System.out.println("__________________________________________________");

    //Sort a list of employees by salary then by name.
    List<Employee> sortedEmployees=employees.stream().sorted(Comparator.comparingDouble(Employee::getSalary).thenComparing(Comparator.comparing(Employee::getName))).collect(Collectors.toList());
    System.out.println("sortedEmployees: " + sortedEmployees);
    System.out.println("__________________________________________________");

    //Find the second-highest number in a list.
    List<Integer>secondHighestNumber= Collections.singletonList(numbers.stream().sorted(Comparator.reverseOrder()).skip(2).findFirst().orElse(null));
    System.out.println("secondHighestNumber: " + secondHighestNumber);
    System.out.println("__________________________________________________");

    Set<Integer> itemsProcessed = new HashSet<>();
    List<Integer> duplicates = numbers.stream().filter(n -> !itemsProcessed.add(n)).collect(Collectors.toList());
    System.out.println("3. Duplicate Elements: " + duplicates);
    System.out.println("__________________________________________________");

    List<String> cleanedNames = names.stream().filter(name -> name != null && !name.isEmpty()).collect(Collectors.toList());
    System.out.println("4. Cleaned List: " + cleanedNames);
    System.out.println("__________________________________________________");

    Map<Boolean, List<Student>> passFailMap = students.stream().collect(Collectors.partitioningBy(s -> s.grade >= 50));
    System.out.println("5. Passed: " + passFailMap.get(true).size());
    System.out.println("5. Failed: " + passFailMap.get(false).size());






}



