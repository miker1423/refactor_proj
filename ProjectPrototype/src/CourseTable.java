

public class CourseTable {
	
	CourseList[] courseTable;
	
	public CourseTable(){

		this.courseTable=new CourseList[Topic.values().length];
		
		for(int i=0;i<this.courseTable.length;i++){
			this.courseTable[i]=new CourseList();
		}
	}
	
	//function to decide where to hash each course
	public static int hashF(Course course){

		return CourseTable.hashF(course.getTopic());
		
	}
	
	//Overload
	public static int hashF(Topic topic){
		return topic.ordinal();
	}
	
	//adds a course to the table
	public void addCourseToTable(Course course){
		
		int index=CourseTable.hashF(course);
		
		if(this.courseTable[index]==null){
			this.courseTable[index]=new CourseList();
		}
		this.courseTable[index].addCourse(course);
		
	}
	
	//erase this later
	public CourseList[] getTable(){
		return this.courseTable;
	}
	
	//returns true if the course is in the table, false if it isn't 
	public boolean findCourse(Course course){
		int index= CourseTable.hashF(course);
		return this.courseTable[index].findCourse(course);
		
	}
	
	//sorts every courseList in the array
	public void sortTable(){
		for (int i=0;i<this.courseTable.length;i++){
			this.courseTable[i].sortList();
		}
	}
}
