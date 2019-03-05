package what.the.bus.booking.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import what.the.bus.admin.ChartVO1;
import what.the.bus.booking.BookingPayVO;
import what.the.bus.booking.dao.BookingPayDAO;
import what.the.bus.booking.service.BookingPayService;

@Service
public class BookingPayServiceImpl implements BookingPayService {
   @Autowired
   private BookingPayDAO bookingPayDAO;

   @Override
   public void insertBookingPay(BookingPayVO vo) {
      bookingPayDAO.insertBookingPay(vo);
   }

   @Override
   public List<Integer> getSitNumList(int busseq) {
      return bookingPayDAO.getSitNumList(busseq);
   }


   @Override
   public List<BookingPayVO> getBookingPayList(int start, int end, String id) {
      return bookingPayDAO.getBookingPayList(start, end, id);
   }

   @Override
   public int getBookingPayListCount(BookingPayVO vo) {
      return bookingPayDAO.getBookingPayListCount(vo);
   }

   @Override
   public List<ChartVO1> getPayPerRegdate(BookingPayVO vo) {
      return bookingPayDAO.getPayPerRegdate(vo);
   }

   @Override
   public void useMemberPoint(BookingPayVO vo) {
      // TODO Auto-generated method stub
      
   }

   @Override
   public void useDriverPoint(BookingPayVO vo) {
      // TODO Auto-generated method stub
      
   }

   @Override
   public int getMemberPoint(String id) {
      // TODO Auto-generated method stub
      return 0;
   }

   @Override
   public int getDriverPoint(String id) {
      // TODO Auto-generated method stub
      return 0;
   }



}