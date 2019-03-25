

public class CourseTable {
	
	CourseList[] table;
	
	public CourseTable(){
		table=new CourseList[Topic.values().length];
		
		for(int i=0;i<table.length;i++){
			table[i]=new CourseList();
		}
	}
	
	//function to decide where to hash each course
	public static int hashF(Course course){

		if (course.getTopic()==Topic.TECHNOLOGY){
			return 0;
		}
		else if(course.getTopic()==Topic.HEALTH){
			return 1;
		}
		else {
			return 2;
		}
		
	}
	
	public static int hashF(Topic topic){

		if (topic==Topic.TECHNOLOGY){
			return 0;
		}
		else if(topic==Topic.HEALTH){
			return 1;
		}
		else {
			return 2;
		}
		
	}
	
	//adds a course to the table
	public void add(Course course){
		
		int index=hashF(course);
		
		if(table[index]==null){
			table[index]=new CourseList();
		}
		table[index].add(course);
		
	}
	
	//erase this later
	public CourseList[] getTable(){
		return table;
	}
	
	//returns true if the course is in the table, false if it isn't 
	public boolean findCourse(Course course){
		int index= hashF(course);
		return table[index].find(course);
		
	}
	
	//sorts every courseList in the array
	public void sortTable(){
		for (int i=0;i<table.length;i++){
			table[i].sortList();
		}
	}
}
