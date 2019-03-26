
public class User {
	
	private String username; //username
	private CourseTable visited;
	private CourseTable taken;
	private TopicTable edges;
	
	public User(String username){
		this.username=username;
		visited=new CourseTable();
		taken=new CourseTable();
		edges=new TopicTable();
	}
	
	public void addVisited(Course course){
		if(course!=null){
			visited.addCourseToTable(course);
		}
		
	}
	
	public boolean findInVisisted(Course course){
		return visited.findCourse(course);
	}
	
	public void addTaken(Course course){
		taken.addCourseToTable(course);	
	}
	
	public void addEdges(TopicNode topic){
		edges.addTopic(topic);
	}
	
	public TopicNode getTopicNode(Topic topic){
		return edges.getTopicNode(topic);
	}
	
	public Course recommendByPopularity(){
		return getRecommendation(edges.maxWeight().getTopic());
	}
	
	//recommends randomly based on popularity
	public Course recommendRandom(){
		return getRecommendation(edges.randomByPopularity().getTopic());
	}
	
	public Course getRecommendation(Topic topic){
		return edges.getTopicNode(topic).recommend(this);
	}
	
	public void setEdge(Topic topic,int weight){
		edges.setTopicEdgeValue(topic, weight);
	}
	

	public static void main(String[] args){
		
		User mike=new User("Mike");
		
		Course math=new Course("Math",Topic.MATH);
		Course biology=new Course("Biology",Topic.HEALTH);
		Course calculus=new Course("Calculus",Topic.MATH);
		Course firstAid=new Course("Firt Aid",Topic.HEALTH);
		Course python=new Course("Python",Topic.TECHNOLOGY);
		Course java=new Course("Java",Topic.TECHNOLOGY);
		
		CourseTable courses=new CourseTable();
		
		courses.addCourseToTable(math);
		courses.addCourseToTable(biology);
		courses.addCourseToTable(calculus);
		courses.addCourseToTable(firstAid);
		courses.addCourseToTable(python);
		courses.addCourseToTable(java);
		
		python.setPopularity(10);
		java.setPopularity(1);
		
		
		TopicNode tech=new TopicNode("Tech",courses,Topic.TECHNOLOGY);
		TopicNode health=new TopicNode("Health",courses,Topic.HEALTH);
		TopicNode mat=new TopicNode("Math",courses,Topic.MATH);
		
		mike.addEdges(tech);
		mike.addEdges(health);
		mike.addEdges(mat);
		
		mike.setEdge(Topic.TECHNOLOGY, 100);
		mike.setEdge(Topic.HEALTH, 0);
		mike.setEdge(Topic.MATH, 100);
		
		
		courses.sortTable();
		
		mike.addVisited(math);
		mike.addVisited(biology);
		mike.addVisited(calculus);
		mike.addVisited(firstAid);
		
		System.out.println(mike.findInVisisted(math));
		System.out.println(mike.findInVisisted(python));
		
		System.out.println(mike.getTopicNode(Topic.TECHNOLOGY).recommend(mike).getName());
		
		//System.out.println(mike.getTopicNode(Topic.TECHNOLOGY).recommend(mike).getName());
	}

}
