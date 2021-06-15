package sdk;

import java.util.ArrayList;
import java.util.List;

public class logger {
	List<log_event> logs = new ArrayList<log_event>();

	public void info(String title ,String msg) {
		log_event le = new log_event(logevent_types.info,title,msg);
		logs.add(le);
	}
	public void exception(String title ,String msg) {
		log_event le = new log_event(logevent_types.exception,title,msg);
		logs.add(le);


	}

	public void event(String title ,String msg) {
		log_event le = new log_event(logevent_types.event,title,msg);
		logs.add(le);
	}
	public void print() {
		for(log_event le:logs) {
			le.print();
		}
	}

}
