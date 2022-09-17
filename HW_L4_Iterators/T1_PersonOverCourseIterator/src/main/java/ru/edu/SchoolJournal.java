package ru.edu;

import java.util.*;
import java.util.stream.Collectors;

/**
 * School journal.
 */
public class SchoolJournal {

    private class PersonIteratorOverCourse implements Iterator<Person> {

        int index;
        int courseNumber;

        public PersonIteratorOverCourse(int courseNumber) {
            this.courseNumber = courseNumber;
            persons = persons.stream()
                    .filter(e -> e.getCourse() == courseNumber)
                    .collect(Collectors.toList());
            index = -1;
        }

        @Override
        public boolean hasNext() {
            if (index + 1 < persons.size()) {
                return persons.get(index + 1)
                        .getCourse() == courseNumber;
            } else return false;
        }

        @Override
        public Person next() {
            if (hasNext()) {
                index++;
                return persons.get(index);
            } else {
                throw new NoSuchElementException();
            }
        }

        @Override
        public void remove() {
            if (persons.size() == 0) {
                throw new IllegalStateException();
            }
            persons.remove(index);
            index--;
        }
    }

    private List<Person> persons;

    public SchoolJournal() {
        this.persons = new ArrayList<>();
    }

    public List<Person> getPersons() {
        return persons;
    }

    public void addPerson(Person person) {
        persons.add(person);
    }

    public Iterator<Person> courseIterator(int courseNumber) {
        return new PersonIteratorOverCourse(courseNumber);
    }
}
