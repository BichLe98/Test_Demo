package javaBasic;

import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.ArrayList;
import java.util.List;

public class Topic_01_DataType {
    // Nguyên thủy (Primitive Type)
    // Number
    // Nguyên
    // byte/ short/int/long
    byte bNumber = 100;
    short sNumber = 1000;
    int iNumber = 10000;
    long lNumber = 100000;

    // Thực
    // float/ double
    float fNumber = 35.5f;
    double dNumber = 26.8d;

    // Boolean
    // boolean
    boolean status = true;


    // Character
    //char
    char c ='B';

    // Tham chiếu (Reference Type)
    // String/ Array/ Class/..
    String studentAdress = "15 Duy Tân";

    // Array : khi khai báo bắt buộc gán dữ liệu cho nó
    String[] students = {"Nguyễn Du","Nguyễn Dữ"};
    int[] studentPhong = {987373655, 376363635};

    // Array List: linh động hơn có thể thêm sửa xóa được
    List<String> studentAccount = new ArrayList<String>();

    FirefoxDriver firefoxDriver = new FirefoxDriver();

    // khai báo biến
    // 1- Access Modifier: public private protected default
    // 2- Data Type
    // 3- Variable Name: lower Camel Case (quy tắc chung: từ đầu viết thường, các từ tiếp theo viết hoa chữ cái đầu tiên)
    // 4- Variable Value
    // = gán dữ liệu cho biến
    public String studentName = "Nguyễn Văn Bảo";

}
