package com.sk.sheikhpura.dao.impl;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sk.sheikhpura.dao.OrderDao;
import com.sk.sheikhpura.dao.ProductDaoForImage;
import com.sk.sheikhpura.dao.UserDao;
import com.sk.sheikhpura.entity.Order;
import com.sk.sheikhpura.entity.OrderDetail;
import com.sk.sheikhpura.entity.Product;
import com.sk.sheikhpura.entity.UserInfo;
import com.sk.sheikhpura.model.CartInfo;
import com.sk.sheikhpura.model.CartLineInfo;
import com.sk.sheikhpura.model.CustomerInfo;
import com.sk.sheikhpura.model.OrderDetailInfo;
import com.sk.sheikhpura.model.OrderInfo;
import com.sk.sheikhpura.model.PaginationResult;

@Repository("orderDaoImpl")
public class OrderDaoImpl implements OrderDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	private ProductDaoForImage productDaoForImage;

	@Autowired
	private UserDao accountDao;

	@SuppressWarnings({ "rawtypes", "deprecation" })
	private int getMaxOrderNum() {
		String sql = "Select max(o.orderNum) from " + Order.class.getName() + " o ";
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery(sql);
		Integer value = (Integer) query.uniqueResult();
		if (value == null) {
			return 0;
		}
		return value;
	}

	@Override
	public Order saveOrder(Integer code, int quantity, String username) {
		Session session = sessionFactory.getCurrentSession();

		int orderNum = this.getMaxOrderNum() + 1;

		//Account account = accountDao.findAccount(username);
		Product product = productDaoForImage.findProduct(code);
		//product.setQuantity(product.getQuantity() - quantity);
		Order order = new Order();
		order.setOrderNum(orderNum);
		order.setOrderDate(new Date());
		order.setAmount(quantity * (product.getPrice()));
		//order.setQuantity(quantity);
		//order.setAccount(account);
		//order.setProduct(product);
		session.save(order);

		return order;
	}

	// @page = 1, 2, ...
	@SuppressWarnings({ "rawtypes", "deprecation" })
	@Override
	public PaginationResult<OrderInfo> listOrderInfo(int page, int maxResult, int maxNavigationPage) {
		String sql = "Select new " + OrderInfo.class.getName()//
				+ "(ord.id, ord.orderDate, ord.orderNum, ord.amount, "
				+ " ord.customerName, ord.customerAddress, ord.customerEmail, ord.customerPhone) " + " from "
				+ Order.class.getName() + " ord "//
				+ " order by ord.orderNum desc";
		Session session = this.sessionFactory.getCurrentSession();

		Query query = session.createQuery(sql);

		return new PaginationResult<OrderInfo>(query, page, maxResult, maxNavigationPage);
	}

	@SuppressWarnings("deprecation")
	public Order findOrder(String orderId) {
		Session session = sessionFactory.getCurrentSession();
		Criteria crit = session.createCriteria(Order.class);
		crit.add(Restrictions.eq("id", orderId));
		return (Order) crit.uniqueResult();
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	@Override
	public List<Order> getOrdersByUserName(String username) {

		Session session = sessionFactory.getCurrentSession();
		UserInfo account = accountDao.findUserByUserName(username);
		Criteria crit = session.createCriteria(Order.class);
		crit.add(Restrictions.eq("account.userId", account.getUserName()));
		List<Order> list = (List<Order>) crit.list();
		/* list.forEach(Order::getProduct); */
		return list;
	}

	@Override
	public void saveOrder(CartInfo cartInfo) {
		Session session = sessionFactory.getCurrentSession();

		int orderNum = this.getMaxOrderNum() + 1;
		Order order = new Order();

		order.setId(UUID.randomUUID().toString());
		order.setOrderNum(orderNum);
		order.setOrderDate(new Date());
		order.setAmount(cartInfo.getAmountTotal());

		CustomerInfo customerInfo = cartInfo.getCustomerInfo();
		order.setCustomerName(customerInfo.getName());
		order.setCustomerEmail(customerInfo.getEmail());
		order.setCustomerPhone(customerInfo.getPhone());
		order.setCustomerAddress(customerInfo.getAddress());

		session.persist(order);

		List<CartLineInfo> lines = cartInfo.getCartLines();

		for (CartLineInfo line : lines) {
			OrderDetail detail = new OrderDetail();
			detail.setId(UUID.randomUUID().toString());
			detail.setOrder(order);
			detail.setAmount(line.getAmount());
			detail.setPrice(line.getProductInfoForImage().getPrice());
			detail.setQuanity(line.getQuantity());

			Integer code = line.getProductInfoForImage().getId();
			Product product = this.productDaoForImage.findProduct(code);
			detail.setProduct(product);

			session.persist(detail);
		}

		// Set OrderNum for report.
		cartInfo.setOrderNum(orderNum);
	}

	@Override
	public OrderInfo getOrderInfo(String orderId) {
		Order order = this.findOrder(orderId);
        if (order == null) {
            return null;
        }
        return new OrderInfo(order.getId(), order.getOrderDate(), //
                order.getOrderNum(), order.getAmount(), order.getCustomerName(), //
                order.getCustomerAddress(), order.getCustomerEmail(), order.getCustomerPhone());
	}

	@SuppressWarnings({ "rawtypes", "deprecation", "unchecked" })
	@Override
	public List<OrderDetailInfo> listOrderDetailInfos(String orderId) {
		 String sql = "Select new " + OrderDetailInfo.class.getName() //
	                + "(d.id, d.product.code, d.product.name , d.quanity,d.price,d.amount) "//
	                + " from " + OrderDetail.class.getName() + " d "//
	                + " where d.order.id = :orderId ";
	 
	        Session session = this.sessionFactory.getCurrentSession();
	 
	        Query query = session.createQuery(sql);
	        query.setParameter("orderId", orderId);
	 
	        return query.list();
	}

}
