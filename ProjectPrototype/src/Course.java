
public class Course implements Comparable<Course>{
	
	private String name; //used to define the name of the course
	private String description; //a description of the course
	private Topic topic; //topic of the course (enum)
	private int popularity; //popularity of this course
	//add url attribute
	
	public Course(String name, Topic topic){
		this.name=name;
		this.topic=topic;
	}
	
	//Necessary setters and getters
	
	public void setDescription(String description){
		this.description=description;
	}
	
	public String getName(){
		return name;
	}
	
	public String getDescription(){
		return description;
	}
	
	public Topic getTopic(){
		return topic;
	}
	
	public void setPopularity(int popularity){
		this.popularity=popularity;	
	}
	
	public int getPopularity(){
		return popularity;
	}

	@Override
	public int compareTo(Course other) {
		if(this.popularity>other.getPopularity()){
			return -1;
		}
		else if(this.popularity==other.getPopularity()){
			return 0;
		}
		else{
			return 1;
		}
		
	}
	
	

}
