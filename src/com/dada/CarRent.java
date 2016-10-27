package com.dada;

import java.util.Scanner;

public class CarRent {
    public static void main(String[] args) {
        System.out.println("欢迎使用dada租车系统！");
        Car[] cars = {
                new PassengerCar("东风标致",120,5),
                new Truck("小货车",150,5),
                new PassengerCar("奔驰",160,9),
                new Pickup("皮卡",180,4,2),
                new Truck("大型货车",220,3),
                new PassengerCar("小型客车",160,9),
                new PassengerCar("宝马",200,8)
        };
        System.out.println("你是否需要租车？");
        System.out.println("是：1，否：0");
        Scanner x = new Scanner(System.in);
        int choice = x.nextInt();
        if(choice == 1){
            int totalbusload = 0;
            int totalcargocapacity = 0;
            int totalprice = 0;
            int rentday = 0;

            System.out.println("可供选择的车型如下：");
            int num = 1;
            System.out.println("序号\t"+"车名\t\t"+"日租金\t\t"+"容量");
            for(Car car:cars){
                //System.out.println("Num."+num+"\t"+car.name+"\t"+car.dailyrent+"元");//公共部分
                if (car instanceof PassengerCar){
                    System.out.println("Num."+num+"\t"+car.name+"\t"+car.dailyrent+"元"+((PassengerCar) car).busload+"人");
                    num++;
                }
                if (car instanceof Truck){
                    System.out.println("Num."+num+"\t"+car.name+"\t"+car.dailyrent+"元"+((Truck) car).cargocapacity+"吨");
                    num++;
                }
                if (car instanceof Pickup){
                    System.out.println("Num."+num+"\t"+car.name+"\t"+car.dailyrent+"元"+((Pickup) car).cargocapacity+"吨\t"+((Pickup) car).busload+"人" );
                    num++;
                }
            }
            System.out.println("请输入您需要租车的数量：");

            int count = x.nextInt();
            for (int i = 0;i < count;i++){
                System.out.println("请输入你需要租车的编号：");
                int Num = x.nextInt();
                if (cars[Num - 1] instanceof PassengerCar){
                    totalbusload += ((PassengerCar) cars[Num - 1]).busload;
                    totalprice += cars[Num - 1].dailyrent;
                }
                if (cars[Num - 1] instanceof  Pickup){
                    totalcargocapacity += ((Pickup) cars[Num - 1]).cargocapacity;
                    totalbusload += ((Pickup) cars[Num - 1]).busload;
                    totalprice += cars[Num - 1].dailyrent;
                }
                if (cars[Num - 1] instanceof Truck){
                    totalcargocapacity += ((Truck) cars[Num - 1]).cargocapacity;
                    totalprice += cars[Num - 1].dailyrent;
                }
            }
            System.out.println("请输入你需要租车的天数：");
            int days = x.nextInt();
            totalprice *= days;
            System.out.println("总载客量："+ totalbusload+"人\t"+"总载货量："  + totalcargocapacity +"吨\t"+ "\t" + "总共需要的价钱：" + totalprice + "");
        }
    }
}

class Car{
    public  String name;
    public  int dailyrent ;//日租金
}

class  Pickup extends  Car{
    public int cargocapacity;//载货量
    public int busload;//载客量
    public  Pickup(String newname ,int newdailtrent,int newcargocapacity,int newbusload){
        this.name = newname;
        this.dailyrent = newdailtrent;
        this.cargocapacity = newcargocapacity;
        this.busload = newbusload;
    }
}

class  PassengerCar extends  Car{
    public int busload;
    public  PassengerCar(String newname , int newdailtrent , int newbusload){
        this.name  = newname;
        this.dailyrent = newdailtrent;
        this.busload = newbusload;
    }
}

class Truck extends  Car{
    public int cargocapacity;
    public  Truck(String newname , int newdailtrent , int newcargocapacity){
        this.name = newname;
        this.dailyrent = newdailtrent;
        this.cargocapacity = newcargocapacity;
    }
}