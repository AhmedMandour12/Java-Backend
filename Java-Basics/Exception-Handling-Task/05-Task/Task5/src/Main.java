//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() throws IOException {
//    Try to read a file from disk and handle FileNotFoundException. (Use FileReader or Scanner)
    try{
        FileReader file = new FileReader("test.txt");
        BufferedReader reader = new BufferedReader(file);
        System.out.println(reader.readLine());
        reader.close();
    }catch(FileNotFoundException e){
        System.out.println("File not found");

    }catch(IOException e){
        System.out.println("Error reading file");
    }
}
