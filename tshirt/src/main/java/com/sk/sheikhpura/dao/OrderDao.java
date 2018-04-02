package com.sk.sheikhpura.dao;

import java.util.List;

import com.sk.sheikhpura.entity.Order;
import com.sk.sheikhpura.model.CartInfo;
import com.sk.sheikhpura.model.OrderDetailInfo;
import com.sk.sheikhpura.model.OrderInfo;
import com.sk.sheikhpura.model.PaginationResult;

public interface OrderDao {
	public Order saveOrder(Integer code,int quantity,String username);
	public List<Order> getOrdersByUserName(String username);
    
    public void saveOrder(CartInfo cartInfo);
    public PaginationResult<OrderInfo> listOrderInfo(int page,
    int maxResult, int maxNavigationPage);
    
    public OrderInfo getOrderInfo(String orderId);
    public List<OrderDetailInfo> listOrderDetailInfos(String orderId);
}
