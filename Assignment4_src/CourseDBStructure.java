import java.io.IOException;
import java.util.LinkedList;

public class CourseDBStructure implements CourseDBStructureInterface {
	public LinkedList<CourseDBElement>[] hashTable;

	@SuppressWarnings("unchecked")
	public CourseDBStructure(int numberOfCourses) {
        hashTable = new LinkedList[numberOfCourses];
    }
	
	
	@Override
	public void add(CourseDBElement element) {
		int hashCode = element.hashCode();
        int index = hashCode%hashTable.length;
        
        if (hashTable[index] == null){
            hashTable[index] = new LinkedList<CourseDBElement>();
            hashTable[index].add(element);
        }else {
        	hashTable[index].add(element);
        }
	}

	@Override
	public CourseDBElement get(int crn) throws IOException {
		 String stringCRN = Integer.toString(crn);
		 int hashCode = stringCRN.hashCode();
	     int index = hashCode%hashTable.length;
	     
	     
	     
	     
		return null;
	}

	@Override
	public int getTableSize() {
		return hashTable.length;
	}
	
}