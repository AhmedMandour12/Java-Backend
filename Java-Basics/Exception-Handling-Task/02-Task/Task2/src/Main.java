
void main() {
    //Task2
    System.out.println("Welcome to your App");
    Scanner sc = new Scanner(System.in);
    System.out.print("Please Enter a number: ");
    String number = sc.nextLine();
    try {
        int num = Integer.parseInt(number);
        System.out.println("Your input: "+ num +" is converted " );
    }
   catch (NumberFormatException e) {
       System.out.println("Invalid input. Please enter a valid integer string (like ==>'123')");

   }

}
