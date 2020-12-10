
public class CourseDBElement implements Comparable{

	String courseId;
    int CRN;
    int creditNum;
    String room;
    String instructor;
    
    public CourseDBElement() {
    }
    
    public CourseDBElement(String courseId, int CRN, int creditNum, String room, String instructor) {
    	this.courseId = courseId;
        this.CRN = CRN;
        this.creditNum = creditNum;
        this.room = room;
        this.instructor = instructor;
    }

	public String getCourseId() {
		return courseId;
	}

	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}

	public int getCourseNum() {
		return CRN;
	}

	public void setCourseNum(int CRN) {
		this.CRN = CRN;
	}

	public int getCreditNum() {
		return creditNum;
	}

	public void setCreditNum(int creditNum) {
		this.creditNum = creditNum;
	}

	public String getRoom() {
		return room;
	}

	public void setRoom(String room) {
		this.room = room;
	}

	public String getInstructor() {
		return instructor;
	}

	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}

	public int compareTo(CourseDBElement element) {
		if (this.CRN < element.CRN)
            return -1;
        else if (this.CRN > element.CRN)
            return 1;
        else
            return 0;
	}
	
	 public int hashCode() {
		String crn = Integer.toString(CRN);
		int hashCode = crn.hashCode();
	    return hashCode;
	}
	 
    public void setCRN(int crn) {
    	this.CRN = crn;
	}
	
    public String toString() {
		return "\nCourse: " + courseId + " CRN: " + CRN + " Credits: " + creditNum + " Instructor: " + instructor + " Room: " + room;
	}
}
