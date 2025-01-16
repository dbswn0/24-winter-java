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
        String[] tokens = str.split("[,:]");

        for (String token : tokens) {
            try {
                int number = Integer.parseInt(token); // 숫자로 변환
                numbers.add(number); //리스트에 추가
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("잘못된 값 입력");
            }
        }
        return numbers;
    }

    public static int calculate(ArrayList<Integer> numbers) {
        int total = 0;
        for (int number : numbers) {
            total += number;
        }
        return total;
    }
}