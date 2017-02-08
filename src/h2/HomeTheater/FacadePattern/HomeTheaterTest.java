package h2.HomeTheater.FacadePattern;

public class HomeTheaterTest {

	public static void main(String[] args) {
		HomeTheaterFacade homeTheater = new HomeTheaterFacade(new Amplifier(), new Tuner(), new DvdPlayer(),
				new CdPlayer(), new Projector(), new TheaterLights(), new Screen(), new PopcornPopper());

		homeTheater.watchMovie("Sally");
		homeTheater.endMovie();
	}

}
