import java.util.ArrayList;
public class TestOrder{
    public static void main(String[] args){
        Item item1 = new Item();
        item1.name="mocha";
        item1.price=9.99;

        Item item2 = new Item();
        item2.name="latte";
        item2.price = 1.99;

        Item item3=new Item();
        item3.name="drip coffee";
        item3.price=99.99;

        Item item4=new Item();
        item4.name="cappuccino";
        item4.price=3.95;

        Order order1= new Order();
        order1.name="Cindhuri";
        order1.ready=false;

        Order order2=new Order();
        order2.name="Jimmy";
        order2.ready=false;

        Order order3=new Order();
        order3.name="Noah";
        order3.ready=false;

        Order order4=new Order();
        order4.name="Sam";
        order4.ready=false;
//^^^^^^^^^^^^^^^Testing Stuff Is below ^^^^^^^^^^^^^^^^^^^^^^^^^^
order2.ready=true;
System.out.println(order2.ready);
//^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
    order4.items.add(item2);
    order4.items.add(item2);
    order4.total+=item2.price*2;
        System.out.println(order4.total);

//^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
    order1.ready=true;
    System.out.println(order1.ready);
//^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
    order4.items.add(item2);
    order4.total+=item2.price;
    System.out.println(order4.total);
//^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
    order3.items.add(item4);
    order3.total+=item4.price;
    System.out.println(order3.total);
//^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
    order2.items.add(item1);
    order2.total+=item1.price;
    System.out.println(order2.total);

}
}
