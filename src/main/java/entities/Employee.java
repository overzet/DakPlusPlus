/**
 * The below class is just a lightweight data container with no behavior attached to it (feel free to judge me for
 * committing this cardinal sin). The only detail worth to stress here is that in order to make it persistable for Hibernate (or any other JPA implementation) it’s been marked with an @Entity annotation. In addition, Hibernate needs to know how to handle the entities’ primary keys.
 *
 * To tackle this, the @Id and @GeneratedValue(strategy = GenerationType.AUTO) annotations instruct Hibernate to automatically generate an ID for each user entity, which will be mapped to the primary key of the corresponding database entry. Finally, the @Table(name = "users") annotation tells Hibernate to map instances of the class to rows in a users table.
 */
package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "EMPLOYEE")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "AGE")
    private Integer age;

    public Employee() {
    }

    public Employee(Integer id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Employee: " + this.id + ", " + this.name + ", " + this.age;
    }

}
