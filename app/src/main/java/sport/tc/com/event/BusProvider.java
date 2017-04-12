package sport.tc.com.event;

import com.squareup.otto.Bus;
import com.squareup.otto.ThreadEnforcer;

/**
 * 事件总线
 */
public class BusProvider {
	
	private static final Bus BUS = new Bus(ThreadEnforcer.ANY);

	public static Bus getInstance() {
		return BUS;
	}
	
}
