package ex5_instance_array;

public class Song {
	
	private String title;
	private String genre;
	private double playTime;
	
	
	public Song(String title, String genre, double playtime) {
		super();
		this.title = title;
		this.genre = genre;
		this.playTime = playtime;
	}
	
	

	public void songinfo() {
		System.out.println(title + "("+ genre+"), "+playTime +"second");
	}
	

	public String getTitle() {
		return title;
	}

	public String getGenre() {
		return genre;
	}


	public void setGenre(String genre) {
		this.genre = genre;
	}


	public double getPlayTime() {
		return playTime;
	}


	public void setPlayTime(double playTime) {
		this.playTime = playTime;
	}



	public void setTitle(String title) {
		this.title = title;
	}	
}
