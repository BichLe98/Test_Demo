package javaKeywords;

public abstract class Computer {
    // Access modifier - phạm vi truy cập
    // public - protected - default - private
    // private: 1 biến / hàm thì chỉ có class hiện tại mới sử dụng được
   private String ramName = "Kingston 8Gb";
    private void touchPC(){}
    String ssd ="EVO";
    protected  String mainName = "";
    public String lcdName = "Dell u2715";
    public void showLcdName(){}


    // Biến - Variable/Properties
    //1- biến non-static
    String fullName;
    int comSize = 15;

    //2- biến static
    // Truy cập truc tiep từ tên lớp / ko can qua instance
    // chia sẻ dữ liệu cho tất cả các luong (Thread)
    static  String cityName = "Ho Chi Minh";


    //3- biến final
    // ko muốn gán lại dữ liệu
    final String addressName ="123 Lê Lai";

    // Xét trong pham vi class
    //4- biến toàn cục - global
    // Trong 1 class thì 1 biến được gọi là toàn cục
    // Khai baso ở phạm vi class
    // Được sử dụng ở pham vi đó

    //5- biến cục bộ - local
    // Khai báo ở phạm vi: trong hàm/ tham số của hàm/ trong khối lệnh (block)
    public void printRam(String ramName){
        String hddName = "";
        for (int i = 0; i < 10; i++){
            System.out.println(i);

            System.out.println(hddName);
            System.out.println(ramName);

            if (i > 0){
                int number = 5;

                System.out.println(hddName);
                System.out.println(ramName);
            }
        }
    }

    // Hàm - Method/ Function
    // 1- hàm non-static
    // ko có tư khoa static thì gọi là non-static
    public  void showWifi(){
        System.out.println("Wifi 5");
    }

    //2- hàm static
    // Gọi ra sử dujnh ở phạm vi lớp
    public static  void showLCD(){

    }

    //3- hàm final
    // ko thể override - tính abstraction (trừu tượng)
    // ko cho phép các lớp con viết lại hàm này
    public static final void showSSD(){

    }
    //4- hàm abstract
    // Bắt buộc các lớp con phải viết lại
    // Chỉ có tên hàm/ tham số của hàm/ kiểuduwxuwx liệu trả về
    // Ko được có phần thân
    public abstract void showNetwork();

    // Áp dụng ược tính chất trừu tượng
    // Thể hiện qua abstract class và interface
    // chứa cái hàm abstract


    // Lớp - Class
    // cho phép đơn kế từa: 1 class chỉ có thể kế thừa 1 class khác
    //1- final class
    // ko cho phép bất kì lớp nào kế thừa

    //2- abstract class
    // chua cả non-abstract method và abstract method

    // 3- non-abstract class
    // Chỉ được phép chưa non-abstract method thôi

    // interface
    // chức năng giống abstract class
    // ko chứa non-abstract method giong như abstract method
    // cho phép đa kế thừa: 1 class có thể kế thừa n interface

}
