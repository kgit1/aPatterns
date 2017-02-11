package j1.GumMachine.ConditionPattern;

public class GumballMachine {

	final static int SOLD_OUT = 0;
	final static int NO_QUARTER = 1;
	final static int HAS_QUARTER = 2;
	final static int SOLD = 3;

	int state = SOLD_OUT;
	int count = 0;

	// gumball machine created with some count of gumballs - if count of
	// gumballs more than ZERO - machine started and turned to waiting state -
	// NO_QUARTER
	public GumballMachine(int count) {
		this.count = count;
		if (count > 0) {
			state = NO_QUARTER;
		}
	}

	// method for inserting coin to the machine
	public void insertQuarter() {
		// if machine state HAS_QUARTER(when coin already in)
		if (state == HAS_QUARTER) {
			System.out.println("You can't insert another quarter");
			// if machine state - SOLD_OUT(when count of gumballs equals ZERO)
		} else if (state == SOLD_OUT) {
			System.out.println("You can't insert a quarter, the machine is sold out");
			// if machine state - SOLD(when coin already inside and machine in
			// process of giving gumball)
		} else if (state == SOLD) {
			System.out.println("Please wait, we're already giving you a gumball");
			// and finally if machine state - NO_QUARTER(when machine in waiting
			// mode and changing own state to HAS_QUARTER and starts process of
			// giving gumball)
		} else if (state == NO_QUARTER) {
			state = HAS_QUARTER;
			System.out.println("You inserted a quarter");
		}
	}

	// method for ejecting coin, if buyer trying to return coin
	public void ejectQuarter() {
		// if machine has coin inside, and process hasn't started yet
		// coin returned and machine returns to state - NO_QUArTER
		if (state == HAS_QUARTER) {
			System.out.println("Quarter returned");
			state = NO_QUARTER;
			// if machine hasn't quarter inside, can't return
		} else if (state == NO_QUARTER) {
			System.out.println("You haven't isert a quarter");
			// if quarter inside but process of giving gumball already started
		} else if (state == SOLD) {
			System.out.println("Sorry, you already turned the crank");
			// if machine empty, doesn't taking coins so can't be any inside
		} else if (state == SOLD_OUT) {
			System.out.println("You can't eject, yo haven't iserted coin yet");
		}
	}

}
