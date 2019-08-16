class RunPMC {
	public static void main(String[] args) {
		Animal[] river_environment = new Animal[]{ new Salmon(), new Eagle};
		for (Animal creature: river_environment) {
			String result;
			if (creature.isPrey()) {
				result = (creature.flight()) ? "You lived, congrats." : "You're stuck here."
				System.out.println(result);
			} else {
				result = (creature.fight()) ? "You eating tonight" : "A swing and a miss."
				System.out.println(result);
			}
		}
	}
}
interface Animal {
	public boolean isPrey();
	public boolean fight();
	public boolean flight();
}
class Salmon implements Animal {
	public boolean isPrey() {
		return true;
	}
	public boolean fight() {
		return false; // measure odds and strength, returning true if winner
	}
	public boolean flight() {
		return true; // measure strength and survival skills, returning true if escaped
	}
}
class Eagle implements Animal {
	public boolean isPrey() {
		return false;
	}
	public boolean fight() {
		return true; // measure odds and strength, returning true if winner
	}
	public boolean flight() {
		return true; // measure strength and survival skills, returning true if escaped
	}
}
