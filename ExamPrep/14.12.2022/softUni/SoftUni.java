package softUni;

import java.util.ArrayList;
import java.util.List;

public class SoftUni {
    private int capacity;
    private List<Student> data;

    public SoftUni(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public int getCapacity() {
        return capacity;
    }

    public int getCount() {
        int count = 0;
        if (!data.isEmpty()) {
            count = data.size();
        }
        return count;
    }

    public String insert(Student studentToInsert) {
        String result = "";
        if (capacity <= getCount()) {
            result = "Tha hall is full.";
        } else {
            if (!data.contains(studentToInsert)) {
                data.add(studentToInsert);
                result = String.format("Added student %s %s.",
                        studentToInsert.getFirstName(), studentToInsert.getLastName());
            } else {
                result = "Student is already in the hall.";
            }
        }
        return result;
    }

    public String remove(Student studentToRemove) {
        String result = "";
        if (data.contains(studentToRemove)) {
            data.remove(studentToRemove);
            result = String.format("Removed student %s %s.",
                    studentToRemove.getFirstName(), studentToRemove.getLastName());
        } else {
            result = "Student not found.";
        }
        return result;
    }

    public Student getStudent(String firstName, String lastName) {
        Student studentToGet = null;

        for (Student student : data) {
            if (student.getFirstName().equals(firstName) &&
                    student.getLastName().equals(lastName)) {
                studentToGet = student;
                break;
            }
        }

        return studentToGet;
    }


    public String getStatistics() {
        StringBuilder result = new StringBuilder();

        result.append(String.format("Hall size: %d", getCount())).append(System.lineSeparator());
        for (Student student : data) {
            result.append(student.toString()).append(System.lineSeparator());
        }
        return result.toString();
    }
}
