package entities;

import main.Status;

public class Soldier {
    private String cpf;
    private String name;
    private String city;

    private int age;
    private double height;
    private double weight;

    private Status status;

    public Soldier(){

    }

    public Soldier(String cpf, String name, String city, int age, double height, double weight){
        this.cpf = cpf;
        this.name = name;
        this.city = city;
        this.age = age;
        this.height = height;
        this.weight = weight;

        status = Status.ALIVE;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public String toString(){
        return  "------------------\n" +
                "CPF: " + getCpf() + ", " + getName() + "\n" +
                "Hometown: " + getCity() + ", Status: " + getStatus() + "\n" +
                "Age: " + getAge() + ", Height: " + getHeight() + ", Weight: " + getWeight();
    }
}
