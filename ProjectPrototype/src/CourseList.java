import java.util.Arrays;
public class CourseList {
	
	private CourseNode front;
	
	
	public CourseList(){
		this.front=null;
	}
	
	//adds a course to the table
	public void addCourse(Course course){
		CourseNode node=new CourseNode(course);
		if(this.front!=null){
			node.setNext(this.front);
		}
		this.front=node;
		
		
	}
	
	//finds if there is or not any node with the given course inside
	public boolean findCourse(Course course){
		CourseNode current=this.front;
		while(current!=null){
			if(current.getCourse()==course){
				return true;
			}
			current=current.getNext();
		}
		return false;
	}
	
	//returns the front node 
	public CourseNode getFront(){
		return this.front;
	}
	
	//sorts the sortLIst based on the popularity of the course
	public void sortList(){
		Course[] courses=createArrayFromList();
		insertionSort(courses);
		//Arrays.sort(courses);
		recreateList(courses);
		
	}
	
	//creates an array based on the elements of the list, helper method
	private Course[] createArrayFromList(){
		
		int count=listLength(); 
		
		Course[] courses=generateArrayWithLength(count);

		return courses;
	}

	private int listLength(){
		CourseNode current=this.front;
		int count=0;
		
		while(current!=null){
			count++;
			current=current.getNext();
		}

		return count;
	}

	private Course[] generateArrayWithLength(int length){

		Course[] courses=new Course[length]; //creates the array with the elements on the list
		CourseNode current=this.front;

		//insert the elements
		for(int i=0;i<courses.length;i++){
			courses[i]=current.getCourse();
			current=current.getNext();
		}

		return courses;
	}
	
	//recreates the list based on an array, helper method
	private void recreateList(Course[] courses){

		CourseNode current=new CourseNode(courses[0]);

		for(int i=0;i<courses.length;i++){
			
			if(i==0){
				this.front=current;
			}
			else{
				current.setNext(new CourseNode(courses[i]));
				current=current.getNext();
			}
		}
	}
	
	private void insertionSort(Course[] courses){
		
		for (int i=1;i<courses.length;i++){
			Course key=courses[i];
			int j=i-1;
			while(j>=0 && courses[j].compareTo(key)>0){
				courses[j+1]=courses[j];
				j=j-1;
			}
			courses[j+1]=key;
		}
	}
	
	

}
