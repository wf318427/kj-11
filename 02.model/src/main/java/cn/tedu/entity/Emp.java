package cn.tedu.entity;

import org.springframework.stereotype.Component;

import java.io.Serializable;
public class Emp implements Serializable{
  private Long id;
  private String name;
  private Long age;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Long getAge() {
    return age;
  }

  public void setAge(Long age) {
    this.age = age;
  }

  @Override
  public String toString() {
    return "Emp{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", age=" + age +
            '}';
  }

  private  void ff(Object o){

    System.out.println(o);
  }
  public  void gg(Object o){
    ff(o);
    System.out.println(o);
  }

  public static void main(String[] args) {
    new Emp().gg("aa");
  }
}
