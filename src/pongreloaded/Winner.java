package pongreloaded;

/**
 * @author Mcat12
 */
public class Winner {
	private String name;
	private int score;
	
	public Winner() {}
	
	public Winner(String name, int score) {
		this.name = name;
		this.score = score;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getScore() {
		return score;
	}
	
	public void setScore(int score) {
		this.score = score;
	}
	
	public String toString() {
		return "Name: " + name +
			   " Score: " + score;
	}
}
