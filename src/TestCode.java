import java.util.*;
public class TestCode {
	public static void main(String[] args) {
		MostBookedHotelRoomOA test = new MostBookedHotelRoomOA();
		String[] records = new String[] {
				"+1A", "+3E", "-1A", "+4F", "+1A", "-3E", "+1A", "+1A", "+1A","+1A","+1A","+1A","+1A", "+3E", "+3E","+3E","+3E","+3E","+3E"
		};
		System.out.println(test.mostBookedRoom(records));
	}
}
