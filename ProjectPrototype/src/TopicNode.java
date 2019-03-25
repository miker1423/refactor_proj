
public class TopicNode {
	
	private String name;
	private int popularity;
	private CourseTable courses;
	private int index; //this index is used to access the hash table
	private Topic topic;
	
	public TopicNode(String name, CourseTable courses,Topic topic){
		this.name=name;
		this.courses=courses;
		this.topic=topic;
		index=courses.hashF(topic);
	}
	
	public int getPopularity(){
		return popularity;
	}
	
	public void increasePopularity(int increase){
		popularity+=increase;
	}
	
	public Course recommend(User user){
		CourseNode recommendation=courses.getTable()[this.index].getFront();
		while(recommendation!=null){
			if (!user.findInVisisted(recommendation.getCourse())){
				user.addVisited(recommendation.getCourse());
				return recommendation.getCourse();
			}
			else {recommendation=recommendation.getNext();}
		}
		
		return null;
	}
	
	public Topic getTopic(){
		return topic;
	}

}
