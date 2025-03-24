import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n------ 欢迎使用旅游预定平台 ------");
            System.out.println("1. 旅游景点信息管理");
            System.out.println("2. 酒店信息管理");
            System.out.println("3. 会员信息管理");
            System.out.println("4. 线路信息查询");
            System.out.println("5. 会员预定查询");
            System.out.println("6. 最受欢迎旅游线路统计");
            System.out.println("7. 门票预定统计");
            System.out.println("8. 退出");
            System.out.print("请输入操作选项: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // 清除换行符

            switch (choice) {
                case 1:
                    touristSpotManagement();
                    break;
                case 2:
                    hotelManagement();
                    break;
                case 3:
                    memberManagement();
                    break;
                case 4:
                    findAllRouteInfo();
                    break;
                case 5:
                    BookingService();
                    break;
                case 6:
                    MostPopularRoute.getMostPopularRoute();
                    break;
                case 7:
                    Scanner scanner = new Scanner(System.in);
                    System.out.println("请输入预定的线路ID:");
                    int tid = scanner.nextInt();
                    System.out.println("请输入预定的数量:");
                    int quantity = scanner.nextInt();
                    try {
                        TicketBooking.bookTicket(tid, quantity);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                case 8:
                    System.out.println("感谢使用！");
                    return;
                default:
                    System.out.println("无效的选项，请重新输入！");
            }
        }
    }



    // 会员管理
    private static void memberManagement() {
        while (true) {
            System.out.println("\n------ 会员管理 ------");
            System.out.println("1. 添加会员信息");
            System.out.println("2. 删除会员信息");
            System.out.println("3. 更新会员信息");
            System.out.println("4. 查找会员信息");
            System.out.println("5. 返回主菜单");
            System.out.print("请输入操作选项: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // 清除换行符

            switch (choice) {
                case 1:
                    addMember();
                    break;
                case 2:
                    deleteMember();
                    break;
                case 3:
                    updateMember();
                    break;
                case 4:
                    findMember();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("无效的选项，请重新输入！");
            }
        }
    }

    private static void addMember() {
        System.out.print("请输入会员姓名: ");
        String mname = scanner.nextLine();
        System.out.print("请输入会员电话: ");
        String mphone = scanner.nextLine();
        System.out.print("请输入会员等级: ");
        String mlevel = scanner.nextLine();
        System.out.print("请输入会员注册日期 (yyyy-MM-dd): ");
        String mdateStr = scanner.nextLine();
        java.sql.Date mdate = java.sql.Date.valueOf(mdateStr);
        Member member = new Member(0, mname, mphone, mlevel, mdate);
        MemberDAOImpl memberDAOImpl = new MemberDAOImpl();
        memberDAOImpl.add(member);
        System.out.println("会员添加成功！");
    }

    private static void deleteMember() {
        System.out.print("请输入要删除的会员 ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();  // 清除换行符
        MemberDAOImpl memberDAOImpl = new MemberDAOImpl();
        memberDAOImpl.delete(id);
        System.out.println("会员删除成功！");
    }

    private static void updateMember() {
        System.out.print("请输入要更新的会员 ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();  // 清除换行符
        System.out.print("请输入新的会员姓名: ");
        String mname = scanner.nextLine();
        System.out.print("请输入新的会员电话: ");
        String mphone = scanner.nextLine();
        System.out.print("请输入新的会员等级: ");
        String mlevel = scanner.nextLine();
        System.out.print("请输入新的会员注册日期 (yyyy-MM-dd): ");
        String mdateStr = scanner.nextLine();
        java.sql.Date mdate = java.sql.Date.valueOf(mdateStr);
        Member member = new Member(id, mname, mphone, mlevel, mdate);
        MemberDAOImpl memberDAOImpl = new MemberDAOImpl();
        memberDAOImpl.update(member);
        System.out.println("会员信息更新成功！");
    }

    private static void findMember() {
        System.out.print("请输入要查找的会员 ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();  // 清除换行符
        MemberDAOImpl memberDAOImpl = new MemberDAOImpl();
        List<Member> members = memberDAOImpl.findById(id);  // 返回多个匹配的会员

        if (members != null && !members.isEmpty()) {
            System.out.println("查询到以下会员信息: ");
            for (Member member : members) {
                System.out.println(member);
            }
        } else {
            System.out.println("未找到匹配的会员！");
        }
    }

    // 酒店管理
    private static void hotelManagement() {
        HotelDAOImpl hotelDAOImpl = new HotelDAOImpl();

        while (true) {
            System.out.println("\n------ 酒店管理 ------");
            System.out.println("1. 添加酒店信息");
            System.out.println("2. 删除酒店信息");
            System.out.println("3. 更新酒店信息");
            System.out.println("4. 查找酒店信息");
            System.out.println("5. 返回主菜单");
            System.out.print("请输入操作选项: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // 清除换行符

            switch (choice) {
                case 1:
                    addHotel();
                    break;
                case 2:
                    deleteHotel();
                    break;
                case 3:
                    updateHotel();
                    break;
                case 4:
                    findHotel();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("无效的选项，请重新输入！");
            }
        }
    }

    private static void addHotel() {
        System.out.print("请输入酒店名称: ");
        String hname = scanner.nextLine();
        System.out.print("请输入酒店价格: ");
        short hprice = scanner.nextShort();
        scanner.nextLine();
        System.out.print("请输入酒店风格: ");
        String hstyle = scanner.nextLine();
        System.out.print("请输入酒店星级: ");
        short hstarrating = scanner.nextShort();
        scanner.nextLine();
        System.out.print("请输入酒店位置: ");
        String hlocation = scanner.nextLine();
        Hotel hotel = new Hotel(0, hname, hprice, hstyle, hstarrating, hlocation);
        HotelDAOImpl hotelDAOImpl = new HotelDAOImpl();
        hotelDAOImpl.add(hotel);
        System.out.println("酒店添加成功！");
    }

    private static void deleteHotel() {
        System.out.print("请输入要删除的酒店 ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();  // 清除换行符
        HotelDAOImpl hotelDAOImpl = new HotelDAOImpl();
        hotelDAOImpl.delete(id);
        System.out.println("酒店删除成功！");
    }

    private static void updateHotel() {
        System.out.print("请输入要更新的酒店 ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();  // 清除换行符
        System.out.print("请输入新的酒店名称: ");
        String hname = scanner.nextLine();
        System.out.print("请输入新的酒店价格: ");
        short hprice = scanner.nextShort();
        scanner.nextLine();
        System.out.print("请输入新的酒店风格: ");
        String hstyle = scanner.nextLine();
        System.out.print("请输入新的酒店星级: ");
        short hstarrating = scanner.nextShort();
        scanner.nextLine();
        System.out.print("请输入新的酒店位置: ");
        String hlocation = scanner.nextLine();
        Hotel hotel = new Hotel(id, hname, hprice, hstyle, hstarrating, hlocation);
        HotelDAOImpl hotelDAOImpl = new HotelDAOImpl();
        hotelDAOImpl.update(hotel);
        System.out.println("酒店信息更新成功！");

    }

    private static void findHotel() {
        System.out.print("请输入要查找的酒店 ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();  // 清除换行符
        HotelDAOImpl hotelDAOImpl = new HotelDAOImpl();
        List<Hotel> hotels = hotelDAOImpl.findById(id);
        if (hotels != null && !hotels.isEmpty()) {
            System.out.println("查询到以下会员信息: ");
            for (Hotel hotel : hotels) {
                System.out.println(hotel);
            }
        } else {
            System.out.println("未找到该酒店！");
        }
    }


    // 旅游景点管理
    private static void touristSpotManagement() {
        TourSpotDAOImpl tourSpotDAOImpl = new TourSpotDAOImpl();

        while (true) {
            System.out.println("\n-- 旅游景点管理 --");
            System.out.println("1. 添加旅游景点");
            System.out.println("2. 删除旅游景点");
            System.out.println("3. 更新旅游景点");
            System.out.println("4. 查找旅游景点");
            System.out.println("5. 返回主菜单");
            System.out.print("请选择操作: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // 清空换行符

            switch (choice) {
                case 1:
                    addTouristSpot();
                    break;
                case 2:
                    deleteTouristSpot();
                    break;
                case 3:
                    updateTouristSpot();
                    break;
                case 4:
                    findTouristSpot();
                    break;
                case 5:
                    System.out.println("退出旅游景点管理！");
                    return;
                default:
                    System.out.println("无效的选项，请重新选择！");
            }
        }
    }

    // 添加旅游景点
    private static void addTouristSpot() {
        System.out.print("请输入旅游景点名称: ");
        String Tname = scanner.nextLine();
        System.out.print("请输入旅游景点价格: ");
        short Tprice = scanner.nextShort();
        scanner.nextLine();  // 清空换行符
        System.out.print("请输入旅游景点位置: ");
        String Tlocation = scanner.nextLine();
        System.out.print("请输入旅游景点开放日期 (yyyy-MM-dd): ");
        String TdateStr = scanner.nextLine();
        java.sql.Date Tdate = java.sql.Date.valueOf(TdateStr);
        TourSpot spot = new TourSpot(0,Tname,Tprice,Tlocation,Tdate);
        TourSpotDAOImpl tourSpotDAOImpl = new TourSpotDAOImpl();
        tourSpotDAOImpl.add(spot);
        System.out.println("旅游景点添加成功！");
    }

    // 删除旅游景点
    private static void deleteTouristSpot() {
        System.out.print("请输入要删除的旅游景点ID: ");
        int Tid = scanner.nextInt();
        scanner.nextLine();
        TourSpotDAOImpl tourSpotDAOImpl = new TourSpotDAOImpl();
        tourSpotDAOImpl.delete(Tid);
        System.out.println("旅游景点删除成功！");
    }

    // 更新旅游景点
    private static void updateTouristSpot() {
        System.out.print("请输入要更新的旅游景点ID: ");
        int Tid = scanner.nextInt();
        scanner.nextLine();  // 清空换行符
        System.out.print("请输入新的旅游景点名称: ");
        String Tname = scanner.nextLine();
        System.out.print("请输入新的旅游景点价格: ");
        short Tprice = scanner.nextShort();
        scanner.nextLine();  // 清空换行符
        System.out.print("请输入新的旅游景点位置: ");
        String Tlocation = scanner.nextLine();
        System.out.print("请输入新的旅游景点开放日期 (yyyy-MM-dd): ");
        String TdateStr = scanner.nextLine();
        java.sql.Date Tdate = java.sql.Date.valueOf(TdateStr);
        TourSpotDAOImpl tourSpotDAOImpl = new TourSpotDAOImpl();
        TourSpot spot = new TourSpot(Tid,Tname,Tprice,Tlocation,Tdate);
        tourSpotDAOImpl.update(spot);
        System.out.println("旅游景点更新成功！");
    }

    // 查找旅游景点
    private static void findTouristSpot() {
        System.out.print("请输入旅游景点ID: ");
        int Tid = scanner.nextInt();
        scanner.nextLine();
        TourSpotDAOImpl tourSpotDAOImpl = new TourSpotDAOImpl();
        List<TourSpot> spots = tourSpotDAOImpl.findById(Tid);
        if (spots != null && !spots.isEmpty()) {
            System.out.println("查询到以下景点信息：");
            for (TourSpot spot : spots) {
                System.out.println(spot);
            }
        } else {
            System.out.println("未找到该旅游景点！");
        }
    }

    //线路信息查询
    private static void findAllRouteInfo() {

        RoutemanageDAOImpl routemanageDAO = new RoutemanageDAOImpl();

        // 查询所有线路信息及其相关详细信息
        List<Routemanage> routemanages = routemanageDAO.findAllRoutemanageWithDetails();

        // 输出查询到的线路信息
        if (routemanages.isEmpty()) {
            System.out.println("未找到任何线路信息。");
        } else {
            // 遍历并打印每个 Routemanage 对象的详细信息
            for (Routemanage routemanage : routemanages) {
                // 打印出 Routemanage 对象的字段（假设你已定义合适的 toString() 方法）
                System.out.println(routemanage);
                System.out.print("\n");
            }
        }
    }
    //会员预定查询
    private static void BookingService() {

            while (true) {
                System.out.println("\n------ 预定管理 ------");
                System.out.println("1. 根据会员ID查询");
                System.out.println("2. 根据酒店ID查询");
                System.out.println("3. 根据旅游景点ID查询");
                System.out.println("4. 根据旅游线路ID查询");
                System.out.println("5. 返回主菜单");
                System.out.print("请输入操作选项: ");
                int choice = scanner.nextInt();
                scanner.nextLine();  // 清除换行符

                switch (choice) {
                    case 1:
                        findBookingsByMemberId();
                        break;
                    case 2:
                        findBookingsByHotelId();
                        break;
                    case 3:
                        findBookingsByTourSpotId();
                        break;
                    case 4:
                        findBookingsByRouteId();
                        break;
                    case 5:
                        return;  // 返回主菜单
                    default:
                        System.out.println("无效的选项，请重新输入！");
                }
            }
        }

        // 根据会员ID查询
        private static void findBookingsByMemberId() {
            System.out.print("请输入会员ID: ");
            int memberId = scanner.nextInt();
            scanner.nextLine();  // 清除换行符
            BookingDAOImpl bookingDAOImpl = new BookingDAOImpl();
            List<Booking> bookings = bookingDAOImpl.findBookingsByMemberId(memberId);
            displayBookings(bookings);
        }

        // 根据酒店ID查询
        private static void findBookingsByHotelId() {
            System.out.print("请输入酒店ID: ");
            int hotelId = scanner.nextInt();
            scanner.nextLine();  // 清除换行符
            BookingDAOImpl bookingDAOImpl = new BookingDAOImpl();
            List<Booking> bookings = bookingDAOImpl.findBookingsByHotelId(hotelId);
            displayBookings(bookings);
        }

        // 根据旅游景点ID查询
        private static void findBookingsByTourSpotId() {
            System.out.print("请输入旅游景点ID: ");
            int tourSpotId = scanner.nextInt();
            scanner.nextLine();  // 清除换行符
            BookingDAOImpl bookingDAOImpl = new BookingDAOImpl();
            List<Booking> bookings = bookingDAOImpl.findBookingsByTourSpotId(tourSpotId);
            displayBookings(bookings);
        }

        // 根据旅游线路ID查询
        private static void findBookingsByRouteId() {
            System.out.print("请输入旅游景点ID: ");
            int routeId = scanner.nextInt();
            scanner.nextLine();  // 清除换行符
            BookingDAOImpl bookingDAOImpl = new BookingDAOImpl();
            List<Booking> bookings = bookingDAOImpl.findBookingsByRouteId(routeId);
            displayBookings(bookings);
        }

        // 显示预定信息
        private static void displayBookings(List<Booking> bookings) {
            if (bookings.isEmpty()) {
                System.out.println("没有找到符合条件的预定信息。");
            } else {
                System.out.println("\n------ 查询结果 ------");
                for (Booking booking : bookings) {
                    System.out.println(booking);
                }
            }
        }


}

