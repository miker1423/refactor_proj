
public class CourseNode {
	
	private Course course;
	private CourseNode next;
	
	public CourseNode(Course course){
		this.course=course;
		next=null;
	}
	
	public Course getCourse(){
		return course;
	}
	
	public void setNext(CourseNode next){
		this.next=next;
	}
	
	public CourseNode getNext(){
		return next;
	}

}
