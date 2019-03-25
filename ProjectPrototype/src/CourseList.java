import java.util.Arrays;
public class CourseList {
	
	private CourseNode front;
	
	
	public CourseList(){
		front=null;
	}
	
	//adds a course to the table
	public void add(Course course){
		CourseNode node=new CourseNode(course);
		if(front!=null){
			node.setNext(front);
		}
		front=node;
		
		
	}
	
	//finds if there is or not any node with the given course inside
	public boolean find(Course course){
		CourseNode myNode=front;
		while(myNode!=null){
			if(myNode.getCourse()==course){
				return true;
			}
			myNode=myNode.getNext();
		}
		return false;
	}
	
	//returns the front of the node 
	public CourseNode getFront(){
		return front;
	}
	
	//sorts the sortLIst based on the popularity of the course
	public void sortList(){
		Course[] courses=createArray();
		insertionSort(courses);
		//Arrays.sort(courses);
		recreateList(courses);
		
	}
	
	//creates an array based on the elements of the list, helper method
	private Course[] createArray(){
		int count=0; //counts the number of elements in the list
		CourseNode node=front;
		
		//count the element on the list
		while(node!=null){
			count++;
			node=node.getNext();
		}
		
		Course[] courses=new Course[count]; //creates the array with the elements on the list
		node=front;
		//insert the elements
		for(int i=0;i<courses.length;i++){
			courses[i]=node.getCourse();
			node=node.getNext();
		}
		return courses;
	}
	
	//recreates the list based on the array, helper method
	private void recreateList(Course[] courses){
		CourseNode node=new CourseNode(courses[0]);
		for(int i=0;i<courses.length;i++){
			
			if(i==0){
				front=node;
			}
			else{
				node.setNext(new CourseNode(courses[i]));
				node=node.getNext();
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
