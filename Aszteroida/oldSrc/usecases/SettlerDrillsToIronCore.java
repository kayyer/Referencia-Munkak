package tau.asteroidgame.Util.usecases;

import tau.asteroidgame.Asteroid;
import tau.asteroidgame.Iron;
import tau.asteroidgame.Settler;
import tau.asteroidgame.Util.Logger;
import tau.asteroidgame.Util.UseCase;

public class SettlerDrillsToIronCore implements UseCase {
	String program;
	Settler s;
	Asteroid a;
	Iron core;

	@Override
	public void init() {
		Logger.clear();
		
		program = "prg"; Logger.registerObject(program, "Program");
		Logger.registerObject(this, "Skeleton");
		
		Logger.pushToRegisterNameStack("s", "a", "core");
		
		Logger.createObjectNextRegister(program);
		s = new Settler();
		
		Logger.createObjectNextRegister(program);
		a = new Asteroid();
		
		Logger.createObjectNextRegister(program);
		core = new Iron();
		
		Logger.callObject(program, a, "acceptWorker", s);
		a.acceptWorker(s);
		
		Logger.callObject(program, a, "setCore", core);
		a.setCore(core);
		
	}

	@Override
	public void run() {
		Logger.callObject(this, s, "drill");
		s.drill();
	}
	
	public String toString() {
		return "Settler Drills To Iron Core";
	}

}
