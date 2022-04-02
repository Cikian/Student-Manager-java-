package com.Student;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentManager {
    //main函数
    public static void main(String[] args) {
        //创建存储学生对象的集合
        ArrayList<Student> array = new ArrayList<>();

        //主界面
        while (true) {
            System.out.println("--------欢迎来到学生管理系统--------");
            System.out.println("- 1 添加学生                     -");
            System.out.println("- 2 删除学生                     -");
            System.out.println("- 3 修改学生                     -");
            System.out.println("- 4 查看所有学生                  -");
            System.out.println("- 5 退出                         -");
            System.out.println("--------------------------------");
            System.out.println("**请输入序号选择功能**");
            Scanner scanner = new Scanner(System.in);

            //获取键盘输入序号
            String line = scanner.nextLine();

            //选择功能
            switch (line) {
                case "1":
                    System.out.println("-----请按照提示输入以下信息-----");
                    addStudent(array);
                    break;
                case "2":
                    deleteStudent(array);
                    break;
                case "3":
                    updateStudent(array);
                    break;
                case "4":
                    findAllStudent(array);
                    break;
                case "5":
                    System.out.println("谢谢使用！");
                    System.exit(0); //JVM退出
            }
        }


    }

    //定义添加学生的方法
    public static void addStudent(ArrayList<Student> array) {
        //键盘录入
        Scanner sc = new Scanner(System.in);
        String id;
        //输入学号，并判断是否已经存在
        while (true) {
            System.out.println("请输入学生学号：");
            id = sc.nextLine();
            if (id.equals("quit")){
                System.out.println("操作取消，程序退出");
                System.exit(0);
            }
            boolean flag = isIdUsed(array, id);
            if (flag) {
                System.out.println("学号" + id + "已存在，请重新输入,或者输入“quit”退出");
            }else{
                break;
            }
        }
        System.out.println("请输入学生姓名：");
        String name = sc.nextLine();
        System.out.println("请输入学生年龄：");
        String age = sc.nextLine();
        System.out.println("请输入学生地址：");
        String address = sc.nextLine();
        //创建学生对象
        Student s = new Student();
        s.setId(id);
        s.setName(name);
        s.setAge(age);
        s.setAddress(address);
        //将学生对象添加到集合
        array.add(s);
        System.out.println("添加成功");

    }

    //判断添加学生的学号是否存在
    public static boolean isIdUsed(ArrayList<Student> array, String id) {
        boolean flag = false;

        for (int i = 0; i < array.size(); i++) {
            Student s = array.get(i);
            if (s.getId().equals(id)) {
                flag = true;
                break;
            }
        }

        return flag;
    }

    //定义查看所有学生的方法
    public static void findAllStudent(ArrayList<Student> array) {
        //判断学生集合是否为空
        if (array.size() == 0) {
            System.out.println("**********无学生信息**********");
        } else {
            //显示表头
            System.out.println("学号\t\t\t\t姓名\t\t年龄\t\t地址");
            //查看所有学生
            for (int i = 0; i < array.size(); i++) {
                Student s = array.get(i);
                System.out.println(s.getId() + "\t" + s.getName() + "\t" + s.getAge() + "岁\t" + s.getAddress());
            }
        }
    }

    //定义删除学生的方法
    public static void deleteStudent(ArrayList<Student> array) {
        Scanner sc = new Scanner(System.in);
        System.out.println("---请输入要删除的学生的学号---");
        String id = sc.nextLine();
        //判断输入的学号是否存在
        int index = -1;
        for (int i = 0; i < array.size(); i++) {
            Student s = array.get(i);
            if (s.getId().equals(id)) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            System.out.println("***不存在学号为" + id + "的学生***");
        } else {
            //执行删除操作
            System.out.println("**请确认学生信息，输入 1 确认删除，输入 0 返回**");
            System.out.println(array.get(index).getId() + "\t" + array.get(index).getName() + "\t" + array.get(index).getAge() + "\t" + array.get(index).getAddress());
            String flag = sc.nextLine();
            if (flag.equals("1")) {
                array.remove(index);
                System.out.println("删除成功");
            } else {
                System.out.println("取消操作");
            }
        }
    }

    //定义修改学生的方法
    public static void updateStudent(ArrayList<Student> array) {
        Scanner sc = new Scanner(System.in);
        System.out.println("---请输入要修改的学生的学号---");
        String id = sc.nextLine();
        //判断输入的学号是否存在
        int index = -1;
        for (int i = 0; i < array.size(); i++) {
            Student s = array.get(i);
            if (s.getId().equals(id)) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            System.out.println("***不存在学号为" + id + "的学生***");
        } else {
            //执行修改操作
            System.out.println("---请输入学生姓名---");
            String name = sc.nextLine();
            System.out.println("---请输入学生年龄---");
            String age = sc.nextLine();
            System.out.println("---请输入学生地址---");
            String address = sc.nextLine();
            //创建一个新的学生对象
            Student s = new Student();
            s.setId(id);
            s.setName(name);
            s.setAge(age);
            s.setAddress(address);
            for (int i = 0; i < array.size(); i++) {
                Student stu = array.get(i);
                if (stu.getId().equals(id)) {
                    //确认是否修改
                    System.out.println("**请确认学生信息，输入 1 确认删除，输入 0 返回**");
                    System.out.println("修改前：" + array.get(i).getId() + "\t" + array.get(i).getName() + "\t" + array.get(i).getAge() + "\t" + array.get(i).getAddress());
                    System.out.println("-          ↓          -");
                    System.out.println("修改后：" + id + "\t" + name + "\t" + age + "\t" + address);
                    String flag = sc.nextLine();
                    if (flag.equals("1")) {
                        array.set(i, s);
                        System.out.println("修改成功");
                        break;
                    } else {
                        System.out.println("取消操作");
                        break;
                    }
                }
            }
        }
    }
}
