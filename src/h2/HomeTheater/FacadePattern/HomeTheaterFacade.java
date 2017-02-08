package h2.HomeTheater.FacadePattern;

public class HomeTheaterFacade {

	Amplifier amplifier;
	Tuner tuner;
	DvdPlayer dvd;
	CdPlayer cd;
	Projector projector;
	TheaterLights lights;
	Screen screen;
	PopcornPopper popper;

	public HomeTheaterFacade(Amplifier amplifier, Tuner tuner, DvdPlayer dvd, CdPlayer cd, Projector projector,
			TheaterLights lights, Screen screen, PopcornPopper popper) {
		super();
		this.amplifier = amplifier;
		this.tuner = tuner;
		this.dvd = dvd;
		this.cd = cd;
		this.projector = projector;
		this.lights = lights;
		this.screen = screen;
		this.popper = popper;
	}

	public void watchMovie(String movie) {
		System.out.println("Get ready to watch a movie..");
		popper.on();
		popper.pop();
		lights.dim();
		screen.down();
		projector.on();
		projector.wideScreen();
		amplifier.on();
		amplifier.setDvd(dvd);
		amplifier.setSurround();
		amplifier.setVolume(5);
		dvd.on();
		dvd.play(movie);
	}

	public void endMovie() {
		System.out.println("Shutting movie theater down");
		popper.off();
		lights.on();
		screen.up();
		projector.off();
		amplifier.off();
		dvd.stop();
		dvd.eject();
		dvd.off();
	}
}
