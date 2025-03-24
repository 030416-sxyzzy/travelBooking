import java.util.List;

public interface BookingDAO {
    List<Booking> findBookingsByMemberId(int memberId);  // 根据会员 ID 查询预定
    List<Booking> findBookingsByHotelId(int hotelId);    // 根据酒店 ID 查询预定
    List<Booking> findBookingsByTourSpotId(int tourSpotId);      // 根据旅游景点 ID 查询预定
    List<Booking> findBookingsByRouteId(int tourSpotId);
}
