package javaBasic;

public class Topic_05_Condition {
    static void main(String[] args) {
        String fullName = "Nguyễn Văn A";
        // if - chỉ có 1 điều kiện
        if (fullName.equals("Nguyễn Văn A")) {
            System.out.println("Tôi là học sinh được chọn !!!");
        }
        // if - else
        // chỉ có 2 điều kiện
        String browserName = "chromium";
        if (browserName.equals("Chromium")) {
            System.out.println("Init Chrome or Edge browser");
        } else {
            System.out.println("Init Firefox or Safari");
        }
        // if - else - if - else
        // A ->= 8.5
        // B - 7.5-8.4
        // C -5.5 - 7.4
        // D -< 5.5
        float point = 7.6f;
        if (point >= 8.5) {
            System.out.println("Điểm A");
        } else if (point < 8.5 && point >= 7.5) {
            System.out.println("Điểm B");
        } else if (point < 7.4 && point >= 5.5) {
            System.out.println("Điểm C");
        } else {
            System.out.println("Điểm D");
        }
        //switch - case
        String emviromentName = "QA";
        String url = null;
        switch (emviromentName) {
            case "Local":
                url = "https://localhost:9999/";
                break;
            case "Dev":
                url = "https://dev.rode.com/";
                break;
            case "QA":
                url = "https://qa.rode.com/";
                break;
            case "Prod":
                url = "https://prod.rode.com/";
                break;
            default:
                throw new RuntimeException("Enviroment name is not valid");
        }
    }

    }

