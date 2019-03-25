
public class TopicEdge {
	
	private TopicNode topic;
	private int weight;
	
	public TopicEdge(TopicNode topic){
		this.topic=topic;
		this.weight=0;
	}
	
	public int getWeight(){
		return weight;
	}
	
	public void setWeight(int edge){
		this.weight=edge;
	}

	public TopicNode getTopicNode(){
		return topic;
	}
}
