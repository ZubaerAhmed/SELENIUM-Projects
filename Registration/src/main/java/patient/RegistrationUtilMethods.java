package patient;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class RegistrationUtilMethods {
	
	Random rnd = new Random();
    String number = "";


	public static int createRandomInt(int start, int end) {
        return start + (int) Math.round(Math.random() * (end - start));
    }
	public static String randomIntString(int start, int end) {
		String number = (start + (int) Math.round(Math.random() * (end - start)))+"";
        return number;
    }
	public String randomName(){
		String name = "";
		for (int i = 0; i < 3; i++) {
			name += (char) (rnd.nextInt(26) + 'a');
		}
		//System.out.println(name); 
		return name;
	}
	public String randomNameWithParameter(String value){
		String name = value + randomName();
		return name;
	}
	public String randomWord(int num){
		String name = "";
		for (int i = 0; i < num; i++) {
			name += (char) (rnd.nextInt(26) + 'a');
		}
		//System.out.println(name); 
		return name;
	}
    public static String createRandomDOB(int startYear, int endYear) {
        String date = "";
    	String day = Integer.toString(createRandomInt(1, 28));
        String month = Integer.toString(createRandomInt(1, 12));
        String year = Integer.toString(createRandomInt(startYear, endYear));
        date = month+"-"+day+"-"+year;
        //System.out.println("createRandomDOB--> "+date); 
        return date;
    }
    public static String createLicense(){
    	
    	String license = null;
    	String one = Integer.toString(1);
        String two = Integer.toString(createRandomInt(1000000,9999999));
    	license = one+two;
    	//license = createRandomInt(10000000,99999999);
    	//System.out.println("Random license--> "+license); 
    	return license;
    }
    public static String createRandomSSN() {
        String ssn = ""; 
    	String one = Integer.toString(createRandomInt(100, 999));
        String two = Integer.toString(createRandomInt(10, 99));
        String three = Integer.toString(createRandomInt(1000, 9999));
        ssn = one+"-"+two+"-"+three;
        //System.out.println("create ssn--> "+ssn); 
        return ssn;
    }  
    public static String createState(){
    	String state = "";
    	String[] states = {"Alabama","Alaska","Arizona","Arkansas","California","Colorado","Connecticut","Delaware","Florida","Georgia","Hawaii","Idaho","Illinois","Indiana","Iowa","Kansas","Kentucky","Louisiana","Maine","Maryland","Massachusetts","Michigan","Minnesota","Mississippi","Missouri","Montana","Nebraska","Nevada","New Hampshire","New Jersey","New Mexico","New York","North Carolina","North Dakota","Ohio","Oklahoma","Oregon","Pennsylvania","Rhode Island","South Carolina","South Dakota","Tennessee","Texas","Utah","Vermont","Virginia","Washington","West Virginia","Wisconsin","Wyoming"};
    	Random random = new Random();
    	int index = random.nextInt(states.length);
    	state = states[index];
    	//System.out.println("=> "+state);
    	return state;
    }
    public static String createCity(){
    	String city = "";
    	String[] capital = {"Montgomery","Juneau","Phoenix","Little Rock","Sacramento","Denver","Hartford","Dover","Tallahassee","Atlanta","Honolulu","Boise","Springfield","Indianapolis","Des Moines","Topeka","Frankfort","Baton Rouge","Augusta","Annapolis","Boston","Lansing","St. Paul","Jackson","Jefferson City","Helena","Lincoln","Carson City","Concord","Trenton","Santa Fe","Albany","Raleigh","Bismarck","Columbus","Oklahoma City","Salem","Harrisburg","Providence","Columbia","Pierre","Nashville","Austin","Salt Lake City","Montpelier","Richmond","Olympia","Charleston","Madison","Cheyenne"};
    	Random random = new Random();
    	int index = random.nextInt(capital.length);
    	city = capital[index];
    	//System.out.println(city);
    	return city;
    }
    public String createEmail(String name){
    	String email = name+"."+ randomName()+"@gmail.com";
    	return email;
    }
    public String createUsername(String name){
    	String username = name + randomIntString(100,999);
    	return username;
    }
//	public String todaysDate(){
//		String today = "";
//		SimpleDateFormat date = new SimpleDateFormat("dd/MM/YYYY");		 
//		System.out.println("DOB--> "+date.format(new Date()));
//		return today;
//	}
	
	
}
