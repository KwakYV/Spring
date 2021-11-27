package homework2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.gb.HomeworkConfig;

public class HomeworkApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(HomeworkConfig.class);

        for (int i = 0; i < 5; i++) {
            Buyer buyer = context.getBean(Buyer.class);
            buyer.purchase();
            buyer.showCart();
        }
    }
}
