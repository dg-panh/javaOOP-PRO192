
public class Test {

    public static void main(String[] args) {
        String a = "XYZ";
        String b = new String("XYZ");
        String c = b.intern();
        if (a == b) {
            System.out.print(" a == b ");
        } else {
            System.out.print("a # b ");
        }
        
        if (a == c) {
            System.out.println(" a == c");
        } else {
            System.out.println(" a # c");
        }
    }
}
