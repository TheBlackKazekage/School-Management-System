package com.company.School_Mgmt_System;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;

public class MainSchool implements Serializable {
    private static String userName;

    private static BufferedReader buffInput = null;
    private static FileOutputStream outputStaff = null;
    private static FileOutputStream outputStudent = null;

    private static FileInputStream readerStaff = null;
    private static FileInputStream readerStudent = null;

    private static ArrayList<Object> listAll = null;

    public static void main(String[] args) throws IOException {

        try{
            buffInput = new BufferedReader(new InputStreamReader(System.in));
            outputStaff = new FileOutputStream("Staff.txt", true);
            outputStudent = new FileOutputStream("Student.txt", true);

            listAll = new ArrayList<>();

            readerStaff = new FileInputStream("Staff.txt");
            readerStudent = new FileInputStream("Student.txt");

            //Prompt the user for name for tailored user experience
            System.out.print("What is your name? : ");
            userName = buffInput.readLine();


//            for(String s: readFileToArrayList()){
//                System.out.println(s);
//            }

            welcome();
            mainPage((char) buffInput.read());

        }catch(IOException e){
            System.out.println(e.getMessage());
        }finally {
            if(buffInput != null){
                buffInput.close();
            }
            if(outputStaff != null){
                outputStaff.close();
            }
            if(outputStudent != null){
                outputStudent.close();
            }
        }
    }


    //This is the system home page. It prints out instructions for the user to follow and sets up the input for the user
    private static void welcome() throws IOException {
        System.out.println("Welcome " + userName + " to the Main Page. Select the numbers to perform an action: ");
        System.out.println("1. To Update Staff Data. \n2. To View Staff Data. \n\n3. To Update Student Data. \n4. To View Student Data. \n0. to exit...");
        mainPage((char) buffInput.read());
    }

    //Collects the user's input and follows the instruction path
    private static void mainPage(char c) throws IOException {
        switch (c){
            case '1':
                updateStaffData();
                break;
            case '2':
                viewStaffData();
                break;
            case '3':
                updateStudentData();
                break;
            case '4':
                viewStudentData();
                break;
            case '0':
                System.out.println("Have a good day....");
                writeToFile();
                break;

        }
    }


    //Creates a new student object and collects the needed user data to be populated to the file
    private static void updateStudentData() throws IOException {
        System.out.println("\n1. To create new student. \n0. to return home...");
        BufferedReader buff = null;
        //ObjectOutputStream objOutStudent = null;

        try{
            buff = new BufferedReader(new InputStreamReader(System.in));
            String s = buff.readLine();
            int c = Integer.parseInt(s);
            switch (c) {
                case 1:
                    System.out.print("\nEnter student ID: ");
                    String id = buff.readLine();
                    System.out.print("Enter student course: ");
                    String course = buff.readLine();
                    System.out.print("Enter student year: ");
                    String year = buff.readLine();
                    System.out.print("Enter student grade: ");
                    String points = buff.readLine();

                    Person p = new Person();
                    System.out.print("Enter Student name: ");
                    String name = buff.readLine();
                    System.out.print("Enter Student PhoneNo: ");
                    String number = buff.readLine();
                    p.setName(name);
                    p.setPhoneNo(number);

                    Student newStudent = new Student(id, course, year, points);
                    listAll.add(newStudent);

//                    objOutStudent = new ObjectOutputStream(outputStudent);

//                    for (Object aListStudent : listStudent) {
//                        objOutStudent.writeObject(aListStudent);
//                    }


//                    objOutStudent.close();
//                    outputStudent.flush();

                    System.out.println("New Student Created...");
                    System.out.println();
                    welcome();
                    mainPage((char) buffInput.read());
                    break;

                case 0:
                    welcome();
                    mainPage((char) buffInput.read());
                    break;

            }

        }catch(IOException e){
            System.out.println(e.getMessage());
        }finally {
            if(buff != null) {
                buff.close();
            }
        }
    }

