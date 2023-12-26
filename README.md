# Inflector

**Simple example**

```java
import github.illuminate.Inflector;

class GoodOrder {
}

public class Test {

    public static void main(String[] args) {

        // Generate table name.
        Inflector inflector = new Inflector();
        String tableName = inflector.sanke(inflector.plural(GoodOrder.class.getSimpleName()),"_"); // good_orders

    }
}
```