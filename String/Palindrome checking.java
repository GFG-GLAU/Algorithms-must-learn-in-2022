import java.util.*;
public class pali {
    public static boolean ispalindrome(String str){
        for(int i=0;i<str.length()/2;i++){
            int n=str.length();
            if(str.charAt(i)!=str.charAt(n-1-i)){
                System.out.println("Not a palindromic string");
                return false;
            }
        }
        System.out.println("Palindromic String");
        return true;
    }
   
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        String str=sc.next();
        System.out.println(ispalindrome(str));
        
    }
    
}
