import java.util.PriorityQueue;

class Student implements Comparable<Student> {
    int id;
    String name;
    double cgpa;
    Student(int id, String name, double cgpa) {
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }

    public int compareTo(Student b) {
        if (this.cgpa > b.cgpa) { return -1; }
        if (this.cgpa < b.cgpa) { return 1; }
        if (this.cgpa == b.cgpa) {
            if (this.name.compareTo(b.name) < 0 ) { return -1; }
            if (this.name.compareTo(b.name) > 0) { return 1; }
            if (this.name.compareTo(b.name) == 0) {
                if (this.id < b.id) { return -1; }
                if (this.id > b.id) { return 1; }
            }
        }
        return 0;
    }

    public String getName() {
        return name;
    }
}

class Priorities {
    Priorities() {}
    public List<Student> getStudents(List<String> events) {
        PriorityQueue<Student> queue = new PriorityQueue<Student>();
        for (int i = 0; i < events.size(); i++) {
            if (events.get(i).contains("SERVED")) {
                if (queue.size() > 0) { queue.poll(); }
            } else {
                String[] data = events.get(i).split(" ");
                queue.add(new Student(Integer.parseInt(data[3]), data[1], Double.valueOf(data[2])));
            }
        }

        List<Student> result = new ArrayList<>();
        while (queue.size() > 0) {
            result.add(queue.poll());
        }

        return result;
    }
}
