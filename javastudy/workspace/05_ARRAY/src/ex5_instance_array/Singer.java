package ex5_instance_array;

public class Singer {

	private String name;
	private Song[] songs;
	private int idx;
	
	public Singer(String name, int songCount) {
		this.name = name;
		songs = new Song[songCount];    //Song배열의 길이가 songCount 
	}
	
	
	// 노래 추가 
	public void addsong(Song song) {
		if(idx == songs.length) {
			System.out.println("Full!");
		         return;
		}
		
		songs[idx] = song;
		idx++;
	}
	
	
/*	  리턴없는 버전 => but 실무에선 리턴있는 버전으로 만듦(else 지양)
 *     if(idx == songs.length) {
		System.out.println("Full!");
      } else
        songs[idx++] = song;	
*/
	
	
	
	//노래 제거
	public void deleteSong(String title) {
		if(idx == 0) {
			System.out.println("Empty");
			return;
		} 
		for(int i=0; i<idx; i++) {
			if(songs[i].getTitle().equals(title)) {
		         for(int j=i+1; j<idx; j++) {
		        	 songs[j-1] = songs[j];
		         }songs[--idx] = null;
		  }   
	  }		
 }
	
	//가수 정보
	public void singerinfo() {
		System.out.println("가수 이름 : "+name );
		System.out.println("======== 노래목록 ========");
		for(int i =0; i<idx; i++) {
			songs[i].songinfo();
		}
	} 

	
	
	
	
} //end of class
