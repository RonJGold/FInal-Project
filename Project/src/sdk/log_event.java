package sdk;

public class log_event {
	logevent_types type ;
	String title;
	String msg;
	
	log_event(logevent_types type,String title,String msg){
		this.type = type ;
		this.title = title;
		this.msg = msg ;
	}
	
	void print() {
		String  output = type.toString() + "\t"   + title  + "\t"  + msg ;
		System.out.println(output);
	}
}
