package com.example.shop;

import com.example.shop.Dao.OrderDataDao;
import com.example.shop.Entity.Book;
import com.example.shop.Entity.OrderData;
import com.example.shop.Entity.UserOrder;
import com.example.shop.Service.OrderDataService;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;


@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
class OrderDataServiceTests {
    
    @InjectMocks
    OrderDataService orderDataService;
    
    @Mock
    OrderDataDao orderDataDaoMock;
        
    List<Book> books;
    OrderData orderData;
    
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        //orderDataService = new OrderDataService();
        books = new ArrayList<Book>();
        Book b1 = new Book(1, 10f, 1);
        Book b2 = new Book(2, 20f, 2);
        Book b3 = new Book(3, 30f, 3);
        books.add(b1);
        books.add(b2);
        books.add(b3);
        
        orderData = new OrderData(0);
    }
    
     @Test
     public void test_add_order_successfully() {
         //need to test private methods
         List<UserOrder> elements = new ArrayList<UserOrder>();
         elements.add(new UserOrder(books.get(0), 1));
         elements.add(new UserOrder(books.get(1), 1));
            
         orderData.setUserOrderCollection(elements);
         orderDataService.addOrderData(orderData);
         
         verify(orderDataDaoMock, times(1)).addOrderData(orderData);
     }
     
     @Test
     public void test_reject_empty_order() {
         List<UserOrder> elements = new ArrayList<UserOrder>();
         
         orderData.setUserOrderCollection(elements);
         orderDataService.addOrderData(orderData);
         
         verify(orderDataDaoMock, times(0)).addOrderData(orderData);
     }
     
     @Test
     public void test_reject_order_when_item_is_not_in_magazine() {
         List<UserOrder> elements = new ArrayList<UserOrder>();
         elements.add(new UserOrder(books.get(0), 5));
         
         orderData.setUserOrderCollection(elements);
         orderDataService.addOrderData(orderData);
         
         verify(orderDataDaoMock, times(0)).addOrderData(orderData);
     }
     
     @Test
     public void test_reject_order_when_duplicates() {
         List<UserOrder> elements = new ArrayList<UserOrder>();
         elements.add(new UserOrder(books.get(1), 1));
         elements.add(new UserOrder(books.get(1), 1));
         
         orderData.setUserOrderCollection(elements);
         orderDataService.addOrderData(orderData);
         
         verify(orderDataDaoMock, times(0)).addOrderData(orderData);
     }
     
     @Test
     public void test_reject_order_when_too_low_cost() {
         List<UserOrder> elements = new ArrayList<UserOrder>();
         elements.add(new UserOrder(books.get(0), 1));
         
         orderData.setUserOrderCollection(elements);
         orderDataService.addOrderData(orderData);
         
         verify(orderDataDaoMock, times(0)).addOrderData(orderData);
     }
     
    private void test_conditions_template(String condition, List<UserOrder> elements){
         try {
            Method method = OrderDataService.class.getDeclaredMethod(condition, List.class);
            method.setAccessible(true);
            boolean x = (boolean)method.invoke(orderDataService, elements);
            assertTrue(x);
        } 
        catch (NoSuchMethodException ex) {
            ex.printStackTrace();
        } 
        catch (SecurityException ex) {
            ex.printStackTrace();
        } 
        catch (InvocationTargetException ex) {
            ex.printStackTrace();
        } 
        catch (IllegalAccessException ex) {
            ex.printStackTrace();
        } 
        catch (IllegalArgumentException ex) {
            ex.printStackTrace();
        }
    }
     
     //Reflection to test private methods
     @Test
     public void test_isItemInMagazine(){
        List<UserOrder> elements = new ArrayList<UserOrder>();
        elements.add(new UserOrder(books.get(0), 1));
        elements.add(new UserOrder(books.get(1), 1));
        
        test_conditions_template("isItemInMagazine", elements);
     }
     
     @Test
     public void test_isOneElementInOrder() {
        List<UserOrder> elements = new ArrayList<UserOrder>();
        elements.add(new UserOrder(books.get(0), 1));
        elements.add(new UserOrder(books.get(1), 1));
         
        test_conditions_template("isOneElementInOrder", elements);
     }
     
     @Test
     public void test_noDuplicatesInOrder() {
         List<UserOrder> elements = new ArrayList<UserOrder>();
        elements.add(new UserOrder(books.get(0), 1));
        elements.add(new UserOrder(books.get(1), 1));
         
        test_conditions_template("noDuplicatesInOrder", elements);
     }
     
     @Test
     public void test_isOrderCostEnough() {
         List<UserOrder> elements = new ArrayList<UserOrder>();
        elements.add(new UserOrder(books.get(0), 1));
        elements.add(new UserOrder(books.get(1), 1));
         
        test_conditions_template("isOrderCostEnough", elements);
     }
}
