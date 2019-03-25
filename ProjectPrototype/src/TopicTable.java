import java.util.Random;
public class TopicTable {
	
	TopicEdge[] edges;
	
	public TopicTable(){
		edges=new TopicEdge[Topic.values().length]; //number of elements in the enum
	}
	
	public void addTopic(TopicNode topic){
		TopicEdge edge=new TopicEdge(topic);
		int index=CourseTable.hashF(topic.getTopic());
		edges[index]=edge;
	}
	
	public int getTopicEdgeValue(Topic topic){
		int index=CourseTable.hashF(topic);
		return edges[index].getWeight();
	}
	
	public void setTopicEdgeValue(Topic topic, int weight){
		int index=CourseTable.hashF(topic);
		edges[index].setWeight(weight);
	}
	
	public TopicNode getTopicNode(Topic topic){
		int index=CourseTable.hashF(topic);
		return edges[index].getTopicNode();
	}
	
	public TopicNode maxWeight(){
		TopicEdge max=edges[0];
		for(int i=0;i<edges.length;i++){
			if(max.getWeight()<edges[i].getWeight()){
				max=edges[i];
			}
		}
		return max.getTopicNode();
	}
	
	public TopicNode randomByPopularity(){
		int sum=0;
		int number;
		Random random=new Random();
		
		for(int i=0; i<edges.length;i++){
			sum+=edges[i].getWeight();
		}
		
		number=random.nextInt(sum+1);
		sum=0;
		
		for(int i=0; i<edges.length;i++){
			sum+=edges[i].getWeight();
			if(number<=sum){
				return edges[i].getTopicNode();
			}
		}
		

		return null;
		
	}

}
