package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String str = scanner.nextLine();

        System.out.println("결과 : ");

        scanner.close();

    }

    //기본 구분자로 문자열 분리
    public static ArrayList<Integer> splitBasic(String str) {
        ArrayList<Integer> numbers = new ArrayList<>();
        String[] parts = str.split("[,:]");

        for (String part : parts) {
            int number = Integer.parseInt(part); // 숫자로 변환
            numbers.add(number); //리스트에 추가
        }
        return numbers;
    }

    //커스텀 구분자로 문자열 분리
    public static ArrayList<Integer> splitCustom(String str) {
        ArrayList<Integer> numbers = new ArrayList<>();
        String customDelimiter = String.valueOf(",");
        String numbersPart = str;

        // 커스텀 구분자 확인
        if (str.startsWith("//") && str.contains("\n")) {
            int lastDelimiter = str.indexOf('\n');
            customDelimiter = str.substring(2, lastDelimiter); // 구분자 추출
            numbersPart = str.substring(lastDelimiter + 1); // 숫자 부분
        }

        String[] parts = numbersPart.split(customDelimiter);

        for (String part : parts) {
            numbers.add(Integer.valueOf(part));
        }
        return numbers; // 숫자 리스트 반환
    }

    public static int calculate(ArrayList<Integer> numbers) {
        int total = 0;
        for (int number : numbers) {
            total += number;
        }
        return total;
    }
}