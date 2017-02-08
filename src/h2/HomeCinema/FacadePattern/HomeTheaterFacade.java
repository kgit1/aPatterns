package h2.HomeCinema.FacadePattern;

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
}
