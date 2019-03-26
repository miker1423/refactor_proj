import java.util.Random;
public class TopicTable {
	
	TopicEdge[] topicEdges;
	
	public TopicTable(){
		topicEdges = new TopicEdge[Topic.values().length]; //number of elements in the enum
	}
	
	public void addTopic(TopicNode topic){
		TopicEdge edge = new TopicEdge(topic);
		int index = CourseTable.hashF(topic.getTopic());
		topicEdges[index]=edge;
	}
	
	public int getTopicEdgeValue(Topic topic){
		int index = CourseTable.hashF(topic);
		return topicEdges[index].getWeight();
	}
	
	public void setTopicEdgeValue(Topic topic, int weight){
		int index = CourseTable.hashF(topic);
		topicEdges[index].setWeight(weight);
	}
	
	public TopicNode getTopicNode(Topic topic){
		int index = CourseTable.hashF(topic);
		return topicEdges[index].getTopicNode();
	}
	
	public TopicNode maxWeight(){
		TopicEdge max = topicEdges[0];

		for(TopicEdge edge : topicEdges){
			if(max.getWeight() < edge.getWeight()){
				max = edge;
			}
		}

		return max.getTopicNode();
	}
	
	public TopicNode randomByPopularity(){
		int upperLimit = getUpperLimit();
		Random random = new Random();
		int number = random.nextInt(upperLimit);
		
		int sum = 0;
		TopicNode result = null;
		for(TopicEdge edge : topicEdges){
			sum += edge.getWeight();
			if(number <= sum){
				result = edge.getTopicNode();
				break;
			}
		}

		return result;
	}

	private int getUpperLimit(){
		int sum = 0;
		for(TopicEdge edge : topicEdges)
			sum += edge.getWeight();
		
		return sum + 1;
	}

}
