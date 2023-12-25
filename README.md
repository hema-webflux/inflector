# Inflector

**Simple example**
```java
import github.illuminate.Inflector;

class GoodOrder {}

public class Test {

    public static void main(String[] args) {
        
    }

    public void test(){

        String str = this.inflector.plural("GoodOrder"); // GoodOrders

        str = this.inflector.snake(str,"_"); // good_orders

    }

}
```