package cn.xf._04Collection_Map.collection.set;

import org.junit.Test;

import java.util.HashSet;
import java.util.Objects;

import static java.util.Objects.hash;

public class HashSet_ {
    @Test
    public  void function1() {
        HashSet<Object> hashSet = new HashSet<>();
        hashSet.add(125);
        hashSet.add(12);
        Student student1 = new Student(12);
        Student student2 = new Student(12);
        hashSet.add(student1);
        hashSet.add(student2);
        System.out.println(hashSet);
        System.out.println(student1.hashCode());
        System.out.println(student2.hashCode());
    }
    class Student{
        private Integer id;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public Student(){

        }

        public Student(Integer id) {
            this.id = id;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "id=" + id +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Student student = (Student) o;
            return Objects.equals(id, student.id);
        }

        @Override
        public int hashCode() {
            return hash(id);
        }
    }

}
