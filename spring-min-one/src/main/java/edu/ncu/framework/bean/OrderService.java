package edu.ncu.framework.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderService {

    private String name;

    public void selectOrder(String order){
        System.out.println("selectOrder:"+Thread.currentThread().getName()+order);
    }
}
