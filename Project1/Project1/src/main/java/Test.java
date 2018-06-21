import com.revature.util.BCrypt;

public class Test {
    public static void main(String[] args) {
    	String salt = BCrypt.gensalt();
    	System.out.println(salt);
    	String hashed = BCrypt.hashpw("33.55OCAStudyGuidemissy.costigan@gmail.com", salt);
    	System.out.println(hashed);

    	if (BCrypt.checkpw("33.55OCAStudyGuidemissy.costigan@gmail.com", hashed))
    		System.out.println("It matches");
    	else
    		System.out.println("It does not match");
    	
    }
}
