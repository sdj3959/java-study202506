package chap2_8.practice.q1;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toList;

public class Main {

    public static void main(String[] args) {

        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        List<Transaction> transactions = List.of(
                new Transaction(brian, 2021, 300),
                new Transaction(raoul, 2022, 1000),
                new Transaction(raoul, 2021, 400),
                new Transaction(mario, 2021, 710),
                new Transaction(mario, 2022, 700),
                new Transaction(alan, 2022, 950)
        );

        // 연습 1: 2021년에 발생한 모든 거래를 찾아 거래액 오름차 정렬(작은 값에서 큰 값).
        // List<Transaction>
        transactions.stream()
                .filter(transaction -> transaction.getYear() == 2021)
                .sorted(Comparator.comparing(Transaction::getValue))
                .collect(toList())
                .forEach(System.out::println);

        System.out.println("========================================");


        // 연습 2: 거래자가 근무하는 모든 도시이름을 중복 없이 나열하시오.
        // List<String>
        transactions.stream()
                .map(transaction -> transaction.getTrader().getCity())
                .distinct()
                .forEach(System.out::println);

        System.out.println("========================================");

        // 연습 3: Cambridge에 근무하는 모든 거래자(Trader)를 찾아
        // 거래자리스트로 이름순으로 오름차정렬.
        // List<Trader>
        transactions.stream()
                .filter(transaction -> transaction.getTrader().getCity().equals("Cambridge"))
                .map(Transaction::getTrader)
                .sorted(Comparator.comparing(Trader::getName))
                .distinct()
                .forEach(System.out::println);

        System.out.println("========================================");

        // 연습 4: 모든 거래자의 이름을 리스트에 모아서
        // 알파벳순으로  오름차정렬하여 반환
        transactions.stream()
                .map(transaction -> transaction.getTrader().getName())
                .distinct()
                .sorted()
                .collect(toList())
                .forEach(System.out::println);

        System.out.println("========================================");

        // 연습 5: Milan에 거주하는 거래자가 한명이라도 있는지 여부 확인?
        boolean anyMilan = transactions.stream()
                .anyMatch(transaction -> transaction.getTrader().getCity().equals("Milan"));
        System.out.println("anyMilan = " + anyMilan);

        System.out.println("========================================");

        // 연습 6: Cambridge에 사는 거래자의 모든 거래액의 총합 출력.
        int allTradersValue = transactions.stream()
                .filter(transaction -> transaction.getTrader().getCity().equals("Cambridge"))
                .mapToInt(Transaction::getValue)
                .sum();
        System.out.println("allTradersValue = " + allTradersValue);

        System.out.println("========================================");


        // 연습 7: 모든 거래에서 최고거래액은 얼마인가?
        transactions.stream()
                .sorted(Comparator.comparing(Transaction::getValue).reversed())
                .map(Transaction::getValue)
                .limit(1)
                .forEach(System.out::println);

        System.out.println("========================================");


        // 연습 8. 가장 작은 거래액을 가진 거래정보 탐색
        Transaction lowestValueTrade = transactions.stream()
                .sorted(Comparator.comparing(Transaction::getValue))
                .findFirst()
                        .get();
        System.out.println("lowestValueTrade = " + lowestValueTrade);

        System.out.println("========================================");


        // 연습 9. 거래액이 500 이상인 거래들만 필터링하고,
        // 해당 거래의 정보를 출력하시오.
        transactions.stream()
                .filter(transaction -> transaction.getValue() >= 500)
                .collect(toList())
                .forEach(System.out::println);

        System.out.println("========================================");


        // 연습 10. 모든 거래에서 가장 작은 거래액보다
        // 큰 거래액을 가진 거래의 평균을 계산하시오.
        // 출력값: 752.0
        Double average = transactions.stream()
                .skip(1)
                .mapToDouble(Transaction::getValue)
                .average()
                        .getAsDouble();
        System.out.println("average = " + average);

        System.out.println("========================================");


        // 연습 11. "Cambridge"에서 거래하는 모든 거래자의 거래정보들을 연도별로 그룹화하여 출력하시오.
        /*
               출력예시

                Year: 2021
                {Trader: Brian in Cambridge, year: 2021, value: 300}
                {Trader: Raoul in Cambridge, year: 2021, value: 400}

                Year: 2022
                {Trader: Raoul in Cambridge, year: 2022, value: 1000}
                {Trader: Alan in Cambridge, year: 2022, value: 950}

                const data = {
                    2021: [
                        {
                            trader: {
                                city: '',
                                name: ''
                            },
                            year: 2021,
                            value: 300
                        },
                        {}
                    ],
                    2022: []
                }
         */

        List<Transaction> tx = transactions.stream()
                .filter(transaction -> transaction.getTrader().getCity().equals("Cambridge"))
                .collect(toList());

        Map<Integer, List<Transaction>> txMap = new HashMap<>();

        List<Transaction> trade2021 = tx.stream()
                .filter(transaction -> transaction.getYear() == 2021)
                .collect(toList());
        List<Transaction> trade2022 = tx.stream()
                .filter(transaction -> transaction.getYear() == 2022)
                .collect(toList());

        txMap.put(2021, trade2021);
        txMap.put(2022, trade2022);

        txMap.forEach((year, transactionList) -> {
            System.out.println("\nYear: " + year);
            transactionList.forEach(System.out::println);
        });


        System.out.println("========================================");


        // 연습 12. 모든 거래 중 가장 큰 거래액과 가장 작은 거래액의 차이를 계산하시오.
        // 출력 값 : 700
        List<Integer> sortedValues = transactions.stream()
                .map(Transaction::getValue)
                .sorted()
                .collect(toList());

        System.out.println("가장 큰 거래액과 가장 작은 거래액의 차이 = " + (sortedValues.get(sortedValues.size()-1)-sortedValues.get(0)));
    }
    private static Map<Integer, Transaction> tsMap;
    private static int year = 2021;
}