package javaBasic;

import java.util.ArrayList;
import java.util.List;

public class Topic_06_Loop {
    static void main(String[] args){
        // Trong trường hợp mnh cần duyệt qua 1 danh sách dữ liệu
        // Duyệt qua hết toàn bộ
        // Gặp 1 điều kiện thỏa mãn thì dừng lại
        // kết hợp cả vòng lặp với điều kiện
        int employeeSize = 100;
        // for (classic)
        for (int i = 0; i < employeeSize; i ++){
            System.out.println(" Nhân viên thứ " + i);
        }
        List<String> productName = new ArrayList<>();
        productName.add("Apple iCan");
        productName.add("HTC smartphone");
        productName.add("HTC One Mini Blue");
        productName.add("Nokia Lumia 1020");
        productName.add("Apple iPhone 16 128GB");
        for (int i = 0; i < productName.size(); i++) {
            if (productName.get(i).equals("Nokia Lumia 1020")){
                System.out.println("Click to Edit icon");
            }
           // System.out.println(productName.get(i));
        }
        // for-each
        for (String name : productName){
            if (name.equals("Nokia Lumia 1020")){
                System.out.println("Click to Edit icon");
            }
           // System.out.println(name);
        }
        // while
        employeeSize = 10;
        int x = 1;
        while (x < employeeSize){
            System.out.println(" Nhân vin thứ" + x);
            x++;
        }
        // do - while
        int y = 1000;
        do {
            System.out.println("Nhân vin thứ" + y);
            y++;
        } while (y <= employeeSize);

    }
}
