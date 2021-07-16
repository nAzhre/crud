package com.company;
import java.io.*;
import java.util.*;
import java.io.FileWriter;
import java.io.FileReader;
class Main{
    public static List<Person> parseFileToObjList()  throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream("people.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        List<Person> persons = (Arrays.asList((Person[])objectInputStream.readObject()));
        return persons;
    }

    public static Person createNewPerson(){
        Scanner sc = new Scanner(System.in);
        Person person = new Person();
        System.out.print("Введите имя нового пользователя: ");
        person.setName(sc.next());
        System.out.println();
        System.out.print("Введите возраст нового пользователя: ");
        person.setAge(sc.nextInt());
        return person;
    }

    public static List<Person> serializePerson(List<Person> arr) throws IOException{
        Person person = createNewPerson();
        arr.add(person);
        FileOutputStream outputStream = new FileOutputStream("people.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        objectOutputStream.writeObject(arr);
        System.out.println("Запись выполнена успешно!");
        return arr;
    }

    public static List<Person> getAllPersons()throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream("people.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        List<Person> persons = (Arrays.asList((Person[])objectInputStream.readObject()));
        return persons;
    }
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        boolean active = true;
        List<Person> arr = getAllPersons();
        Scanner sc1 = new Scanner(System.in);
        while (active){
            System.out.println("Введите опцию\n[1] - создать нового пользователя\n[2] - десериализовать всех пользователей из people.txt");
            int inst = sc1.nextInt();
            if (inst==1){
                arr = serializePerson(arr);
            }
            else if (inst==2){
                System.out.println(parseFileToObjList());
            }
            
        }
    }
}