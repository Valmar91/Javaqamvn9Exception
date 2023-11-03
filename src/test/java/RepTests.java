import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RepTests {

    Product pro1 = new Product(1, "Название", 100);
    Product pro2 = new Product(2, "Название", 100);
    Product pro3 = new Product(3, "Название", 100);



    @Test
    public void Test1() {

        ShopRepository repo = new ShopRepository();

        repo.add(pro1);
        repo.add(pro2);
        repo.add(pro3);
        repo.remove(2);

        Product[] expected = {pro1, pro3};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }


    @Test
    public void Test2() {

        ShopRepository repo = new ShopRepository();

        repo.add(pro1);
        repo.add(pro2);
        repo.add(pro3);



        Assertions.assertThrows(NotFoundException.class,() -> {
            repo.remove(4);
        });
    }
}