    //Creates a new staff object and collects the needed information to be saved to the file
    private static void updateStaffData() throws IOException {
        System.out.println("\n1. To create new staff member. \n0. to return home...");
        BufferedReader buff = null;

        try{
            buff = new BufferedReader(new InputStreamReader(System.in));
            String s = buff.readLine();
            int c = Integer.parseInt(s);
            switch (c) {
                case 1:
                    System.out.print("\nEnter staff ID (DEPT CODE + NO): ");
                    String id = buff.readLine();
                    System.out.print("Enter staff role: ");
                    String role = buff.readLine();
                    System.out.print("Enter staff department: ");
                    String department = buff.readLine();
                    System.out.print("Enter staff salary: ");
                    String sal = buff.readLine();
                    int salary = Integer.parseInt(sal);

                    System.out.print("Enter staff name: ");
                    String name = buff.readLine();
                    System.out.print("Enter staff phone no: ");
                    String phone = buff.readLine();
                    Person p = new Person();
                    p.setName(name);
                    p.setPhoneNo(phone);

                    Staff newStaff = new Staff(id, role, department, salary);

                    listAll.add(newStaff);

                    System.out.println("New User Created...");
                    System.out.println();

                    welcome();
                    mainPage((char) buffInput.read());
                    break;

                case 0:
                    welcome();
                    mainPage((char) buffInput.read());
                    break;
            }

        }catch (IOException e){
            e.getMessage();
        }finally {
            if (buff != null){
                buff.close();
            }
            if(buffInput != null){
                buffInput.close();
            }
        }
    }

    //Reads from the file and prints the saved staff objects
    private static void viewStaffData() throws IOException {
        try{
//            readerStaff = new FileInputStream("Staff.txt");
//
//            int c;
//            while((c = readerStaff.read()) != -1){
//                System.out.print((char)c);
//            }

//            ArrayList<Staff> li

            System.out.println();
            welcome();
            mainPage((char) buffInput.read());

        }catch (Exception e){
            System.out.println(e);
        }finally {
            if(readerStaff != null){
                readerStaff.close();
            }
        }
    }

    //Reads from the file and displays the saved student objects
    private static void viewStudentData() throws IOException {
        try{
            readerStudent = new FileInputStream("Student.txt");

            int c;
            while((c = readerStudent.read()) != -1){
                System.out.print((char)c);
            }

            System.out.println();

            welcome();
            mainPage((char) buffInput.read());

        }catch (Exception e){
            System.out.println(e);
        }finally {
            if(readerStudent != null){
                readerStudent.close();
            }
        }
    }

    private static void readFileToArrayList() throws IOException{
//        BufferedReader readerStudent = null;
//        BufferedReader readerStaff = null;

        ObjectInputStream inStudent = null;
        ObjectInputStream inStaff = null;

        try{
//            readerStudent = new BufferedReader(new FileReader("Student.txt"));
//            readerStaff = new BufferedReader(new FileReader("Staff.txt"));

//            String lineStudent;
//            while((lineStudent = readerStudent.readLine()) != null){
//                //studentList.add(lineStudent);
//            }
//
//            String lineStaff;
//            while((lineStaff = readerStaff.readLine()) != null){
//                //staffList.add(lineStaff);
//            }


            inStudent = new ObjectInputStream(readerStudent);
            inStaff = new ObjectInputStream(readerStaff);

            while(inStudent.readObject() != null){
                listAll.add(inStudent.readObject());
            }

            while(inStaff.readObject() != null){
                listAll.add(inStaff.readObject());
            }

        }catch (IOException e){
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (readerStudent != null){
                readerStudent.close();
            }
            if(readerStaff != null){
                readerStaff.close();
            }
        }
    }

    private static void writeToFile() throws IOException{
        ObjectOutputStream outStudent = null;
        ObjectOutputStream outStaff = null;
        try{
            outStudent = new ObjectOutputStream(outputStudent);
            outStaff = new ObjectOutputStream(outputStaff);

            Iterator iterator = listAll.iterator();

            while(iterator.hasNext()){
                if(iterator.next() instanceof Student){
                    outStudent.writeObject(iterator.next());
                }
                if (iterator.next() instanceof Staff){
                    outStaff.writeObject(iterator.next());
                }
            }

        }catch (IOException e){
            System.out.println(e.getMessage());
        }finally {
            if(outStaff != null){
                outStaff.close();
            }
            if(outStudent != null){
                outStudent.close();
            }
        }
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();

        buffInput.close();
        outputStaff.close();
        outputStudent.close();
        readerStaff.close();
        readerStudent.close();
    }
}
