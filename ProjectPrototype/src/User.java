import java.security.InvalidParameterException;

public class User {

    private String username; //username
    private CourseTable visited;
    private CourseTable taken;
    private TopicTable edges;

    private User(String username){
        this.username = username;
        this.visited = new CourseTable();
        this.taken = new CourseTable();
        this.edges = new TopicTable();
    }

    void addVisited(Course course){
        if(course!=null){
            visited.add(course);
        }
    }

    boolean findInVisisted(Course course){
        return visited.findCourse(course);
    }

    public void addTaken(Course course){
        taken.add(course);
    }

    private void addEdges(TopicNode topic){
        edges.addTopic(topic);
    }

    public TopicNode getTopicNode(Topic topic){
        return edges.getTopicNode(topic);
    }

    public Course recommendByPopularity(){
        return getRecommendation(edges.maxWeight().getTopic());
    }

    private Course recommendRandomByPopularity(){
        return getRecommendation(edges.randomByPopularity().getTopic());
    }

    private Course getRecommendation(Topic topic){
        return edges.getTopicNode(topic).recommend(this);
    }

    private void setEdge(Topic topic, int weight){
        edges.setTopicEdgeValue(topic, weight);
    }

    private static Course[] createUsersCourseList(String[] coursesNames, Topic[] topics) throws InvalidParameterException {
        if (coursesNames.length == topics.length) {
            int listSize = coursesNames.length;
            Course[] coursesList;
            coursesList = new Course[listSize];
            for (int i = 0; i < listSize; i++){
                coursesList[i] = new Course(coursesNames[i],topics[i]);
            }
            return coursesList;
        }
        throw new InvalidParameterException("Courses Names and Topics List do not match in length");
    }

    public static void main(String[] args){

        User mike=new User("Mike");

        String[] courseNames = {"Math", "Biology", "Calculus", "First Aid", "Python", "Java"};
        Topic[] topics = {Topic.MATH, Topic.HEALTH, Topic.MATH, Topic.HEALTH, Topic.TECHNOLOGY, Topic.TECHNOLOGY};
        Course[] coursesList;

        coursesList = createUsersCourseList(courseNames, topics);

        // Set popularity rates
        coursesList[4].setPopularity(10);
        coursesList[5].setPopularity(1);

        // Create course Table
        CourseTable coursesTable = new CourseTable();
        coursesTable.fillCourseTableWithList(coursesList);


        TopicNode tech = new TopicNode("Tech",coursesTable,Topic.TECHNOLOGY);
        TopicNode health = new TopicNode("Health",coursesTable,Topic.HEALTH);
        TopicNode mat = new TopicNode("Math",coursesTable,Topic.MATH);

        mike.addEdges(tech);
        mike.addEdges(health);
        mike.addEdges(mat);

        mike.setEdge(Topic.TECHNOLOGY, 0);
        mike.setEdge(Topic.HEALTH, 100);
        mike.setEdge(Topic.MATH, 100);

        coursesTable.sortTable();

        mike.addVisited(coursesList[0]);
        mike.addVisited(coursesList[1]);
        mike.addVisited(coursesList[2]);
        mike.addVisited(coursesList[3]);

        System.out.println(mike.findInVisisted(coursesList[0]));
        System.out.println(mike.findInVisisted(coursesList[4]));
        System.out.println(mike.getTopicNode(Topic.TECHNOLOGY).recommend(mike).getName());
    }
}
