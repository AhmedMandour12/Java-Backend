//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {
    //Task4

    int []arr={10,20,30,40,50};

    try {
        System.out.println("The array is:"+Arrays.toString(arr));

        Scanner sc=new Scanner(System.in);
        System.out.println("Please Enter index of value: ");

        int index=sc.nextInt();
        int result=arr[index];
        System.out.println("The value is:"+result);

    }catch(ArrayIndexOutOfBoundsException e){
        System.out.println("Index out of bounds");


    }
}
