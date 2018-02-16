/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sashimipos;

import java.util.LinkedHashMap;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author dani_
 */
public class Cart {
    private LinkedHashMap<Item, Integer> items;
    private int total;
    
    public Cart(){
        this.items = new LinkedHashMap<>();
        this.total = 0;
    }
    
    public Cart(LinkedHashMap<Item, Integer> items){
        this.items = items;
        this.total = 0;
    }
    
    public void removeItem(Item item){
        int count = items.get(item);
        if(count == 1){ // if this item is only in cart once, remove it completely
            items.remove(item);
        }else{ // otherwise, decrease its counter/amount in the basket without removing it from the item list
            int newCount = count - 1;
            items.put(item, newCount);
        }
        
        int price = item.getPrice();
        
        total -= price;
    }

    public void addItem(Item item){
        int price = item.getPrice();
        if(items.containsKey(item)){
            int count = items.get(item);
            count += 1;
            items.put(item, count);
        }else{
            items.putIfAbsent(item, 1);
        }
        total += price;
    }
    
    public Item getItem(int index){
        int i = 0;
        for(Item item : items.keySet()){
           if(i == index){
               return item;
           }
           i++;
        }
        return null;
    }
    
    public int size(){
        return items.size();
    }
    
    public int count(Item item){
        return items.get(item);
    }
    
    public LinkedHashMap<Item, Integer> getItems() {
        return items;
    }

    public void setItems(LinkedHashMap<Item, Integer> items) {
        this.items = items;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
    /*@author onishi
    */
    public Timer getStartTimer(){
        format = new SimpleDateFormat("HH:mm:ss");
        Timer t = new Timer();
        t.schedule(new TimerLabelTask(), 0,1000);
    }
    public void setTime(){
        Calendar calendar = Calendar.getInstance(Locale.JAPAN);
        this.setText(format.format(calendar.getTime()));
    }
    public TimerLabelTask extends TimerTask(){
        public void run(){
            setTime();
        }
    }
    
}
