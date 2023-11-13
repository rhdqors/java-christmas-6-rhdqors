package christmas;

import java.util.HashMap;
import java.util.Map;

public class OutputView {

    private final InputView inputView;
    private final Order order;
    private final Event event;
    private HashMap<String, Integer> saveOrderMenu;

    public OutputView(InputView inputView, Order order, Event event) {
        this.inputView = inputView;
        this.order = order;
        this.event = event;
    }

    public void excuteOrder() {
        inputView.inputDate();
        printMenu();
        printAllPriceAndService();
        showEventList();
    }

    private void printMenu() {
        saveOrderMenu = order.saveOrderMenu();
        System.out.println("<주문 메뉴>");
        for (Map.Entry<String, Integer> entry : saveOrderMenu.entrySet()) {
            System.out.println(entry.getKey() + " " +  entry.getValue() + "개");
        }
    }

    private void printAllPriceAndService() {
        int allPrice = order.savePriceBeforeDiscount();
        boolean isService = event.serviceChampaneCheck(allPrice);
        String result = "";

        System.out.println("<할인 전 총주문 금액>");
        System.out.println(String.format("%,d", allPrice));
        System.out.println("<증정 메뉴>");

        if(isService) {
            result = MenuPrice.CHAMPAGNE.getName() + " 1개";
        } else {
            result = "없음";
        }
        System.out.println(result);
    }

    private void showEventList() {
        String dDay = String.format("크리스마스 디데이 할인: -%,d원", event.dDayDiscount());
        String dailyDiscount = String.format("평일 할인: -%,d원", event.weekDayDiscount());
        if(event.isWeekend()) {
            dailyDiscount = String.format("주말 할인: -%,d원", event.weekendDiscount());
        }

        System.out.println("<혜택 내역>");
        System.out.println(dDay);
        System.out.println(dailyDiscount);
        System.out.println();
        System.out.println();

        /*
        크리스마스 디데이 할인: -1,200원 -> 1일부터 천원 기준 100원씩 추가
        주말 or 평일 할인
        특별 할인: -1,000원 -> 달력에 별모양
        증정 이벤트: -25,000원 -> 총 주문 12만원 이상 샴페인
         */
    }


}
